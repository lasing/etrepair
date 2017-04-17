package com.liveneo.etrepair.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MapUtil {
    // private static String KEY = "151ebf3a6e02dffe6772836ec12df122";
    private static String KEY = PropertyConfigurer.getValue("gaodekey");

    public static String addressToGPS(String address) {
        try {
            address = java.net.URLEncoder.encode(address, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        try {
            String url = "http://restapi.amap.com/v3/geocode/geo?key=" + KEY + "&address=" + address;
            URL myURL = null;
            URLConnection httpsConn = null;
            try {
                myURL = new URL(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            InputStreamReader insr = null;
            BufferedReader br = null;
            httpsConn = (URLConnection) myURL.openConnection();// 不使用代理
            if (httpsConn != null) {
                insr = new InputStreamReader(httpsConn.getInputStream(), "UTF-8");
                br = new BufferedReader(insr);
                String data = "";
                String line = null;
                while ((line = br.readLine()) != null) {
                    data += line;
                }
                JSONObject object = JSONObject.fromObject(data);
                if ("1".equals(object.getString("status"))) {
                    JSONArray geocodes = object.getJSONArray("geocodes");
                    if (geocodes.size() == 1) {
                        JSONObject trueAddress = geocodes.getJSONObject(0);
                        String location = trueAddress.getString("location");
                        return location;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public static void main(String[] args) {
        // double[] data = MapUtil.addressToGPS("上海金桥");
        // System.out.println(data);
        // System.out.println("经度:" + data[0]);
        // System.out.println("纬度:" + data[1]);
        String data = MapUtil.addressToGPS("上海金桥");
        System.out.println(data);
        // {"status":"1","info":"OK","infocode":"10000","count":"1","geocodes":[{"formatted_address":"上海市浦东新区金桥","province":"上海市","citycode":"021","city":"上海市","district":"浦东新区","township":[],"neighborhood":{"name":[],"type":[]},"building":{"name":[],"type":[]},"adcode":"310115","street":[],"number":[],"location":"121.600891,31.253796","level":"热点商圈"}]}
    }
}
