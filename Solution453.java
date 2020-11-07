/*453. 最小移动次数使数组元素相等
给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动将会使 n - 1 个元素增加 1。


示例:

输入:
[1,2,3]

输出:
3

解释:
只需要3次移动（注意每次移动会增加两个元素的值）：

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

*//
//暴力+超时
class Solution453 {

    public int minMoves(int[] nums) {
        int length= nums.length;
        if(length==1)
            return 0;
        if(length==2)
            return Math.abs(nums[0]-nums[1]);
        int temp;
        int count = 1;
        int result=0;
        int max=nums[0];
        int min=nums[1];
        for(int i=1;i<length;i++){
            if(nums[i]>max)
                max=nums[i];
            else if(nums[i]<min)
                min=nums[i];
        }
        int abs=max-min;
        if(abs!=0)
            for(int i=0;i<length;i++){

                nums[i]+=abs;
            }
        while (count!=length){

            count=1;
            for(int i=0;i<length-1;i++){

                if(nums[i]>nums[i+1])
                {
                    temp=nums[i+1]+1;
                    nums[i+1]=nums[i];
                    nums[i]=temp;
                }
                else if(nums[i]<nums[i+1])
                    nums[i]++;
                else if(nums[i]==nums[i+1])
                {
                    nums[i]++;
                    count++;
                }
            }
            result++;}
        return result-1;
    }
}

//超出时间限制++
class Solution {
    public int minMoves(int[] nums) {
    int length= nums.length;
        if(length==1)
            return 0;
        if(length==2)
            return Math.abs(nums[0]-nums[1]);
        int temp;
        int result=0;
        for (int i=1;i<length;i++)
            for(int j=0;j<length-i;j++)
                if(nums[j]> nums[j+1])
                {
                    temp=nums[j+1];
                    nums[j+1]=nums[j];
                    nums[j]=temp;
                }
        int p=length-1;
        while (p!=0){
            temp=nums[p]-nums[0];
            result+=temp;
            p--;
        }
        return  result;
    }
}

//终于做出来了555555555555
// 执行用时：
//1 ms
//, 在所有 Java 提交中击败了
//100.00%
//的用户
//内存消耗：
//38.6 MB
//, 在所有 Java 提交中击败了
//95.54%
//的用户
class Solution {
    public int minMoves(int[] nums) {

            int length= nums.length;
            if(length==1)
                return 0;
            if(length==2)
                return Math.abs(nums[0]-nums[1]);
            int min=nums[0];
            int result=0;
            int position=0;
            for (int i=1;i<length;i++)
                if(nums[i]<min)
                {
                    min=nums[i];
                    position=i;

                }

            int temp=0;
            for(int i=0;i<length;i++){
                if(i!=position)
                {    temp=nums[i]-min;
                    result+=temp;
                }
            }

            return  result;

        }}