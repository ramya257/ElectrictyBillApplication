package com.cg.cbill.db;

public interface QueryMapper {

	public static String SHOW_CONSUMER_LIST_QUERY="SELECT * FROM CONSUMERS";
	public static String SEARCH_CUSTOMER_QUERY="SELECT CONSUMER_NUM,CONSUMER_NAME,ADDRESS FROM CONSUMERS WHERE CONSUMER_NUM=?";
	public static String SHOW_CONSUMER_BILLS_LIST ="SELECT * FROM BILLDETAILS WHERE CONSUMER_NUM=?";
	public static String INSERT_BILL_DETAILS_QUERY="INSERT INTO BILLDETAILS VALUES(seq_bill_num.nextval,?,?,?,?,SYSDATE)";
	public static String SHOW_CONSUMER_NAME_QUERY="SELECT consumer_name FROM consumers WHERE consumer_num=?";
}
