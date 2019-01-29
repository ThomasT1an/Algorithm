/*
 * P74题目一：斐波那契数列
 * 写一个函数 输入n 求斐波那契数列的第n项
 */
public class T10_1
{
	/*
	 * 方法一 递归 会重复计算一些子问题
	 * 例如f(10)需要计算f(9)和f(8) 计算f(9)需要计算f(8)和f(7)
	 * f(8)被重复计算
	 */
	public int Fibonacci1(int n)
	{
		if(n<=1)
		{
			return n;
		}
		return Fibonacci1(n-1)+Fibonacci1(n-2);
	}
	/*
	 * 方法二 动态规划的做法
	 * 把子问题的解缓存起来 这样避免了重复求解子问题
	 */
	public int Fibonacci2(int n) 
	{
		if(n<=1)
		{
			return n;
		}
		int res[]=new int[n+1];
		//res[0]=0; 默认初始化为0
		res[1]=1;
		for(int i=2;i<=n;i++)
		{
			res[i]=res[i-1]+res[i-2];
		}
		return res[n];
    }
	/*
	 * 方法三 在上一方法的基础上改进
	 * 由于第n项只和第n-1项与n-2项有关
	 * 因此只需要存储前两项的值
	 * 空间复杂度从O（N）降至O（1）
	 * 时间复杂度为O（N）
	 */
	public int Fibonacci3(int n)
	{
		if(n<=1)
		{
			return n;
		}
		int pre1=1;//前一项为1
		int pre2=0;//前两项为0
		int fibN=0;
		for(int i=2;i<=n;i++)
		{
			fibN=pre1+pre2;
			pre2=pre1;//前进一位
			pre1=fibN;
		}
		return fibN;
	}
	
}
