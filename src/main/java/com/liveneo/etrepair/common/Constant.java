package com.liveneo.etrepair.common;

/**
 * 常量
 */
public class Constant {
    // 修理厂操作类型
    public static final int    OPER_TYPE_ADD                     = 1;                       // 新增
    public static final int    OPER_TYPE_UPDATE                  = 2;                       // 修改
    public static final int    OPER_TYPE_DELETE                  = 3;                       // 删除
    // mysql uuid函数字符串
    public static final String MYSQL_UUID                        = "replace(uuid(),'-','')";
    public static final String CLAIM_RESULT_SUCCESS              = "000";                   // 成功
    public static final String CLAIM_RESULT_SUCCESS_DEST         = "成功";                    // 成功
    public static final String CLAIM_RESULT_FAIL                 = "999";                   // 失败
    // 接口结果码（中兴接口，InvokedPInterfaceServiceImpl中使用）
    // 成功
    public static final String INTERFACE_RESULT_CODE_ZTE_SUCCESS = "0000";
    // 接口结果码（P接口）
    // 成功
    public static final String INTERFACE_RESULT_CODE_P_SUCCESS   = "000";
    // 成功失败状态
    public static final String STATUS_SUCCESS                    = "success";               // 成功
    public static final String STATUS_FAILED                     = "failed";                // 失败
    // app消息推送成功失败
    public static final byte   APP_PUSH_MESSAGE_SUCCESS          = 1;                       // 成功
    public static final byte   APP_PUSH_MESSAGE_FAIL             = 0;                       // 失败
    // app成功失败
    public static final String APP_RESULT_SUCCESS                = "1";                     // 成功
    public static final String APP_RESULT_SUCCESS_DESC           = "成功";                    // 成功
    public static final String APP_RESULT_SUCCESS_2              = "2";                     // 登录成功，个推ID为空
    public static final String APP_RESULT_SUCCESS_2_DESC         = "登录成功，个推ID为空";           // 登录成功，个推ID为空
    public static final String APP_RESULT_FAIL                   = "0";                     // 失败
    public static final String APP_RESULT_FAIL_DESC              = "失败";                    // 失败
    public static final String APP_RESULT_ERROE                  = "-1";
    public static final String APP_RESULT_ERROE_DESC             = "系统异常";
    public static final String APP_RESULT_VALIDATE               = "-2";
    public static final String APP_RESULT_VALIDATE_DESC          = "参数错误";
    public static final String APP_RESULT_SSO_FAIL               = "-3";
    public static final String APP_RESULT_SSO_FAIL_DESC          = "用户权限sso失效";
    public static final String SYSTEM_ERROR                      = "系统异常";
    public static final String DATABASE_SAVE_ERROR               = "数据保存失败";
    public static final String SYSTEM_USER                       = "SYSTEM";
    // 是否可用
    public static final byte   IS_ENABLE_YES                     = 1;                       // 是
    public static final byte   IS_ENABLE_NO                      = 0;                       // 否
    public static final String IS_VALIDATE_YES                   = "1";                     // 是
    public static final String IS_VALIDATE_NO                    = "0";                     // 否
    public static final String SIGNIN_MONITOR                    = "SIGNIN_MONITOR";
    public static final String FILE_SEPARATOR                    = "/";
    public static final String XLS                               = ".xls";
    // sd_sys_config key
    public static final String SYS_CONFIG_UPLOAD_INTERVAL        = "uploadinterval";
    // 用户操作类型
    public static final byte   OPERATE_TYPE_ADD                  = 1;                       // 新增
    public static final byte   OPERATE_TYPE_UPDATE               = 2;                       // 修改
    public static final byte   OPERATE_TYPE_DELETE               = 3;                       // 删除
    public static final byte   OPERATE_TYPE_LOGIN                = 4;                       // 登录
    public static final byte   OPERATE_TYPE_LOGOUT               = 5;                       // 退出
    // 用户登录异常信息
    public static final String USER_NO_ROLES_ERROR               = "0";                     // 用户角色未分配
    // APP类型
    public static final String APP_TYPE_IOS                      = "1";
    public static final String APP_TYPE_ANDROID                  = "2";
    public static final String PLISTPACKAGENAME                  = "uploadPlist.plist";
}
