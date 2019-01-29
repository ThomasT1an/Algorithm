/*
 * P205������39�������г��ִ�������һ�������
 * ��Ŀ����������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�� ���ҳ��������
 */
public class T39
{
	/*
	 * ��������֮���±�Ϊ���鳤�ȵ�һ�봦��Ԫ��ΪĿ��Ԫ�� �÷���ʱ�临�Ӷ�ΪO(nlogn)
	 * ��ϣ˼��ͳ��ÿ�����ֳ��ֵĴ��� ʱ�临�Ӷ�ΪO(n) ������Ҫ����O(n)�Ŀռ�
	 * �ö����Ƶķ���Ҳ��һ��˼· ͳ��ÿһλ��0/1���ֵĴ��� ��������֮��������ķ�ʽ�� 0/1�ĸ�����һ�� ��ô��λ����0/1�г���һ�����
	 * ÿһλ���������� ��������ת��Ϊ10���ƾ���Ŀ������
	 * 
	 * ����ʹ�õ���Ħ��ͶƱ����ÿ��ɾ��һ�ԣ���������ͬ��Ԫ�� ֱ��������ֻʣ����ͬ��Ԫ��
	 * ��Ŀ��Ԫ�ش��� ��һ������ɾ��������з�Ŀ��Ԫ�ص�Ԫ��
	 * �����ʵ�ַ�ʽ�ж��� ʹ�õ�˼·���£�
	 * ʹ��һ��������num ����һ����ѡ����res �������� 
	 * ��res�뵱ǰԪ����ͬ ��num++ ��ͬ��num--
	 * ��numΪ0ʱ �ǰԪ�س�Ϊ��ѡ���� ֱ��������������
	 * ֮����Ҫ�ٱ���һ������ ��ֹ���ֲ�����Ŀ��Ԫ�ص����
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