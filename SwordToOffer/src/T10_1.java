/*
 * P74��Ŀһ��쳲���������
 * дһ������ ����n ��쳲��������еĵ�n��
 */
public class T10_1
{
	/*
	 * ����һ �ݹ� ���ظ�����һЩ������
	 * ����f(10)��Ҫ����f(9)��f(8) ����f(9)��Ҫ����f(8)��f(7)
	 * f(8)���ظ�����
	 */
	public int Fibonacci1(int n)
	{
		if(n<=1)
		{
			return n;
		}
		return Fibonacci1(n-1)+Fibonacci1(n-2);
	}
	/*
	 * ������ ��̬�滮������
	 * ��������Ľ⻺������ �����������ظ����������
	 */
	public int Fibonacci2(int n) 
	{
		if(n<=1)
		{
			return n;
		}
		int res[]=new int[n+1];
		//res[0]=0; Ĭ�ϳ�ʼ��Ϊ0
		res[1]=1;
		for(int i=2;i<=n;i++)
		{
			res[i]=res[i-1]+res[i-2];
		}
		return res[n];
    }
	/*
	 * ������ ����һ�����Ļ����ϸĽ�
	 * ���ڵ�n��ֻ�͵�n-1����n-2���й�
	 * ���ֻ��Ҫ�洢ǰ�����ֵ
	 * �ռ临�Ӷȴ�O��N������O��1��
	 * ʱ�临�Ӷ�ΪO��N��
	 */
	public int Fibonacci3(int n)
	{
		if(n<=1)
		{
			return n;
		}
		int pre1=1;//ǰһ��Ϊ1
		int pre2=0;//ǰ����Ϊ0
		int fibN=0;
		for(int i=2;i<=n;i++)
		{
			fibN=pre1+pre2;
			pre2=pre1;//ǰ��һλ
			pre1=fibN;
		}
		return fibN;
	}
	
}
