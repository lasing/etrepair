package com.liveneo.etrepair.common;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liveneo.etrepair.pojo.RepairTask;

public abstract class ExcelUtils {
	static Logger logger = LoggerFactory.getLogger(ExcelUtils.class);
	private static final String pattern = "yyyy-MM-dd HH:mm:ss";
	
	
	public static void writeXls2003New(HttpServletResponse response,  
			List<RepairTask> rowDataList,String fileName) {
		OutputStream output = null;
		HSSFWorkbook workbook = null;
		try {
			output = response.getOutputStream();
			
			workbook = new HSSFWorkbook();

			HSSFSheet sheet = workbook.createSheet();
			sheet.createFreezePane(0, 1);
			workbook.setSheetName(0, fileName);
			int cellIdxheader=0;
			Row rowtheader= sheet.createRow(cellIdxheader);
			createStringCell(rowtheader, cellIdxheader++,"机构编码");
			createStringCell(rowtheader, cellIdxheader++, "机构名称");
			createStringCell(rowtheader, cellIdxheader++, "案件号");
			createStringCell(rowtheader, cellIdxheader++, "车牌号");
			createStringCell(rowtheader, cellIdxheader++, "送修类型");
			createStringCell(rowtheader, cellIdxheader++, "送修来源");
			createStringCell(rowtheader, cellIdxheader++, "送修账号");
			createStringCell(rowtheader, cellIdxheader++, "送修人电话");
			createStringCell(rowtheader, cellIdxheader++, "查勘员姓名");
			createStringCell(rowtheader, cellIdxheader++, "车主姓名");
			createStringCell(rowtheader, cellIdxheader++, "送修时间");
			createStringCell(rowtheader, cellIdxheader++, "修理厂名称");
			createStringCell(rowtheader, cellIdxheader++, "接收时间");
			createStringCell(rowtheader, cellIdxheader++, "状态");
			createStringCell(rowtheader, cellIdxheader++, "完成时间");
			createStringCell(rowtheader, cellIdxheader++, "评价时间");
			

			int rowIdx = 1;
			for (RepairTask rows : rowDataList) {
				Row row = sheet.createRow(rowIdx++);
				int cellIdx = 0;
                String orgId=rows.getOrgId()==null ? " ":rows.getOrgId();
                String orgName=rows.getOrgName()==null ? " ":rows.getOrgName();
                String registNo=rows.getRegistNo()== null ? " " :rows.getRegistNo();
                String licenseNo=rows.getLicenseNo()==null ?" ":rows.getLicenseNo();
                String carType;
                if(rows.getCarType()==null){
                	carType=" ";
                }else if(rows.getCarType().equals("1")){
                	carType="标的车";
                }else{
                	carType="三者车";
                }
                String taskType;
                if(rows.getTaskType()==null){
                	taskType=" ";
                }else if(rows.getTaskType().equals("1")){
                	taskType="C";
                }else{
                	taskType="B";
                }
                String userAccount=rows.getUserAccount()==null ?" ":rows.getUserAccount();
                String userPhone=rows.getUserPhone()==null ?" ":rows.getUserPhone();
                String surveyName=rows.getSurveyName()==null ?" ":rows.getSurveyName();
                String carOwner=rows.getCarOwner()==null ?" ":rows.getCarOwner();
                String startTime=rows.getStartTime()==null ?" ":DateUtil.formatDatetime(rows.getStartTime());
                String garageName=rows.getGarageName()==null ?" ":rows.getGarageName();
                String confirmTime=rows.getConfirmTime()==null ?" ":DateUtil.formatDatetime(rows.getConfirmTime());
                String status=rows.getStatus()==null ?" ":rows.getStatus();
                String finishTime=rows.getFinishTime()==null ?" ":DateUtil.formatDatetime(rows.getFinishTime());
                String evTime=rows.getEvTime()==null ?" ":DateUtil.formatDatetime(rows.getEvTime());

				createStringCell(row, cellIdx++,orgId);
				createStringCell(row, cellIdx++, orgName);
				createStringCell(row, cellIdx++, registNo);
				createStringCell(row, cellIdx++, licenseNo);
				createStringCell(row, cellIdx++, carType);
				createStringCell(row, cellIdx++, taskType);
				createStringCell(row, cellIdx++, userAccount);
				createStringCell(row, cellIdx++, userPhone);
				createStringCell(row, cellIdx++, surveyName);
				createStringCell(row, cellIdx++, carOwner);
				createStringCell(row, cellIdx++, startTime);
				createStringCell(row, cellIdx++, garageName);
				createStringCell(row, cellIdx++, confirmTime);
				createStringCell(row, cellIdx++, status);
				createStringCell(row, cellIdx++, finishTime);
				createStringCell(row, cellIdx++, evTime);
			}
			workbook.write(output);
		} catch (Exception e) {
			throw new RuntimeException("生成excel文件时出错!", e);
		} finally {
			if (null != workbook) {
				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			IOUtils.closeQuietly(output);
		}
	}

	public static void writeXls2003(File destXlsFile, List<String[]> rowDataList) {
		FileOutputStream output = null;
		HSSFWorkbook workbook = null;
		try {
			if (!destXlsFile.exists()) {
				FileUtils.touch(destXlsFile);
			}
			output = new FileOutputStream(destXlsFile);
			workbook = new HSSFWorkbook();

			HSSFSheet sheet = workbook.createSheet();
			sheet.createFreezePane(0, 1);
			workbook.setSheetName(0, FilenameUtils.getBaseName(destXlsFile.getName()));

			int rowIdx = 0;
			for (String[] rows : rowDataList) {
				Row row = sheet.createRow(rowIdx++);
				int cellIdx = 0;
				for (String cellData : rows) {
					createStringCell(row, cellIdx++, cellData);
				}
			}
			workbook.write(output);
		} catch (Exception e) {
			throw new RuntimeException("生成excel文件时出错!", e);
		} finally {
			if (null != workbook) {
				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			IOUtils.closeQuietly(output);
		}
	}

	public static void writeXls2007(File destXlsFile, List<String[]> rowDataList) {
		FileOutputStream output = null;
		XSSFWorkbook workbook = null;
		try {
			if (!destXlsFile.exists()) {
				FileUtils.touch(destXlsFile);
			}
			output = new FileOutputStream(destXlsFile);
			workbook = new XSSFWorkbook();

			XSSFSheet sheet = workbook.createSheet();
			sheet.createFreezePane(0, 1);
			workbook.setSheetName(0, FilenameUtils.getBaseName(destXlsFile.getName()));

			int rowIdx = 0;
			for (String[] rows : rowDataList) {
				Row row = sheet.createRow(rowIdx++);
				int cellIdx = 0;
				for (String cellData : rows) {
					createStringCell(row, cellIdx++, cellData);
				}
			}
			workbook.write(output);
		} catch (Exception e) {
			throw new RuntimeException("生成excel文件时出错!", e);
		} finally {
			if (null != workbook) {
				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			IOUtils.closeQuietly(output);
		}
	}

	public static void readXls(File file, ExcelDataHandler dataHandler) {
		InputStream inputStream = null;
		long st = System.currentTimeMillis();
		String type = "";
		try {
			Workbook workbook;
			try {
				inputStream = new FileInputStream(file);
				workbook = new HSSFWorkbook(inputStream);
				type = "2003";
			} catch (Exception e) {
				IOUtils.closeQuietly(inputStream);
				inputStream = new FileInputStream(file);
				workbook = new XSSFWorkbook(inputStream);
				type = "2007";
			}
			readXls(workbook, dataHandler);
			long ed = System.currentTimeMillis();
			logger.info("解析Excel{}文件..用时={}ms, [{}]", new Object[] { type, Long.valueOf(ed - st), file });
		} catch (Exception e) {
			long ed = System.currentTimeMillis();
			logger.error("解析Excel{}文件出错! 用时={}ms, [{}]", new Object[] { type, Long.valueOf(ed - st), file, e });
			throw new RuntimeException("解析Excel" + type + "文件出错! " + file, e);
		} finally {
			IOUtils.closeQuietly(inputStream);
		}
	}

	public static void readXls(File file, int columnNumber, ExcelDataHandler dataHandler) {
		InputStream inputStream = null;
		long st = System.currentTimeMillis();
		String type = "";
		try {
			Workbook workbook;
			try {
				inputStream = new FileInputStream(file);
				workbook = new HSSFWorkbook(inputStream);
				type = "2003";
			} catch (Exception e) {
				IOUtils.closeQuietly(inputStream);
				inputStream = new FileInputStream(file);
				workbook = new XSSFWorkbook(inputStream);
				type = "2007";
			}
			readXls(workbook, dataHandler);
			long ed = System.currentTimeMillis();
			logger.info("解析Excel{}文件..用时={}ms, [{}]", new Object[] { type, Long.valueOf(ed - st), file });
		} catch (Exception e) {
			long ed = System.currentTimeMillis();
			logger.error("解析Excel{}文件出错! 用时={}ms, [{}]", new Object[] { type, Long.valueOf(ed - st), file, e });
			throw new RuntimeException("解析Excel" + type + "文件出错! " + file, e);
		} finally {
			IOUtils.closeQuietly(inputStream);
		}
	}

	private static void readXls(Workbook workbook, ExcelDataHandler dataHandler) {
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setFillBackgroundColor(IndexedColors.RED.getIndex());

		List<String> cellDataList = new ArrayList<String>();
		int maxSheets = workbook.getNumberOfSheets();
		int rowNum;
		Iterator<Row> itRow;
		for (int sheetIndex = 0; sheetIndex < maxSheets; sheetIndex++) {
			Sheet sheet = workbook.getSheetAt(sheetIndex);
			rowNum = 0;
			for (itRow = sheet.iterator(); itRow.hasNext();) {
				Row row = (Row) itRow.next();
				cellDataList.clear();
				for (Iterator<Cell> itCell = row.iterator(); itCell.hasNext();) {
					Cell cell = (Cell) itCell.next();
					String data = getStringValue(cell);
					cellDataList.add(data);
				}
				dataHandler.handle(sheetIndex, rowNum++, (String[]) cellDataList.toArray(new String[0]));
			}
		}
	}

	private static final FastDateFormat fdf = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");

	private static String getStringValue(Cell cell) {
		if (cell == null) {
			return null;
		}
		try {
			int cellType = cell.getCellType();
			switch (cellType) {
			case 0:
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					Date date = cell.getDateCellValue();
					return fdf.format(date);
				}
				return cell.getNumericCellValue() + "";
			case 1:
				return cell.getStringCellValue();
			case 2:
				return cell.getNumericCellValue() + "";
			case 3:
				return "";
			case 4:
				return cell.getBooleanCellValue() + "";
			case 5:
				return cell.getErrorCellValue() + "";
			}
			return cell.toString();
		} catch (Exception e) {
			throw new RuntimeException("无法解析单元格输数据! CellType=" + cell.getCellType(), e);
		}
	}

	private static Cell createStringCell(Row row, int index, Object value) {
		Cell cell = row.createCell(index);
		cell.setCellType(1);
		cell.setCellValue(String.valueOf(value));
		return cell;
	}

	public static abstract interface ExcelDataHandler {
		public abstract void handle(int paramInt1, int paramInt2, String[] paramArrayOfString);
	}
}
