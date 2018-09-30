package com.cg.cbill.dto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cg.cbill.service.EBillServiceImpl;

/**
 * Servlet implementation class EBillController
 */
@WebServlet("/EBillController")
public class EBillController extends HttpServlet {
	
	public EBillServiceImpl serviceImpl=null;
	public RequestDispatcher requestDispatcher=null;

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EBillController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String param=request.getParameter("reqParam");
		
		if(param.equals("1")){
			showConsumerList(request,response);
		}
		else if(param.equals("2")){
			getSearchConsumer(request,response);
		}else if(param.equals("3")){
			searchConsumer(request,response);
		}
		else if(param.equals("4")){
			showBillDetails(request,response);
		}
		else if(param.equals("5")){
			getGenerateBill(request,response);
		}
		else if(param.equals("6")){
			generateBill(request,response);
		}
		
	}

	
	private void getGenerateBill(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher requestDispatcher=null;
		requestDispatcher=request.getRequestDispatcher("/assign4/User_Info.jsp");
		
		try {
			requestDispatcher.include(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	private void generateBill(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		serviceImpl=new EBillServiceImpl();
		BillDTO billDTO=null;
		int consumerNumber=Integer.parseInt(request.getParameter("consumerId"));
		float previousReading=Float.parseFloat(request.getParameter("previousReading"));
		float currentReading=Float.parseFloat(request.getParameter("currentReading"));
		
		
		
		billDTO=serviceImpl.generateBill(consumerNumber, previousReading, currentReading);
		
	
			requestDispatcher=request.getRequestDispatcher("/assign4/Bill_Info.jsp");
			request.setAttribute("billDTO", billDTO);
			try {
				requestDispatcher.include(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
	}

	private void showBillDetails(HttpServletRequest request,
			HttpServletResponse response) {
		
		serviceImpl=new EBillServiceImpl();
		ArrayList<BillDTO> consumerBillList=new ArrayList<BillDTO>();
		int consumerNumber=Integer.parseInt(request.getParameter("consumerId"));
		consumerBillList=serviceImpl.showBills(consumerNumber);
		requestDispatcher=request.getRequestDispatcher("/assign4/Show_Bills.jsp");
		request.setAttribute("consumerBillList", consumerBillList);
		request.setAttribute("consumerNumber", consumerNumber);
		try {
			
			requestDispatcher.include(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void searchConsumer(HttpServletRequest request,
			HttpServletResponse response) {
		serviceImpl=new EBillServiceImpl();
		ConsumerDTO consumerDTO=new ConsumerDTO();
		consumerDTO=serviceImpl.searchConsumer(Integer.parseInt(request.getParameter("consumerId")));
		if(consumerDTO!=null){
			requestDispatcher=request.getRequestDispatcher("/assign4/Search_Consumer.jsp");
			request.setAttribute("consumerDTO", consumerDTO);
			try {
				requestDispatcher.include(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private void showConsumerList(HttpServletRequest request, HttpServletResponse response) {
		
		serviceImpl=new EBillServiceImpl();
		ArrayList<ConsumerDTO> consumersList=new ArrayList<ConsumerDTO>();
		consumersList=serviceImpl.getConsumersList();
		if(consumersList!=null){
			requestDispatcher=request.getRequestDispatcher("/assign4/Show_Consumer_List.jsp");
			request.setAttribute("consumersList", consumersList);
			try {
				requestDispatcher.forward(request, response);
			} catch (ServletException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		}
	}
	
	private void getSearchConsumer(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher requestDispatcher=null;
		requestDispatcher=request.getRequestDispatcher("/assign4/Search_Consumer.jsp");
		try {
			requestDispatcher.forward(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
}
