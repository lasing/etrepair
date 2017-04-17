package com.liveneo.etrepair.service;

import java.util.List;
import com.liveneo.etrepair.json.wrapper.TypeWrapper;
import com.liveneo.etrepair.pojo.Type;
import com.liveneo.etrepair.pojo.Typegroup;

public interface TypeService {
    public int saveType(Type type, String groupId);

    public int saveTypeGroup(Typegroup typeGroup);

    public void deleteType(String typeId);

    public void deleteTypeGroup(String TypeGroupId);

    public void update(String name, String code, String id, String updateBy);

    public List<Type> getTypesByGroupId(String groupId);

    public List<Typegroup> getAllTypeGroups();

    public List<TypeWrapper> listTypes();

    public void delete(String id);

    // 是字典项或参数值
    public String typeOrTypeGroup(String id);
}
