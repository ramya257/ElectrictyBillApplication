package com.cg.cbill.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.cg.cbill.dao.EBillDAOImpl;
import com.cg.cbill.dto.BillDTO;
import com.cg.cbill.dto.ConsumerDTO;

public class EBillServiceImpl implements IEBillService {
	
	final int fixedCharge=100;
	private float unitsConsumed=0;
	private float netAmount=0;
	public EBillDAOImpl daoImpl=null;

	@Override
	public ArrayList<ConsumerDTO> getConsumersList() {
		ArrayList<ConsumerDTO> consumerList= new ArrayList<ConsumerDTO>();
		daoImpl=new EBillDAOImpl();
		consumerList=daoImpl.getConsumersList();
		return consumerList;
	}

	@Override
	public ArrayList<BillDTO> showBills(int consumerNumber) {
		ArrayList<BillDTO> consumerBillList= new ArrayList<BillDTO>();
		daoImpl=new EBillDAOImpl();
		consumerBillList=daoImpl.showBills(consumerNumber);
		return consumerBillList;
	}

	@Override
	public BillDTO showBillInformation(int billNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConsumerDTO searchConsumer(int consumerNumber) {
		
		ConsumerDTO consumerDTO= new ConsumerDTO();
		daoImpl=new EBillDAOImpl();
		consumerDTO=daoImpl.searchConsumer(consumerNumber);
		return consumerDTO;
	}

	@Override
	public BillDTO generateBill(int consumerNumber, float previousReading,float currentReading) {
		BillDTO billDTO=null;
		daoImpl=new EBillDAOImpl();
		calculateBillDetails(previousReading,currentReading);
		billDTO=daoImpl.generateBill(consumerNumber, currentReading, unitsConsumed, netAmount);
		return billDTO;
	}

	private void calculateBillDetails(float previousReading, float currentReading) {
		// TODO Auto-generated method stub
		
		unitsConsumed=currentReading-previousReading;
		netAmount=(float) ((unitsConsumed*1.15)+fixedCharge);
		
		
		System.out.println(netAmount);
	}

	
	

}
