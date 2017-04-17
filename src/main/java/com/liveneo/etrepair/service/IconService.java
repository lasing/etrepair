package com.liveneo.etrepair.service;

import java.util.List;
import com.liveneo.etrepair.pojo.Icon;

public interface IconService {
    int addIcon(Icon icon);

    List<Icon> listIcons();
}
