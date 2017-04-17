package com.liveneo.etrepair.dao.mapper.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.liveneo.etrepair.dao.mapper.TypegroupMapper;
import com.liveneo.etrepair.pojo.Typegroup;
import com.liveneo.etrepair.pojo.TypegroupExample;

@Repository
public class TypeGroupDaoImpl {
    @Autowired
    private TypegroupMapper typegroupMapper;

    public int addTypeGroup(Typegroup typeGroup) {
        return this.typegroupMapper.insert(typeGroup);
    }

    public void deleteTypeGroup(String id) {
        this.typegroupMapper.deleteByPrimaryKey(id);
    };

    public void updateTypeGruop(Typegroup typeGroup) {
        this.typegroupMapper.updateByPrimaryKey(typeGroup);
    }

    public List<Typegroup> listTypeAllGroup() {
        TypegroupExample example = new TypegroupExample();
        return this.typegroupMapper.selectByExample(example);
    }

    public Typegroup getTypeGroup(String groupId) {
        TypegroupExample example = new TypegroupExample();
        example.createCriteria().andTypeGroupIdEqualTo(groupId);
        return this.typegroupMapper.selectByPrimaryKey(groupId);
    }
}