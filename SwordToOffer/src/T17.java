/*
 * P114������17����ӡ��1������nλ��
 * ��Ŀ����������n ��˳���ӡ����1������nλʮ������
 * ��������3 ���ӡ��1��2��3һֱ������3λ��999
 */
public class T17
{
	public static void main(String[] args)
	{
		Print1ToMaxOfNDigits_1(3);
	}
	
	/*
	 * ���������n���ܷǳ��� ���Բ��������Σ������Σ�����ʾ
	 * ������int����/char�������洢
	 * �ⷨһ����������ģ��ӷ� �ڴ�ӡʱ�����ʼ��0
	 */
	public static void Print1ToMaxOfNDigits_1(int n)
	{
		int number[]=new int[n+1];
		for(int i=n;i>0;i--)
		{
			for(int j=0;j<Math.pow(10, i)-Math.pow(10, i-1);j++)
			{
				number[n]++;
				printNumber(number);
			}
		}
	}
	/*
	 * �ⷨ����ȫ����ʵ��
	 * ȫ�����õݹ�����ױ�� ���ֵ�ÿһλ��������0~9�е�һ����
	 * Ȼ��������һλ �ݹ�����������������Ѿ����������ֵ����һλ
	 */
	public static void Print1ToMaxOfNDigitis_2(int n)
	{
		int number[]=new int[n];
		Print1ToMaxCore(number,0);
	}
	
	private static void Print1ToMaxCore(int num[],int index)
	{
		if(index==num.length)
		{
			printNumber(num);
			return;
		}
		for(int i=0;i<10;i++)
		{
			num[index]=i;
			Print1ToMaxCore(num,index+1);
		}
	}
	
	/*
	 * ʵ�ִ�ӡ���ܵĺ���
	 */
	public static void printNumber(int num[])
	{
		boolean flag=true;//���ֵ�һ����0���ֵı�־
		int index=0;
		while(flag)
		{
			if(index>=num.length)
				break;
			if(num[index]==0)
				index++;
			else
				flag=false;
		}
		for(int i=index;i<num.length;i++)
		{
			System.out.print(num[i]);
		}
		System.out.println();
	}
}
