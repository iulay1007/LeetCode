package 剑指offer;

/**
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 */
public class Solution92 {

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode reverseBetween(ListNode head, int left, int right) {
                if(left == right) return head;
                ListNode fast ,slow;
                ListNode pre = new ListNode(0);
                pre.next = head;
                fast = pre;
                slow=pre;
                int count = 0;
                while (fast!=null&&count!=right){
                    fast=fast.next;
                    count++;
                }
                count=0;
                while (slow!=null&&count+1!=left){
                    slow=slow.next;
                    count++;
                }
                ListNode cur = slow.next;
                ListNode next = cur.next;
                cur.next = fast.next;
                while (cur!=null&&next!=fast.next&&cur!=fast){
                    ListNode temp =next;
                    next = temp.next;
                    temp.next = cur;
                    cur =temp;
                }
                slow.next = cur;
                if(left==1)
                    return cur;
                return head;
            }

        }
    }