package com.liveneo.etrepair.dao.mapper.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.liveneo.etrepair.dao.mapper.TypeMapper;
import com.liveneo.etrepair.pojo.Type;
import com.liveneo.etrepair.pojo.TypeExample;
import com.liveneo.etrepair.pojo.TypeExample.Criteria;

@Repository
public class TypeDaoImpl {
    @Autowired
    private TypeMapper typeMapper;

    /***
     * 添加
     * 
     * @param type
     * @return
     */
    public int addType(Type type) {
        return this.typeMapper.insert(type);
    }

    public void deleteType(String id) {
        this.typeMapper.deleteByPrimaryKey(id);
    }

    // 删除该groupid下的所有type
    public void deleteTypeByGroup(String groupid) {
        this.typeMapper.deleteTypeByGroup(groupid);
    }

    public void updateType(Type type) {
        this.typeMapper.updateByPrimaryKey(type);
    }

    /***
     * 根据分组id 获取类别
     * 
     * @param groupId
     * @return
     */
    public List<Type> listTypesByGroupId(String groupId) {
        TypeExample example = new TypeExample();
        Criteria c = example.createCriteria();
        c.andTypeGroupIdEqualTo(groupId);
        return this.typeMapper.selectByExample(example);
    }

    /***
     * 根据id 获取Type
     * 
     * @param typeId
     * @return
     */
    public Type getTypeById(String typeId) {
        TypeExample example = new TypeExample();
        example.createCriteria().andTypeIdEqualTo(typeId);
        return this.typeMapper.selectByPrimaryKey(typeId);
    }

    public List<Type> listRepairTaskStatus(String taskstatus) {
        return typeMapper.listRepairTaskStatus(taskstatus);
    }

    public List<Map<String, String>> getTypeNameByTypeGroupCode(String typeGroupCode) {
        return typeMapper.getTypeNameByTypeGroupCode(typeGroupCode);
    }
}
