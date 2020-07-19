package com.arithmetic;

/**
 * 实现一个顺序表(固定长度)
 * 顺序表可以添加、移除、获取元素以及顺序表节点数量
 * 优点:顺序存放,操作简单
 * 缺点:插入和删除结点时,往往需要大量的移动数据;表数据过大,比较难分配足够的连续空间,
 * 往往会导致内存分配失败,而无法存储
 */
public class OrdinalList {
    /**
     * 顺序表最多节点数
     */
    private static final int MAX_LENGTH = 100;
    /**
     * 初始化顺序表(下标从0开始)
     */
    private Object[] list = new Object[MAX_LENGTH];
    /**
     * 顺序表节点数量
     */
    private int size;

    /**
     * 获取顺序表节点个数
     */
    public int size(){
        return size;
    }

    /**
     * 是否为空顺序表
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
     * 获取指定位置顺序表中元素
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
     * 清空顺序表
     */
    public void clear(){
        for(int i = 0; i < size; i++){
            list[i] = null;
        }
        size = 0;
    }

    /**
     * 打印顺序表中所有元素
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
