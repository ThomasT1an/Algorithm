/*
 * P127面试题20：表示数值的字符串
 * 题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）
 * 例如 字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是
 */
public class T20
{
	/*
	 * 表示数值的字符串遵循欧式 A[.[B]][e|EC]或者.B[e|EC]
	 * 其中A为数值的整数部分 B紧跟着小数点为数值的小数部分
	 * C紧跟着'e'或'E'为数值的指数部分
	 * 在小数里可能没有数值的整数部分
	 * 如果一个数没有整数部分 那么它的小数部分不能为空
	 * 其中A和C都是可能以'+' '-'开头的0~9数位串 B也是0~9的数位串 但前面不能有正负号
	 */
	public boolean isNumeric(char[] str)
	{
		if(str==null)
			return false;
		int index=0;
		//首先看是否有符号位
		if(str[index]=='+'||str[index]=='-')
			index++;
		//如果只有符号位 则不是数值
		if(index==str.length)
			return false;
		//接下来有两种情况  一是A存在 二是A不存在 这两种情况均可以扫描直到到达非数值位（小数点或指数符号）或直接到达终点
		index=moveIndex(str,index);
		//此时可能到达终点 也可能没有
		//直接到达终点就结束了 是数值 没到达终点有两种可能 小数点或指数符号
		if(index<str.length)
		{
			if(str[index]=='.')//小数点若出现 则一定在指数符号前 所以先判断小数点
			{
				index++;
				index=moveIndex(str,index);
				if(index<str.length)//若还没结束 则说明还有指数符号
				{
					if(str[index]=='e'||str[index]=='E')
					{
						index++;
						return isExponential(str,index);
					}
					return false;
				}
				return true;//小数点部分直接到达终点
			}
			else if(str[index]=='e'||str[index]=='E')//如果没有小数 直接为指数部分
			{
				index++;
                return isExponential(str,index);
			}
			return false;
		}
		return true;
	}
	/*
	 * 该函数的作用是扫描数位部分来匹配A、B、C部分 
	 */
	private int moveIndex(char[] str,int index)
	{
		while(index<str.length&&str[index]>='0'&&str[index]<='9')
			index++;
		return index;
	}
	/*
	 * 该函数的作用是处理指数位
	 */
	private boolean isExponential(char[] str, int index)
	{
		if (index < str.length)
		{
			// 如果是符号，跳到下一个
			if (str[index] == '+' || str[index] == '-')
				index++;
			index = moveIndex(str, index);
			if (index == str.length)
				return true;
			return false;
		}
		return false;
	}
}
