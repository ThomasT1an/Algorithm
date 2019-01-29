/*
 * P96������14��������
 * ����һ�������� n��������Ϊ���������������ĺͣ���ʹ��Щ�����ĳ˻���󻯡� ��������Ի�õ����˻�
 */
public class T14
{
	/*
	 * �ⷨһ����̬�滮
	 * ��dp[n]Ϊn��Ӧ�����˻�
	 * ά��������Ž�����
	 * ע���е�д������һ����ⷽʽ
	 * ����ֳ���һ���ֵĳ���Ϊ4ʱ ��һ���Ƿ���Ҫ�ٽ��в�֣�
	 * 4=2*2 ��С��4ʱ ����3 �����3 ��õ�1*2=2 �����С�ڲ���ֵĽ��
	 * ��������4ʱ ����5 ���Ϊ2*3=6 >5 ����4Ϊ�ֽ��
	 * ����4�Ĳ�����Ҫ�ٽ��в�� С��4�Ĳ�������Ҫ���
	 * �˷�����ʱ�临�Ӷ�ΪO(n^2)
	 */
	public static int integerBreak(int n)
	{
		int dp[]=new int[n+1];
		dp[1]=1;
		for(int i=2;i<=n;i++)
		{
			for(int j=1;j<i;j++)
			{
				dp[i]=Math.max(dp[i], (i-j)*Math.max(dp[j], j));
			}
		}
		return dp[n];
		
//		int dp[]=new int[n+1];
//		dp[1]=1;
//		for(int i=2;i<=n;i++)
//		{
//			for(int j=1;j<i;j++)
//			{
//				if(j<=4)
//				{
//					dp[i]=Math.max(dp[i], (i-j)*j);
//				}
//				else
//				{
//					dp[i]=Math.max(dp[i],(i-j)*dp[j]);
//				}
//			}
//		}
//		return dp[n];
	}
	
	/*
	 * �ⷨ����̰��
	 * �����ɾ�ֵ����ʽ�е�����ƽ����>=����ƽ������֪
	 * �������n��ֳɶ����ȵ���ʱ�����
	 * �ȼ������Ų��������ÿһ������Ϊx
	 * ��ôһ������n/x����
	 * �����ǵĻ�Ϊf(x) ��f(x)=x^(n/x)
	 * Ϊ����f(x)�����ֵ ���Զ�����
	 * ����ʡ��
	 * ������ x=eʱf(x)�м���ֵ
	 * e=2.7 �����Ȳ��3 �𲻳�3���2
	 * ʵ���ϵ�ʣ�೤��С�ڵ���4ʱ
	 * ʣ�ಿ�ֲ���ּ��ɣ�����һ��˵����
	 * �˷�����ʱ�临�Ӷ�ΪO(lgn)
	 */
	public static int integerBreak2(int n)
	{
		if (n < 2)
	        return 0;
	    if (n == 2)
	        return 1;
	    if (n == 3)
	        return 2;
	    int timesOf3=0;
	    while(n>3)
	    {
	    	if(n<=4)
	    		break;
	    	timesOf3++;
	    	n-=3;
	    }
	    return (int)(Math.pow(3, timesOf3))*(n);
	}
	
	/*
	 * ��¼һ����һ�ֿ�����˼·
	 *
	 * class Solution {
public:
    int integerBreak(int n) {
      if(n==2){return 1;}
      if(n==3){return 2;}
      n-=2;
      return pow(3,n/3)*(n%3+2);
    }
};

	 */
}
