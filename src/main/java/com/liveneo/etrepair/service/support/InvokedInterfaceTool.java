package com.liveneo.etrepair.service.support;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.google.gson.Gson;
import com.liveneo.etrepair.common.DesBase64Util;
import com.liveneo.etrepair.log.LVLogger;

/**
 * 案件调度 接口调用 service
 * 
 * @author fcy
 *
 */
public class InvokedInterfaceTool {
    private static LVLogger logger = LVLogger.getLogger(InvokedInterfaceTool.class);

    public static int connectionHttpURLByPostForTest(String urlStr, Map<String, Object> params, StringBuffer result) {
        /*
         * { resultCode:xxx message: xxx regisNo:xxx dispatchType :xxx //调度类别 assignToLossCenter:xxx //是否调派定损中心
         * isSelfDispatch:xxx //是否自助调度 IsSingleTraffic：XXX //是否单车 tasks : [{ taskID: xxx, //任务id surveyID: xxxx //查勘员id
         * }… ] }
         */
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        resultMap.put("resultCode", "0000");
        resultMap.put("message", "成功");
        resultMap.put("registNo", params.get("registNo"));
        resultMap.put("dispatchType", "0");
        // 车辆可移动，设置定损中心为1
        resultMap.put("assignToLossCenter", "0");
        resultMap.put("isSelfDispatch", "0");
        resultMap.put("isSingleTraffic", "0");
        // 查勘员 0103
        List<Map<String, String>> tasks = (List<Map<String, String>>) params.get("tasks");
        List<Map<String, String>> taskSurveyMaps = new ArrayList<Map<String, String>>();
        for (Map<String, String> task : tasks) {
            Map<String, String> taskSurveyMap = new LinkedHashMap<String, String>();
            taskSurveyMap.put("taskID", task.get("taskID"));
            taskSurveyMap.put("surveyID", "4");
            taskSurveyMaps.add(taskSurveyMap);
        }
        resultMap.put("tasks", taskSurveyMaps);
        Gson gson = new Gson();
        result.append(gson.toJson(resultMap));
        // 直接返回成功
        return 200;
    }

    /**
     * 通过 HTTP URL调用接口，获取信息
     * 
     * @param urlStr
     * @param params
     * @param result
     * @return
     */
    public static int connectionHttpURLByGet(String urlStr, String params, StringBuffer result) {
        URL url = null;
        HttpURLConnection connection = null;
        BufferedReader bf = null;
        int resultCode = -1;
        try {
            // params = java.net.URLEncoder.encode(params, "UTF-8");
            urlStr += (params != null && !"".equals(params) ? "?" + params : "");
            url = new URL(urlStr);
            // 打开和URL之间的连接
            connection = (HttpURLConnection) url.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("Accept-Charset", "utf-8");
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 建立连接
            // 请求未开始,直到connection.getInputStream()方法调用时才发起,以上各个参数设置需在此方法之前进行
            connection.connect();
            // 返回连接信息码（200成功，404无法获取连接）
            resultCode = connection.getResponseCode();
            // System.out.println(connection.getResponseCode());
            // 连接发起请求,处理服务器响应 (从连接获取到输入流并包装为bufferedReader)
            bf = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            result.append(IOUtils.toString(bf));
        } catch (Exception e) {
            logger.error(e);
            result.append(e.getMessage());
        } finally {
            // 关闭IO流
            IOUtils.closeQuietly(bf);
            // 销毁连接
            if (connection != null) {
                connection.disconnect();
            }
        }
        return resultCode;
    }

