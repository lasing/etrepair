package com.liveneo.etrepair.common;

public class ValidateCUtil {
    /**
     * C01 代位求偿
     * @param behalfThe
     * @return0：否 1：是
     */
    public static boolean valiC01BehalfThe(String behalfThe) {
        if ("0".equals(behalfThe) || "1".equals(behalfThe)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * C01 是否车险
     * @param isVehicleInsurance
     * @return0：否 1：是
     */
    public static boolean valiC01IsVehicleInsurance(String isVehicleInsurance) {
        if ("0".equals(isVehicleInsurance) || "1".equals(isVehicleInsurance)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * C01 损失类型
     * @param lossType
     * @return
     * 非空，1-标的车;2-三者车;3-本车司机;4-本车车上人员;5-三者人员;6-车上物;7-三者物
     */
    public static boolean valiC01LossType(String lossType) {
        if ("1".equals(lossType) || "2".equals(lossType) || "3".equals(lossType) || "4".equals(lossType) || "5".equals(lossType) || "6".equals(lossType)
                || "7".equals(lossType)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * C01 损失类型分类
     * @param lossPageType
     * @return 非空，“1”：车；”2”：人；”3”：物
     */
    public static boolean valiC01LossPageType(String lossPageType) {
        if ("1".equals(lossPageType) || "2".equals(lossPageType) || "3".equals(lossPageType)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * C02 调度类型
     * @param type
     * @return  1.视频调度  2.普通调度
     */
    public static boolean valiC02Type(String type) {
        if ("1".equals(type) || "2".equals(type)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * C02 调度状态
     * @param status
     * @return 1.新增  2.注销 
     */
    public static boolean valiC02Status(String status) {
        if ("1".equals(status) || "2".equals(status)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * C03 调度类型
     * @param type
     * @return  1.视频调度  2.普通调度
     */
    public static boolean valiC03Type(String type) {
        if ("1".equals(type) || "2".equals(type)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * C03 案件状态
     * @param status
     * @return 1.完结
     */
    public static boolean valiC03Status(String status) {
        if ("1".equals(status)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * C03 调度状态
     * @param status
     * @return 1 申请改派 2直接改派 3 任务注销 4 整案注销
     */
    public static boolean valiC03LossStatus(String status) {
        if ("1".equals(status) || "2".equals(status) || "3".equals(status) || "4".equals(status)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * C10查勘员类型
     * @param userType
     * @return 0：车险 1：非车险 2：既是车险又是非车险
     */
    public static boolean valiC10UserType(String userType) {
        if ("1".equals(userType) || "2".equals(userType) || "0".equals(userType)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * C10是否视频定损
     * @param isVideo
     * @return 0：否， 1：是
     */
    public static boolean valiC10IsVideo(String isVideo) {
        if ("0".equals(isVideo) || "1".equals(isVideo)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * C10状态
     * @param userType
     * @return 1：有效 0：无效
     */
    public static boolean valiC10Status(String status) {
        if ("1".equals(status) || "0".equals(status)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * C11是否视频定损
     * @param isVideo
     * @return  0：否， 1：是
     */
    public static boolean valiC11IsVideo(String isVideo) {
        if ("1".equals(isVideo) || "0".equals(isVideo)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * C11状态
     * @param userType
     * @return 1：新增，2：修改，9：注销
     */
    public static boolean valiC11Status(String status) {
        if ("1".equals(status) || "2".equals(status) || "9".equals(status)) {
            return true;
        } else {
            return false;
        }
    }
}
