package com.attao.java2;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/5 20:20
 */
public class MyLinkedList {

    static class ListNode{
        public int val;
        public ListNode prev;//前驱
        public ListNode next;//后继

        public ListNode(int val) {
            this.val = val;
        }

    }
    public ListNode head;
    public ListNode last;

    //删除第一次出现值为key的节点
    public void remove(int key){
            ListNode cur = head;
            while(cur != null){
                if(cur.val == key){
                    if(cur == head){//头结点
                        head = head.next;
                        //只有一个节点
                        if(head != null){
                            head.prev = null;
                        }
                        return;
                    }else if (cur == last){//尾巴节点
//                        cur.prev.next = null;
                        last = last.prev;
                        last.next = null;
                        return;
                    }else {//中间结点
                        cur.prev.next = cur.next;
                        cur.next.prev = cur.prev;
                        return;
                    }

                }else {
                    cur = cur.next;
                }
            }

    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode cur = head;
        while(cur != null){
            if(cur.val == key){
                if(cur == head){//头结点
                    head = head.next;
                    //只有一个节点
                    if(head != null){
                        head.prev = null;
                    }
                }else if (cur == last){//尾巴节点
                    last = last.prev;
                    last.next = null;
                }else {//中间结点
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }

            }

            cur = cur.next;

        }
    }

    //任意位置插入，第一个数据节点为0号下标
    public void addIndex(int index, int data){
        if(index < 0 || index > size()){
            throw new ListIndexOutOfException();
        }
        if(index == 0){
            addFirst(data);
            return;
        }
        if(index == size()){
            addLast(data);
            return;
        }

        ListNode cur = findIndex(index);
        ListNode node = new ListNode(data);
        node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;

    }

    private ListNode findIndex(int index){
        ListNode cur = head;
        while(index != 0){
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //尾插法O(1)
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(head == null){
            head = node;
            last = node;
        }else {
           last.next = node;
           node.prev = last;
           last = node;
        }
    }

    //头插法o(1)
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(head == null){
            head = node;
            last = node;
        }else {
            node.next = head;
            head.prev = node;
            head = node;
        }

    }

    //查找是否包含关键字key是否在单链表中
    public boolean contains(int key){
        ListNode cur = head;
        while(cur != null){
            if(cur.val == key){
                return true;
            }
            cur = cur.next;
        }
        return  false;
    }

    public int size(){
        ListNode cur = head;
        int len = 0;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        return len;
    }

    public void display(){
        ListNode cur = head;
        while(cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void clear(){
        ListNode cur = head;
        while(cur != null){
            ListNode curNext = cur.next;
            cur.prev = null;
            cur.next = null;
            cur = curNext;
        }
        head = null;
        last = null;
    }
}
