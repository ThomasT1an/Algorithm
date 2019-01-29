import java.util.Arrays;

/*
 * P78 ������̨����չ
 * һֻ����һ�ο������� 1 ��̨�ף�Ҳ�������� 2 ��... ��Ҳ�������� n ���������������һ�� n ����̨���ܹ��ж���������
 */
public class T10_4
{
	/*
	 * ˼·һ����̬�滮
	 * ��f(5)�����ϵ���׵�����������Ϊ��
	 * �յ�Ϊ�����ʱ ��һ������Ϊ��4 3 2 1 0��
	 * ��f(5)=f(4)+......+f(0)
	 * ����f(4) ����f(4)=f(3)+f(2)+f(1)+f(0)
	 */
	public int JumpFloorII(int target)
	{
		int dp[]=new int[target+1];
		Arrays.fill(dp, 1);//ÿһ����������1������
		for(int i=1;i<target;i++)
		{
			for(int j=0;j<i;j++)
			{
				dp[i]=dp[i]+dp[j];
			}
		}
		return dp[target-1];
	}
	
	/*
	 * ˼·������ѧ�Ƶ�
	 * �������˼· Ҫ���ϵ�n��̨��
	 * �У�f(n) = f(n-1) + f(n-2) + ... + f(0)
	 * Ҫ���ϵ�n-1��̨��
	 * �У�f(n-1) = f(n-2) + f(n-3) + ... + f(0)
	 * ��ʽ��� �ã�
	 * f(n)-f(n-1)=f(n-1)
	 * ����
	 * f(n)=2*f(n-1)
	 * ��
	 * f(n)=2^(n-1)
	 */
	public int JumpFloor(int target)
	{
		return (int)Math.pow(2, target-1);
	}
}
