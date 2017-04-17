package com.liveneo.etrepair.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MenuJsonTree {
    public static String dataToTree(List<HashMap> dataList) {
        // 读取层次数据结果集列表
        // List dataList = VirtualDataGenerator.getVirtualResult();
        // 节点列表（散列表，用于临时存储节点对象）
        HashMap nodeList = new HashMap();
        // 根节点
        Menu root = new Menu();
        root.parentId = null;
        root.menuname = "菜单";
        root.menuid = "0";
        root.url = "";
        root.order = "0";
        nodeList.put(root.menuid, root);
        // 根据结果集构造节点列表（存入散列表）
        for (Iterator it = dataList.iterator(); it.hasNext();) {
            Map dataRecord = (Map) it.next();
            Menu node = new Menu();
            node.menuid = dataRecord.get("menuid").toString();
            node.menuname = (String) dataRecord.get("menuname");
            node.url = (String) dataRecord.get("url");
            node.order = dataRecord.get("order").toString();
            node.icon = dataRecord.get("icon") == null ? null : dataRecord.get("icon").toString();
            if (dataRecord.get("parentId") == null || "".equals(dataRecord.get("parentId"))) {
                node.parentId = root.menuid;
            } else {
                node.parentId = dataRecord.get("parentId").toString();
            }
            nodeList.put(node.menuid, node);
        }
        // 构造无序的多叉树
        Set entrySet = nodeList.entrySet();
        for (Iterator it = entrySet.iterator(); it.hasNext();) {
            Menu node = (Menu) ((Map.Entry) it.next()).getValue();
            if (node.parentId == null || "".equals(node.parentId)) {
                root = node;
            } else {
                ((Menu) nodeList.get(node.parentId)).addChild(node);
            }
        }
        // 输出无序的树形菜单的JSON字符串
        System.out.println(root.toString());
        // 对多叉树进行横向排序
        root.sortChildren();
        // 输出有序的树形菜单的JSON字符串
        return root.toString();
    }
}

class Menu {
    /**
     * 节点编号
     */
    public String   menuid;
    public String   icon;
    public String   menuname;
    public String   url;
    public String   order;
    /**
     * 父节点编号
     */
    public String   parentId;
    /**
     * 孩子节点列表
     */
    private SubMenu menus = new SubMenu();

    // 先序遍历，拼接JSON字符串
    public String toString() {
        String result = "{\"menuid\":\"" + menuid + "\", \"menuname\":\"" + menuname + "\"";
        if (icon != null && !"".equals(icon)) {
            result += ",\"icon\":\"" + icon + "\"";
        }
        if (url != null && !"".equals(url)) {
            result += ",\"url\":\"" + url + "\"";
        }
        // + "\", \"url\" :\"" + url + "\"";
        if (menus != null && menus.getSize() != 0) {
            result += ", \"menus\" : " + menus.toString();
        } else {
            result += ", \"leaf\" : true";
        }
        return result + "}";
    }

    // 兄弟节点横向排序
    public void sortChildren() {
        if (menus != null && menus.getSize() != 0) {
            menus.sortChildren();
        }
    }

    // 添加孩子节点
    public void addChild(Menu node) {
        this.menus.addChild(node);
    }
}

class SubMenu {
    private List list = new ArrayList();

    public int getSize() {
        return list.size();
    }

    public void addChild(Menu node) {
        list.add(node);
    }

    // 拼接孩子节点的JSON字符串
    public String toString() {
        String result = "[";
        for (Iterator it = list.iterator(); it.hasNext();) {
            result += ((Menu) it.next()).toString();
            result += ",";
        }
        result = result.substring(0, result.length() - 1);
        result += "]";
        return result;
    }

    // 孩子节点排序
    public void sortChildren() {
        // 对本层节点进行排序
        // 可根据不同的排序属性，传入不同的比较器，这里传入ID比较器
        Collections.sort(list, new MenuOrderComparator());
        // 对每个节点的下一层节点进行排序
        for (Iterator it = list.iterator(); it.hasNext();) {
            ((Menu) it.next()).sortChildren();
        }
    }
}

class MenuOrderComparator implements Comparator {
    // 按照节点编号比较
    public int compare(Object o1, Object o2) {
        int j1 = Integer.parseInt(((Menu) o1).order);
        int j2 = Integer.parseInt(((Menu) o2).order);
        return (j1 < j2 ? -1 : (j1 == j2 ? 0 : 1));
    }
}
