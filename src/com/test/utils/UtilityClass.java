package com.test.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

public class UtilityClass {

	static Logger logger=Logger.getLogger(UtilityClass.class.getName());
	
	public String getCharArr(String c) {
		char[] result = c.toCharArray();
		String res="";
		
		for(char temp:result){
			res  = res+"    "+temp;
		}
		return res;
	}
	public String getCharSpace(String c) {
		char[] result = c.toCharArray();
		String res="";
		
		for(char temp:result){
			res  = res+"     "+temp;
		}
		return res;
	}
	
	public String getCharSpaceFour(String c) {
		char[] result = c.toCharArray();
		String res="";
		
		for(char temp:result){
			res  = res+"    "+temp;
		}
		return res;
	}
	public String getCharSpaceThree(String c) {
		char[] result = c.toCharArray();
		String res="";
		
		for(char temp:result){
			res  = res+"   "+temp;
		}
		return res;
	}
	
	public  String getSpace(String input ,int no){
		String s="";
		for(int i=0; i<=no;i++){
			s+=" ";
		}
		
		char[] result = input.toCharArray();
	
		String res="";
		for(char temp:result){
			res  = res+s+temp;
		}
		return res;
		
		
	}

//	added by Rishabh Sharma
	public String getCharArrPage2(String c) {
		char[] result = c.toCharArray();
		String res="";
		
		for(char temp:result){
			res  = res+"   "+temp;
		}
		return res;
	}
//	added by Rishabh Sharma
	public String getCharArrPage2L(String c) {
		char[] result = c.toCharArray();
		String res="";
		
		for(char temp:result){
			res  = res+"     "+temp;
		}
		return res;
	}
//	added by Rishabh Sharma
	public String getCharArrPage2M(String c) {
		char[] result = c.toCharArray();
		String res="";
		
		for(char temp:result){
			res  = res+"    "+temp;
		}
		return res;
	}
	
	public String getDateToString(Date date)
	{
		String curDate=null;
		try{
			 SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
			 curDate = df.format(date);
			 System.out.println("DateTo String: " + curDate);
		}
		catch(Exception e){
			e.printStackTrace();
			logger.info("error while convert date to string");
		}
		return curDate;
	}
	public Date getDateToStringInFormat(String str)
	{
		
		Date curDate=null;
		try{
			//String str = "2000-05-12T12:00"; 
			SimpleDateFormat parserSDF = new SimpleDateFormat("yyyy-MM-dd");
			curDate = parserSDF.parse(str);
			Calendar cal = Calendar.getInstance();
			cal.setTime(curDate);
			System.out.println(cal.get(Calendar.DAY_OF_MONTH));
			System.out.println(cal.get(Calendar.MONTH)); // month in the Calendar class begins from 0
			System.out.println(cal.get(Calendar.YEAR));
			System.out.println(cal.get(Calendar.HOUR_OF_DAY));
			System.out.println(cal.get(Calendar.MINUTE));
			System.out.println(cal.get(Calendar.SECOND));
		}
		catch(Exception e){
			e.printStackTrace();
			logger.info("error while convert date to string");
		}
		return curDate;
	}
	public Date getStringToDate(String date)
	{
		Date curDate=null;
		SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		try{
			
			
			curDate = df.parse(date);
			System.out.println("String to Date: " + curDate);
		}
		catch(Exception e){
			e.printStackTrace();
			logger.info("error while convert string to date");
		}
		return curDate;
	}
	
		public static void main(String[] args) {
			
			reverseString("4546");//212254546 52212@98@6454
		 }
		
		public static String reverseString(String input)
		{
			String  reverse = "";
		      int length = input.length();
		      for ( int i = length - 1 ; i >= 0 ; i-- )
		    	  	reverse = reverse + input.charAt(i);
		      		System.out.println("Reverse of entered string is: "+reverse);
			return reverse;
		}
		
		public byte[] getBytesFromFile(File file) throws IOException,Exception
		{
			logger.debug("Inside getBytesFromFile... Method");
			InputStream is = new FileInputStream(file);
			long length = file.length();
			if (length > Integer.MAX_VALUE)
			{
	
			}

			byte[] bytes = new byte[(int)length];
			int offset = 0;
			int numRead = 0;
			while (offset < bytes.length
					&& (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0)
			{
				offset += numRead;
			}

			if (offset < bytes.length)
			{
				throw new IOException("Could not completely read file "+file.getName());
			}
			is.close();
			logger.debug("Exiting getBytesFromFile... Method");
			return bytes;
		}
		
		public String commaSeprated(String str) {
	         double d = 0;
	         
	         DecimalFormat twoDForm = new DecimalFormat(",###");
	         try
	         {
	         	if((str == null) || (str.equals("")) || (str.equals("")))
	     		{
	             	d  = 0;
	     		}
	             else
	             	d = Double.parseDouble(str);
	         }
	         catch(Exception ex)
	         {
	             ex.printStackTrace();
	         }
	         finally
	         {
	             return twoDForm.format(d);
	         }
		}

		 public String age(String userDob) throws Exception{
				
			 	int age=0;
				boolean isNum =true;
				Calendar dob = Calendar.getInstance();
				
				if(userDob!=null && userDob!=""){
					String dateArr[] = userDob.split("-");
					isNum = userDob.length()>5 ? isNumeric(userDob.substring(4, 5)) : isNum; 
					SimpleDateFormat sdf =dateArr[0].length()==4? new SimpleDateFormat("yyyy-MM-dd") : isNum ? new SimpleDateFormat("dd-MM-yyyy"):new SimpleDateFormat("dd-MMM-yyyy");
					Date d= sdf.parse(userDob);
					dob.setTime(d);
					Calendar today = Calendar.getInstance();
					age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
					if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR))
						age--;
					
				}System.out.println("new age "+ age);
				return age==0? " " : String.valueOf(age);
			}
			
			public static boolean isNumeric(String str){
			    return str.matches("-?\\d+(.\\d+)?");
			}
			
		 @SuppressWarnings("finally")
		public String commaSepratedIndianFormat(String str) {
	         String s = ""; 
	         if(str.length()>1){
	             s = str.substring(str.length()-1, str.length());
	             str = str.substring(0, str.length()-1);
	          }
	         double d = 0;
	         DecimalFormat twoDForm = new DecimalFormat(",##");
	         try
	         {
	         	if((str == null) || (str.equals("")) || (str.equals("")))
	     		{
	             	d  = 0;
	     		}
	             else
	             	d = Double.parseDouble(str);
	         }
	         catch(Exception ex)
	         {
	             ex.printStackTrace();
	         }
	         finally
	         {
	             return (twoDForm.format(d)+s);
	         }
	     }
}
