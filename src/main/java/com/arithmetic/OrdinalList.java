package com.arithmetic;

/**
 * 实现一个顺序链表(固定长度)
 * 链表可以添加、移除、获取元素以及链表节点数量
 */
public class OrdinalList {
    /**
     * 链表最多节点数
     */
    private static final int MAX_LENGTH = 100;
    /**
     * 初始化链表(下标从0开始)
     */
    private Object[] list = new Object[MAX_LENGTH];
    /**链表节点数量
     *
     */
    private int size;

    /**
     * 获取链表节点个数
     */
    public int size(){
        return size;
    }

    /**
     * 是否为空链表
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 添加元素
     */
    public boolean addElement(Object object){
        if(size > MAX_LENGTH){
            throw new OutOfMemoryError();
        }
        list[size] = object;
        size++;
        return true;
    }

    /**
     * 指定位置添加元素
     */
    public boolean setElement(int index, Object object){
        if(index < 0 || index > (size - 1)){
            throw new IndexOutOfBoundsException();
        }
        if(size >= MAX_LENGTH){
            throw new OutOfMemoryError();
        }
        /*for(int i = index; i < length; i++){
            list[i + 1] = list[i];
        }*/
        System.arraycopy(list, index, list, (index + 1), size - index - 1);
        list[index] = object;
        size++;
        return true;
    }

    /**
     * 获取指定位置链表中元素
     */
    public Object getElement(int index){
        if(index < 0 || index > (size - 1)){
            throw new IndexOutOfBoundsException();
        }
        return list[index];
    }

    /**
     * 移除指定位置元素并且返回该元素
     */
    public Object removeElement(int index){
        if(index < 0 || index > (size - 1)){
            throw new IndexOutOfBoundsException();
        }
        Object returnValue = list[index];
        Object[] tempObj = new Object[size - 1];
        int tempIndex = -1;
        for(int i = 0; i < size; i++){
            if(i != index){
                tempObj[tempIndex + 1] = list[i];
            }
        }
        list = tempObj;
        size--;
        return returnValue;
    }

    /**
     * 清空链表
     */
    public void clear(){
        for(int i = 0; i < size; i++){
            list[i] = null;
        }
        size = 0;
    }

    /**
     * 打印链表中所有元素
     */
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getSimpleName()).append("[");
        for(int i = 0; i < size; i++){
            if( i == (size - 1)){
                sb.append(list[i]);
            }else{
                sb.append(list[i]).append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
