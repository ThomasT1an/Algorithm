/*
 * P51������5���滻�ո�
 * ��Ŀ����ʵ��һ�����������ַ����е�ÿ���ո��滻��"%20"
 * ��������"We are happy."
 * �����"We%20are%20happy."
 */
public class T05
{
	/*
	 * ����˼·��
	 * �ȱ���һ������ �ҵ�һ���ж��ٸ��ո� ��β�����2*�ո�����������ַ�
	 * ��P1ָ��ԭĩβ��P2ָ���ӳ����ĩβ����ָ����Ӻ���ǰ������P1��ʼ��
	 * ÿ��P1������һ���ַ�ʱ �������Ƶ�P2 ��ָ��ͬʱǰ��һλ
	 * ��P1�������ո�ʱ P1��ǰ��һλ P2��ǰ�ƶ���λ�����02%
	 * ��P1��P2�غ�ʱ �����
	 * �Ӻ���ǰ������Ϊ���ڸı�P2��ָ�������ʱ ����Ӱ�쵽P1����ԭ�����ַ������� 
	 */
	public String replaceSpace(StringBuffer str) 
	 {
		 int P1=str.length()-1;
		 for(int i=0;i<=P1;i++)
		 {
			 if(str.charAt(i)==' ')
			 {
				 str.append("  ");
			 }
		 }
		 int P2=str.length()-1;
		 while(P1!=P2)
		 {
			 if(str.charAt(P1)!=' ')
			 {
				 str.setCharAt(P2, str.charAt(P1));
				 P1--;
				 P2--;
			 }
			 else
			 {
				 P1--;
				 str.setCharAt(P2--, '0');
				 str.setCharAt(P2--, '2');
				 str.setCharAt(P2--, '%');
			 }
		 }
		 return str.toString();
	 }
}
