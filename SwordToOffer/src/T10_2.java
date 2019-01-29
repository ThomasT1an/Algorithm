/*
 * P77题目二：青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶 也可以跳上2级台阶 
 * 求该青蛙跳上一个n级台阶总共有多少种跳法
 */
public class T10_2
{
	/*
	 * 思路：将到达第n阶台阶共有几种跳法看成是n的函数 即f（n）
	 * 因为一次可以跳1阶或者2阶
	 * 所以第n阶的跳法可以看成是n-1阶跳法加上n-2阶跳法的和
	 * 比如到达第100层的时候，那么上一步要么是在第99层 要么是在第98层
	 * 所以到达100层的方法是他们俩的和
	 * 不难看出这实际上是一个斐波那契数列
	 * 第一项为第一阶的方法 只有1种
	 * 第二项为第二阶的方法 有两种 即两次跳1级和一次跳两级
	 */
	public int JumpFloor(int target)
	{
		if(target<=2)
		{
			return target;
		}
		int pre1=2;
		int pre2=1;
		int now=0;
		for(int i=2;i<target;i++)
		{
			now=pre1+pre2;
			pre2=pre1;
			pre1=now;
		}
		return now;
	}
}
