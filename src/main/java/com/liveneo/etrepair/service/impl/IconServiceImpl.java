package com.liveneo.etrepair.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.liveneo.etrepair.dao.mapper.impl.IconDaoImpl;
import com.liveneo.etrepair.pojo.Icon;
import com.liveneo.etrepair.service.IconService;

@Service
public class IconServiceImpl implements IconService {
    @Autowired
    private IconDaoImpl iconDaoImpl;

    /***
     * 添加icon
     */
    @Override
    public int addIcon(Icon icon) {
        return this.iconDaoImpl.addIcon(icon);
    }

    @Override
    public List<Icon> listIcons() {
        return this.iconDaoImpl.listIcons();
    }
}
