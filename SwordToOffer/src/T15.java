/*
 * P100面试题15：二进制中1的个数
 * 题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数
 * 例如 把9表示为二进制是1001 有2位是1 因此该函数返回2
 */
public class T15
{
	/*
	 * 思路一：首先把n和1做与运算 判断n的最低位是不是1
	 * 接着把1左移一位得到2 再和n做与运算 就能判断n的次低位是不是1
	 * 如此反复左移 每次都能判断n的其中一位是不是1 
	 * 该算法的循环次数等于整数二进制的位数
	 * 故时间复杂度为O(n)
	 */
	public int NumberOf1(int n)
	{
		int count=0;
		int flag=1;
		while(flag!=0)
		{
			if((n&flag)!=0)
			{
				count++;
			}
			flag=flag<<1;
		}
		return count;
	}
	/*
	 * 思路二：把一个整数减去1 都是把最右边的1变成0
	 * 如果它的右边还有0，则所有的0都变成1
	 * 而它左边的所有位都保持不变 之后把这个n与(n-1)做位与运算
	 * 就会把该整数最右边的1变成0
	 * n中有几个1 该过程就会进行几次
	 * 复杂度为O（M） M为1的个数
	 */
	public int anotherNumberOf1(int n) 
	{
		int count=0;
		while(n!=0)
		{
			count++;
			n=n&(n-1);
		}
		return count;
    }
	/*
	 * 思路三：使用Integer.bigCount()函数
	 */
//	public int NumberOf1(int n) {
//	    return Integer.bitCount(n);
//	}
}
