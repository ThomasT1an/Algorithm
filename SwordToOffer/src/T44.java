/*
 * P225面试题44：数字序列中某一位的数字
 * 题目：数字以0123456789101112131415....的格式序列化到每一个字符序列中
 * 在这个序列中（从0开始计数）第5位是5 第13位是1 第19位是4
 * 请写一个函数 求任意第n位对应的数字
 */
public class T44
{
	public static void main(String[] args)
	{
		System.out.println(digitAtIndex(19));
	}
	
	public static int digitAtIndex(int index)
	{
		if(index<0)
			return -1;
		if(index==0)
			return 0;
		boolean flag=false;
		int digits=1;
		while(!flag)
		{
			int count=digits*countOfIntegers(digits);
			if(index>=count)
			{
				index-=count;
				digits++;
			}
			else
				flag=true;
		}
		int res=countOfIntegers(index,digits);
		return res;
	}
	/*
	 * 这个函数用来得到m位的数字总共有多少个
	 * 例如 输入2 则返回两位数的个数（10~99）90
	 * 输入3 则返回三位数（100~999）的个数900
	 */
	private static int countOfIntegers(int digits)
	{
		if(digits==1)
			return 10;
		int count=(int) (Math.pow(10, digits)-Math.pow(10, digits-1));
		return count;
	}
	/*
	 * 当知道要找的那一位数字位于某m位数之后  需要知道这个m位数字的第一个数字
	 * 例如 第一个两位数是10 第一个三位数是100
	 */
	private static int beginNumber(int digits)
	{
		if(digits==1)
			return 0;
		int res=(int) Math.pow(10, digits-1);
		return res;
	}
	/*
	 * 利用下面这个函数找出结果数字
	 */
	private static int countOfIntegers(int index,int digits)
	{
		int begin=beginNumber(digits);
		begin=begin+(index/digits);
		int count=index%digits;
		String num=begin+"";
		int res=num.charAt(count)-'0';
		return res;
	}
}
