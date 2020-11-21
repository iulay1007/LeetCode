import java.util.Stack;
/*682. 棒球比赛
你现在是一场采特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。

比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：

整数 x - 表示本回合新获得分数 x
"+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
"D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
"C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
请你返回记录中所有得分的总和。



示例 1：

输入：ops = ["5","2","C","D","+"]
输出：30
解释：
"5" - 记录加 5 ，记录现在是 [5]
"2" - 记录加 2 ，记录现在是 [5, 2]
"C" - 使前一次得分的记录无效并将其移除，记录现在是 [5].
"D" - 记录加 2 * 5 = 10 ，记录现在是 [5, 10].
"+" - 记录加 5 + 10 = 15 ，记录现在是 [5, 10, 15].
所有得分的总和 5 + 10 + 15 = 30
*/
public class Solution682 {
    public int calPoints(String[] ops) {
        Stack <Integer>stack=new Stack();
        int result=0;
        int firstNum=0;
        int secondNum=0;
        for(int i=0;i<ops.length;i++)
        {

            if (ops[i].equals("+")){
                firstNum=stack.pop();
                secondNum=stack.peek();
                stack.push(firstNum);
                stack.push(firstNum+secondNum);

            }
            else if (ops[i].equals("C"))
                stack.pop();
            else if (ops[i].equals("D")) {
                int temp = stack.peek();
                stack.push(temp*2);

            }

            else {
                stack.push(Integer.valueOf(ops[i]));
            }

        }

        while (!stack.isEmpty())
            result+=stack.pop();

        return result;
    }
}

/*C语言版
//别人写的
int calPoints(char ** ops, int opsSize){
    if(0 >= opsSize)
        return 0;

    int stack[opsSize]; // 栈
    int top = -1; // 栈顶指针
    int sum = 0; // 累计得分
    for(int i = 0; i < opsSize; i++) {
        switch(ops[i][0]) {
            case '+' :
                // +获取前两轮和
                // 注意代码执行顺序 虽然 ++top 的意思是 top 加1后在使用，但是存在赋值运算符时。赋值运算符右边的会先执行 切记不是 是赋值运算符右边先执行不是左边
                stack[++top] = stack[top] + stack[top - 1];
                sum += stack[top];
            break;
            case 'D' :
                // D获取上一轮的2倍
                stack[++top] = stack[top] * 2;
                sum += stack[top];
            break;
            case 'C' :
                //直接出栈并减去无效分
                sum -= stack[top--];
            break;
            default :
                //正常得分入栈累加
                stack[++top] = atoi(ops[i]);//atoi (表示 ascii to integer)是把字符串转换成整型数的一个函数
                sum += stack[top];
        }
    }

    return sum;
}

*/