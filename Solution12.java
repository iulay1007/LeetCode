/*
 * 121. 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。

注意：你不能在买入股票前卖出股票。

 * */
public class Solution12 {
	 public int maxProfit(int[] prices) {
		 if(prices.length==0)return 0;
	        int maxProfit = 0; 
	        int min = prices[0];
	        for (int i = 1; i < prices.length; i++) {
	            if (prices[i] - min > maxProfit)
	            	maxProfit = prices[i] - min;
	            else if (prices[i] < min)
	                min = prices[i];
	        }
	        return maxProfit;
	    }
	 
	 public static void main(String[] args) {
			
			Solution12 solution=new Solution12();
			int num[]= {1,1,3,3,5};
			int result=solution.maxProfit(num);
			System.out.print(result);
			
			
		}
	 
	 
	 
	 
	}

	