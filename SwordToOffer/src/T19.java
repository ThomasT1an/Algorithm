/*
 * P124������19��������ʽƥ��
 * ��Ŀ����ʵ��һ����������ƥ�����'.'��'*'��������ʽ
 * ģʽ�е��ַ�'.'��ʾ����һ���ַ� ��'*'��ʾ��ǰ����ַ����Գ�������Σ���0�Σ�
 * �ڱ����� ƥ����ָ�ַ����������ַ�ƥ������ģʽ
 * ���� �ַ���"aaa"��ģʽ"a.a" "ab*ac*a"ƥ��
 * ����"aa.a"��"ab*a"����ƥ��
 */
public class T19
{
	/*
	 * ˼·һ��
	 * ���ַ�����ģʽ���ĸ���Ԫ�ؽ������ζԱ� �����¼������
	 * A.������ģʽ���е�Ԫ�����ַ�����ƥ�� ��ģʽ�������Ԫ�صĺ�һԪ�ز�Ϊ* ������ƥ�� ���±깲ͬ+1 ��ƥ������Ϊ��ƥ��
	 * B.����һ����� ģʽ���е�Ԫ����Ϊ. ���±깲ͬ+1
	 * ��ģʽ���е�ĳһԪ�صĺ�һԪ��Ϊ* ����3����� ��
	 * C.*��ʾģʽ���е��ַ�����0�Σ����ַ����±겻�� ģʽ���±�+2
	 * D.*��ʾģʽ���е��ַ�����1�Σ����ַ����±�+1 ģʽ���±�+2
	 * E.*��ʾģʽ���е��ַ�����1�����ϣ����ַ����±�+1 ģʽ���±겻��
	 * ����CDE������� ����ǰ�±�Ԫ�����߲�ƥ�� ֻ�ܽ���C���� ���ǵ�ƥ��ʱ Ҳ���Խ���C����
	 * ����Ҫ����.*�������ֵ���� 
	 */
	public boolean match(char[] str, char[] pattern)
    {
		if(str==null||pattern==null)
			return false;
		return matchCore(str,pattern,0,0);
    }
	private boolean matchCore(char[] str,char[] pattern,int index1,int index2)//index1�ַ����±� index2ģʽ���±�
	{
		if(index1>=str.length&&index2>=pattern.length)//��ƥ�����
			return true;
		if(index1<str.length&&index2>=pattern.length)//�ַ���û�굫��ģʽ������
			return false;
		//����һ������� �ַ������� �����������ģʽ������ɲ��� ��Ϊģʽ�����ܻ������C���� ���Բ������ó���
		if(index2+1<pattern.length&&pattern[index2+1]=='*')//ע���ж�˳��
		{
			/*
			 * ������������ַ������˵���ģʽ��û������
			 */
			if(index1>=str.length)
				return matchCore(str,pattern,index1,index2+2);
			else
			{
				if(pattern[index2]==str[index1]||pattern[index2]=='.')
				{
					return matchCore(str,pattern,index1+1,index2+2)||//D
							matchCore(str,pattern,index1+1,index2)||//E
							matchCore(str,pattern,index1,index2+2);//C
				}
				else
					return matchCore(str,pattern,index1,index2+2);
			}
		}
		if(index1>=str.length)
			return false;
		else
		{
			if(pattern[index2]==str[index1]||pattern[index2]=='.')
				return matchCore(str,pattern,index1+1,index2+1);
		}
		return false;
	}
	
	/*
	 * ˼·������̬�滮
	 * ά��һ�������Ͷ�ά���� ��ά�ֱ�Ϊ�ַ����ĳ��Ⱥ�ģʽ���ĳ���
	 * ����dp[i][j]��ֵΪtrue���ʾ�ַ�������Ϊi ģʽ������Ϊjʱ���߿���ƥ��
	 * ����ļ��������˼·һ����
	 * ����Ҫ����a* ��ʾ0����1�������a����� 
	 */
	public boolean match2(char[] str,char[] pattern)
	{
		boolean dp[][]=new boolean[str.length+1][pattern.length+1];
		dp[0][0]=true;
		/*
		 * ����һ��forѭ���Ǵ����ַ�������Ϊ0�Ķ�Ӧ��������
		 */
		for(int i=1;i<=pattern.length;i++)
		{
			if(pattern[i-1]=='*')
				dp[0][i]=dp[0][i-2];
		}
		for(int i=1;i<=str.length;i++)
		{
			for(int j=1;j<=pattern.length;j++)
			{
				if(str[i-1]==pattern[j-1]||pattern[j-1]=='.')
					dp[i][j]=dp[i-1][j-1];
				else if(pattern[j-1]=='*')
				{
					if(pattern[j-2]==str[i-1]||pattern[j-2]=='.')
					{
						dp[i][j]=dp[i][j]||dp[i][j-2];//*��ʾ����0��
						dp[i][j]=dp[i][j]||dp[i][j-1];//*��ʾ����1��
						dp[i][j]=dp[i][j]||dp[i-1][j];//*��ʾ���ֶ��
					}
					else
						dp[i][j]=dp[i][j]||dp[i][j-2];//*��ƥ��ʱֻ��ѡ�����0��
				}
			}
		}
		return dp[str.length][pattern.length];
	}
}
