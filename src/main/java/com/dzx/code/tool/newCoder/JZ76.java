package com.dzx.code.tool.newCoder;

import java.util.List;

public class JZ76 {
    public static void main(String[] args) {

    }
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode dummy = new ListNode(-1);
        boolean flag = false;
        dummy.next = pHead;
        ListNode pre = pHead;
        ListNode cur = pHead.next;
        ListNode record = dummy;
        while(cur != null){
            if(pre.val == cur.val){
                flag = true;
                record.next = cur;
                pre = cur;
                cur = cur.next;
            }else{
                if(flag){
                    record.next = cur;
                    pre = cur;
                    cur = cur.next;
                    flag = false;
                }else{
                    record = pre;
                    pre = cur;
                    cur = cur.next;
                }
            }
        }
        return dummy.next;


    }
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

