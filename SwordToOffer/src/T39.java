/*
 * P205面试题39：数组中出现次数超过一半的数字
 * 题目：数组中有一个数字出现的次数超过数组长度的一般 请找出这个数字
 */
public class T39
{
	/*
	 * 排序数组之后下标为数组长度的一半处的元素为目标元素 该方法时间复杂度为O(nlogn)
	 * 哈希思想统计每个数字出现的次数 时间复杂度为O(n) 但是需要额外O(n)的空间
	 * 用二进制的方法也是一种思路 统计每一位的0/1出现的次数 （用左移之后与运算的方式） 0/1哪个超过一半 那么这位就是0/1中超过一半的数
	 * 每一位都这样计算 最后的数字转换为10进制就是目标数字
	 * 
	 * 本题使用的是摩尔投票法：每次删除一对（两个）不同的元素 直到数组中只剩下相同的元素
	 * 若目标元素存在 则一定可以删除完成所有非目标元素的元素
	 * 具体的实现方式有多种 使用的思路如下：
	 * 使用一个计数器num 设置一个候选数字res 遍历数组 
	 * 若res与当前元素相同 则num++ 不同则num--
	 * 当num为0时 令当前元素成为候选数字 直到遍历整个数组
	 * 之后还需要再遍历一次数组 防止出现不存在目标元素的情况
	 */
	public int MoreThanHalfNum_Solution(int[] array)
	{
		int res = 0;
		int num = 0;
		for (int i = 0; i < array.length; i++)
		{
			if (num == 0)
				res = array[i];
			if (res == array[i])
				num++;
			else
				num--;
		}
		num = 0;
		for (int i = 0; i < array.length; i++)
		{
			if (res == array[i])
				num++;
		}
		if (num > array.length / 2)
			return res;
		else
			return 0;
	}
}
