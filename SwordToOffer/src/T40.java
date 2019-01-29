import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * P209面试题40：最小的k个数
 * 题目：输入n个整数 找出其中最小的k个数
 */
public class T40
{
	//方法一：排序数组后直接得到 复杂度为O(nlogn)
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k)
	{
		ArrayList<Integer> ret = new ArrayList<>();
		if (k > input.length)
			return ret;
		Arrays.parallelSort(input);
		for (int i = 0; i < k; i++)
			ret.add(input[i]);
		return ret;
	}
	public static void main(String[] args)
	{
		int input[]={4,5,1,6,2,7,3,8};
		ArrayList<Integer> ret=GetLeastNumbers_Solution2(input,4);
	}
	/*
	 * 方法二：使用Partition函数实现 
	 * Partition函数是实现快速排序的核心函数
	 * 其功能是返回一个整数 j 使得 a[0..j-1] 小于等于 a[j] 且 a[j+1..最后一个元素] 大于等于 a[j]
	 * 此时 a[j] 就是数组的第 j 大元素 可以利用这个特性找出数组的第 K 个元素
	 * 而由于基准数的选取是随机的（本题使用第一个元素作为基准数）
	 * 并不能保证直接得到第k大的数字 比如若返回的下标j是10 那么只能得到前9个小于data[10]的数  而这些元素的排列是无序的
	 * 所以需要一个额外的函数来保证Partition函数返回的j刚好为k
	 */
	
	public static ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k)
	{
		ArrayList<Integer> ret = new ArrayList<>();
		if (k > input.length)
			return ret;
		findKthNum(input,k-1);
		for(int i=0;i<k;i++)
			ret.add(input[i]);
		return ret;
	}
	private static void findKthNum(int nums[],int k)
	{
		int start=0;
		int end=nums.length-1;
		while(start<end)
		{
			int j=Partition(nums,start,end);
			if(j==k)
				break;
			if(j>k)//若j大于k 则在这前j个元素中查找即可
				end=j-1;
			if(j<k)//若j小于k 则在j之后的元素中查找
				start=j+1;
		}
	}
	private static int Partition(int data[],int start,int end)
	{
		int base=data[start];//选取第一个数为基准数
		int i=start+1,j=end;//定义两个"哨兵"  (《啊哈，算法》图解快速排序)
		while(true)
		{
			while(j!=start&&data[j]>base)
				j--;
			while(i!=end&&data[i]<base)
				i++;
			//i向右找到第一个大于基准数的数 j向左找到第一个小于基准数的数
			if(j>i)
				swap(data,i,j);//若i、j尚未重合 则交换两元素
			else
				break;
		}
		swap(data,start, j);//重合之后交换基准数与j的位置
		return j;
	}
	private static void swap(int[] nums, int i, int j) 
	{
	    int t = nums[i];
	    nums[i] = nums[j];
	    nums[j] = t;
	}
	/*
	 * 方法三：大小为 K 的最小堆
	 * 复杂度：O(NlogK) + O(K) 适合处理海量数据
	 * 应该使用大顶堆来维护最小堆，而不能直接创建一个小顶堆并设置一个大小，企图让小顶堆中的元素都是最小元素。
	 * 维护一个大小为 K 的最小堆过程如下：在添加一个元素之后，如果大顶堆的大小大于 K，那么需要将大顶堆的堆顶元素去除。
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution3(int[] nums, int k) 
	{
	    if (k > nums.length || k <= 0)
	        return new ArrayList<>();
	    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
	    for (int num : nums) {
	        maxHeap.add(num);
	        if (maxHeap.size() > k)
	            maxHeap.poll();
	    }
	    return new ArrayList<>(maxHeap);
	}
}
