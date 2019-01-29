/*
 * P110������16����ֵ�������η�
 * ��Ŀ������һ��double���͵ĸ�����base��int���͵�����exponent
 * ��base��exponent�η�
 */
public class T16
{
	/*
	 * ͨ��ѭ��ʹresult=result*base����expontent����ʵ��
	 * ͬʱ��Ҫ���������ָ��С��1�����
	 * ���Ϊ���� ��Ҫ�ѽ��ȡ����
	 * ��һ��Ч�ʸ��ߵ�˼·������
	 * ���ǵ�Ŀ�������һ�����ֵ�32�η� ��������Ѿ�֪��������16�η�
	 * ��ôֻҪ��16�η��Ļ�������ƽ��һ�ξͿ�����
	 * ��16�η���8�η���ƽ��......��������
	 * ���Եõ�����һ�����㹫ʽ aΪ��ֵ nΪ�η�
	 * ��nΪż�� ��a^n=a^(n/2)*a^(n/2)
	 * ��nΪ���� ��a^n=a^((n-1)/2)*a^((n-1)/2)*a
	 * �õݹ�ķ�ʽ���
	 * �÷�����ʱ�临�Ӷ�ΪO(logN)
	 */
	public double Power(double base, int exponent)
	{
		if(exponent==0)
		{
			return 1;
		}
		if(exponent==1)
		{
			return base;
		}
		boolean flag=false;//��¼�η����Ƿ�Ϊ����
		if(exponent<0)
		{
			flag=true;
			exponent=-exponent;//��Ϊ���� ��ȡ����ֵ�����������ȡ����
		}
		double pow=Power(base*base,exponent/2);//ż�����
		if(exponent%2==1)
		{
			pow=pow*base;//�������
		}
		return flag ? 1/pow:pow;
	}
}
