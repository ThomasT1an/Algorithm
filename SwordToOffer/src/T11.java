/*
 * P82������11����ת�������С����
 * ��Ŀ����һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ ���ǳ�֮Ϊ�������ת
 * ����һ����������������һ����ת �����ת�������СԪ��
 * ���� ���� {3, 4, 5, 1, 2} Ϊ {1, 2, 3, 4, 5} ��һ����ת�����������СֵΪ 1
 */
public class T11
{
	/*
	 * ˼·���ڲ������ظ�������� �����ö��ֲ��ҵ�˼·���
	 * ������ת�����˼�룬��ת���������һ��������������������������
	 * ��СԪ��Ϊ������������Ľ��紦
	 * ��ĳ��Ԫ�ش���������Ԫ�� ��ô��Ԫ�ش���ǰ��ĵ���������
	 * �����ں�ߵĵ��������� �Դ˵�������ָ��ָ���Ԫ��
	 */
	public int minNumberInRotateArray(int[] array)
	{
		if(array.length==0)
		{
			return 0;
		}
		int l=0;
		int r=array.length-1;
		/*
		 * ������ʽһ
		 */
		while(l<r)
		{
			int m=(l+r)/2;//�۰���Ԫ��λ��
			if(array[m]>array[r])//����м�Ԫ�ش���ĩβԪ�� ˵���м�Ԫ�ش��ڵ�һ���������� ˵����Сֵ���м�Ԫ�ص��Ҳ�
			{
				l=m+1;
			}
			else//����м�Ԫ��С��ĩβԪ�� ˵���м�Ԫ�ش��ڵڶ����������� ˵����Сֵ���м�Ԫ�ص����
			{
				r=m;
			}
		}
		//return array[l];
		
		/*
		 * ��һ�ֱ�����ʽ
		 */
		int mid=l;
		while(array[l]>=array[r])
		{
			if(r-l==1)
			{
				mid=r;
				break;
			}
			mid=(l+r)/2;
			if(array[mid]>=array[l])
			{
				l=mid;
			}
			else if(array[mid]<=array[r])
			{
				r=mid;
			}
		}
		return array[mid];
	}
	/*
	 * ���������Ԫ�������ظ��Ļ� ���ܳ����������Ϊl��r��m���±��Ӧ��Ԫ�����
	 * ��ʱ�޷�ȷ�������ĸ����� ��Ҫת��Ϊ˳����� ��while�м�����жϺͶ�Ӧ��������
	 */
}