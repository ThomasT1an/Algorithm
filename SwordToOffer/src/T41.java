import java.util.LinkedList;

/*
 * P214������41���������е���λ��
 * ��Ŀ����εõ�һ���������е���λ����
 * ������������ж�����������ֵ ��ô��λ������������ֵ����֮��λ���м����ֵ
 * ������������ж���ż������ֵ ��ô��λ������������ֵ����֮���м���������ƽ��ֵ
 * ����ʹ��Insert()������ȡ��������ʹ��GetMedian()������ȡ��ǰ��ȡ���ݵ���λ��
 */
public class T41
{
	//ʹ��List�洢���� ά��List����������
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
