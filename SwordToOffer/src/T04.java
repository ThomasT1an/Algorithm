/*
 * P44������4����ά�����еĲ���
 * ��Ŀ����һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
 * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�����
 */
public class T04
{
	/*
	 * ˼·�����ڶ�ά�����е�ÿһ�����֣���С�����ұߵ����֣�С�����·�������
	 * ���Դ����Ͻǵ����֣���Ϊm����ʼ���� 
	 * ��m>target ���޳�m���ڵ��� ��Ϊm����һ����С��Ԫ�� ��һ�����е�Ԫ�ؽ�����target
	 * ��m<target ���޳�m���ڵ��� ��Ϊm����һ����С��Ԫ�� ��һ�����е�Ԫ�ؽ�С��target
	 */
	public boolean Find(int target, int [][] array) 
	{
		if(array.length==0||array[0].length==0||array==null)
		{
			return false;
		}
		//��¼����������
		int rows=array.length;
		int cols=array[0].length;
		//�����Ͻǿ�ʼ����
		int rownow=0;
		int colnow=cols-1;
		while(rownow<=rows-1&&colnow>=0)//�����������½ǵ������Ǳ߽�����
		{
			if(array[rownow][colnow]==target)
			{
				return true;
			}
			else if(array[rownow][colnow]>target)
			{
				colnow--;
			}
			else
			{
				rownow++;
			}
		}
		return false;
    }
}
