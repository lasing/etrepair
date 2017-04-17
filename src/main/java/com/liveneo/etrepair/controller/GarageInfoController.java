package com.liveneo.etrepair.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.liveneo.etrepair.common.OssManage;
import com.liveneo.etrepair.common.PropertyConfigurer;
import com.liveneo.etrepair.log.LVLogger;
import com.liveneo.etrepair.pojo.Garage;
import com.liveneo.etrepair.pojo.GaragePhoto;
import com.liveneo.etrepair.pojo.User;
import com.liveneo.etrepair.service.GarageService;

@Controller
@RequestMapping("/garageInfo")
public class GarageInfoController extends BaseController {
    LVLogger              logger           = LVLogger.getLogger(this.getClass());
    @Autowired
    private GarageService garageService;
    @Autowired
    private OssManage     ossManage;
    private String        ossbucketsubname = PropertyConfigurer.getValue("OSS_BUCKET_SUB_NAME");

    @RequestMapping(value = "/garage", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public ModelAndView getGarageInfo(String garageId, HttpSession session) throws Exception {
        if ("".equals(garageId) || garageId == null) {
            User user = (User) session.getAttribute("user");
            String userCode = user.getUserCode();
            garageId = garageService.getGarageIdByUserCode(userCode);
        }
        Garage garage = garageService.getGarageById(garageId);
        // 图片路径
        // String basePath = PropertyConfigurer.getValue("ossBaseUrl");
        if ("".equals(garageId) || garageId == null) {
            return new ModelAndView("common/403", null);
        } else {
            List<GaragePhoto> photoList = garageService.getGaragePhotoById(garageId);
            List<String> photoUrls = new ArrayList<String>();
            if (photoList != null) {
                for (GaragePhoto phurl : photoList) {
                    String u = ossbucketsubname + "/" + phurl.getPhotoUrl();
                    // 根据key去获取图片的路径 zhaoyy 20161025
                    // TODO 根据key去获取图片的路径 zhaoyy 20161025
                    String url = ossManage.getURL(u);
                    photoUrls.add(url);
                }
            }
            garage.setPhotoList(photoUrls);
            String category = garage.getCategoryCode();
            // 根据categoryCode查找type表typeName字段
            String typeName = garageService.getTypeNameByCode(category);
            garage.setTypeName(typeName);
        }
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("garage", garage);
        return new ModelAndView("garageInfo/garageInfo", maps);
    }
}
