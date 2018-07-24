package com.test.utils;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.test.pojo.NewBean;
import com.test.pojo.OldBean;
import org.apache.poi.ss.usermodel.Font;
public class CreateExlFile{

	
	
	public static void createExcel(List oldList,List newList)
	{
		ResourceBundle res=ResourceBundle.getBundle("application");
	        XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet("finalCopy");
	        int rowCount = 0; 
	        int cellCount=0;
	        OldBean oldBean=null;
	        NewBean newBean=null;
	        int datarow=1;
	        
	        CellStyle style = workbook.createCellStyle();
		    style.setFillForegroundColor(IndexedColors.SKY_BLUE.getIndex());
		    style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		    /*Font font = workbook.createFont();
	        font.setColor(IndexedColors.RED.getIndex());
	        style.setFont(font);
		   */ 
	        //For Headder
	        
	        Object[] header = {
	                "Tracking ID", "MIS Period","PO No.",
	                "Tentative PO date", "PO Description","TCU Code",
	                "Team Lead", "Project Name", "Rel / Non-Rel",
	                "Team Split", "Account Codes","Technology","FS/CR","Item Name","FS/CR Name","Current Status"
	                ,"Challenge","General Remark","Patch","Assigned To","Total Effort( in Man-days) - Total effort of the project / deliverable",
	                "Effort in Man-days (for the month)","Effort Approval by","Effort Approval Date","Approval Status(Approved / Yet To Be Approved)",
	                "Request Received Date","Requested By (BSA)","Walkthough Planned date","Dev Planned Start date","Dev  Planned End date","UAT Rel Planned date","Actual Walkthrough  Date","Assigned for Development Date",
	                "Actual Dev Start  Date","Actual Dev End date","UAT Promotion/Sent for Sign-off Date","Delayed Delivery","Reason of Delay",
	                "TS Document (Y-Prepared P-Pending N-Not required)","Reviewed By","Promotion Date","Promoted By","Promotion Ticket No.","MIS Group",
	                "Invoice No.","Final Status"
	                
	        };
	        try{
	        Row headerrow = sheet.createRow(0);
	        
	        for (Object headerRow : header)
	        {
	        	
		        Cell cell = headerrow.createCell(cellCount++);
		        cell.setCellStyle(style);
		        cell.setCellValue((String) headerRow);
	        }

	        Row dataRow =null;
	        int cellCount1=0;
	        boolean flag=false;
	        if(oldList.size()>newList.size())
	        { 
	        	int count=0;
	        	int totalCount=0;
	        	      for(int i=0;i<newList.size();i++)
	        	      {   
	        	        cellCount1=0;
	        	        totalCount++;
	        	        dataRow = sheet.createRow(datarow++);
	        	        newBean=(NewBean)newList.get(i);
	        	        
	        	           if(count<oldList.size()){
	        	                    	  
	        	    	oldBean=(OldBean)oldList.get(count);
	        	    	
	        	    	
		        	   if(oldBean.getTrackingID().equals(newBean.getTrackingID()))
		        	   {
		        		   count++;
		        	    	Cell cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getTrackingID());
		    		        
		    		        
		    		        if(oldBean.getMisPeriod().equals(newBean.getMisPeriod()))
		        	    	{
		    		        	
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getMisPeriod());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	          cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getMisPeriod());
		        	    	}
	
		        	    	if(oldBean.getpONo().equals(newBean.getpONo()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getpONo());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getpONo());
		        	    	}
		        	    	
		        	    	if(oldBean.getTentativePOdate().equals(newBean.getTentativePOdate()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getTentativePOdate());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getTentativePOdate());
		        	    	}
		        	    	
		        	    	if(oldBean.getPoDescription().equals(newBean.getPoDescription()))
		        	    	{
		        	    		
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getPoDescription());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getPoDescription());
		        	    	}
		        	    	
		        	    	if(oldBean.getTcuCode().equals(newBean.getTcuCode()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getTcuCode());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getTcuCode());
		        	    	}	
		        	    	
		        	    	if(oldBean.getTeamLead().equals(newBean.getTeamLead()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getTeamLead());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getTeamLead());
		        	    	}
		        	    	
		        	    	if(oldBean.getProjectName().equals(newBean.getProjectName()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getProjectName());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getProjectName());
		        	    	}
		        	    	
		        	    	if(oldBean.getRelNonRel().equals(newBean.getRelNonRel()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getRelNonRel());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getRelNonRel());
		        	    	}
		        	    	
		        	    	
		        	    	if(oldBean.getTeamSplit().equals(newBean.getTeamSplit()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getTeamSplit());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getTeamSplit());
		        	    	}
		        	    	
		        	    	if(oldBean.getAccountCodes().equals(newBean.getAccountCodes()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getAccountCodes());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getAccountCodes());
		        	    	}
		        	    	
		        	    	
		        	    	if(oldBean.getTechnology().equals(newBean.getTechnology()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getTechnology());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getTechnology());
		        	    	}
		        	    	
		        	    	
		        	    	if(oldBean.getFsCr().equals(newBean.getFsCr()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getFsCr());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getFsCr());
		        	    	}
		        	    	
		        	    	if(oldBean.getItemName().equals(newBean.getItemName()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getItemName());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getItemName());
		        	    	}
		        	    	
		        	    	
		        	    	if(oldBean.getFsCrName().equals(newBean.getFsCrName()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getFsCrName());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getFsCrName());
		        	    	}
		        	    	
		        	    	if(oldBean.getCurrentStatus().equals(newBean.getCurrentStatus()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getCurrentStatus());
		        	    	}else
		        	    	{flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getCurrentStatus());
		        	    	}
	    		        
		        	    	if(oldBean.getChallenge().equals(newBean.getChallenge()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getChallenge());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getChallenge());
		        	    	}
		        	    	
		        	    	if(oldBean.getGeneralRemark().equals(newBean.getGeneralRemark()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getGeneralRemark());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getGeneralRemark());
		        	    	}
		        	    	
		        	    	
		        	    	if(oldBean.getPatch().equals(newBean.getPatch()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getPatch());
		        	    	}else
		        	    	{flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getPatch());
		        	    	}
		        	    	
		        	    	if(oldBean.getAssignedTo().equals(newBean.getAssignedTo()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getAssignedTo());
		        	    	}else
		        	    	{flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getAssignedTo());
		        	    	}
		        	    	
		        	    	
		        	    	if(oldBean.getTotal_Effort_In_ManDays().equals(newBean.getTotal_Effort_In_ManDays()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getTotal_Effort_In_ManDays());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getTotal_Effort_In_ManDays());
		        	    	}
		        	    	
		        	    	if(oldBean.getEffort_In_Man_Days_For_The_Month().equals(newBean.getEffort_In_Man_Days_For_The_Month()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getEffort_In_Man_Days_For_The_Month());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getEffort_In_Man_Days_For_The_Month());
		        	    	}
		        	    	
		        	    	if(oldBean.getEffort_Approval_By().equals(newBean.getEffort_Approval_By()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getEffort_Approval_By());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getEffort_Approval_By());
		        	    	}
		        	    	
		        	    	if(oldBean.getEffortApprovalDate().equals(newBean.getEffortApprovalDate()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getEffortApprovalDate());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getEffortApprovalDate());
		        	    	}
		        	    	
		        	    	if(oldBean.getApproval_Status_Approved_Yet_To_Be_Approved().equals(newBean.getApproval_Status_Approved_Yet_To_Be_Approved()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getApproval_Status_Approved_Yet_To_Be_Approved());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getApproval_Status_Approved_Yet_To_Be_Approved());
		        	    	}
		        	    	
		        	    	if(oldBean.getRequest_Received_Date().equals(newBean.getRequest_Received_Date()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getRequest_Received_Date());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getRequest_Received_Date());
		        	    	}
		        	    	
		        	    	if(oldBean.getRequested_By_BSA().equals(newBean.getRequested_By_BSA()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getRequested_By_BSA());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getRequested_By_BSA());
		        	    	}
		        	    	
		        	    	if(oldBean.getWalkthough_Planned_Date().equals(newBean.getWalkthough_Planned_Date()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getWalkthough_Planned_Date());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getWalkthough_Planned_Date());
		        	    	}
		        	    	
		        	    	if(oldBean.getDev_Planned_Start_Date().equals(newBean.getDev_Planned_Start_Date()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getDev_Planned_Start_Date());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getDev_Planned_Start_Date());
		        	    	}
		        	    	
		        	    	if(oldBean.getDev_Planned_End_date().equals(newBean.getDev_Planned_End_date()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getDev_Planned_End_date());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getDev_Planned_End_date());
		        	    	}
		        	    	
		        	    	if(oldBean.getUAT_Rel_Planned_date().equals(newBean.getUAT_Rel_Planned_date()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getUAT_Rel_Planned_date());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	    		
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getUAT_Rel_Planned_date());
		        	    	}
		        	    	
		        	    	if(oldBean.getActual_Walkthrough_Date().equals(newBean.getActual_Walkthrough_Date()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getActual_Walkthrough_Date());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getActual_Walkthrough_Date());
		        	    	}
		        	    	
		        	    	if(oldBean.getAssigned_For_Development_Date().equals(newBean.getAssigned_For_Development_Date()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getAssigned_For_Development_Date());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getAssigned_For_Development_Date());
		        	    	}
		        	    	
		        	    	if(oldBean.getActual_Dev_Start_Date().equals(newBean.getActual_Dev_Start_Date()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getActual_Dev_Start_Date());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getActual_Dev_Start_Date());
		        	    	}
		        	    	
		        	    	if(oldBean.getActual_Dev_End_date().equals(newBean.getActual_Dev_End_date()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getActual_Dev_End_date());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getActual_Dev_End_date());
		        	    	}
		        	    	
		        	    	if(oldBean.getUat_Promotion_Sent_for_Sign_Off_Date().equals(newBean.getUat_Promotion_Sent_for_Sign_Off_Date()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getUat_Promotion_Sent_for_Sign_Off_Date());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getUat_Promotion_Sent_for_Sign_Off_Date());
		        	    	}
		        	    	
		        	    	
		        	    	
		        	    	if(oldBean.getDelayedDelivery().equals(newBean.getDelayedDelivery()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getDelayedDelivery());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getDelayedDelivery());
		        	    	}
		        	    	
		        	    	if(oldBean.getReasonOfDelay().equals(newBean.getReasonOfDelay()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getReasonOfDelay());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getReasonOfDelay());
		        	    	}	
		        	    	
		        	    	if(oldBean.getiSDocument_Y_Prepared_P_Pending_N_Not_required().equals(newBean.getiSDocument_Y_Prepared_P_Pending_N_Not_required()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getiSDocument_Y_Prepared_P_Pending_N_Not_required());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getiSDocument_Y_Prepared_P_Pending_N_Not_required());
		        	    	}
		        	    	
		        	    	if(oldBean.getReviewed_By().equals(newBean.getReviewed_By()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getReviewed_By());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getReviewed_By());
		        	    	}
		        	    	
		        	    	if(oldBean.getPromotion_Date().equals(newBean.getPromotion_Date()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getPromotion_Date());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getPromotion_Date());
		        	    	}
		        	    	
		        	    	if(oldBean.getPromoted_By().equals(newBean.getPromoted_By()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getPromoted_By());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getPromoted_By());
		        	    	}
		        	    	
		        	    	if(oldBean.getPromotion_Ticket_No().equals(newBean.getPromotion_Ticket_No()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getPromotion_Ticket_No());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getPromotion_Ticket_No());
		        	    	}
		        	    	
		        	    	if(oldBean.getMis_Group().equals(newBean.getMis_Group()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getMis_Group());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getMis_Group());
		        	    	}
		        	    	
		        	    	if(oldBean.getInvoice_No().equals(newBean.getInvoice_No()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getInvoice_No());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getInvoice_No());
		        	    	}
		        	    	
		        	    	if(flag)
		        	    	{
		        	    		cell = dataRow.createCell(cellCount1++);
						        cell.setCellStyle(style);
			    		        cell.setCellValue("Modified Row");
		        	    	}
		        	    	
	        	    	}else
	        	    	{
	        	    		
	  	        	    	  cellCount1=0;
	  	        	    	 
	  	        	    	  oldBean=(OldBean)oldList.get(count);
	  	        	    	  
	  	        	    	 
	  	        	    	  
	  	        	    	  Cell cell = dataRow.createCell(cellCount1++);
	  			    		  cell.setCellStyle(style);
	  			    		  cell.setCellValue((String) oldBean.getTrackingID());
	  			    		  
	  			    		  cell = dataRow.createCell(cellCount1++);
	  			    		  cell.setCellStyle(style);
	  			    		  cell.setCellValue((String) oldBean.getMisPeriod());
	  			    		  
	  			    		  cell = dataRow.createCell(cellCount1++);
	  			    		  cell.setCellStyle(style);
	  			    		  cell.setCellValue((String) oldBean.getpONo());
	  			    		  

			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getTentativePOdate());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getPoDescription());
			        	   
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getTcuCode());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getTeamLead());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getProjectName());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getRelNonRel());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getTeamSplit());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getAccountCodes());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getTechnology());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getFsCr());
			        	    
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getItemName());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getFsCrName());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getCurrentStatus());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getChallenge());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getGeneralRemark());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getPatch());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getAssignedTo());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getTotal_Effort_In_ManDays());
			        	    
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getEffort_In_Man_Days_For_The_Month());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getEffort_Approval_By());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getEffortApprovalDate());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getApproval_Status_Approved_Yet_To_Be_Approved());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getRequest_Received_Date());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getRequested_By_BSA());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getWalkthough_Planned_Date());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getDev_Planned_Start_Date());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getDev_Planned_End_date());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getUAT_Rel_Planned_date());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getActual_Walkthrough_Date());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getAssigned_For_Development_Date());
			        	    
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getActual_Dev_Start_Date());
			        	    	
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getActual_Dev_End_date());
			    		        
			    		        cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getUat_Promotion_Sent_for_Sign_Off_Date());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getDelayedDelivery());
			        	    	
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getReasonOfDelay());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getiSDocument_Y_Prepared_P_Pending_N_Not_required());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getReviewed_By());
			        	    	
			        	    	
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getPromotion_Date());
			    		        
			    		        cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getPromoted_By());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getPromotion_Ticket_No());

			    		        cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getMis_Group());

			        	    	cell = dataRow.createCell(cellCount1++);
			        	    	cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getInvoice_No());
			        	    	
			    		        cell = dataRow.createCell(cellCount1++);
						        cell.setCellStyle(style);
			    		        cell.setCellValue("Deleted Row");
	  			    		  
	  			    		  
			    		        
	  			    		  
	  			    		count++;
	        	    		i--;
	  			    		  
	        	    		
	        	    	}
		        	   
	        	           }else
	        	           {
	        	        	   
	        	        	   System.out.println("oldBean adit+++"+i);
	        	        	   
	        	        	   newBean=(NewBean)newList.get(i);
	 	        	    	  Cell cell = dataRow.createCell(cellCount1++);
	 			    		  cell.setCellStyle(style);
	 			    		  cell.setCellValue((String) newBean.getTrackingID());
	 			    		  
	 			    		  cell = dataRow.createCell(cellCount1++);
	 			    		  cell.setCellStyle(style);
	 			    		  cell.setCellValue((String) newBean.getMisPeriod());
	 			    		  
	 			    		  cell = dataRow.createCell(cellCount1++);
	 			    		  cell.setCellStyle(style);
	 			    		  cell.setCellValue((String) newBean.getpONo());
	 			    		  
	 			        	    
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getTentativePOdate());
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getPoDescription());
	 		        	   
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getTcuCode());
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getTeamLead());
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getProjectName());
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getRelNonRel());
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getTeamSplit());
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getAccountCodes());
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getTechnology());
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getFsCr());
	 		        	    
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getItemName());
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getFsCrName());
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getCurrentStatus());
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getChallenge());
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getGeneralRemark());
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getPatch());
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getAssignedTo());
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getTotal_Effort_In_ManDays());
	 		        	    
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getEffort_In_Man_Days_For_The_Month());
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getEffort_Approval_By());
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getEffortApprovalDate());
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getApproval_Status_Approved_Yet_To_Be_Approved());
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getRequest_Received_Date());
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getRequested_By_BSA());
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getWalkthough_Planned_Date());
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getDev_Planned_Start_Date());
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getDev_Planned_End_date());
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getUAT_Rel_Planned_date());
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getActual_Walkthrough_Date());
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getAssigned_For_Development_Date());
	 		        	    
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getActual_Dev_Start_Date());
	 		        	    	
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getActual_Dev_End_date());
	 		    		        

	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getUat_Promotion_Sent_for_Sign_Off_Date());
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getDelayedDelivery());
	 		        	    	
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getReasonOfDelay());
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getiSDocument_Y_Prepared_P_Pending_N_Not_required());
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getReviewed_By());
	 		        	    	
	 		        	    	
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getPromotion_Date());
	 		        	    	

	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getPromoted_By());
	 		        	    	
	 		    		        
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getPromotion_Ticket_No());
	 		        	    	
	 		        	    	
	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getMis_Group());
	 		        	    	


	 		        	    	cell = dataRow.createCell(cellCount1++);
	 					cell.setCellStyle(style);
	 		    		        cell.setCellValue((String) newBean.getInvoice_No());
	 		        	    	
	 		    		        cell = dataRow.createCell(cellCount1++);
	 					        cell.setCellStyle(style);
	 		    		        cell.setCellValue("Created new Row");
	   			    		  
	 			    		  
	        	        	   
	        	        	   
	        	           }
		        	   
	        	      }
	        	      
	        	  for(int i=totalCount;i<oldList.size();i++)
	        	  {
	        		 
	        		      cellCount1=0;
	        	    	  dataRow = sheet.createRow(datarow++);
	        	    	  oldBean=(OldBean)oldList.get(i);
	        	    	  Cell cell = dataRow.createCell(cellCount1++);
			    		  cell.setCellStyle(style);
			    		  cell.setCellValue((String) oldBean.getTrackingID());
			    		  
			    		  cell = dataRow.createCell(cellCount1++);
			    		  cell.setCellStyle(style);
			    		  cell.setCellValue((String) oldBean.getMisPeriod());
			    		  
			    		  cell = dataRow.createCell(cellCount1++);
			    		  cell.setCellStyle(style);
			    		  cell.setCellValue((String) oldBean.getpONo());
			    		  
			        	    
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getTentativePOdate());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getPoDescription());
		        	   
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getTcuCode());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getTeamLead());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getProjectName());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getRelNonRel());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getTeamSplit());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getAccountCodes());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getTechnology());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getFsCr());
		        	    
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getItemName());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getFsCrName());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getCurrentStatus());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getChallenge());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getGeneralRemark());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getPatch());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getAssignedTo());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getTotal_Effort_In_ManDays());
		        	    
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getEffort_In_Man_Days_For_The_Month());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getEffort_Approval_By());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getEffortApprovalDate());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getApproval_Status_Approved_Yet_To_Be_Approved());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getRequest_Received_Date());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getRequested_By_BSA());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getWalkthough_Planned_Date());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getDev_Planned_Start_Date());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getDev_Planned_End_date());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getUAT_Rel_Planned_date());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getActual_Walkthrough_Date());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getAssigned_For_Development_Date());
		        	    
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getActual_Dev_Start_Date());
		        	    	
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getActual_Dev_End_date());
		    		        

		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getUat_Promotion_Sent_for_Sign_Off_Date());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getDelayedDelivery());
		        	    	
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getReasonOfDelay());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getiSDocument_Y_Prepared_P_Pending_N_Not_required());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					           cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getReviewed_By());
		        	    	
		        	    	
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getPromotion_Date());
		    		        
		    		        cell = dataRow.createCell(cellCount1++);
							cell.setCellStyle(style);
				    		        cell.setCellValue((String) oldBean.getPromoted_By());
		        	    	
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getPromotion_Ticket_No());
		        	    	
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					       cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getMis_Group());
		        	    	


		        	    	cell = dataRow.createCell(cellCount1++);
					        cell.setCellStyle(style);
		    		        cell.setCellValue((String) oldBean.getInvoice_No());
		        	    	
		    		        cell = dataRow.createCell(cellCount1++);
					        cell.setCellStyle(style);
		    		        cell.setCellValue("Deleted Row");
  			    		  
	        		  
	        	  }    
	        	      
	        	      
	        	      
	        
	        	      
	        	
	        }else if(oldList.size()<=newList.size())
	        {
	        	int count=0;
	        	int totalCount=0;
	        	      for(int i=0;i<oldList.size();i++)
	        	      {   
	        	        cellCount1=0;
	        	       
	        	        dataRow = sheet.createRow(datarow++);
	        	    	oldBean=(OldBean)oldList.get(i);
	        	    	
	        	    	newBean=(NewBean)newList.get(count);
	        	    	
		        	   if(oldBean.getTrackingID().equals(newBean.getTrackingID()))
		        	   {
		        		    count++;
		        		    totalCount++;
		        	    	Cell cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getTrackingID());
		    		        
		    		        
		    		        if(oldBean.getMisPeriod().equals(newBean.getMisPeriod()))
		        	    	{
		        	    	 cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getMisPeriod());
		        	    	}else
		        	    	{
		        	    	 flag=true;	
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getMisPeriod());
		        	    	}
	
		        	    	if(oldBean.getpONo().equals(newBean.getpONo()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getpONo());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getpONo());
		        	    	}
		        	    	
		        	    	
		        	    	if(oldBean.getTentativePOdate().equals(newBean.getTentativePOdate()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getTentativePOdate());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getTentativePOdate());
		        	    	}
		        	    	
		        	    	
		        	    	
		        	    	if(oldBean.getPoDescription().equals(newBean.getPoDescription()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getPoDescription());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getPoDescription());
		        	    	}
		        	    	
		        	    	if(oldBean.getTcuCode().equals(newBean.getTcuCode()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getTcuCode());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getTcuCode());
		        	    	}	
		        	    	
		        	    	if(oldBean.getTeamLead().equals(newBean.getTeamLead()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getTeamLead());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getTeamLead());
		        	    	}
		        	    	
		        	    	if(oldBean.getProjectName().equals(newBean.getProjectName()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getProjectName());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getProjectName());
		        	    	}
		        	    	
		        	    	if(oldBean.getRelNonRel().equals(newBean.getRelNonRel()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getRelNonRel());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getRelNonRel());
		        	    	}
		        	    	
		        	    	
		        	    	if(oldBean.getTeamSplit().equals(newBean.getTeamSplit()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getTeamSplit());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getTeamSplit());
		        	    	}
		        	    	
		        	    	if(oldBean.getAccountCodes().equals(newBean.getAccountCodes()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getAccountCodes());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getAccountCodes());
		        	    	}
		        	    	
		        	    	
		        	    	if(oldBean.getTechnology().equals(newBean.getTechnology()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getTechnology());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getTechnology());
		        	    	}
		        	    	
		        	    	
		        	    	if(oldBean.getFsCr().equals(newBean.getFsCr()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getFsCr());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getFsCr());
		        	    	}
		        	    	
		        	    	if(oldBean.getItemName().equals(newBean.getItemName()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getItemName());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getItemName());
		        	    	}
		        	    	
		        	    	
		        	    	if(oldBean.getFsCrName().equals(newBean.getFsCrName()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getFsCrName());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getFsCrName());
		        	    	}
		        	    	
		        	    	if(oldBean.getCurrentStatus().equals(newBean.getCurrentStatus()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getCurrentStatus());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getCurrentStatus());
		        	    	}
	    		        
		        	    	if(oldBean.getChallenge().equals(newBean.getChallenge()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getChallenge());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getChallenge());
		        	    	}
		        	    	
		        	    	if(oldBean.getGeneralRemark().equals(newBean.getGeneralRemark()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getGeneralRemark());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getGeneralRemark());
		        	    	}
		        	    	
		        	    	
		        	    	if(oldBean.getPatch().equals(newBean.getPatch()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getPatch());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getPatch());
		        	    	}
		        	    	
		        	    	if(oldBean.getAssignedTo().equals(newBean.getAssignedTo()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getAssignedTo());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getAssignedTo());
		        	    	}
		        	    	
		        	    	
		        	    	if(oldBean.getTotal_Effort_In_ManDays().equals(newBean.getTotal_Effort_In_ManDays()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getTotal_Effort_In_ManDays());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getTotal_Effort_In_ManDays());
		        	    	}
		        	    	
		        	    	if(oldBean.getEffort_In_Man_Days_For_The_Month().equals(newBean.getEffort_In_Man_Days_For_The_Month()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getEffort_In_Man_Days_For_The_Month());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getEffort_In_Man_Days_For_The_Month());
		        	    	}
		        	    	
		        	    	if(oldBean.getEffort_Approval_By().equals(newBean.getEffort_Approval_By()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getEffort_Approval_By());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getEffort_Approval_By());
		        	    	}
		        	    	
		        	    	if(oldBean.getEffortApprovalDate().equals(newBean.getEffortApprovalDate()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getEffortApprovalDate());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getEffortApprovalDate());
		        	    	}
		        	    	
		        	    	if(oldBean.getApproval_Status_Approved_Yet_To_Be_Approved().equals(newBean.getApproval_Status_Approved_Yet_To_Be_Approved()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getApproval_Status_Approved_Yet_To_Be_Approved());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getApproval_Status_Approved_Yet_To_Be_Approved());
		        	    	}
		        	    	
		        	    	if(oldBean.getRequest_Received_Date().equals(newBean.getRequest_Received_Date()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getRequest_Received_Date());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getRequest_Received_Date());
		        	    	}
		        	    	
		        	    	if(oldBean.getRequested_By_BSA().equals(newBean.getRequested_By_BSA()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getRequested_By_BSA());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getRequested_By_BSA());
		        	    	}
		        	    	
		        	    	if(oldBean.getWalkthough_Planned_Date().equals(newBean.getWalkthough_Planned_Date()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getWalkthough_Planned_Date());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getWalkthough_Planned_Date());
		        	    	}
		        	    	
		        	    	if(oldBean.getDev_Planned_Start_Date().equals(newBean.getDev_Planned_Start_Date()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getDev_Planned_Start_Date());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getDev_Planned_Start_Date());
		        	    	}
		        	    	
		        	    	if(oldBean.getDev_Planned_End_date().equals(newBean.getDev_Planned_End_date()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getDev_Planned_End_date());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getDev_Planned_End_date());
		        	    	}
		        	    	
		        	    	if(oldBean.getUAT_Rel_Planned_date().equals(newBean.getUAT_Rel_Planned_date()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getUAT_Rel_Planned_date());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getUAT_Rel_Planned_date());
		        	    	}
		        	    	
		        	    	if(oldBean.getActual_Walkthrough_Date().equals(newBean.getActual_Walkthrough_Date()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getActual_Walkthrough_Date());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getActual_Walkthrough_Date());
		        	    	}
		        	    	
		        	    	if(oldBean.getAssigned_For_Development_Date().equals(newBean.getAssigned_For_Development_Date()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getAssigned_For_Development_Date());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getAssigned_For_Development_Date());
		        	    	}
		        	    	
		        	    	if(oldBean.getActual_Dev_Start_Date().equals(newBean.getActual_Dev_Start_Date()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getActual_Dev_Start_Date());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getActual_Dev_Start_Date());
		        	    	}
		        	    	
		        	    	if(oldBean.getActual_Dev_End_date().equals(newBean.getActual_Dev_End_date()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getActual_Dev_End_date());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getActual_Dev_End_date());
		        	    	}
		        	    	
		        	    	if(oldBean.getUat_Promotion_Sent_for_Sign_Off_Date().equals(newBean.getUat_Promotion_Sent_for_Sign_Off_Date()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getUat_Promotion_Sent_for_Sign_Off_Date());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getUat_Promotion_Sent_for_Sign_Off_Date());
		        	    	}
		        	    	
		        	    	
		        	    	
		        	    	if(oldBean.getDelayedDelivery().equals(newBean.getDelayedDelivery()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getDelayedDelivery());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getDelayedDelivery());
		        	    	}
		        	    	
		        	    	if(oldBean.getReasonOfDelay().equals(newBean.getReasonOfDelay()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getReasonOfDelay());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getReasonOfDelay());
		        	    	}	
		        	    	
		        	    	if(oldBean.getiSDocument_Y_Prepared_P_Pending_N_Not_required().equals(newBean.getiSDocument_Y_Prepared_P_Pending_N_Not_required()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getiSDocument_Y_Prepared_P_Pending_N_Not_required());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getiSDocument_Y_Prepared_P_Pending_N_Not_required());
		        	    	}
		        	    	
		        	    	if(oldBean.getReviewed_By().equals(newBean.getReviewed_By()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getReviewed_By());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getReviewed_By());
		        	    	}
		        	    	
		        	    	if(oldBean.getPromotion_Date().equals(newBean.getPromotion_Date()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getPromotion_Date());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getPromotion_Date());
		        	    	}
		        	    	
		        	    	if(oldBean.getPromoted_By().equals(newBean.getPromoted_By()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getPromoted_By());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getPromoted_By());
		        	    	}
		        	    	
		        	    	if(oldBean.getPromotion_Ticket_No().equals(newBean.getPromotion_Ticket_No()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getPromotion_Ticket_No());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getPromotion_Ticket_No());
		        	    	}
		        	    	
		        	    	if(oldBean.getMis_Group().equals(newBean.getMis_Group()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getMis_Group());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getMis_Group());
		        	    	}
		        	    	
		        	    	if(oldBean.getInvoice_No().equals(newBean.getInvoice_No()))
		        	    	{
		        	    	cell = dataRow.createCell(cellCount1++);
		    		        cell.setCellValue((String) oldBean.getInvoice_No());
		        	    	}else
		        	    	{
		        	    		flag=true;
		        	         cell = dataRow.createCell(cellCount1++);
			    		     cell.setCellStyle(style);
			    		     cell.setCellValue((String) newBean.getInvoice_No());
		        	    	}
		        	    	if(flag)
		        	    	{
		        	    		cell = dataRow.createCell(cellCount1++);
						        cell.setCellStyle(style);
			    		        cell.setCellValue("Modified Row");
		        	    	}
	        	    	}else
	        	    	{
	        	    		
	  	        	    	  cellCount1=0;
	  	        	    	 // dataRow = sheet.createRow(datarow++);
	  	        	    	  oldBean=(OldBean)oldList.get(i);
	  	        	    	  Cell cell = dataRow.createCell(cellCount1++);
	  			    		  cell.setCellStyle(style);
	  			    		  cell.setCellValue((String) oldBean.getTrackingID());
	  			    		  
	  			    		  cell = dataRow.createCell(cellCount1++);
	  			    		  cell.setCellStyle(style);
	  			    		  cell.setCellValue((String) oldBean.getMisPeriod());
	  			    		  
	  			    		  cell = dataRow.createCell(cellCount1++);
	  			    		  cell.setCellStyle(style);
	  			    		  cell.setCellValue((String) oldBean.getpONo());
	  			    		
	  		        	    
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getTentativePOdate());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getPoDescription());
			        	   
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getTcuCode());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getTeamLead());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getProjectName());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getRelNonRel());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getTeamSplit());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getAccountCodes());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getTechnology());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getFsCr());
			        	    
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getItemName());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getFsCrName());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getCurrentStatus());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getChallenge());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getGeneralRemark());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getPatch());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getAssignedTo());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getTotal_Effort_In_ManDays());
			        	    
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getEffort_In_Man_Days_For_The_Month());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getEffort_Approval_By());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getEffortApprovalDate());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getApproval_Status_Approved_Yet_To_Be_Approved());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getRequest_Received_Date());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getRequested_By_BSA());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getWalkthough_Planned_Date());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getDev_Planned_Start_Date());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getDev_Planned_End_date());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getUAT_Rel_Planned_date());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getActual_Walkthrough_Date());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getAssigned_For_Development_Date());
			        	    
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getActual_Dev_Start_Date());
			        	    	
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getActual_Dev_End_date());
			    		        

			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getUat_Promotion_Sent_for_Sign_Off_Date());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getDelayedDelivery());
			        	    	
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getReasonOfDelay());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getiSDocument_Y_Prepared_P_Pending_N_Not_required());
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getReviewed_By());
			        	    	
			        	    	
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getPromotion_Date());
			        	    	

			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getPromoted_By());
			        	    	
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getPromotion_Ticket_No());
			        	    	
			        	    	
			        	    	cell = dataRow.createCell(cellCount1++);
						cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getMis_Group());
			        	    	


			        	    	cell = dataRow.createCell(cellCount1++);
						        cell.setCellStyle(style);
			    		        cell.setCellValue((String) oldBean.getInvoice_No());
			        	    	
	  			    		  
			    		        cell = dataRow.createCell(cellCount1++);
						        cell.setCellStyle(style);
			    		        cell.setCellValue("Deleted Row");
	  			    		  
	  			    		  
	        	    		
	        	    	}
	        	      }
	        	      
	        	      for(int i=totalCount;i<newList.size();i++)
	        	      {
	        	    	  cellCount1=0;
	        	    	  dataRow = sheet.createRow(datarow++);
	        	    	  newBean=(NewBean)newList.get(i);
	        	    	  Cell cell = dataRow.createCell(cellCount1++);
			    		  cell.setCellStyle(style);
			    		  cell.setCellValue((String) newBean.getTrackingID());
			    		  
			    		  cell = dataRow.createCell(cellCount1++);
			    		  cell.setCellStyle(style);
			    		  cell.setCellValue((String) newBean.getMisPeriod());
			    		  
			    		  cell = dataRow.createCell(cellCount1++);
			    		  cell.setCellStyle(style);
			    		  cell.setCellValue((String) newBean.getpONo());
			    		  
			        	    
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getTentativePOdate());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getPoDescription());
		        	   
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getTcuCode());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getTeamLead());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getProjectName());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getRelNonRel());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getTeamSplit());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getAccountCodes());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getTechnology());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getFsCr());
		        	    
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getItemName());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getFsCrName());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getCurrentStatus());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getChallenge());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getGeneralRemark());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getPatch());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getAssignedTo());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getTotal_Effort_In_ManDays());
		        	    
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getEffort_In_Man_Days_For_The_Month());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getEffort_Approval_By());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getEffortApprovalDate());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getApproval_Status_Approved_Yet_To_Be_Approved());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getRequest_Received_Date());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getRequested_By_BSA());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getWalkthough_Planned_Date());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getDev_Planned_Start_Date());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getDev_Planned_End_date());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getUAT_Rel_Planned_date());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getActual_Walkthrough_Date());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getAssigned_For_Development_Date());
		        	    
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getActual_Dev_Start_Date());
		        	    	
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getActual_Dev_End_date());
		    		        

		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getUat_Promotion_Sent_for_Sign_Off_Date());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getDelayedDelivery());
		        	    	
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getReasonOfDelay());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getiSDocument_Y_Prepared_P_Pending_N_Not_required());
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getReviewed_By());
		        	    	
		        	    	
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getPromotion_Date());
		        	    	

		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getPromoted_By());
		        	    	
		    		        
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getPromotion_Ticket_No());
		        	    	
		        	    	
		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getMis_Group());
		        	    	


		        	    	cell = dataRow.createCell(cellCount1++);
					cell.setCellStyle(style);
		    		        cell.setCellValue((String) newBean.getInvoice_No());
		        	    	
		    		        cell = dataRow.createCell(cellCount1++);
					        cell.setCellStyle(style);
		    		        cell.setCellValue("Created new Row");
  			    		  
			    		  
			    		  
	        	      }
	        	      
	        }else
	        {
	        	
	        }
	         
	        FileOutputStream outputStream = new FileOutputStream(res.getString("newfileupload"));
	            workbook.write(outputStream);
	        }catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
          }


public static void main(String[] args) throws IOException {
	
	//CreateExlFile.createExcel();
}
}