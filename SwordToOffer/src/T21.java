/*
 * P129面试题21：调整数组顺序使奇数位于偶数前面
 * 题目：输入一个整数数组 实现一个函数来调整该数组中数字的顺序
 * 使得所有奇数位于数组的前半部分 所有偶数位于数组的后半部分
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变（牛客网额外条件）
 */
public class T21
{
	/*
	 * 思路一：使用两个指针 由于要保证奇数与奇数 偶数与偶数之间的相对位置不变
	 * 不能按照原书中的方法处理 会打乱相对顺序
	 * 只能交换相邻的元素 如果相邻的元素为前偶后奇 那么交换他们
	 */
	public void reOrderArray1(int [] array) 
	{
        for(int i=0;i<array.length;i++)
        {
        	for(int j=array.length-1;j>i;j--)
        	{
        		if(array[j-1]%2==0&&array[j]%2==1)
        		{
        			int temp=array[j-1];
        			array[j-1]=array[j];
        			array[j]=temp;
        		}
        	}
        }	
    }
/*
 * 另一种用空间换时间的方法是建立一个新数组
 * 统计原数组中奇数的个数 
 * 在新数组中以这个个数为分界线 遍历原数组 遇到奇数则放在新数组首部
 * 遇到偶数则放在新数组的分界线之后
 */
	public void reOrderArray2(int [] array)
	{
		int count=0;//奇数个数
		for(int i=0;i<array.length;i++)
		{
			if(array[i]%2==1)
				count++;
		}
		int[] copy = array.clone();
	    int a= 0;
	    for(int i=0;i<copy.length;i++)
	    {
	    	if(copy[i]%2==1)
	    		array[a++]=copy[i];
	    	else
	    		array[count++]=copy[i];
	    }
	}
}
