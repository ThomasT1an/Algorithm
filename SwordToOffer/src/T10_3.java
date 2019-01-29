/*
 * P79矩形覆盖
 * 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
 */
public class T10_3
{
	/*
	 * 当把2*n的覆盖方法记录为f(n)时 如f(8)
	 * 从最左边开始覆盖 当用第一个2*1的小矩形去覆盖时
	 * 只有两种选择：一是竖着放 那么大矩形就成为了一个2*7的矩形 即f(7)
	 * 二是横着放 那么就必须再横着放一个2*1的小矩形 那么大矩形就成为了一个2*6的矩形 即f(6)
	 * 则f(8)=f(7)+f(6)
	 * 可以看出 这仍然是一个斐波那契数列
	 */
	public int RectCover(int target)
	{
		if(target<=2)
		{
			return target;
		}
		int pre1=2;
		int pre2=1;
		int res=0;
		for(int i=2;i<target;i++)
		{
			res=pre1+pre2;
			pre2=pre1;
			pre1=res;
		}
		return res;
	}
}
