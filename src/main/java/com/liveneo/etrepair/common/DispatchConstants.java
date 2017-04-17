package com.liveneo.etrepair.common;

import java.util.LinkedHashMap;
import java.util.Map;

public class DispatchConstants {
    // 损失类型 1-标的车;2-三者车;3-本车司机;4-本车车上人员;5-三者人员;6-车上物;7-三者物
    public static final Map<Integer, String> LOSS_TYPE_MAP                     = new LinkedHashMap<Integer, String>();
    // 调度类型 0:修理厂查勘 1：普通查勘 2：视频查勘 3：客户自助 4：预约 5:转分公司 10：申请改派
    public static final Map<String, String>  DISPATCH_TYPE_MAP                 = new LinkedHashMap<String, String>();
    // 调度状态 1：未调度 2：已调度 3：申请改派 10:已接受 11：已联系 12：已到达 13：已完成 99：已注销 100：转分公司调度
    public static final Map<String, String>  DISPATCH_STATUS_MAP               = new LinkedHashMap<String, String>();
    // 调度状态定义
    public static final String               DISPATCH_STATUS_WDD               = "1";
    public static final String               DISPATCH_STATUS_YDD               = "2";
    public static final String               DISPATCH_STATUS_SSGP              = "3";
    public static final String               DISPATCH_STATUS_YJS               = "10";
    public static final String               DISPATCH_STATUS_YLX               = "11";
    public static final String               DISPATCH_STATUS_YDDA              = "12";
    public static final String               DISPATCH_STATUS_YWC               = "13";
    public static final String               DISPATCH_STATUS_YZX               = "99";
    public static final String               DISPATCH_STATUS_ZFGSDD            = "100";
    // 调度类型定义
    public static final String               DISPATCH_TYPE_LLCCC               = "0";
    public static final String               DISPATCH_TYPE_PTCK                = "1";
    public static final String               DISPATCH_TYPE_SSCK                = "2";
    public static final String               DISPATCH_TYPE_KHZZ                = "3";
    public static final String               DISPATCH_TYPE_YY                  = "4";
    public static final String               DISPATCH_TYPE_ZFGS                = "5";
    public static final String               DISPATCH_TYPE_SQGP                = "10";
    static {
        LOSS_TYPE_MAP.put(1, "标的车");
        LOSS_TYPE_MAP.put(2, "三者车");
        LOSS_TYPE_MAP.put(3, "本车司机");
        LOSS_TYPE_MAP.put(4, "本车车上人员");
        LOSS_TYPE_MAP.put(5, "三者人员");
        LOSS_TYPE_MAP.put(6, "车上物");
        LOSS_TYPE_MAP.put(7, "三者物");
        DISPATCH_TYPE_MAP.put(DISPATCH_TYPE_LLCCC, "修理厂查勘");
        DISPATCH_TYPE_MAP.put(DISPATCH_TYPE_PTCK, "普通查勘");
        DISPATCH_TYPE_MAP.put(DISPATCH_TYPE_SSCK, "视频查勘");
        DISPATCH_TYPE_MAP.put(DISPATCH_TYPE_KHZZ, "客户自助");
        DISPATCH_TYPE_MAP.put(DISPATCH_TYPE_YY, "预约");
        DISPATCH_TYPE_MAP.put(DISPATCH_TYPE_ZFGS, "转分公司");
        DISPATCH_TYPE_MAP.put(DISPATCH_TYPE_SQGP, "申请改派");
        DISPATCH_STATUS_MAP.put(DISPATCH_STATUS_WDD, "未调度");
        DISPATCH_STATUS_MAP.put(DISPATCH_STATUS_YDD, "已调度");
        DISPATCH_STATUS_MAP.put(DISPATCH_STATUS_SSGP, "申请改派");
        DISPATCH_STATUS_MAP.put(DISPATCH_STATUS_YJS, "已接受");
        DISPATCH_STATUS_MAP.put(DISPATCH_STATUS_YLX, "已联系");
        DISPATCH_STATUS_MAP.put(DISPATCH_STATUS_YDDA, "已到达");
        DISPATCH_STATUS_MAP.put(DISPATCH_STATUS_YWC, "已完成");
        DISPATCH_STATUS_MAP.put(DISPATCH_STATUS_YZX, "已注销");
        DISPATCH_STATUS_MAP.put(DISPATCH_STATUS_ZFGSDD, "转分公司调度");
    }
    // 接口结果码（中兴）
    // 成功
    public static final String               INTERFACE_RESULT_CODE_ZTE_SUCCESS = "0000";
    // 接口结果码（P接口）
    // 成功
    public static final String               INTERFACE_RESULT_CODE_P_SUCCESS   = "000";
}
