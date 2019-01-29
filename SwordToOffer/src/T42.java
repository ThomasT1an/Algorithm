/*
 * P218面试题42：连续子数组的最大和
 * 题目：输入一个整形数组，数字里有正数也有负数 数组中的一个或连续多个整数组成一个子数组
 * 求所有子数组的和的最大值 要求时间复杂度为O(n)
 * 例如：{6, -3, -2, 7, -15, 1, 2, 2}，连续子数组的最大和为 8（从第 0 个开始，到第 3 个为止）
 */
public class T42
{
	/*
	 * 动态规划
	 * 转移方程为dp[i]=Max(dp[i-1]+array[i],array[i]
	 * 意思是 若array[i]的值大于dp[i-1]+array[i] 就舍弃前面的所有数字
	 * 由于只需要用到dp[i]和dp[i-1] 所以不需要用数组来储存 用一个临时变量即可
	 */
	public int FindGreatestSumOfSubArray(int[] array)
	{
		if(array.length==0)
			return 0;
		int dp=array[0];
		int res=array[0];
		for(int i=1;i<array.length;i++)
		{
			dp=Math.max(dp+array[i], array[i]);
			res=Math.max(res, dp);
		}
		return res;
	}
}
