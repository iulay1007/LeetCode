package 剑指offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 示例 3：
 * <p>
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 */
public class Solution239 {
    //超时了！！！
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int[] res = new int[nums.length - k + 1];
        int fast = k;
        for (int i = 0; i <= nums.length; i++) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(nums[i]);
            } else {
                res[i - k] = priorityQueue.peek();
                if (i - k >= 0)
                    priorityQueue.remove((Integer) nums[i - k]);
                if (fast < nums.length)
                    priorityQueue.offer(nums[fast]);
                fast++;
            }

        }
        return res;


    }

    /**
     * 对于「最大值」，我们可以想到一种非常合适的数据结构，那就是优先队列（堆），其中的大根堆可以帮助我们实时维护一系列元素中的最大值。
     * <p>
     * 对于本题而言，初始时，我们将数组 \textit{nums}nums 的前 kk 个元素放入优先队列中。每当我们向右移动窗口时，我们就可以把一个新的元素放入优先队列中，此时堆顶的元素就是堆中所有元素的最大值。然而这个最大值可能并不在滑动窗口中，在这种情况下，这个值在数组 \textit{nums}nums 中的位置出现在滑动窗口左边界的左侧。因此，当我们后续继续向右移动窗口时，这个值就永远不可能出现在滑动窗口中了，我们可以将其永久地从优先队列中移除。
     * <p>
     * 我们不断地移除堆顶的元素，直到其确实出现在滑动窗口中。此时，堆顶元素就是滑动窗口中的最大值。为了方便判断堆顶元素与滑动窗口的位置关系，我们可以在优先队列中存储二元组 (\textit{num}, \textit{index})(num,index)，表示元素 \textit{num}num 在数组中的下标为 \textit{index}index。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetco-ki6m/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
                public int compare(int[] o1, int[] o2) {
                    return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
                }
            });
            for (int i = 0; i < k; ++i)
                priorityQueue.add(new int[]{nums[i], i});
            int[] res = new int[n - k + 1];
            res[0] = priorityQueue.peek()[0];
            for (int i = k; i < n; i++) {
                priorityQueue.add(new int[]{nums[i], i});
                while (priorityQueue.peek()[1] <= i - k) {
                    priorityQueue.poll();
                }
                res[i-k+1] = priorityQueue.peek()[0];
            }
            return res;
        }
    }

    /**思路
     遍历数组，将 数 存放在双向队列中，并用 L,R 来标记窗口的左边界和右边界。队列中保存的并不是真的 数，而是该数值对应的数组下标位置，并且数组中的数要从大到小排序。如果当前遍历的数比队尾的值大，则需要弹出队尾值，直到队列重新满足从大到小的要求。刚开始遍历时，L 和 R 都为 0，有一个形成窗口的过程，此过程没有最大值，L 不动，R 向右移。当窗口大小形成时，L 和 R 一起向右移，每次移动时，判断队首的值的数组下标是否在 [L,R] 中，如果不在则需要弹出队首的值，当前窗口的最大值即为队首的数。

     示例

     输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     输出: [3,3,5,5,6,7]

     解释过程中队列中都是具体的值，方便理解，具体见代码。
     初始状态：L=R=0,队列:{}
     i=0,nums[0]=1。队列为空,直接加入。队列：{1}
     i=1,nums[1]=3。队尾值为1，3>1，弹出队尾值，加入3。队列：{3}
     i=2,nums[2]=-1。队尾值为3，-1<3，直接加入。队列：{3,-1}。此时窗口已经形成，L=0,R=2，result=[3]
     i=3,nums[3]=-3。队尾值为-1，-3<-1，直接加入。队列：{3,-1,-3}。队首3对应的下标为1，L=1,R=3，有效。result=[3,3]
     i=4,nums[4]=5。队尾值为-3，5>-3，依次弹出后加入。队列：{5}。此时L=2,R=4，有效。result=[3,3,5]
     i=5,nums[5]=3。队尾值为5，3<5，直接加入。队列：{5,3}。此时L=3,R=5，有效。result=[3,3,5,5]
     i=6,nums[6]=6。队尾值为3，6>3，依次弹出后加入。队列：{6}。此时L=4,R=6，有效。result=[3,3,5,5,6]
     i=7,nums[7]=7。队尾值为6，7>6，弹出队尾值后加入。队列：{7}。此时L=5,R=7，有效。result=[3,3,5,5,6,7]
     通过示例发现 R=i，L=k-R。由于队列中的值是从大到小排序的，所以每次窗口变动时，只需要判断队首的值是否还在窗口中就行了。
     解释一下为什么队列中要存放数组下标的值而不是直接存储数值，因为要判断队首的值是否在窗口范围内，由数组下标取值很方便，而由值取数组下标不是很方便。
     代码
     Java

     class Solution {
     public int[] maxSlidingWindow(int[] nums, int k) {
     if(nums == null || nums.length < 2) return nums;
     // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
     LinkedList<Integer> queue = new LinkedList();
     // 结果数组
     int[] result = new int[nums.length-k+1];
     // 遍历nums数组
     for(int i = 0;i < nums.length;i++){
     // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
     while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
     queue.pollLast();
     }
     // 添加当前值对应的数组下标
     queue.addLast(i);
     // 判断当前队列中队首的值是否有效
     if(queue.peek() <= i-k){
     queue.poll();
     }
     // 当窗口长度为k时 保存当前窗口中最大值
     if(i+1 >= k){
     result[i+1-k] = nums[queue.peek()];
     }
     }
     return result;
     }
     }

*/


}