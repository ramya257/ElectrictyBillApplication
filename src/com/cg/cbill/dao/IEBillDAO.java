package com.cg.cbill.dao;

import java.util.ArrayList;
import java.util.Map;

import com.cg.cbill.dto.BillDTO;
import com.cg.cbill.dto.ConsumerDTO;

public interface IEBillDAO {
	public ArrayList<ConsumerDTO> getConsumersList();
	public ArrayList<BillDTO> showBills(int consumerNumber);
	public BillDTO showBillInformation(int billNumber);
	public ConsumerDTO  searchConsumer(int consumerNumber);
	public BillDTO generateBill(int consumerNumber,float currentReading,float unitsConsumed,float netAmount);
}
