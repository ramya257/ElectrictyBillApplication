package com.cg.cbill.service;

import java.util.ArrayList;
import java.util.Map;

import com.cg.cbill.dto.BillDTO;
import com.cg.cbill.dto.ConsumerDTO;

public interface IEBillService {

	public ArrayList<ConsumerDTO> getConsumersList();
	public ArrayList<BillDTO> showBills(int consumerNumber);
	public BillDTO showBillInformation(int billNumber);
	public ConsumerDTO searchConsumer(int consumerNumber);
	public BillDTO generateBill(int consumerNumber,float previousReading, float currentReading);
}
