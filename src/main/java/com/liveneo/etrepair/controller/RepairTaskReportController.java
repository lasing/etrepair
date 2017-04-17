package com.liveneo.etrepair.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liveneo.etrepair.common.ExcelUtils;
import com.liveneo.etrepair.json.wrapper.DropDownModel;
import com.liveneo.etrepair.log.LVLogger;
import com.liveneo.etrepair.pojo.RepairTask;
import com.liveneo.etrepair.pojo.Type;
import com.liveneo.etrepair.pojo.User;
import com.liveneo.etrepair.service.RepairTaskService;

@Controller
@RequestMapping("/repairtaskreport")
public class RepairTaskReportController extends BaseController {
	LVLogger logger = LVLogger.getLogger(this.getClass());
	@Autowired
	private RepairTaskService repairTaskService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = { "application/html;charset=UTF-8" })
	@ResponseBody
	public String getAllRepairTaskReportByCondition(RepairTask repairTask,
			Integer page, Integer rows, HttpSession session) {
		int skip = -1;
		if (page != -1) {
			skip = (page - 1) * rows;
		}
		
		if(repairTask.getOrgId()!=null&&repairTask.getOrgId().equals("00001")){
			repairTask.setOrgId(null);
		}
		
	     // 当前组织结构用户只能查看该组织机构的修理厂
        User user = (User) session.getAttribute("user");
        if (user != null) {
            if ("admin".equals(user.getUserName())) {
                if (user.getOrgId() != null) {
                    if (repairTask.getOrgId() != null) {
                        repairTask.setOrgId(repairTask.getOrgId());
                    } else {
                        // 管理员请求全部数据
                        repairTask.setOrgId(null);
                    }
                } else {
                    repairTask.setOrgId(repairTask.getOrgId());
                }
            } else {
                repairTask.setOrgId(user.getOrgId());
            }
        }
		
		
		List<RepairTask> repairTasks = repairTaskService.getReportFormList(
				repairTask, skip, rows);
		List<RepairTask> repairListreport = new ArrayList<RepairTask>();
		if (repairTasks != null && repairTasks.size() > 0) {
			// 查询配置表中的状态说明
			List<Map<String, String>> statuslist = repairTaskService
					.getTypeNameByTypeGroupCode("TASKSTATUS");
			for (RepairTask bean : repairTasks) {
				String status = bean.getStatus();
				if (statuslist != null && statuslist.size() > 0) {
					for (Map<String, String> map : statuslist) {
						if (map.get("code").equals(status)) {
							bean.setStatus(map.get("name"));
						}
					}
				}
				repairListreport.add(bean);
			}
		}
		Map<String, Object> maps = new HashMap<String, Object>();
		 maps.put("total", repairTaskService.countRepairTask(repairTask));
		maps.put("rows", repairListreport);
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(maps);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
			return JSON_PARSE_ERROR;
		} catch (JsonMappingException e) {
			e.printStackTrace();
			return JSON_PARSE_ERROR;
		} catch (IOException e) {
			e.printStackTrace();
			return JSON_PARSE_ERROR;
		}
	}
	
	
	@RequestMapping(value = "/statusList/json", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String statusList() {
        List<DropDownModel> dropList = new ArrayList<DropDownModel>();
        String taskstatus = "TASKSTATUS";
        List<Type> result = repairTaskService.listRepairTaskStatus(taskstatus);
        for (Type type : result) {
            dropList.add(new DropDownModel(type.getTypeCode(), type.getTypeName()));
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(dropList);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
            return JSON_PARSE_ERROR;
        } catch (JsonMappingException e) {
            e.printStackTrace();
            return JSON_PARSE_ERROR;
        } catch (IOException e) {
            e.printStackTrace();
            return JSON_PARSE_ERROR;
        }
    }
	
	
	/**
	 * 导出报表
	 * @param repairTask
	 * @param session
	 * @param response
	 * @param request
	 

	@RequestMapping(value = "/export")
	public void exportCsv(RepairTask repairTask, HttpSession session,HttpServletResponse response,HttpServletRequest request) {

		if(repairTask.getOrgId()!=null&&repairTask.getOrgId().equals("00001")){
			repairTask.setOrgId(null);
		}
		
		
	     // 当前组织结构用户只能查看该组织机构的修理厂
        User user = (User) session.getAttribute("user");
        if (user != null) {
            if ("admin".equals(user.getUserName())) {
                if (user.getOrgId() != null) {
                    if (repairTask.getOrgId() != null) {
                        repairTask.setOrgId(repairTask.getOrgId());
                    } else {
                        // 管理员请求全部数据
                        repairTask.setOrgId(null);
                    }
                } else {
                    repairTask.setOrgId(repairTask.getOrgId());
                }
            } else {
                repairTask.setOrgId(user.getOrgId());
            }
        }
        
		List<RepairTask> repairTasks = new ArrayList<RepairTask>();
		repairTasks = repairTaskService.getReportFormList2(repairTask);
		List<RepairTask> repairListreport = new ArrayList<RepairTask>();
		if (repairTasks != null && repairTasks.size() > 0) {
			// 查询配置表中的状态说明
			List<Map<String, String>> statuslist = repairTaskService
					.getTypeNameByTypeGroupCode("TASKSTATUS");
			for (RepairTask bean : repairTasks) {
				String status = bean.getStatus();
				if (statuslist != null && statuslist.size() > 0) {
					for (Map<String, String> map : statuslist) {
						if (map.get("code").equals(status)) {
							bean.setStatus(map.get("name"));
						}
					}
				}
				repairListreport.add(bean);
			}
		}
		LinkedHashMap map = new LinkedHashMap();
		map.put("1", "机构编码");
		map.put("2", "机构名称");
		map.put("3", "案件号");
		map.put("4", "车牌号");
		map.put("5", "送修类型");
		map.put("6", "送修来源");
		map.put("7", "送修账号");
		map.put("8", "送修人电话");
		map.put("9", "查勘员姓名");
		map.put("10", "车主姓名");
		map.put("11", "送修时间");
		map.put("12", "修理厂名称");
		map.put("13", "接收时间");
		map.put("14", "状态");
		map.put("15", "完成时间");
		map.put("16", "评价时间");
		
		CSVUtil.createCSVFile(repairTasks,map,request,response);
	}
*/
	/**
	 * 导出报表
	 * 
	 * @param repairTask
	 * @param session
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "/export")
	@ResponseBody
	public void exportCsvNew(RepairTask repairTask, HttpSession session,
			HttpServletResponse response, HttpServletRequest request) {

		if (repairTask.getOrgId() != null
				&& repairTask.getOrgId().equals("00001")) {
			repairTask.setOrgId(null);
		}

		// 当前组织结构用户只能查看该组织机构的修理厂
		User user = (User) session.getAttribute("user");
		if (user != null) {
			if ("admin".equals(user.getUserName())) {
				if (user.getOrgId() != null) {
					if (repairTask.getOrgId() != null) {
						repairTask.setOrgId(repairTask.getOrgId());
					} else {
						// 管理员请求全部数据
						repairTask.setOrgId(null);
					}
				} else {
					repairTask.setOrgId(repairTask.getOrgId());
				}
			} else {
				repairTask.setOrgId(user.getOrgId());

			}
		}
		List<RepairTask> repairTasks = new ArrayList<RepairTask>();
		repairTasks = repairTaskService.getReportFormList2(repairTask);
		List<RepairTask> repairListreport = new ArrayList<RepairTask>();
		if (repairTasks != null && repairTasks.size() > 0) {
			// 查询配置表中的状态说明
			List<Map<String, String>> statuslist = repairTaskService
					.getTypeNameByTypeGroupCode("TASKSTATUS");
			for (RepairTask bean : repairTasks) {
				String status = bean.getStatus();
				if (statuslist != null && statuslist.size() > 0) {
					for (Map<String, String> map : statuslist) {
						if (map.get("code").equals(status)) {
							bean.setStatus(map.get("name"));
						}
					}
				}
				repairListreport.add(bean);
			}
		}

		
		String fileName = "送修任务列表.xls";
		// 设置文件输出类型
				response.setContentType("application/octet-stream");
				try {
					response.setHeader("Content-disposition", "attachment; filename="
							+new String(fileName.getBytes("utf-8"), "ISO8859-1") );
					
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
		

		ExcelUtils.writeXls2003New(response,repairTasks,fileName);

	}

	@RequestMapping("/repairTaskReportview")
	public String RepairTaskReport() {
		Map<String, Object> maps = new HashMap<String, Object>();
		 maps.put("total","0");
		return "repairtaskreport/list";
	}

}
