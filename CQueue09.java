package 剑指offer;

import java.util.Stack;
/*剑指 Offer 09. 用两个栈实现队列
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

 

示例 1：

输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
示例 2：

输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]*/
public class CQueue09 {

    Stack stack1 = new Stack();
    Stack stack2 = new Stack();

    public void appendTail(int value) {

        if(!stack2.isEmpty()) {
            while (!stack2.isEmpty())
            {
                stack1.add(stack2.pop());
            }
        }
        stack1.add(value);
    }

    public int deleteHead() {
        if(stack1.isEmpty()&&stack2.isEmpty())
            return -1;
        if(!stack1.isEmpty()){
        while (!stack1.isEmpty()){
            stack2.add(stack1.pop());
        }
        }
        return (int)stack2.pop();
    }
}

/*
*  Stack stack1 = new Stack();
    Stack stack2 = new Stack();

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if(stack1.isEmpty())
            return -1;
        while (!stack1.isEmpty()){
            stack2.add(stack1.pop());
        }
        int result = (int)stack2.pop();
        while (!stack2.isEmpty())
        {
           stack1.add(stack2.pop());
        }
        return result;
    }*/