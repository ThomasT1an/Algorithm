/*
 * P127������20����ʾ��ֵ���ַ���
 * ��Ŀ����ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С����
 * ���� �ַ���"+100","5e2","-123","3.1416"��"-1E-16"����ʾ��ֵ
 * ����"12e","1a3.14","1.2.3","+-5"��"12e+4.3"������
 */
public class T20
{
	/*
	 * ��ʾ��ֵ���ַ�����ѭŷʽ A[.[B]][e|EC]����.B[e|EC]
	 * ����AΪ��ֵ���������� B������С����Ϊ��ֵ��С������
	 * C������'e'��'E'Ϊ��ֵ��ָ������
	 * ��С�������û����ֵ����������
	 * ���һ����û���������� ��ô����С�����ֲ���Ϊ��
	 * ����A��C���ǿ�����'+' '-'��ͷ��0~9��λ�� BҲ��0~9����λ�� ��ǰ�治����������
	 */
	public boolean isNumeric(char[] str)
	{
		if(str==null)
			return false;
		int index=0;
		//���ȿ��Ƿ��з���λ
		if(str[index]=='+'||str[index]=='-')
			index++;
		//���ֻ�з���λ ������ֵ
		if(index==str.length)
			return false;
		//���������������  һ��A���� ����A������ ���������������ɨ��ֱ���������ֵλ��С�����ָ�����ţ���ֱ�ӵ����յ�
		index=moveIndex(str,index);
		//��ʱ���ܵ����յ� Ҳ����û��
		//ֱ�ӵ����յ�ͽ����� ����ֵ û�����յ������ֿ��� С�����ָ������
		if(index<str.length)
		{
			if(str[index]=='.')//С���������� ��һ����ָ������ǰ �������ж�С����
			{
				index++;
				index=moveIndex(str,index);
				if(index<str.length)//����û���� ��˵������ָ������
				{
					if(str[index]=='e'||str[index]=='E')
					{
						index++;
						return isExponential(str,index);
					}
					return false;
				}
				return true;//С���㲿��ֱ�ӵ����յ�
			}
			else if(str[index]=='e'||str[index]=='E')//���û��С�� ֱ��Ϊָ������
			{
				index++;
                return isExponential(str,index);
			}
			return false;
		}
		return true;
	}
	/*
	 * �ú�����������ɨ����λ������ƥ��A��B��C���� 
	 */
	private int moveIndex(char[] str,int index)
	{
		while(index<str.length&&str[index]>='0'&&str[index]<='9')
			index++;
		return index;
	}
	/*
	 * �ú����������Ǵ���ָ��λ
	 */
	private boolean isExponential(char[] str, int index)
	{
		if (index < str.length)
		{
			// ����Ƿ��ţ�������һ��
			if (str[index] == '+' || str[index] == '-')
				index++;
			index = moveIndex(str, index);
			if (index == str.length)
				return true;
			return false;
		}
		return false;
	}
}
