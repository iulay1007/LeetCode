package 剑指offer;


public class Solution19 {
     class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode removeNthFromEnd(ListNode head, int n) {
         if(head == null||head.next==null)
             return null;
         ListNode fast = head;
         ListNode slow = head;
         for (int i = 1;i<=n;i++){
             if(fast == null)return null;
             fast = fast.next;
         }
        if(fast == null){
            ListNode temp = head.next;
            head.next = null;
            return temp;
        }
         while (fast!=null&&fast.next!=null){
             fast = fast.next;
             slow = slow.next;
         }

         if(slow.next!=null)
         {
             slow .next = slow.next.next;
             return head;
         }
         return null;
}
}