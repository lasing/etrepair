package com.liveneo.etrepair.dao.mapper.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.liveneo.etrepair.dao.mapper.GarageCoreMapper;
import com.liveneo.etrepair.dao.mapper.GarageMapper;
import com.liveneo.etrepair.pojo.Garage;
import com.liveneo.etrepair.pojo.GarageCore;

@Repository
public class GarageDaoImpl {
    @Autowired
    GarageMapper     garageMapper;
    @Autowired
    GarageCoreMapper garageCoreMapper;

    /**
     * 根据机构id 获取最大的编号
     * 
     * @param orgId
     * @return
     */
    public String getMaxPointNumber(String orgId) {
        return garageMapper.getMaxPointNumber(orgId);
    }

    /***
     * 添加修理厂
     */
    public void addGarage(Garage garage) {
        garageMapper.insert(garage);
    }

    /***
     * 修改修理厂
     */
    public void updateGarage(Garage garage) {
        garageMapper.updateByPrimaryKeySelective(garage);
    }

    /***
     * 删除修理厂
     */
    public void deleteGarage(String garageId) {
        garageMapper.deleteByPrimaryKey(garageId);
    }

    /**
     * 批量删除修理厂
     * 
     * @param idList
     */
    public void deleteBatch(List<String> idList) {
        garageMapper.deleteBatch(idList);
    }

    /***
     * ET修理厂总数
     */
    public int countGarage(Garage garage) {
        return garageMapper.countGarage(garage);
    }

    /***
     * 获取ET修理厂列表
     */
    public List<Garage> getGarageList(Garage garage, int skip, int rows) {
        garage.setSkip(skip);
        garage.setLimit(rows);
        return garageMapper.selectGarageList(garage);
    }

    /***
     * 核心修理厂总数
     */
    public int countGarageCore(GarageCore garageCore) {
        return garageCoreMapper.countGarageCore(garageCore);
    }

    /***
     * 获取核心修理厂列表
     */
    public List<GarageCore> getGarageCoreList(GarageCore garageCore, int skip, int rows) {
        garageCore.setSkip(skip);
        garageCore.setLimit(rows);
        return garageCoreMapper.selectGarageCoreList(garageCore);
    }

    public GarageCore getGarageCoreById(String garageId) {
        return garageCoreMapper.selectByPrimaryKey(garageId);
    }

    /**
     * 根据修理厂Id获取修理厂信息
     */
    public Garage getGarageById(String garageId) {
        return garageMapper.selectByPrimaryKey(garageId);
    }

    public int isGarageIdExistInGarageCore(String garageId) {
        return garageCoreMapper.isGarageIdExistInGarageCore(garageId);
    }

    public String getGarageIdByUserCode(String userCode) {
        return garageMapper.getGarageIdByUserCode(userCode);
    }

    public List<Garage> getGarageListByIdList(List<String> idList) {
        return garageMapper.getGarageListByIdList(idList);
    }

    public String getTypeNameByCode(String category) {
        return garageMapper.getTypeNameByCode(category);
    }
    /***
	 * 同步到核心修理厂2016-11-18 王学杰
	 */
	public int updateGarageCore(GarageCore record) {
		return garageCoreMapper.updateByPrimaryKeySelective(record);
	}
}
