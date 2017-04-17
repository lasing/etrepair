package com.liveneo.etrepair.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JsonTreeTool {
    public static String dataToTree(List<HashMap> dataList) {
        // 读取层次数据结果集列表
        // List dataList = VirtualDataGenerator.getVirtualResult();
        // 节点列表（散列表，用于临时存储节点对象）
        HashMap nodeList = new HashMap();
        // 根节点
        Node root = new Node();
        root.parentId = null;
        root.text = "所有菜单";
        root.id = "0";
        root.checked = false;
        nodeList.put(root.id, root);
        // 根据结果集构造节点列表（存入散列表）
        for (Iterator it = dataList.iterator(); it.hasNext();) {
            Map dataRecord = (Map) it.next();
            Node node = new Node();
            node.id = dataRecord.get("id").toString();
            node.text = (String) dataRecord.get("text");
            node.isreadonly = dataRecord.get("isreadonly").toString();
            boolean checked = (Boolean) dataRecord.get("checked");
            if (checked) {
                node.checked = true;
            } else {
                node.checked = false;
            }
            if (dataRecord.get("parentId") == null || "".equals(dataRecord.get("parentId"))) {
                node.parentId = root.id;
            } else {
                node.parentId = (String) (dataRecord.get("parentId") + "");
            }
            nodeList.put(node.id, node);
        }
        // 构造无序的多叉树
        Set entrySet = nodeList.entrySet();
        for (Iterator it = entrySet.iterator(); it.hasNext();) {
            Node node = (Node) ((Map.Entry) it.next()).getValue();
            if (node.parentId == null || node.parentId.equals("")) {
                root = node;
            } else {
                ((Node) nodeList.get(node.parentId)).addChild(node);
            }
        }
        // 输出无序的树形菜单的JSON字符串
        // System.out.println(root.toString());
        // 对多叉树进行横向排序
        // root.sortChildren();
        // 输出有序的树形菜单的JSON字符串
        return root.toString();
    }
}

class Node {
    /**
     * 节点编号
     */
    public String    id;
    /**
     * 节点内容
     */
    public String    text;
    /**
     * 父节点编号
     */
    public String    parentId;
    public boolean   checked  = true;
    public String    isreadonly;
    /**
     * 孩子节点列表
     */
    private Children children = new Children();

    // 先序遍历，拼接JSON字符串
    public String toString() {
        String result = "{\"id\":" + id + ", \"text\":\"" + text + "\"" + ", \"checked\" : " + checked + ", \"isreadonly\" : " + isreadonly;
        if (children != null && children.getSize() != 0) {
            result += ", \"children\" : " + children.toString();
        } else {
            result += ", \"leaf\" : true";
        }
        return result + "}";
    }

    // 兄弟节点横向排序
    public void sortChildren() {
        if (children != null && children.getSize() != 0) {
            children.sortChildren();
        }
    }

    // 添加孩子节点
    public void addChild(Node node) {
        this.children.addChild(node);
    }
}

class Children {
    private List list = new ArrayList();

    public int getSize() {
        return list.size();
    }

    public void addChild(Node node) {
        list.add(node);
    }

    // 拼接孩子节点的JSON字符串
    public String toString() {
        String result = "[";
        for (Iterator it = list.iterator(); it.hasNext();) {
            result += ((Node) it.next()).toString();
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
        Collections.sort(list, new NodeIDComparator());
        // 对每个节点的下一层节点进行排序
        for (Iterator it = list.iterator(); it.hasNext();) {
            ((Node) it.next()).sortChildren();
        }
    }
}

class NodeIDComparator implements Comparator {
    // 按照节点编号比较
    public int compare(Object o1, Object o2) {
        int j1 = Integer.parseInt(((Node) o1).id);
        int j2 = Integer.parseInt(((Node) o2).id);
        return (j1 < j2 ? -1 : (j1 == j2 ? 0 : 1));
    }
}