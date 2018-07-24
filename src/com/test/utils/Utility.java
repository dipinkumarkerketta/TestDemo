package com.test.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import org.apache.log4j.Logger;

import com.test.controller.ControllerClass;

public class Utility {

	static Logger logger = Logger.getLogger(Utility.class.getName());
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
	
	public static String getUniqueProposalNumber() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 12) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	

	



	public static String MODE_LNAME;
	public static String MODE_UNAME;
	public static double planType;
	
	public static String formatString(String s) {
		
		if (s != null && !s.equals("")) {
			try {
				return s.trim();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return s;
			}
		} else {
			return s;
		}
	}
	
	public String getCharArr(String c) {
		char[] result = c.toCharArray();
		String res="";
		
		for(char temp:result){
			res  = res+"   "+temp;
		}
		return res;
	}
	
	/*public Integer getAge(UserDetailsForm udf)
	{
		int mnth = Integer.parseInt((udf
				.getDob().toString()).substring(3, 5));
		int year = Integer.parseInt((udf
				.getDob().toString()).substring(6, 10));
		int day = Integer.parseInt((udf
				.getDob().toString()).substring(0,2));
		Calendar cal = Calendar.getInstance();
		int currentYear = cal.get(Calendar.YEAR);
		int currentMnth = cal.get(Calendar.MONTH)+1;
		int currentDay = cal.get(Calendar.DAY_OF_MONTH);
		int age = (currentYear - year);
		if (mnth > currentMnth)
		{
			age--;
		}
		else if(mnth == currentMnth)
		{
			if(day > currentDay )
			{
				age--;
			}
		}
		return age;
	}*/
	
	
	 @SuppressWarnings("finally")
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

	 public static int getNumberOfMonths(Date fromDate, Date toDate) {
		    int monthCount = 0;
		    Calendar cal = Calendar.getInstance();
		    cal.setTime(fromDate);
		    int c1date = cal.get(Calendar.DATE);
		    int c1month = cal.get(Calendar.MONTH);
		    c1month=c1month+1;
		    int c1year = cal.get(Calendar.YEAR);
		    cal.setTime(toDate);
		    int c2date = cal.get(Calendar.DATE);
		    int c2month = cal.get(Calendar.MONTH);
		    c2month=c2month+1;
		    int c2year = cal.get(Calendar.YEAR);
		    System.out.println(" c1date:"+c1date+" month:"+c1month+" year:"+c1year);
		    System.out.println(" c2date:"+c2date+" month:"+c2month+" year:"+c2year);
		    GregorianCalendar grCal = new GregorianCalendar();
		    boolean isLeapYear1 = grCal.isLeapYear(c1year);
		    boolean isLeapYear2 = grCal.isLeapYear(c2year);
		    monthCount = ((c2year - c1year) * 12) + (c2month - c1month);
		    if(isLeapYear2 && c2month == 1 && c2date == 29){
		        monthCount = monthCount+ ((c1date == 28)?0:1);
		    }else if(isLeapYear1 && c1month == 1 && c1date == 29){
		        monthCount = monthCount+ ((c2date == 28)?0:1);
		    }else{
		        monthCount = monthCount+ ((c2date >= c1date)?0:1);
		    }
		    return monthCount;

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
			}
			return curDate;
		}
		public static Date getStringToDate(String date)
		{
			java.util.Date curDate=null;
			SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
			try{
				
				
				curDate = df.parse(date);
				System.out.println("String to Date: " + curDate);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return curDate;
		}
		public static Date getStringToDate2(String date)
		{
			java.util.Date curDate=null;
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
			try{
				curDate = df.parse(date);
				System.out.println("String to Date: " + curDate);
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return curDate;
		}
		
		public static Integer calculateMonthDiff(Date begining, Date end) throws Exception {

	        if (begining.compareTo(end) > 0) {
	            throw new Exception("Beginning date is greater than the ending date");
	        }

	        if (begining.compareTo(end) == 0) {
	            return 0;
	        }

	        Calendar cEndCheckDate = Calendar.getInstance();
	        cEndCheckDate.setTime(begining);
	        int add = 0;
	        while (true) {
	            cEndCheckDate.add(Calendar.MONTH, 1);
	            add++;
	            if (cEndCheckDate.getTime().compareTo(end) > 0) {
	                return add - 1;
	            }
	        }
	    }

		public static java.sql.Date stringToSqlDateFormat1(String strDate){
				
			   SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
			   java.util.Date date=null;
			try {
				date = sdf1.parse(strDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			   java.sql.Date sqlStartDate = (java.sql.Date) new java.sql.Date(date.getTime()); 
			   return sqlStartDate;
		} 
		
		public static java.sql.Date stringToSqlDate(String strDate){
			
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yy");
			java.util.Date date=null;
			try {
				date = sdf1.parse(strDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			java.sql.Date sqlStartDate = (java.sql.Date) new java.sql.Date(date.getTime()); 
			return sqlStartDate;
		} 
		
		public static String getStringDate(java.sql.Date sqlStartDate){
			SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
			String StringDate=sdf2.format(sqlStartDate);
			return StringDate;
		}
		
		public static String getFormattedStringDate(String  stringDate){
			
			java.util.Date curDate=null;
			String StringDate="";
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
			try{
				curDate = df.parse(stringDate);
				System.out.println("String to Date: " + curDate);
				SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
				 StringDate=sdf2.format(curDate);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return StringDate;
		}
		
		public static String[] getDateStringSplit(String stringDate){
			String [] splitStr=null;
			
			java.util.Date curDate=null;
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
			try{
				curDate = df.parse(stringDate);
				System.out.println("String to Date: " + curDate);
				SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
				splitStr=sdf2.format(curDate).split("/");
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return splitStr;
		}
		
		public static char[] getCharArray(String ss){
			String originalString = ss;
			char[] charArray = originalString.toCharArray();
			return charArray;
		}
		
		
		public static String nullThenBlank(String value) {
			String data = "";
			try {
				if (null != value) {
					data = value;
				}
			} catch (Exception e) {
				logger.info("creating excepiton in nullThenBlank " + e);
			}
			return data;
		}
		
		
	 public static void main(String[] args) throws Exception {
		// String from="28-Jul-2016";
		 //Date curdate= new Date();
		// String end="31-Mar-2017";
		 //Date fromm=getStringToDate(from);
		 //Date endd=getStringToDate(end);
		 //System.out.println(calculateMonthDiff(new Date(),getStringToDate("31-Mar-2017")));
		// System.out.println(new Utility().commaSepratedIndianFormat("12"));
		 //System.out.println(new Utility().commaSeprated("11111111"));
		 System.out.println(stringToSqlDate("01/05/1988"));
		 System.out.println(getStringDate(stringToSqlDate("01/05/1988")));
		 System.out.println(getFormattedStringDate("01/11/20"));
		 
		 String date="01/11/20";
		 String []dd=Utility.getDateStringSplit(date);
		 System.out.println(dd[0]);
		 
		 char s[]=getCharArray("asdjudsgfjds");
		 System.out.println(s[0]);
		 System.out.println(s[1]);
		 System.out.println(s[2]);
		 System.out.println(s[3]);
		 System.out.println(s[4]);
		 
	}
}
