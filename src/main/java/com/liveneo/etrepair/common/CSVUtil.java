package com.liveneo.etrepair.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liveneo.etrepair.pojo.RepairTask;

public class CSVUtil {
	
	 public static void createCSVFile(List<RepairTask> exportData,  LinkedHashMap rowMapper,  
	       HttpServletRequest request,HttpServletResponse response) {
		 
		     String filename = "送修任务列表.csv";
			String iso_filename = CSVUtil.parseGBK(filename);
		 
		   response.setContentType("application/csv;charset=UTF-8"); 
		   response.setHeader("Content-Disposition","attachment;  filename="+iso_filename); 
		   PrintWriter out;
		   
		try {
			out = response.getWriter();
			 // 写入文件头部  
            for (Iterator propertyIterator = rowMapper.entrySet().iterator(); propertyIterator.hasNext();) {  
                java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator  
                        .next();  
                out.print("\""  
                        + propertyEntry.getValue().toString() + "\"");  
                if (propertyIterator.hasNext()) {  
                    out.write(",");  
                }  
            }  
            out.println("");
			
		     // 写入文件内容  
            for (Iterator<RepairTask> iterator = exportData.iterator(); iterator.hasNext();) {    
            	
            	RepairTask row =iterator.next();  
//                System.out.println(row);  
                String orgId=row.getOrgId()==null ? " ":row.getOrgId();
                String orgName=row.getOrgName()==null ? " ":row.getOrgName();
                String registNo=row.getRegistNo()== null ? " " :row.getRegistNo();
                String licenseNo=row.getLicenseNo()==null ?" ":row.getLicenseNo();
                String carType;
                if(row.getCarType()==null){
                	carType=" ";
                }else if(row.getCarType().equals("1")){
                	carType="标的车";
                }else{
                	carType="三者车";
                }
                String taskType;
                if(row.getTaskType()==null){
                	taskType=" ";
                }else if(row.getTaskType().equals("1")){
                	taskType="C";
                }else{
                	taskType="B";
                }
                String userAccount=row.getUserAccount()==null ?" ":row.getUserAccount();
                String userPhone=row.getUserPhone()==null ?" ":row.getUserPhone();
                String surveyName=row.getSurveyName()==null ?" ":row.getSurveyName();
                String carOwner=row.getCarOwner()==null ?" ":row.getCarOwner();
                String startTime=row.getStartTime()==null ?" ":DateUtil.formatDatetime(row.getStartTime());
                String garageName=row.getGarageName()==null ?" ":row.getGarageName();
                String confirmTime=row.getConfirmTime()==null ?" ":DateUtil.formatDatetime(row.getConfirmTime());
                String status=row.getStatus()==null ?" ":row.getStatus();
                String finishTime=row.getFinishTime()==null ?" ":DateUtil.formatDatetime(row.getFinishTime());
                String evTime=row.getEvTime()==null ?" ":DateUtil.formatDatetime(row.getEvTime());
                
                out.println(orgId+ ","+orgName+ ",\t"+registNo+ ","+licenseNo
                        + ","+carType+ ","+taskType+ ",\t"+userAccount+ ",\t"+userPhone
                        + ",\t"+surveyName+ ","+carOwner+ ",\t"+startTime+ ","+garageName+ ",\t"+confirmTime
                        + ","+status+ ",\t"+finishTime+ ",\t"+evTime); 
                
           }  
          out.flush(); 
  		  out.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        } 
	    
//将GBK字符转化为ISO码
	public static String parseGBK(String sIn) {
		if (sIn == null || sIn.equals(""))
			return sIn;
		try {
			return new String(sIn.getBytes("GBK"), "ISO-8859-1");
		} catch (UnsupportedEncodingException usex) {
			return sIn;
		}
	}
}
