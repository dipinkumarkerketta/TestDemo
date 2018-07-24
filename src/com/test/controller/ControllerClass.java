package com.test.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.test.entity.RegistrationEntity;
import com.test.pojo.OldBean;
import com.test.pojo.NewBean;
import com.test.service.ServiceInterface;
import com.test.utils.CreateExlFile;
import com.test.utils.ExcellTool;
import com.test.utils.FileRead;
import com.test.utils.Utility;

@Controller
public class ControllerClass 
{
	static Logger logger = Logger.getLogger(ControllerClass.class.getName());
	//@Autowired ServiceInterface service;
	ResourceBundle res=ResourceBundle.getBundle("application");
	
	
	@RequestMapping(method = RequestMethod.GET, value = { "login" })
	public String Login()
	{
		logger.info("UserController | Login() | :- START");
		System.out.println("login start....");
		logger.info("UserController | Login() | :- END");
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = { "logincheck" })
	public String LoginCheck(HttpServletRequest request ,Model model)
	{
		logger.info("UserController | LoginCheck() | :- START");
		String res="";
		String userName=request.getParameter("username");
		String Password=request.getParameter("password");
		
		if(userName.equals("admin") && Password.equals("admin")){
			res="fileupload";
		}else{
			model.addAttribute("wrongUser","User Id or Password Wrong!");
			res="login";
		}
		logger.info("UserController | LoginCheck() | :- END");
		return res;
	}

	
/*	@RequestMapping(method = RequestMethod.GET, value = { "downloadfile" })
	public  String downloadFile()
	{
		logger.info("UserController | homePage() | :- START");
		 
		logger.info("UserController | homePage() | :- END");
		return "fileupload";
	}
*/	
	@RequestMapping(method = RequestMethod.POST, value = { "uploadExcel" })
	public String userLoginShow(Model model,HttpSession session,@RequestParam("file") List < MultipartFile > files)
	{
		logger.info("UserController | userLoginShow() | :- START");
		
         if (!files.isEmpty())
         {		
		
        	 for (MultipartFile file: files)
             {
        		
        		try{
        		InputStream in = file.getInputStream();
             	String filename = file.getOriginalFilename();
             	System.out.println("file name "+filename);
             	
             	String fileLocation =  res.getString("uploadPath")+file.getOriginalFilename();
                FileOutputStream f = new FileOutputStream(fileLocation);
                int ch = 0;
                while ((ch = in.read()) != -1) {
                    f.write(ch);
                }
                f.flush();
                f.close();
             }catch (Exception e)
        	{
				logger.info("creating exception UserController | userLoginShow() for uploading file  "+e);
			}
              }
         }
		
		
		List excelData=null;
		List excelDataNew=null;
		String path=res.getString("uploadPath");
		//String filename="Java Dev MIS with tracking ID.xlsx";
		String oldFile="oldfile.xlsx";
		String newFile="newfile.xlsx";
		
		ArrayList list = null;
		ArrayList newList = null;
		OldBean beanOne = null;
		NewBean beanTwo = null;
		ArrayList oldlist = null;
		ArrayList newlist = null;
		
		try{
			
			excelData = new ExcellTool().loadListFromValidExcel(path + File.separator + oldFile);
			if (excelData != null && !excelData.isEmpty())
			{
				System.out.println("size__"+excelData.size());
				oldlist = new ArrayList();
				for (int i = 1; i < excelData.size(); i++)
				{
					int k = 0;
					beanOne = new OldBean();
					list = (ArrayList<String>) excelData.get(i);

					if (list != null && !list.isEmpty() && list.size()<=45) 
					{
                            beanOne.setTrackingID(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setMisPeriod(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setpONo(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setTentativePOdate(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setPoDescription(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setTcuCode(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setTeamLead(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setProjectName(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setRelNonRel(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setTeamSplit(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setAccountCodes(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setTechnology(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setFsCr(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setItemName(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setFsCrName(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setCurrentStatus(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setChallenge(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setGeneralRemark(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setPatch(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setAssignedTo(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setTotal_Effort_In_ManDays(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setEffort_In_Man_Days_For_The_Month(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setEffort_Approval_By(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setEffortApprovalDate(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setApproval_Status_Approved_Yet_To_Be_Approved(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setRequest_Received_Date(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setRequested_By_BSA(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setWalkthough_Planned_Date(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setDev_Planned_Start_Date(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setDev_Planned_End_date(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setUAT_Rel_Planned_date(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setActual_Walkthrough_Date(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setAssigned_For_Development_Date(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setActual_Dev_Start_Date(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setActual_Dev_End_date(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setUat_Promotion_Sent_for_Sign_Off_Date(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setDelayedDelivery(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setReasonOfDelay(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setiSDocument_Y_Prepared_P_Pending_N_Not_required(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setReviewed_By(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setPromotion_Date(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setPromoted_By(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setPromotion_Ticket_No(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setMis_Group(Utility.nullThenBlank(list.get(k++).toString()));
							beanOne.setInvoice_No(Utility.nullThenBlank(list.get(k++).toString()));
						
					}
					 oldlist.add(beanOne);
					}
				     
				
				excelDataNew = new ExcellTool().loadListFromValidExcel(path + File.separator +newFile);
				if (excelDataNew != null && !excelDataNew.isEmpty())
				{
					System.out.println("size__"+excelData.size());
					newlist = new ArrayList();
					for (int i = 1; i < excelDataNew.size(); i++)
					{
						int k = 0;
						beanTwo = new NewBean();
						newList = (ArrayList<String>) excelDataNew.get(i);

						if (newList != null && !newList.isEmpty() && newList.size()<=45) 
						{
							    beanTwo.setTrackingID(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setMisPeriod(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setpONo(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setTentativePOdate(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setPoDescription(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setTcuCode(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setTeamLead(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setProjectName(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setRelNonRel(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setTeamSplit(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setAccountCodes(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setTechnology(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setFsCr(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setItemName(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setFsCrName(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setCurrentStatus(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setChallenge(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setGeneralRemark(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setPatch(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setAssignedTo(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setTotal_Effort_In_ManDays(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setEffort_In_Man_Days_For_The_Month(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setEffort_Approval_By(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setEffortApprovalDate(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setApproval_Status_Approved_Yet_To_Be_Approved(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setRequest_Received_Date(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setRequested_By_BSA(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setWalkthough_Planned_Date(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setDev_Planned_Start_Date(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setDev_Planned_End_date(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setUAT_Rel_Planned_date(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setActual_Walkthrough_Date(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setAssigned_For_Development_Date(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setActual_Dev_Start_Date(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setActual_Dev_End_date(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setUat_Promotion_Sent_for_Sign_Off_Date(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setDelayedDelivery(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setReasonOfDelay(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setiSDocument_Y_Prepared_P_Pending_N_Not_required(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setReviewed_By(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setPromotion_Date(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setPromoted_By(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setPromotion_Ticket_No(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setMis_Group(Utility.nullThenBlank(newList.get(k++).toString()));
								beanTwo.setInvoice_No(Utility.nullThenBlank(newList.get(k++).toString()));
						}
						  newlist.add(beanTwo);
						}
			    	}

				      if(oldlist!=null && newlist!=null)
				      {
				    	CreateExlFile.createExcel(oldlist,newlist);
				        System.out.println("Sheet Updated successfully");
				      }
			}
			else
			{
		      logger.info("Excel is cooming blank");
			}
		}catch(Exception e)
		{
		e.printStackTrace();	
		}
		logger.info("UserController | userLoginShow() | :- END");
		return "fileupload";
	}
	
}
