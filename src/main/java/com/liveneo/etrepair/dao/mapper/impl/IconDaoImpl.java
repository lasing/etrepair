package com.liveneo.etrepair.dao.mapper.impl;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.liveneo.etrepair.dao.mapper.IconMapper;
import com.liveneo.etrepair.pojo.Icon;
import com.liveneo.etrepair.pojo.IconExample;

@Repository
public class IconDaoImpl {
    @Autowired
    IconMapper iconMapper;

    /***
     * 添加icon
     */
    public int addIcon(Icon icon) {
        icon.setIconId(UUID.randomUUID().toString().replaceAll("-", ""));
        return iconMapper.insert(icon);
    }

    /***
     * 获取所有icon
     * 
     * @return
     */
    public List<Icon> listIcons() {
        IconExample example = new IconExample();
        return iconMapper.selectByExample(example);
    }
}