    /**
     * 通过 HTTP URL调用接口，获取信息
     * 
     * @param urlStr
     * @param params
     * @param paramType 参数传递类型 0 ：以key-value形式传递，1：将整个参数封装成json字符串传递
     * @param result
     * @return
     */
    public static int connectionHttpURLByPOST(String urlStr, Map<String, Object> params, int paramType, StringBuffer result) {
        URL url = null;
        HttpURLConnection connection = null;
        BufferedReader bf = null;
        int resultCode = -1;
        Gson gson = new Gson();
        try {
            url = new URL(urlStr);
            // 将 url 打开连接
            connection = (HttpURLConnection) url.openConnection();
            // 设置连接输出流为true,默认false (post请求是以流的方式隐式的传递参数)
            connection.setDoOutput(true);
            // 设置连接输入流为true
            connection.setDoInput(true);
            // 设置请求方式为post
            connection.setRequestMethod("POST");
            // post请求缓存设为false
            connection.setUseCaches(false);
            // 设置该HttpURLConnection实例是否自动执行重定向
            connection.setInstanceFollowRedirects(true);
            // 设置请求头里面的各个属性 (以下为设置内容的类型,设置为经过urlEncoded编码过的from参数)
            // connection.setRequestProperty("Content-Type","application/json; charset=UTF-8");
            // connection.setRequestProperty("Accept", "application/json");
            if (paramType == 0) {
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            } else {
                connection.setRequestProperty("Content-Type", "application/json");
            }
            // 建立连接
            // 请求未开始,直到connection.getInputStream()方法调用时才发起,以上各个参数设置需在此方法之前进行
            connection.connect();
            // 创建输入输出流,用于往连接里面输出携带的参数,(输出内容为?后面的内容)
            DataOutputStream dataout = new DataOutputStream(connection.getOutputStream());
            String encodeParams = "";
            if (paramType == 0) {
                String paramsStr = "";
                for (Entry<String, Object> param : params.entrySet()) {
                    Object value = param.getValue();
                    if (value instanceof String) {
                        paramsStr += param.getKey() + "=" + URLEncoder.encode((String) value, "utf-8") + "&";
                    } else {
                        paramsStr += param.getKey() + "=" + URLEncoder.encode(gson.toJson(value), "utf-8") + "&";
                    }
                }
                encodeParams = paramsStr.length() > 0 ? paramsStr.substring(0, paramsStr.length() - 1) : "";
            } else {
                encodeParams = gson.toJson(params);
            }
            // UTF-8编码
            // String encodeParams = URLEncoder.encode(params, "utf-8");
            // System.out.println(encodeParams);
            // 将参数输出到连接
            if (encodeParams != null && !"".equals(encodeParams)) {
                dataout.write(encodeParams.getBytes("utf-8"));
            }
            // 输出完成后刷新并关闭流
            dataout.flush();
            dataout.close(); // 重要且易忽略步骤 (关闭流,切记!)
            // 返回连接信息码（200成功，404无法获取连接）
            resultCode = connection.getResponseCode();
            // System.out.println(connection.getResponseCode());
            // 连接发起请求,处理服务器响应 (从连接获取到输入流并包装为bufferedReader)
            bf = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            result.append(IOUtils.toString(bf));
        } catch (Exception e) {
            logger.error(e);
            result.append(e.getMessage());
        } finally {
            // 关闭IO流
            IOUtils.closeQuietly(bf);
            // 销毁连接
            if (connection != null) {
                connection.disconnect();
            }
        }
        return resultCode;
    }

    /**
     * 调用核心系统请求
     * @param url
     * @param param
     * @param encoding
     * @return
     */
    public static String httpPost(String url, String param, String encoding) {
        String result = null;
        HttpPost httppost = null;
        CloseableHttpClient httpclient = null;
        try {
            // 创建默认的httpClient实例.
            httpclient = HttpClients.createDefault();
            // 创建httppost
            httppost = new HttpPost(url);
            // 设置参数
            String xmlDes = DesBase64Util.encrypt(param);
            httppost.setEntity(new ByteArrayEntity(xmlDes.getBytes(encoding)));
            // 执行请求
            HttpResponse httpResponse = httpclient.execute(httppost);
            // 获取返回的数据
            HttpEntity httpEntity = httpResponse.getEntity();
            if (httpEntity != null) {
                String response = new String(getData(httpEntity), encoding);
                // 解密
                result = DesBase64Util.decrypt(response);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            // 终止连接
            if (httppost != null) {
                httppost.abort();
            }
            if (httpclient != null) {
                httpclient.getConnectionManager().shutdown();
            }
        }
    }

    /**
     * 获取Entity中数据
     * @param httpEntity
     * @return
     * @throws Exception
     */
    public static byte[] getData(HttpEntity httpEntity) throws Exception {
        BufferedHttpEntity bufferedHttpEntity = new BufferedHttpEntity(httpEntity);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bufferedHttpEntity.writeTo(byteArrayOutputStream);
        byte[] responseBytes = byteArrayOutputStream.toByteArray();
        return responseBytes;
    }
    /*
     * public static void main(String[] args) { System.setProperty("http.proxyHost", "localhost");
     * System.setProperty("http.proxyPort", "8888");
     * 
     * System.setProperty("https.proxyHost", "localhost"); System.setProperty("https.proxyPort", "8888");
     * 
     * StringBuffer result = new StringBuffer(); Gson gson = new Gson();
     * 
     * Map<String, String> params = new HashMap<String, String>(); params.put("param", "aa"); params.put("tttt", "bbb");
     * 
     * StringBuffer value = new StringBuffer();
     * 
     * for(int i = 0; i < 1000; i++){ value.append("ab"); }
     * 
     * int code = connectionHttpURLByPOST("http://localhost:8680/webTest/test/first", gson.toJson(params), result);
     * 
     * // int code = connectionHttpURLByPOST("http://www.baidu.com", gson.toJson(params), result);
     * 
     * System.out.println("响应码：" + code); System.out.println(); System.out.println("结果：" + result.toString()); }
     */
}
