package com.dzx.code.tool.leetcode;

import java.util.HashMap;

public class LRU {
    int capacity;
    int count;
    HashMap<Integer,Node> map;
    Node head;
    Node tail;
    public LRU(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        tail.prev.next = node;
        tail.prev = node;
        node.prev = tail.prev;
        node.next = tail;
        return node.value;
    }

    public void put(int key, int value){
        if(map.containsKey(key)){
            get(key);
            Node node = map.get(key);
            node.value = value;
        }else{

        if(count == capacity) {
            Node temp = head.next;
            head.next = temp.next;
            temp.next.prev = head;
            map.remove(temp.key);
            count--;
        }
        Node node = new Node();
        node.key = key;
        node.value = value;
        node.prev = tail.prev;
        tail.prev.next = node;
        node.next = tail;
        tail.prev = node;
        map.put(key,node);
        count++;

        }
    }

    public static void main(String[] args) {
        LRU lru = new LRU(3);
        lru.put(1,1);
        lru.put(2,2);
        lru.put(3,3);
        lru.put(1,4);
        lru.put(4,4);

    }
}

class Node{
    Node prev;
    Node next;
    int key;
    int value;
}
