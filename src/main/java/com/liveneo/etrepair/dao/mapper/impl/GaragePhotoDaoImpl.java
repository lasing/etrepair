package com.liveneo.etrepair.dao.mapper.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.liveneo.etrepair.dao.mapper.GaragePhotoMapper;
import com.liveneo.etrepair.pojo.GaragePhoto;

@Repository
public class GaragePhotoDaoImpl {
    @Autowired
    GaragePhotoMapper garagePhotoMapper;

    /***
     * 添加修理厂图片
     */
    public int addGaragePhoto(GaragePhoto garagePhoto) {
        return garagePhotoMapper.insert(garagePhoto);
    }

    /***
     * 删除修理厂图片
     */
    public void deleteGaragePhoto(String garagePhotoId) {
        garagePhotoMapper.deleteByPrimaryKey(garagePhotoId);
    }

    /**
     * 修理厂图片列表详情
     */
    public List<GaragePhoto> getGaragePhotoByGarageId(String garageId) {
        return garagePhotoMapper.getGaragePhotoByGarageId(garageId);
    }

    /**
     * 查询单个修理厂图片
     * @param garagePhotoId
     * @return
     */
    public GaragePhoto getGaragePhotoByGaragePhotoId(String garagePhotoId) {
        return garagePhotoMapper.getGaragePhotoByGaragePhotoId(garagePhotoId);
    }
}
