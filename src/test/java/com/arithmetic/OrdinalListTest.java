package com.arithmetic;

/**
 * 顺序链表测试类
 */
public class OrdinalListTest {
    public static void main(String[] args) {
        OrdinalList ordinalList = new OrdinalList();
        ordinalList.addElement("a");
        ordinalList.addElement("b");
        System.out.println(ordinalList.size());
        System.out.println(ordinalList.isEmpty());
        System.out.println(ordinalList.removeElement(1));
        System.out.println(ordinalList.toString());
    }
}
