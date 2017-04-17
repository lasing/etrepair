package com.liveneo.etrepair.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Description:险种险类Json树
 * @Author:zuokunpeng
 * @Since:2016-4-8 上午9:58:15
 */
public class InsuranceTypeJsonTree {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static String dataToTree(List<HashMap> dataList) {
        // 节点列表（散列表，用于临时存储节点对象）
        HashMap nodeList = new HashMap();
        // 根节点
        InsuranceTypeNode root = null;
        // 根据结果集构造节点列表（存入散列表）
        if (dataList != null && dataList.size() > 0) {
            root = new InsuranceTypeNode();
            for (Iterator it = dataList.iterator(); it.hasNext();) {
                Map dataRecord = (Map) it.next();
                InsuranceTypeNode node = new InsuranceTypeNode();
                node.id = dataRecord.get("id").toString();
                node.text = (String) dataRecord.get("text");
                node.insuranceTypeCode = dataRecord.get("insuranceTypeCode").toString();
                node.parentId = (String) dataRecord.get("parentId");
                boolean checked = (Boolean) dataRecord.get("checked");
                if (checked) {
                    node.checked = true;
                } else {
                    node.checked = false;
                }
                if (dataRecord.get("parentId") == null || "".equals(dataRecord.get("parentId"))) {
                    node.parentId = root.id;
                }
                nodeList.put(node.id, node);
            }
            // 构造无序的多叉树
            Set entrySet = nodeList.entrySet();
            for (Iterator it = entrySet.iterator(); it.hasNext();) {
                InsuranceTypeNode node = (InsuranceTypeNode) ((Map.Entry) it.next()).getValue();
                if (node.parentId == null || node.parentId.equals("")) {
                    root = node;
                } else {
                    if (nodeList.get(node.parentId) != null) {
                        ((InsuranceTypeNode) nodeList.get(node.parentId)).addChild(node);
                    }
                }
            }
        }
        // dataList为null则root为null不构造树
        if (root == null) {
            return "";
        } else {
            if (StringUtil.isEmptyOrNull(root.id)) {
                return "";
            }
            // 输出无序的树形菜单的JSON字符串
            return root.toString();
        }
    }
}

class InsuranceTypeNode {
    /**
     * 节点编号
     */
    public String                 id;
    /**
     * 节点内容
     */
    public String                 text;
    /**
     * 父节点编号
     */
    public String                 parentId;
    /**
     * 保险种类编号
     */
    public String                 insuranceTypeCode;
    public boolean                checked  = false;
    /**
     * 孩子节点列表
     */
    private InsuranceTypeChildren children = new InsuranceTypeChildren();

    // 先序遍历，拼接JSON字符串
    public String toString() {
        String result = "{\"id\":\"" + id + "\", \"text\":\"" + text + "\"" + ", \"insuranceTypeCode\" :\"" + insuranceTypeCode + "\", \"checked\" : "
                + checked;
        if (children != null && children.getSize() != 0) {
            result += ", \"children\" : " + children.toString();
        } else {
            result += ", \"leaf\" : true";
        }
        return result + "}";
    }

    // 添加孩子节点
    public void addChild(InsuranceTypeNode node) {
        this.children.addChild(node);
    }
}

class InsuranceTypeChildren {
    private List list = new ArrayList();

    public int getSize() {
        return list.size();
    }

    public void addChild(InsuranceTypeNode node) {
        list.add(node);
    }

    // 拼接孩子节点的JSON字符串
    public String toString() {
        String result = "[";
        for (Iterator it = list.iterator(); it.hasNext();) {
            result += ((InsuranceTypeNode) it.next()).toString();
            result += ",";
        }
        result = result.substring(0, result.length() - 1);
        result += "]";
        return result;
    }
}
