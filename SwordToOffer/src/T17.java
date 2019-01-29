/*
 * P114面试题17：打印从1到最大的n位数
 * 题目：输入数字n 按顺序打印出从1到最大的n位十进制数
 * 比如输入3 则打印出1、2、3一直到最大的3位数999
 */
public class T17
{
	public static void main(String[] args)
	{
		Print1ToMaxOfNDigits_1(3);
	}
	
	/*
	 * 由于输入的n可能非常大 所以不能用整形（长整形）来表示
	 * 可以用int数组/char数组来存储
	 * 解法一：在数组中模拟加法 在打印时忽略最开始的0
	 */
	public static void Print1ToMaxOfNDigits_1(int n)
	{
		int number[]=new int[n+1];
		for(int i=n;i>0;i--)
		{
			for(int j=0;j<Math.pow(10, i)-Math.pow(10, i-1);j++)
			{
				number[n]++;
				printNumber(number);
			}
		}
	}
	/*
	 * 解法二：全排列实现
	 * 全排列用递归很容易表达 数字的每一位都可能是0~9中的一个数
	 * 然后设置下一位 递归结束的条件是我们已经设置了数字的最后一位
	 */
	public static void Print1ToMaxOfNDigitis_2(int n)
	{
		int number[]=new int[n];
		Print1ToMaxCore(number,0);
	}
	
	private static void Print1ToMaxCore(int num[],int index)
	{
		if(index==num.length)
		{
			printNumber(num);
			return;
		}
		for(int i=0;i<10;i++)
		{
			num[index]=i;
			Print1ToMaxCore(num,index+1);
		}
	}
	
	/*
	 * 实现打印功能的函数
	 */
	public static void printNumber(int num[])
	{
		boolean flag=true;//出现第一个非0数字的标志
		int index=0;
		while(flag)
		{
			if(index>=num.length)
				break;
			if(num[index]==0)
				index++;
			else
				flag=false;
		}
		for(int i=index;i<num.length;i++)
		{
			System.out.print(num[i]);
		}
		System.out.println();
	}
}
