package com.shoufeng.linklist.question2;

import java.util.HashSet;
import java.util.Set;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * @author shoufeng
 */
public class Solution {

    //方法一：利用set的唯一性
    public ListNode EntryNodeOfLoop1(ListNode pHead) {
        Set<ListNode> set = new HashSet<ListNode>();
        while (pHead.next != null) {
            if (!set.add(pHead)) {
                return pHead;
            }
            pHead = pHead.next;
        }
        return null;
    }

    //方法二：利用快慢指针 起点到入口点为a，入口点到相遇点为b，相遇点再到入口点为c
    //第一次循环得到相遇点 相遇时 单步：a + b  双步：a + b + c + b
    // a + b = (a + b + c + b )/2  => b = c
    //第二次循环得到入口点 相遇点到入口点的距离 = 起始点到入口点的距离 将
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode singleStep = pHead;
        ListNode doubleStep = pHead;
        ListNode secondSingleStep = pHead;
        //得到第一次相遇点
        while (true) {
            if (doubleStep.next == null) {
                return null;
            }
            doubleStep = doubleStep.next.next;
            if (doubleStep == null) return null;
            singleStep = singleStep.next;
            if (doubleStep == singleStep) {
                break;
            }
        }
        //得到第二次相遇点，也就是链表环的入口
        while (true) {
            if (singleStep == secondSingleStep) {
                return secondSingleStep;
            }
            singleStep = singleStep.next;
            secondSingleStep = secondSingleStep.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
