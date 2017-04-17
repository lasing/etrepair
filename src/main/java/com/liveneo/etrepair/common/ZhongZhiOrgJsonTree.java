package com.liveneo.etrepair.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Description:中支机构json树
 * @Author:zuokunpeng
 * @Since:2016-4-17 下午9:53:25
 */
public class ZhongZhiOrgJsonTree {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static String dataToTree(List<HashMap> dataList) {
        // 节点列表（散列表，用于临时存储节点对象）
        HashMap nodeList = new HashMap();
        // 根节点
        ZhongZhiOrgNode nodes = new ZhongZhiOrgNode();
        // 根据结果集构造节点列表（存入散列表）
        for (Iterator it = dataList.iterator(); it.hasNext();) {
            Map dataRecord = (Map) it.next();
            ZhongZhiOrgNode node = new ZhongZhiOrgNode();
            node.id = dataRecord.get("id").toString();
            node.text = (String) dataRecord.get("text");
            boolean checked = (Boolean) dataRecord.get("checked");
            if (checked) {
                node.checked = true;
            } else {
                node.checked = false;
            }
            nodeList.put(node.id, node);
        }
        // 构造无序的多叉树
        Set entrySet = nodeList.entrySet();
        List list = new ArrayList();
        for (Iterator it = entrySet.iterator(); it.hasNext();) {
            ZhongZhiOrgNode node = (ZhongZhiOrgNode) ((Map.Entry) it.next()).getValue();
            list.add(node);
        }
        // 输出无序的树形菜单的JSON字符串
        System.out.println(nodes.resultToString(list));
        // 对多叉树进行横向排序
        // root.sortChildren();
        // 输出有序的树形菜单的JSON字符串
        return nodes.resultToString(list);
    }
}

class ZhongZhiOrgNode {
    public String  id;             // 节点编号
    public String  text;           // 节点内容
    public boolean checked = false; // 是否选中checkbox

    // 每个JSON对象模板
    public String nodeTemplate() {
        String result = "{\"id\":\"" + id + "\", \"text\":\"" + text + "\"" + ", \"checked\" : " + checked + "}";
        return result;
    }

    // 拼接json结果并返回
    public String resultToString(List list) {
        String result = "";
        if (list != null && list.size() > 0) {
            for (Iterator it = list.iterator(); it.hasNext();) {
                result += ((ZhongZhiOrgNode) it.next()).nodeTemplate();
                result += ",";
            }
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }
}
