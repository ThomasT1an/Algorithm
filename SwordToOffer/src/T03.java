import java.util.Arrays;

/**
 * P39 ������3���������ظ�������
 * ��һ������Ϊn���������������ֶ���0~n-1�ķ�Χ�� ������ĳЩ�������ظ��� ����֪���м��������ظ���
 * Ҳ��֪��ÿ�������ظ��˼��� ���ҳ�����������һ���ظ�������
 * ���� ������볤��Ϊ7�������2��3��1��0��2��5��3��
 * ��ô��Ӧ��������ظ�������2����3
 * @author tzy
 *
 */


public class T03
{
	public static void main(String[] args)
	{
//		int[] duplication=new int[1];  //����𰸵����� ���������[0]
//		int[] inputarr={11,22,1,0,2,5,5};

		
	}
	
	/*
	 * �ⷨ1������������ҵ��ظ�ֵ
	 * �����㷨��ʱ�临�Ӷ�ΪO(nlogn)
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
	 * �ⷨ2��ʹ�ù�ϣ��
	 * ʱ�临�Ӷ�O(N) �ռ临�Ӷ�O(N)
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
	 * �ⷨ3 �Ƽ��ⷨ
	 * ʱ�临�Ӷ�O(N) �ռ临�Ӷ�O(1)
	 * ͨ�����±�Ϊi�����֣���Ϊm�����������������±��λ��
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
