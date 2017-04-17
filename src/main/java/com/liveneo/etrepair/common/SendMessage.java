package com.liveneo.etrepair.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Component;
import com.liveneo.etrepair.log.LVLogger;
import com.liveneo.etrepair.pojo.Message;
import com.liveneo.etrepair.pojo.SendInfo;
import com.liveneo.etrepair.service.support.InvokedInterfaceTool;

@Component
public class SendMessage {
    public static final LVLogger logger   = LVLogger.getLogger(SendMessage.class);
    // String url = PropertyConfigurer.getValue("msplatformUrl") + PropertyConfigurer.getValue("sendMessageUrlAction");
    String                       getuiUrl = PropertyConfigurer.getValue("getuiUrl") + PropertyConfigurer.getValue("getuiUrlAction");

    /**
     * @Title: 旧版本消息推送
     * @Author: zhaoyy 2016年10月24日 下午2:01:15
     * @param sendInfo
     */
    // public void push(SendInfo sendInfo) {
    // Map<String, Object> map = new HashMap<String, Object>();
    // String jsonstr = JsonUtils.beanToJson(sendInfo);
    // map.put("jsonstr", jsonstr);
    // logger.info("推送内容：" + jsonstr);
    // try {
    // StringBuffer result = new StringBuffer();
    // InvokedInterfaceTool.connectionHttpURLByPOST(url, map, 0, result);
    // logger.info("推送结果：" + result.toString());
    // } catch (Exception e) {
    // logger.error(e.getMessage());
    // }
    // }
    /**
     * @Title: 新的消息推送
     * @Author: zhaoyy 2016年10月24日 下午2:38:13
     * @param sendInfo
     */
    public void pushMessage(SendInfo sendInfo) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        Date date = new Date();
        String dates = DateUtil.formatDateToString(date, "yyyyMMddHHmmss");
        String projectCode = "ET";
        // 设置公共信息
        sendInfo.setProjectCode(projectCode);
        sendInfo.setCurTime(dates);
        sendInfo.setUuid(uuid);
        sendInfo.setToken(MD5Util.GetMD5Code(projectCode + uuid + dates));
        Map<String, Object> map = new HashMap<String, Object>();
        String jsonstr = JsonUtils.beanToJson(sendInfo);
        logger.info("推送内容：" + jsonstr);
        String baseStr = EncryptUtil.encodeBase64(jsonstr);
        map.put("data", baseStr);
        logger.info("编码后的推送内容：" + baseStr);
        try {
            StringBuffer result = new StringBuffer();
            InvokedInterfaceTool.connectionHttpURLByPOST(getuiUrl, map, 0, result);
            logger.info("推送结果：" + result.toString());
            logger.info("解码后的推送结果：" + EncryptUtil.decodeBase64String(result.toString()));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        Date date = new Date();
        String dates = DateUtil.formatDateToString(date, "yyyyMMddHHmmss");
        String projectCode = "ET";
        String url = "http://appservice.mobsurvey.cn/masplatform/bp/api/pushMessage";
        SendInfo request = new SendInfo();
        // 设置公共信息
        request.setProjectCode(projectCode);
        request.setCurTime(dates);
        request.setUuid(uuid);
        request.setToken(MD5Util.GetMD5Code(projectCode + uuid + dates));
        List<Message> ulist = new ArrayList<Message>();
        Message msg = new Message();
        msg.setCaseNo("07603008062016400213");
        msg.setContent("深圳修理厂" + "确认了您的任务编号为" + "112233" + "的送修任务");
        msg.setNewstype("0");
        msg.setMsgUUID("ET-" + uuid);
        msg.setUserMobile("13910000008");// 13910000008
        msg.setClientType("B");
        msg.setUserCode("13910000008ss");
        ulist.add(msg);
        request.setMsgList(ulist);
        String jsonstr = JsonUtils.beanToJson(request);
        System.out.println("请求加密前报文==>" + jsonstr);
        Map<String, Object> map = new HashMap<String, Object>();
        String baseStr = EncryptUtil.encodeBase64(jsonstr);
        System.out.println("请求加密后报文==>" + baseStr);
        map.put("data", baseStr);
        StringBuffer result = new StringBuffer();
        InvokedInterfaceTool.connectionHttpURLByPOST(url, map, 0, result);
        System.out.println("返回加密报文==>" + result);
        String rspminwen = EncryptUtil.decodeBase64String(result.toString());
        System.out.println("返回解密报文==>" + rspminwen);
    }
}
