package com.cg.cbill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.cg.cbill.db.DbConnection;
import com.cg.cbill.db.QueryMapper;
import com.cg.cbill.dto.BillDTO;
import com.cg.cbill.dto.ConsumerDTO;
import com.cg.cbill.exception.EBillException;



public class EBillDAOImpl implements IEBillDAO {
	public Connection connection;
	public ResultSet resultSet;
	public PreparedStatement preparedStatement;

	@Override
	public ArrayList<ConsumerDTO> getConsumersList() {
	connection=DbConnection.getConnection();
	ArrayList<ConsumerDTO> consumerList= new ArrayList<ConsumerDTO>();
	try {
		preparedStatement=connection.prepareStatement(QueryMapper.SHOW_CONSUMER_LIST_QUERY);
		resultSet=preparedStatement.executeQuery();
		
		while(resultSet.next()){
			ConsumerDTO consumerDTO= new ConsumerDTO();
			consumerDTO.setConsumerNumber(resultSet.getInt(1));
			consumerDTO.setConsumerName(resultSet.getString(2));
			consumerDTO.setConsumerAddress(resultSet.getString(3));
			consumerList.add(consumerDTO);
			
		}
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
		
		return consumerList;
	}

	
	
	
	@Override
	public ArrayList<BillDTO> showBills(int consumerNumber) {
		connection=DbConnection.getConnection();
		ArrayList<BillDTO> consumerBillList= new ArrayList<BillDTO>();
		
			try {
				preparedStatement=connection.prepareStatement(QueryMapper.SHOW_CONSUMER_BILLS_LIST);

				preparedStatement.setInt(1, consumerNumber);
				resultSet=preparedStatement.executeQuery();
				
				while(resultSet.next()){
					BillDTO billDTO = new BillDTO();
					billDTO.setBillNumber(resultSet.getInt(1));
					billDTO.setConsumerNumber(resultSet.getInt(2));
					billDTO.setCurrentReading(resultSet.getDouble(3));
					billDTO.setUnitsConsumed(resultSet.getDouble(4));
					billDTO.setNetAmount(resultSet.getDouble(5));
					billDTO.setBillDate(resultSet.getString(6));
					consumerBillList.add(billDTO);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return consumerBillList;
}

	@Override
	public BillDTO showBillInformation(int billNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConsumerDTO searchConsumer(int customerNumber) {
		connection=DbConnection.getConnection();
		ConsumerDTO consumerDTO = null;
		try {
			preparedStatement=connection.prepareStatement(QueryMapper.SEARCH_CUSTOMER_QUERY);
			preparedStatement.setInt(1, customerNumber);
			resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()){
				consumerDTO= new ConsumerDTO();
				consumerDTO.setConsumerNumber(resultSet.getInt(1));
				consumerDTO.setConsumerName(resultSet.getString(2));
				consumerDTO.setConsumerAddress(resultSet.getString(3));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return consumerDTO;
	}




	@Override
	public BillDTO generateBill(int consumerNumber, float currentReading, float unitsConsumed,
			float netAmount){
		connection=DbConnection.getConnection();
		String consumerName=null;
	
		BillDTO billDTO= new BillDTO();
		
		try {
			preparedStatement=connection.prepareStatement(QueryMapper.INSERT_BILL_DETAILS_QUERY);
			preparedStatement.setInt(1, consumerNumber);
			preparedStatement.setFloat(2, currentReading);
			preparedStatement.setFloat(3, unitsConsumed);
			preparedStatement.setFloat(4, netAmount);
			
			int result=preparedStatement.executeUpdate();
		
			if(result>0){
				
				preparedStatement=connection.prepareStatement(QueryMapper.SHOW_CONSUMER_NAME_QUERY);
				preparedStatement.setInt(1, consumerNumber);
				resultSet=preparedStatement.executeQuery();
				
				if(resultSet.next()){
					consumerName=resultSet.getString(1);
					billDTO.setConsumerName(consumerName);
					billDTO.setConsumerNumber(consumerNumber);
					billDTO.setUnitsConsumed(unitsConsumed);
					billDTO.setNetAmount(netAmount);
					
				}
				
			}
		
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return billDTO;
	}

}
