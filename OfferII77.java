package 剑指offer;

import java.util.*;

/**剑指 Offer II 077. 链表排序
 给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。



 示例 1：



 输入：head = [4,2,1,3]
 输出：[1,2,3,4]
 示例 2：



 输入：head = [-1,5,3,4,0]
 输出：[-1,0,3,4,5]
 示例 3：

 输入：head = []
 输出：[]
 */
public class OfferII77 {
      class ListNode {
      int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  public ListNode sortList(ListNode head) {
      PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
          @Override
          public int compare(ListNode o1, ListNode o2) {
              return o1.val - o2.val;
          }
      });
      ListNode node = head;
      while (node!=null){
          ListNode temp = node.next;
          priorityQueue.add(node);
          node.next = null;
          node = temp;
      }
      if(priorityQueue.size() == 0) return null;
      head = priorityQueue.poll();
      node = head;
      while (priorityQueue.size()>0){
          node.next = priorityQueue.poll();
          node = node.next;
      }
      return head;
  }

        //超时
//    public ListNode sortList(ListNode head) {
//          Map<Integer,ListNode> map = new HashMap<>();
//          ListNode node = head;
//          while (node!=null){
//              ListNode temp = node.next;
//              if (!map.containsKey(node.val))
//              {
//                  node.next = null;
//                  map.put(node.val,node);
//              }else {
//                  ListNode t = map.get(node.val);
//                  while (t.next!=null){
//                      t = t.next;
//                  }
//                  node.next =null;
//                  t.next = node;
//              }
//              node = temp;
//          }
//          Integer [] nums = new Integer[map.size()];
//          map.keySet().toArray(nums);
//        Arrays.sort(nums);
//          ListNode pre = new ListNode();
//          for (int i =0;i<nums.length;i++){
//              if(i == 0){
//                  pre = map.get(nums[i]);
//              }else {
//                  pre.next = map.get(nums[i]);
//                  pre = map.get(nums[i]);
//              }
//              while (pre.next!=null){
//                  pre= pre.next;
//              }
//          }
//          if(nums.length>0)
//          return map.get(nums[0]);
//          else return null;
//}
}