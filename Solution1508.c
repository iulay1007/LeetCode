#include<stdio.h>
#include<stdlib.h>

/*1508. 子数组和排序后的区间和
给你一个数组 nums ，它包含 n 个正整数。你需要计算所有非空连续子数组的和，并将它们按升序排序，得到一个新的包含 n * (n + 1) / 2 个数字的数组。

请你返回在新数组中下标为 left 到 right （下标从 1 开始）的所有数字和（包括左右端点）。由于答案可能很大，请你将它对 10^9 + 7 取模后返回。

 

示例 1：

输入：nums = [1,2,3,4], n = 4, left = 1, right = 5
输出：13 
解释：所有的子数组和为 1, 3, 6, 10, 2, 5, 9, 3, 7, 4 。将它们升序排序后，我们得到新的数组 [1, 2, 3, 3, 4, 5, 6, 7, 9, 10] 。下标从 le = 1 到 ri = 5 的和为 1 + 2 + 3 + 3 + 4 = 13 。
示例 2：

输入：nums = [1,2,3,4], n = 4, left = 3, right = 4
输出：6
解释：给定数组与示例 1 一样，所以新数组为 [1, 2, 3, 3, 4, 5, 6, 7, 9, 10] 。下标从 le = 3 到 ri = 4 的和为 3 + 3 = 6 。
示例 3：

输入：nums = [1,2,3,4], n = 4, left = 1, right = 10
输出：50
 */
 
 //时间就是不过！！！！ 
int partion(int* nums, int left, int right) {
int pivtion = nums[left];
while(left < right) {
while(left < right && pivtion <= nums[right]) {
right--;
}
nums[left] = nums[right];
while(left < right && pivtion >= nums[left]) {
left++;
}
nums[right] = nums[left];
}
nums[left] = pivtion;
return left;
}

  void quickSort(int* nums, int left, int right) {
if (left < right) {
int index = partion(nums, left, right);
quickSort(nums, left, index - 1);
quickSort(nums, index + 1, right);
}}
int rangeSum(int* nums, int n, int left, int right){

    int * nsum=(int*)malloc(sizeof(int)*(n*(n+1)/2)+4);
    if(nsum==NULL)
    return 0;
    int temp=0;
    int k=0;
    int result=0;
    int i=0;
    int h=left-1;
    int j=0;
    
    for(;i<n-1;i++)
    {
     //   temp=nums[i];
        for( j=i;j<n;j++)
        {
            temp+=nums[j];
            nsum[k]=temp;
            k++;
        }    
        temp=0; 
    }
  
    nsum[k]=nums[n-1];
  //  nsum[k]=1;

	quickSort(nsum, 0, k );
  /*  for(int q=0;q<=k-1;q++)
    for(int w=0;w<=k-q-1;w++){
        if(nsum[w]>nsum[w+1])
        {
           int t=nsum[w];
            nsum[w]=nsum[w+1];
            nsum[w+1]=t;

        }
    }*/ 
    
  

    
	for(int i=0;i<=k;i++)
	printf("%d ",nsum[i]); 
    for(;h<right;h++)
    {
         result=(result+nsum[h])%1000000007;
    }
    
    //  printf("%d",result);
    return result;
  
}
int main(){
	int num[]={1,2,3,4};
	 rangeSum(num, 4,1,5);
}
//java的sort真滴好用qwq 
/*class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
         int nsum[]=new int[n*(n+1)/2];
    
    int temp=0;
    int k=0;
    int result=0;
   

   
    for( int i=0;i<n;i++)
    {
        for(int j=i;j<n;j++)
        {
            temp+=nums[j];
            nsum[k]=temp;
            k++;
        }    
        temp=0;
    }
  
   
	Arrays.sort(nsum);
    for( int h=left-1;h<right;h++)
    {
        result=(result+nsum[h])%1000000007;
    }
    return result;
    }
}*/