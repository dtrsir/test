import com.sun.org.apache.xpath.internal.operations.String;

import java.util.Objects;

public class List<E> {
    private int size = 20;  //数组长度，也就是线性表的容量
    private E[] data = null;    //泛型数组，用来初始化我们需要类型的数组
    private int length = 0; //线性表元素个数

    //构造器，初始化线性表
    public List() {
        Object[] tmp = new String[size];
        data = (E[]) tmp;
    }

    public List(int size) {
        data = (E[]) new Objects[size];
        this.size = size;
    }

    //判空
    public boolean isEmpty() {
        if (length == 0) {
            return true;
        } else {
            return false;
        }
    }

    //清空线性表
    public void clearList() {
        data = (E[]) new Objects[size];
        length = 0;
    }

    //取出线性表中第i个位置的元素
    public E getElement(int index) {
        return data[index];
    }

    //判断是否包含元素e
    public boolean contains(E element) {
        boolean flag = false;
        for (E x : data) {
            if (element.equals(x)) {
                flag = true;
            }
        }
        return flag;
    }

    //返回指定元素的下标，如果没找到直接返回-1
    public int getElementIndex(E element) {
        int index = -1;
        if (this.contains(element)) {
            for (int i = 0; i < length; i++) {
                if (data[i].equals(element)) {
                    index = i;
                }
            }
        } else {
            return index;
        }
        return index;
    }

    //插入元素
    public void insert(E element) {
        data[length] = element;
    }

    //删除元素
    public E delete() {
        E tmp = data[--length];
        data[length] = null;
        return tmp;
    }

    //获得线性表长度（当前线性表的元素个数）
    public int getLength() {
        return length;
    }

}