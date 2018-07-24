package com.test.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcellTool
{
	static Logger logger = Logger.getLogger(ExcellTool.class);
	public List<List<String>> loadListFromValidExcel(String path)
	{
		logger.info("ExcellTool :: loadListFromValidExcel start executing .... ");
		logger.info("File path "+path);
		Map returnMap=new HashMap();
		List<List<String>> dataList =null;
		try
		{	
			File file = new File(path);
			String fileName = file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf(File.separator)+1, file.getAbsolutePath().length());
			String[] dots = fileName.split("\\.",-1);
			String fileType = dots[dots.length-1];
			fileType = fileType.toLowerCase();
			logger.info("file type "+fileType+"    file "+file);
			Sheet sheet = getSheet(fileType, file);
			Row row;
			Cell cell;
			int rows;
			rows = sheet.getPhysicalNumberOfRows();            
			int cols = 0;
			int tmpCols = 0;
			List<String> data = null;
			String status="";
			
			for(int i = 0; i < rows; i++)
			{
				row = sheet.getRow(i);
				if(row != null)
				{
					tmpCols = sheet.getRow(i).getPhysicalNumberOfCells();
					if(tmpCols > cols)
						cols = tmpCols;
				}				
			}
			if(!status.equals("H"))
			{
				dataList = new ArrayList<List<String>>();
				for(int r = 0; r < rows; r++)
				{
					row = sheet.getRow(r);
					
					if(row != null)
					{		
						data = new ArrayList<String>();
						//						for(int c = 0; c < 12; c++)
						for(int c = 0; c < cols; c++)
						{
							cell = row.getCell((short)c);
							String cellValue = "";
							DataFormatter df = new DataFormatter();
							if(cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK)
							{
								//System.out.println("BlankVaLUEs");
								data.add("");
							}
							else if(null!=cell)
							{
								cellValue  = df.formatCellValue(cell);
								if(cellValue.contains("*"))
								{
									double dval = cell.getNumericCellValue();
									float fval = (float) (dval%1);
									if(fval!=0.0F)
									{
										cellValue = ((double)dval)+"";
									}else
									{
										cellValue = ((long)dval)+"";
									}
									data.add(cellValue);
								}
								else if(!cellValue.equalsIgnoreCase(""))
								{

									data.add(cellValue);
								}
							}

						}
//						System.out.println("+++ "+data);
						
						dataList.add(data);
						status="S";
					}					
				}			
			}
		}
		catch(Exception ioe)
		{
			logger.info("exception in loadListFromValidExcel while reading excel sheet "+ioe);
		}
		logger.info("ExcellTool :: loadListFromValidExcel Ending.... ");
		return dataList;
	}

	public Sheet getSheet(String extn,File file) 
	{
		Workbook workbook=null;
		Sheet sheet=null;
		InputStream fileStream=null;
		try
		{
		fileStream = new FileInputStream(file);
		logger.info("Getting workbook from File:-");
		
			if (extn.equalsIgnoreCase("xlsx"))
			{
				workbook=new XSSFWorkbook(fileStream);
				workbook= WorkbookFactory.create(file);
				logger.info("File type is XLSX:- and sheet name is:-"+workbook.getSheetName(0));
				sheet = workbook.getSheetAt(0);
			}
			else if (extn.equalsIgnoreCase("xls"))
			{
				POIFSFileSystem fs = new POIFSFileSystem(fileStream);
				workbook=new HSSFWorkbook(fs);
				logger.info("File type is XLS:- and sheet name is:-"+workbook.getSheetName(0));
				sheet = workbook.getSheetAt(0);
			}
		}
		catch(Exception e)
		{
             logger.error("Error in getting sheet from workbook :-"+e,new Throwable());
		}
		logger.info("Getting out workbook from File:-");	
		return sheet;
	}


	private byte[] getBytesFromFile(File file) throws IOException,Exception
	{
		InputStream is = new FileInputStream(file);
		long length = file.length();
		if (length > Integer.MAX_VALUE)
		{
			System.out.println("File too big");
		}

		byte[] bytes = new byte[(int)length];
		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0)
		{
			offset += numRead;
		}

		if (offset < bytes.length)
		{
		  throw new IOException("Could not completely read file "+file.getName());
		}
		is.close();
		return bytes;
	}
	public static void main(String[] args) 
	{

	}

}