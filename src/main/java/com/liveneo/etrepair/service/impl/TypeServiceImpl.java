package com.liveneo.etrepair.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.liveneo.etrepair.common.Constant;
import com.liveneo.etrepair.dao.mapper.impl.TypeDaoImpl;
import com.liveneo.etrepair.dao.mapper.impl.TypeGroupDaoImpl;
import com.liveneo.etrepair.dao.mapper.impl.TypeGroupDaoImpl;
import com.liveneo.etrepair.json.wrapper.TypeWrapper;
import com.liveneo.etrepair.log.Opertorlog;
import com.liveneo.etrepair.pojo.Type;
import com.liveneo.etrepair.pojo.Typegroup;
import com.liveneo.etrepair.service.TypeService;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeDaoImpl      typeDaoImpl;
    @Autowired
    private TypeGroupDaoImpl typeGroupDaoImpl;

    @Override
    @Opertorlog(name = "新增字典", functionPath = "系统操作-->字典管理-->字典部门", operateType = Constant.OPERATE_TYPE_ADD)
    public int saveType(Type type, String id) {
        Typegroup typeGroup = this.typeGroupDaoImpl.getTypeGroup(id);
        if (typeGroup != null) {
            type.setTypeGroupId(id);
        } else {
            Type t = this.typeDaoImpl.getTypeById(id);
            type.setTypeGroupId(t.getTypeGroupId());
        }
        return this.typeDaoImpl.addType(type);
    }

    @Override
    @Opertorlog(name = "新增字典类型", functionPath = "系统操作-->数据字典-->字典项录入", operateType = Constant.OPERATE_TYPE_ADD)
    public int saveTypeGroup(Typegroup typeGroup) {
        return this.typeGroupDaoImpl.addTypeGroup(typeGroup);
    }

    @Override
    @Opertorlog(name = "删除字典", functionPath = "系统操作-->数据字典-->删除字典", operateType = Constant.OPERATE_TYPE_DELETE)
    public void deleteType(String typeId) {
        this.typeDaoImpl.deleteType(typeId);
    }

    @Override
    @Opertorlog(name = "删除字典项", functionPath = "系统操作-->数据字典-->删除字典", operateType = Constant.OPERATE_TYPE_DELETE)
    public void deleteTypeGroup(String typeGroupId) {
        this.typeGroupDaoImpl.deleteTypeGroup(typeGroupId);
    }

    @Override
    @Opertorlog(name = "更新字典", functionPath = "系统操作-->数据字典-->更新字典", operateType = Constant.OPERATE_TYPE_UPDATE)
    public void update(String name, String code, String id, String updateBy) {
        Typegroup group = this.typeGroupDaoImpl.getTypeGroup(id);
        if (group != null) {
            group.setTypeGroupCode(code);
            group.setTypeGroupName(name);
            group.setUpdateBy(updateBy);
            this.typeGroupDaoImpl.updateTypeGruop(group);
        } else {
            Type type = this.typeDaoImpl.getTypeById(id);
            if (type != null) {
                type.setTypeCode(name);
                type.setTypeName(code);
                type.setUpdateBy(updateBy);
                this.typeDaoImpl.updateType(type);
            }
        }
    }

    @Override
    public List<Type> getTypesByGroupId(String groupId) {
        return this.typeDaoImpl.listTypesByGroupId(groupId);
    }

    @Override
    public List<Typegroup> getAllTypeGroups() {
        return this.typeGroupDaoImpl.listTypeAllGroup();
    }

    @Override
    public List<TypeWrapper> listTypes() {
        List<TypeWrapper> result = new ArrayList<TypeWrapper>();
        List<Typegroup> typeGroups = this.typeGroupDaoImpl.listTypeAllGroup();
        for (Typegroup typeGroup : typeGroups) {
            String groupId = typeGroup.getTypeGroupId();
            TypeWrapper wrapper = new TypeWrapper();
            wrapper.setId(typeGroup.getTypeGroupId());
            wrapper.setCode(typeGroup.getTypeGroupCode());
            wrapper.setName(typeGroup.getTypeGroupName());
            wrapper.set_parentId(null);
            wrapper.setState("closed");
            result.add(wrapper);
            List<Type> types = this.typeDaoImpl.listTypesByGroupId(groupId);
            for (Type type : types) {
                TypeWrapper w = new TypeWrapper();
                w.set_parentId(groupId);
                w.setId(type.getTypeId());
                w.setCode(type.getTypeName());
                w.setName(type.getTypeCode());
                result.add(w);
            }
        }
        return result;
    }

    /***
     * 删除类型 删除类型组时，同时删除对应组下面的子元素
     * 
     */
    @Opertorlog(name = "删除字典", functionPath = "系统操作-->字典管理-->删除字典", operateType = Constant.OPERATE_TYPE_DELETE)
    @Override
    public void delete(String id) {
        Typegroup group = this.typeGroupDaoImpl.getTypeGroup(id);
        if (group != null) {
            List<Type> types = this.typeDaoImpl.listTypesByGroupId(id);
            if (types != null && types.size() != 0) {
                /*
                 * for (Type t : types) { this.typeDaoImpl.deleteType(t.getTypeId()); }
                 */
                this.typeDaoImpl.deleteTypeByGroup(group.getTypeGroupId());
            }
            this.typeGroupDaoImpl.deleteTypeGroup(id);
        } else {
            Type type = this.typeDaoImpl.getTypeById(id);
            if (type != null) {
                this.typeDaoImpl.deleteType(id);
            }
        }
    }

    @Override
    public String typeOrTypeGroup(String id) {
        Typegroup group = this.typeGroupDaoImpl.getTypeGroup(id);
        if (group != null) {
            return "typeGroup";
        } else {
            Type type = this.typeDaoImpl.getTypeById(id);
            if (type != null) {
                return "type";
            }
        }
        return "";
    }
}
