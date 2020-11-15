import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*.题解
A 思考过程
由时间复杂度可以联想到归并排序.

对数组做归并排序需要的空间复杂度为O(n)-->新开辟数组O(n)+递归调用函数O(logn);
对链表做归并排序可以通过修改引用来更改节点位置，因此不需要向数组一样开辟额外的O(n)空间，但是只要是递归就需要消耗log(n)的空间复杂度，要达到O(1)空间复杂度的目标，得使用迭代法。
因此对于链表进行排序有两种方案：
（1）递归实现归并排序（空间复杂度不符合要求）
（2）迭代实现归并排序

B 关键技巧
(a) 技巧一：通过快慢指针找到链表中点
需要确定链表的中点以进行两路归并。可以通过快慢指针的方法。快指针每次走两步，慢指针每次走一步。遍历完链表时，慢指针停留的位置就在链表的中点。
以下两种找中点的方式都🉑️
注：下面图片的快慢指针初始化粗心写错了。。。。应该是：
ListNode slow = head;
ListNode fast = head.next;
*/

class Solution148 {

    public ListNode sortList(ListNode head) {
        if(head==null)
            return head;
        List<Integer> list = new ArrayList<>();
        while(head!=null) {
            list.add(head.val);
            head=head.next;
        }
        Collections.sort(list);

        ListNode nhead=new ListNode();
        ListNode result=nhead;
        for(int i=0;i<list.size();i++)
        {
            ListNode temp=new ListNode();
            temp.val=list.get(i);
            nhead.next=temp;
            nhead=nhead.next;


        }
        return result.next;

    }
}

/*可能不是很好的题解，但是把一题拆分成小题来做的思想真的挺棒的
递归的写法~
public ListNode sortList(ListNode head) {
        // 1、递归结束条件
        if (head == null || head.next == null) {
            return head;
        }

        // 2、找到链表中间节点并断开链表 & 递归下探
        ListNode midNode = middleNode(head);
        ListNode rightHead = midNode.next;
        midNode.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // 3、当前层业务操作（合并有序链表）
        return mergeTwoLists(left, right);
    }

    //  找到链表中间节点（876. 链表的中间结点）
    private ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // 合并两个有序链表（21. 合并两个有序链表）
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentry = new ListNode(-1);
        ListNode curr = sentry;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        curr.next = l1 != null ? l1 : l2;
        return sentry.next;
    }*/

/*
* 按照规模从小到大进行归并排序，一开始规模为1，每相邻的两个节点进行一次归并，
* 后面为每相邻的两个节点进行一次归并……。cutcut函数就是为了找到长度大小为ii的链表头。逐步归并并扩大规模，直到i > lengthi>length。

迭代法~

class Solution {
    public ListNode cut(ListNode head, int n) {
        while(head != null && n > 1) {
            head = head.next;
            n--;
        }
        if (head == null) return null;
        ListNode ret = head.next;
        head.next = null;
        return ret;
    }
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(), p = dummy;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 != null ? l1 : l2;
        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        int len = 0;
        ListNode p = head;
        while(p != null)  {
            len++;
            p = p.next;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        for (int i = 1; i < len; i *= 2) {
            ListNode cur = dummy.next;
            ListNode tail = dummy;
            while(cur != null) {
                ListNode left = cur;
                ListNode right = cut(left, i);
                cur = cut(right, i);//返回拆分后的最尾部
                tail.next = merge(left, right);
                while(tail.next != null) tail = tail.next;
            }
        }
        return dummy.next;
    }
}

*/