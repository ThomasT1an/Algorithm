import java.util.LinkedList;

/*
 * P214面试题41：数据流中的中位数
 * 题目：如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值 那么中位数就是所有数值排序之后位于中间的数值
 * 如果从数据流中读出偶数个数值 那么中位数就是所有数值排序之后中间两个数的平均值
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数
 */
public class T41
{
	//使用List存储数据 维持List中数据有序
	LinkedList<Integer> list = new LinkedList<Integer>();
	public void Insert(Integer num)
	{
		if(list.size()==0||num<list.getFirst())
			list.addFirst(num);
		else
		{
			boolean flag=false;
			for(Integer temp:list)
			{
				if(temp>num)
				{
					int index=list.indexOf(temp);
					list.add(index, num);
					flag=true;
					break;
				}
			}
			if(!flag)
				list.addLast(num);
		}
	}
	public Double GetMedian()
	{
		if(list.size()==0)
			return null;
		if(list.size()%2==0)
		{
			Double temp=Double.valueOf(list.get(list.size()/2-1)+list.get(list.size()/2));
			return temp/2;
		}
        return Double.valueOf(list.get((list.size() + 1) / 2 - 1));
	}
}
