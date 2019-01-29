/*
 * P44面试题4：二维数组中的查找
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 */
public class T04
{
	/*
	 * 思路：对于二维数组中的每一个数字，他小于他右边的数字，小于他下方的数字
	 * 所以从右上角的数字（称为m）开始查找 
	 * 若m>target 则剔除m所在的列 因为m是这一列最小的元素 这一列所有的元素将大于target
	 * 若m<target 则剔除m所在的行 因为m是这一行最小的元素 这一行所有的元素将小于target
	 */
	public boolean Find(int target, int [][] array) 
	{
		if(array.length==0||array[0].length==0||array==null)
		{
			return false;
		}
		//记录行数与列数
		int rows=array.length;
		int cols=array[0].length;
		//从右上角开始搜索
		int rownow=0;
		int colnow=cols-1;
		while(rownow<=rows-1&&colnow>=0)//搜索到最左下角的数字是边界条件
		{
			if(array[rownow][colnow]==target)
			{
				return true;
			}
			else if(array[rownow][colnow]>target)
			{
				colnow--;
			}
			else
			{
				rownow++;
			}
		}
		return false;
    }
}
