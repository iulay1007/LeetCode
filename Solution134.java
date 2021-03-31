import java.util.ArrayList;
import java.util.List;

/*134. 加油站
在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。

你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。

如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。

说明:

如果题目有解，该答案即为唯一答案。
输入数组均为非空数组，且长度相同。
输入数组中的元素均为非负数。
示例 1:

输入:
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]

输出: 3

解释:
从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
因此，3 可为起始索引。
示例 2:

输入:
gas  = [2,3,4]
cost = [3,4,3]

输出: -1

解释:
你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
因此，无论怎样，你都不可能绕环路行驶一周。*/
public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if( gas.length==1)
        {
            if(gas[0]>=cost[0])
                return 0;
            else return -1;
        }
        int gassum=0;
        int costsum=0;
        List<Integer> startPosition=new ArrayList<>();
        for(int i=0;i< gas.length;i++) {
            gassum+=gas[i];
            costsum+=cost[i];

            if(gas[i]>=cost[i])
            {
                startPosition.add(i);
                System.out.println("add1"+i);
            }

        }
        if(gassum<costsum)
            return -1;
        if(startPosition.size()==0)
            return -1;
        System.out.println("size"+startPosition.size());

        for(int i=0;i<startPosition.size();i++){
            int tempgas=0;
            int tempcost=0;
            int count=0;
            for(int j=startPosition.get(i);count<=gas.length;j++,count++)
            {

                tempgas+=gas[j%gas.length];
                tempcost+=cost[j%gas.length];
                if(tempgas<tempcost)
                    break;

            }

            if(tempgas>tempcost)
                return startPosition.get(i);

        }
        return -1;
    }
}

/*别人的解题思路
这道题跟之前我们做最大和的那题非常像！！！
首先我们两个数组其实可以看成一个数组，比如我们有：
gas: 1 2 3 4 5 cost： 3 4 5 1 2
我们其实可以抽象化的看为： gas - cost： -2, -2, -2, 3, 3;
所以问题也就简化成了为从哪个index开始我们可以找到新数组的最大的和！
我们开始解题：

两个变量，一个记录总油量，一个记录总花费，当遍历到尾部时如果
总花费大于总油量那么就为-1，反之则是我们找到的index。
然后还需两个变量，一个记录当前的新数组的最大sum，一个为这个sum起始的
记录位置，也就是要找的index。当sum小于0时我们要重新记录，因为那已经说明
我们从刚才的位置已经达不到终点了

作者：Xiaohu9527
链接：https://leetcode-cn.com/problems/gas-station/solution/ctan-xin-suan-fa-on-by-xiaohu9527-7pap/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalCost = 0, totalGas = 0, sum = 0, index=0;
        for(int i = 0; i < cost.length; ++i)
        {
            totalCost += cost[i];
            totalGas += gas[i];
            if(sum > 0) sum += gas[i] - cost[i]; 
            else 
            {
                sum = gas[i] - cost[i];
                index = i;
            }
        }
        return totalCost>totalGas? -1 : index;
    }}*/