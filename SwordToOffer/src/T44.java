/*
 * P225������44������������ĳһλ������
 * ��Ŀ��������0123456789101112131415....�ĸ�ʽ���л���ÿһ���ַ�������
 * ����������У���0��ʼ��������5λ��5 ��13λ��1 ��19λ��4
 * ��дһ������ �������nλ��Ӧ������
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
	 * ������������õ�mλ�������ܹ��ж��ٸ�
	 * ���� ����2 �򷵻���λ���ĸ�����10~99��90
	 * ����3 �򷵻���λ����100~999���ĸ���900
	 */
	private static int countOfIntegers(int digits)
	{
		if(digits==1)
			return 10;
		int count=(int) (Math.pow(10, digits)-Math.pow(10, digits-1));
		return count;
	}
	/*
	 * ��֪��Ҫ�ҵ���һλ����λ��ĳmλ��֮��  ��Ҫ֪�����mλ���ֵĵ�һ������
	 * ���� ��һ����λ����10 ��һ����λ����100
	 */
	private static int beginNumber(int digits)
	{
		if(digits==1)
			return 0;
		int res=(int) Math.pow(10, digits-1);
		return res;
	}
	/*
	 * ����������������ҳ��������
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
