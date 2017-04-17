package com.liveneo.etrepair.validate.app;

import java.util.Map;
import org.springframework.stereotype.Component;
import com.google.gson.Gson;
import com.liveneo.etrepair.common.StringUtil;

@Component
public class MobileRequestValidate {
    /**
     * 用户登录校验
     * @param jsonStr
     * @return
     */
    public String credentialsValidate(String jsonStr) {
        Gson gson = new Gson();
        @SuppressWarnings("unchecked")
        Map<String, String> map = gson.fromJson(jsonStr, Map.class);
        if (StringUtil.isEmptyOrNull(map.get("loginName"))) {
            return "查勘员用户编码和用户名不能同时为空";
        }
        if (StringUtil.isEmptyOrNull(map.get("userPwd"))) {
            return "密码不能为空";
        }
        if (StringUtil.isEmptyOrNull(map.get("phoneType"))) {
            return "手机系统类型不能为空";
        }
        if (map.get("phoneType").equals("IOS")) {
            if (StringUtil.isEmptyOrNull(map.get("deviceToken"))) {
                return "手机设备证书不能为空";
            }
        }
        return null;
    }

    /**
     * 定时上传查勘员位置信息
     * @param jsonStr
     * @return
     */
    public String updateLocationValidate(String jsonStr) {
        Gson gson = new Gson();
        @SuppressWarnings("unchecked")
        Map<String, String> map = gson.fromJson(jsonStr, Map.class);
        if (StringUtil.isEmptyOrNull(map.get("userCode"))) {
            return "查勘员用户编码不能为空";
        }
        if (StringUtil.isEmptyOrNull(map.get("sso"))) {
            return "sso不能为空";
        }
        if (StringUtil.isEmptyOrNull(map.get("longitude"))) {
            return "经度不能为空";
        }
        if (StringUtil.isEmptyOrNull(map.get("latitude"))) {
            return "纬度不能为空";
        }
        return null;
    }

    /**
     * 执行查勘员签到签退操作
     * @param jsonStr
     * @return
     */
    public String updatesignstatusValidate(String jsonStr) {
        Gson gson = new Gson();
        @SuppressWarnings("unchecked")
        Map<String, String> map = gson.fromJson(jsonStr, Map.class);
        if (StringUtil.isEmptyOrNull(map.get("userCode"))) {
            return "查勘员用户编码不能为空";
        }
        if (StringUtil.isEmptyOrNull(map.get("sso"))) {
            return "sso不能为空";
        }
        if (StringUtil.isEmptyOrNull(map.get("signStatus"))) {
            return "签到状态不能为空";
        }
        return null;
    }

    /**
     * 获取未处理和处理中案件列表
     * @param jsonStr
     * @return
     */
    public String getcaselistValidate(String jsonStr) {
        Gson gson = new Gson();
        @SuppressWarnings("unchecked")
        Map<String, String> map = gson.fromJson(jsonStr, Map.class);
        if (StringUtil.isEmptyOrNull(map.get("userCode"))) {
            return "查勘员用户编码不能为空";
        }
        if (StringUtil.isEmptyOrNull(map.get("sso"))) {
            return "sso不能为空";
        }
        if (StringUtil.isEmptyOrNull(map.get("listType"))) {
            return "列表类型不能为空";
        }
        return null;
    }

    /**
     * 获取案件任务项列表
     * @param jsonStr
     * @return
     */
    public String gettasklistValidate(String jsonStr) {
        Gson gson = new Gson();
        @SuppressWarnings("unchecked")
        Map<String, String> map = gson.fromJson(jsonStr, Map.class);
        if (StringUtil.isEmptyOrNull(map.get("userCode"))) {
            return "查勘员用户编码不能为空";
        }
        if (StringUtil.isEmptyOrNull(map.get("sso"))) {
            return "sso不能为空";
        }
        if (StringUtil.isEmptyOrNull(map.get("caseNO"))) {
            return "报案号不能为空";
        }
        return null;
    }

    /**
     * 获取改派原因列表
     * @param jsonStr
     * @return
     */
    public String getreasonlistValidate(String jsonStr) {
        Gson gson = new Gson();
        @SuppressWarnings("unchecked")
        Map<String, String> map = gson.fromJson(jsonStr, Map.class);
        if (StringUtil.isEmptyOrNull(map.get("userCode"))) {
            return "查勘员用户编码不能为空";
        }
        if (StringUtil.isEmptyOrNull(map.get("sso"))) {
            return "sso不能为空";
        }
        return null;
    }

    /**
     * 修改案件任务状态
     * @param jsonStr
     * @return
     */
    public String updatetaskstatusValidate(String jsonStr) {
        Gson gson = new Gson();
        @SuppressWarnings("unchecked")
        Map<String, String> map = gson.fromJson(jsonStr, Map.class);
        if (StringUtil.isEmptyOrNull(map.get("userCode"))) {
            return "查勘员用户编码不能为空";
        }
        if (StringUtil.isEmptyOrNull(map.get("sso"))) {
            return "sso不能为空";
        }
        if (StringUtil.isEmptyOrNull(map.get("uuid"))) {
            return "案件ID不能为空";
        }
        if (StringUtil.isEmptyOrNull(map.get("taskStatus"))) {
            return "任务状态不能为空";
        }
        return null;
    }

    /**
     * 查询已处理案件信息
     * @param jsonStr
     * @return
     */
    public String querysolvedcaseValidate(String jsonStr) {
        Gson gson = new Gson();
        @SuppressWarnings("unchecked")
        Map<String, String> map = gson.fromJson(jsonStr, Map.class);
        if (StringUtil.isEmptyOrNull(map.get("userCode"))) {
            return "查勘员用户编码不能为空";
        }
        if (StringUtil.isEmptyOrNull(map.get("sso"))) {
            return "sso不能为空";
        }
        if (StringUtil.isEmptyOrNull(map.get("startTime"))) {
            return "开始日期不能为空";
        }
        if (StringUtil.isEmptyOrNull(map.get("endTime"))) {
            return "结束日期不能为空";
        }
        if (StringUtil.isEmptyOrNull(map.get("page"))) {
            return "页码不能为空";
        }
        if (StringUtil.isEmptyOrNull(map.get("pageSize"))) {
            return "每页行数不能为空";
        }
        return null;
    }

    /**
     * app退出
     * @param jsonStr
     * @return
     */
    public String logoutValidate(String jsonStr) {
        Gson gson = new Gson();
        @SuppressWarnings("unchecked")
        Map<String, String> map = gson.fromJson(jsonStr, Map.class);
        if (StringUtil.isEmptyOrNull(map.get("userCode"))) {
            return "查勘员用户编码不能为空";
        }
        if (StringUtil.isEmptyOrNull(map.get("sso"))) {
            return "sso不能为空";
        }
        return null;
    }

    /**
     * 版本更新检测
     * @param jsonStr
     * @return
     */
    public String versionCheckValidate(String jsonStr) {
        Gson gson = new Gson();
        @SuppressWarnings("unchecked")
        Map<String, String> map = gson.fromJson(jsonStr, Map.class);
        if (StringUtil.isEmptyOrNull(map.get("versionId"))) {
            return "终端版本号不能为空";
        }
        if (StringUtil.isEmptyOrNull(map.get("appType"))) {
            return "App类型不能为空";
        }
        if (StringUtil.isEmptyOrNull(map.get("systemCode"))) {
            return "系统代码不能为空";
        }
        return null;
    }
}
