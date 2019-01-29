import java.util.Arrays;

/**
 * P39 面试题3：数组中重复的数字
 * 在一个长度为n的数组里所有数字都在0~n-1的范围内 数组中某些数字是重复的 但不知道有几个数字重复了
 * 也不知道每个数字重复了几次 请找出数组中任意一个重复的数字
 * 例如 如果输入长度为7的数组｛2，3，1，0，2，5，3｝
 * 那么对应的输出是重复的数字2或者3
 * @author tzy
 *
 */


public class T03
{
	public static void main(String[] args)
	{
//		int[] duplication=new int[1];  //保存答案的数组 结果保存在[0]
//		int[] inputarr={11,22,1,0,2,5,5};

		
	}
	
	/*
	 * 解法1：排序数组后找到重复值
	 * 排序算法的时间复杂度为O(nlogn)
	 */
	public static boolean solution1(int[] numbers,int length,int[] duplication)
	{
		if(numbers==null||length<=0)
		{
			return false;
		}
		Arrays.parallelSort(numbers);
		for(int i=0;i<numbers.length-1;i++)
		{
			if(numbers[i]==numbers[i+1])
			{
				duplication[0]=numbers[i];
				return true;
			}
		}
		return false;
	}
	
	/*
	 * 解法2：使用哈希表
	 * 时间复杂度O(N) 空间复杂度O(N)
	 */
	public static boolean solution2(int[] numbers,int length,int[] duplication)
	{
		int temp[]=new int[length+1];
		if(numbers==null||length<=0)
		{
			return false;
		}
		for(int i=0;i<length;i++)
		{
			temp[numbers[i]]++;
		}
		for(int j=0;j<length;j++)
		{
			if(temp[j]>1)
			{
				duplication[0]=j;
				return true;
			}
		}
		return false;
	}
	
	/*
	 * 解法3 推荐解法
	 * 时间复杂度O(N) 空间复杂度O(1)
	 * 通过将下标为i的数字（称为m）调整到属于它的下标的位置
	 */
	public static boolean solution3(int[] numbers,int length,int[] duplication)
	{
		if(numbers==null||length<=0)
		{
			return false;
		}
		for(int i=0;i<length;i++)
		{
			while(numbers[i]!=i)
			{
				if(numbers[i]==numbers[numbers[i]])
				{
					duplication[0]=numbers[i];
					return true;
				}
				int temp=numbers[i];
				numbers[i]=numbers[temp];
				numbers[temp]=temp;
			}
		}
		return false;
	}
}
