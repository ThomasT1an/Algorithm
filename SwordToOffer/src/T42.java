/*
 * P218������42�����������������
 * ��Ŀ������һ���������飬������������Ҳ�и��� �����е�һ������������������һ��������
 * ������������ĺ͵����ֵ Ҫ��ʱ�临�Ӷ�ΪO(n)
 * ���磺{6, -3, -2, 7, -15, 1, 2, 2}�����������������Ϊ 8���ӵ� 0 ����ʼ������ 3 ��Ϊֹ��
 */
public class T42
{
	/*
	 * ��̬�滮
	 * ת�Ʒ���Ϊdp[i]=Max(dp[i-1]+array[i],array[i]
	 * ��˼�� ��array[i]��ֵ����dp[i-1]+array[i] ������ǰ�����������
	 * ����ֻ��Ҫ�õ�dp[i]��dp[i-1] ���Բ���Ҫ������������ ��һ����ʱ��������
	 */
	public int FindGreatestSumOfSubArray(int[] array)
	{
		if(array.length==0)
			return 0;
		int dp=array[0];
		int res=array[0];
		for(int i=1;i<array.length;i++)
		{
			dp=Math.max(dp+array[i], array[i]);
			res=Math.max(res, dp);
		}
		return res;
	}
}
