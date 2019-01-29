/*
 * P96面试题14：剪绳子
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积
 */
public class T14
{
	/*
	 * 解法一：动态规划
	 * 令dp[n]为n对应的最大乘积
	 * 维护这个最优解数组
	 * 注释中的写法是另一种理解方式
	 * 当拆分出的一部分的长度为4时 这一段是否需要再进行拆分？
	 * 4=2*2 而小于4时 例如3 若拆分3 则得到1*2=2 结果将小于不拆分的结果
	 * 而当大于4时 例如5 拆分为2*3=6 >5 所以4为分界点
	 * 大于4的部分需要再进行拆分 小于4的部分则不需要拆分
	 * 此方法的时间复杂度为O(n^2)
	 */
	public static int integerBreak(int n)
	{
		int dp[]=new int[n+1];
		dp[1]=1;
		for(int i=2;i<=n;i++)
		{
			for(int j=1;j<i;j++)
			{
				dp[i]=Math.max(dp[i], (i-j)*Math.max(dp[j], j));
			}
		}
		return dp[n];
		
//		int dp[]=new int[n+1];
//		dp[1]=1;
//		for(int i=2;i<=n;i++)
//		{
//			for(int j=1;j<i;j++)
//			{
//				if(j<=4)
//				{
//					dp[i]=Math.max(dp[i], (i-j)*j);
//				}
//				else
//				{
//					dp[i]=Math.max(dp[i],(i-j)*dp[j]);
//				}
//			}
//		}
//		return dp[n];
	}
	
	/*
	 * 解法二：贪心
	 * 首先由均值不等式中的算数平均数>=几何平均数可知
	 * 将输入的n拆分成多个相等的数时积最大
	 * 先假设最优拆法所拆出的每一个数都为x
	 * 那么一共会拆出n/x个数
	 * 设他们的积为f(x) 则f(x)=x^(n/x)
	 * 为了求f(x)的最大值 可以对其求导
	 * 过程省略
	 * 最终有 x=e时f(x)有极大值
	 * e=2.7 故优先拆成3 拆不成3则拆2
	 * 实际上当剩余长度小于等于4时
	 * 剩余部分不拆分即可（方法一中说明）
	 * 此方法的时间复杂度为O(lgn)
	 */
	public static int integerBreak2(int n)
	{
		if (n < 2)
	        return 0;
	    if (n == 2)
	        return 1;
	    if (n == 3)
	        return 2;
	    int timesOf3=0;
	    while(n>3)
	    {
	    	if(n<=4)
	    		break;
	    	timesOf3++;
	    	n-=3;
	    }
	    return (int)(Math.pow(3, timesOf3))*(n);
	}
	
	/*
	 * 记录一下另一种看到的思路
	 *
	 * class Solution {
public:
    int integerBreak(int n) {
      if(n==2){return 1;}
      if(n==3){return 2;}
      n-=2;
      return pow(3,n/3)*(n%3+2);
    }
};

	 */
}
