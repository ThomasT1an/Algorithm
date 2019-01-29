import java.util.Arrays;

/*
 * P78 青蛙跳台阶扩展
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法
 */
public class T10_4
{
	/*
	 * 思路一：动态规划
	 * 以f(5)即跳上第五阶的总跳法数量为例
	 * 终点为第五阶时 上一步可以为第4 3 2 1 0阶
	 * 即f(5)=f(4)+......+f(0)
	 * 对于f(4) 又有f(4)=f(3)+f(2)+f(1)+f(0)
	 */
	public int JumpFloorII(int target)
	{
		int dp[]=new int[target+1];
		Arrays.fill(dp, 1);//每一级都至少有1种跳法
		for(int i=1;i<target;i++)
		{
			for(int j=0;j<i;j++)
			{
				dp[i]=dp[i]+dp[j];
			}
		}
		return dp[target-1];
	}
	
	/*
	 * 思路二：数学推导
	 * 由上面的思路 要跳上第n级台阶
	 * 有：f(n) = f(n-1) + f(n-2) + ... + f(0)
	 * 要跳上第n-1级台阶
	 * 有：f(n-1) = f(n-2) + f(n-3) + ... + f(0)
	 * 两式相减 得：
	 * f(n)-f(n-1)=f(n-1)
	 * 即：
	 * f(n)=2*f(n-1)
	 * 即
	 * f(n)=2^(n-1)
	 */
	public int JumpFloor(int target)
	{
		return (int)Math.pow(2, target-1);
	}
}
