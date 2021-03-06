/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 面试题 02.02. 返回倒数第 k 个节点
实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。

注意：本题相对原题稍作改动

示例：

输入： 1->2->3->4->5 和 k = 2
输出： 4
 */


int kthToLast(struct ListNode* head, int k){
    struct ListNode* fast=head;
    struct ListNode* slow=head;
    for(int i=1;i<=k;i++)
    fast=fast->next;
    while(fast!=NULL)
        {
            slow=slow->next;
            fast=fast->next;
        }
        return slow->val;
}