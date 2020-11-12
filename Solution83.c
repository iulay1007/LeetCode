/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
83. 删除排序链表中的重复元素
给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:

输入: 1->1->2
输出: 1->2
示例 2:

输入: 1->1->2->3->3
输出: 1->2->3
 */


struct ListNode* deleteDuplicates(struct ListNode* head){

if(head==NULL||head->next==NULL)
return head;


struct ListNode* node=head;
while(node!=NULL&&node->next!=NULL)
{
if(node->val==node->next->val){
   node->next=node->next->next;

}
else {
  node=node->next;
}
}
    return head;
}
