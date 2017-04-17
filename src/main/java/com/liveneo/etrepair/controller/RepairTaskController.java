package com.liveneo.etrepair.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.liveneo.etrepair.common.PropertyConfigurer;
import com.liveneo.etrepair.json.wrapper.DropDownModel;
import com.liveneo.etrepair.log.LVLogger;
import com.liveneo.etrepair.pojo.EvaluatePhoto;
import com.liveneo.etrepair.pojo.EvaluteItem;
import com.liveneo.etrepair.pojo.RepairTask;
import com.liveneo.etrepair.pojo.ScoreDetail;
import com.liveneo.etrepair.pojo.TaskEvalute;
import com.liveneo.etrepair.pojo.Type;
import com.liveneo.etrepair.pojo.User;
import com.liveneo.etrepair.service.RepairTaskService;

@Controller
@RequestMapping("/repairtask")
public class RepairTaskController extends BaseController {
    LVLogger                  logger     = LVLogger.getLogger(this.getClass());
    @Autowired
    private RepairTaskService repairTaskService;
    private String            ossBaseUrl = PropertyConfigurer.getValue("ossBaseUrl");

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "/editstatus", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String updateRepairTask(String taskId, String registNo, String targetStatus, HttpSession session) {
        try {
            logger.debug("更新送修任务id=" + taskId + "status=" + targetStatus);
            repairTaskService.updateRepairTaskStatus(taskId, registNo, targetStatus);
        } catch (Exception e) {
            logger.error("修改送修任务状态失败" + e);
            return resultError("修改送修任务状态失败");
        }
        return resultOK();
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String getAllRepairTaskByCondition(RepairTask repairTask, Integer page, Integer rows, HttpSession session) {
        int skip = -1;
        if (page != -1) {
            skip = (page - 1) * rows;
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
        List<RepairTask> repairTasks = repairTaskService.getAllRepairTaskByCondition(repairTask, skip, rows);
        List<RepairTask> repairList = new ArrayList<RepairTask>();
        if (repairTasks != null && repairTasks.size() > 0) {
            // 查询配置表中的状态说明
            List<Map<String, String>> statuslist = repairTaskService.getTypeNameByTypeGroupCode("TASKSTATUS");
            for (RepairTask bean : repairTasks) {
                String status = bean.getStatus();
                if (statuslist != null && statuslist.size() > 0) {
                    for (Map<String, String> map : statuslist) {
                        if (map.get("code").equals(status)) {
                            bean.setStatusDes(map.get("name"));
                        }
                    }
                }
                repairList.add(bean);
            }
        }
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("total", repairTaskService.countRepairTask(repairTask));
        maps.put("rows", repairList);
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

    @RequestMapping(value = "/viewTaskDetail")
    public String viewTaskDetail(String taskId, Model model) {
        RepairTask repairTask = repairTaskService.getTaskDetailByTaskId(taskId);
        model.addAttribute("repairTask", repairTask);
        if ("7".equals(repairTask.getStatus())) {// 返回用户评价详情页面的信息
            // 当前任务号的点评信息
            TaskEvalute evalute = repairTaskService.getTaskEvaluteByTaskId(repairTask.getTaskId());
            if (evalute != null) {
                model.addAttribute("evalute", evalute);
                // 获取该评价的每个选项打分
                List<ScoreDetail> scoreList = repairTaskService.getScoreDetailByEvId(evalute.getEvId());
                model.addAttribute("scoreList", scoreList);
                ObjectMapper mapper = new ObjectMapper();
                try {
                    model.addAttribute("scoreListJson", mapper.writeValueAsString(scoreList));
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                // 获取该任务评价的上传的图片，拼接上传服务器路径
                List<EvaluatePhoto> photoList = repairTaskService.getEvaluatePhotoByTaskId(repairTask.getTaskId());
                if (photoList != null && photoList.size() > 0) {
                    List<EvaluatePhoto> urlPhotolist = new ArrayList<EvaluatePhoto>();
                    for (EvaluatePhoto photo : photoList) {
                        EvaluatePhoto newPhoto = new EvaluatePhoto();
                        newPhoto.setPhotoUrl(ossBaseUrl + photo.getPhotoUrl());
                        urlPhotolist.add(newPhoto);
                    }
                    model.addAttribute("urlPhotolist", urlPhotolist);
                }
                // 查询打分项目
                List<EvaluteItem> evaluteItemlist = repairTaskService.getAllEvaluteItem();
                model.addAttribute("evaluteItemlist", evaluteItemlist);
            }
        }
        return "repairtask/view";
    }

    @RequestMapping("/garageview")
    public String garageview() {
        return "repairtask/garageRepairTasklist";
    }

    /**
     * 修理厂查看页面
     * @param repairTask
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/garagelist", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String getGarageRepairTaskByCondition(RepairTask repairTask, Integer page, Integer rows, HttpSession session) {
        // 根据登录用户查询该修理厂编号，只查询该修理厂的送修任务
        User user = (User) session.getAttribute("user");
        if (null == user) {
            return "login";
        }
        String garageid = repairTaskService.getGarageIdByUserCode(user.getUserCode());
        repairTask.setGarageId(garageid);
        int skip = -1;
        if (page != -1) {
            skip = (page - 1) * rows;
        }
        List<RepairTask> repairTasks = repairTaskService.getAllRepairTaskByCondition(repairTask, skip, rows);
        List<RepairTask> repairList = new ArrayList<RepairTask>();
        if (repairTasks != null && repairTasks.size() > 0) {
            // 查询配置表中的状态说明
            List<Map<String, String>> statuslist = repairTaskService.getTypeNameByTypeGroupCode("TASKSTATUS");
            for (RepairTask bean : repairTasks) {
                String status = bean.getStatus();
                if (statuslist != null && statuslist.size() > 0) {
                    for (Map<String, String> map : statuslist) {
                        if (map.get("code").equals(status)) {
                            bean.setStatusDes(map.get("name"));
                        }
                    }
                }
                repairList.add(bean);
            }
        }
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("total", repairTaskService.countRepairTask(repairTask));
        maps.put("rows", repairList);
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

    @RequestMapping
    public String RepairTask() {
        return "repairtask/list";
    }
}
