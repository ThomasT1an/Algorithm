/*
 * P110面试题16：数值的整数次方
 * 题目：给定一个double类型的浮点数base和int类型的整数exponent
 * 求base的exponent次方
 */
public class T16
{
	/*
	 * 通过循环使result=result*base进行expontent即可实现
	 * 同时需要考虑输入的指数小于1的情况
	 * 如果为负数 即要把结果取倒数
	 * 另一种效率更高的思路：例如
	 * 我们的目标是求出一个数字的32次方 如果我们已经知道了它的16次方
	 * 那么只要在16次方的基础上再平方一次就可以了
	 * 而16次方是8次方的平方......依次类推
	 * 可以得到这样一个计算公式 a为数值 n为次方
	 * 若n为偶数 则a^n=a^(n/2)*a^(n/2)
	 * 若n为奇数 则a^n=a^((n-1)/2)*a^((n-1)/2)*a
	 * 用递归的方式求解
	 * 该方法的时间复杂度为O(logN)
	 */
	public double Power(double base, int exponent)
	{
		if(exponent==0)
		{
			return 1;
		}
		if(exponent==1)
		{
			return base;
		}
		boolean flag=false;//记录次方数是否为负数
		if(exponent<0)
		{
			flag=true;
			exponent=-exponent;//若为负数 则取绝对值后正常计算后取倒数
		}
		double pow=Power(base*base,exponent/2);//偶数情况
		if(exponent%2==1)
		{
			pow=pow*base;//奇数情况
		}
		return flag ? 1/pow:pow;
	}
}
