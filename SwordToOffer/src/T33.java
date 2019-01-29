/*
 * P179������33�������������ĺ����������
 * ��Ŀ������һ���������� �жϸ������ǲ���ĳ�����������ĺ���������
 * �������������������������ֶ�������ͬ
 */
public class T33
{
	/*
	 * 	˼·��������������һ�������Ǹ��ڵ�
	 * ���ݸ��ڵ��ֵ����ȷ���������� ֵС�ڸ��ڵ�ľ��������� ���ڵľ���������
	 * ͨ���ݹ�ķ�ʽ���� ȷ��ÿһ���ֶ�Ӧ�������Ľṹ
	 */
	public boolean VerifySquenceOfBST(int [] sequence) 
	{
        if(sequence.length==0)
        	return false;
        return Core(sequence,0,sequence.length-1);
    }
	private boolean Core(int sequence[],int first,int last)
	{
		//���ݹ���е�ĳ��Ҷ�ӽڵ�ʱ �ݹ���ֹ Ҷ�ӽڵ�û���ӽڵ� ���Կ������±��ľ����ж�
		if(last-first<2)
			return true;
		int rootnow=sequence[last];
		int left=first;
		while(left<last&&sequence[left]<rootnow)
			left++;//�ҵ���ǰ���ڵ�������������нڵ� ��Щ�ڵ㶼��С�ڸ��ڵ�
		for(int i=left;i<last;i++)
			if(sequence[i]<rootnow)
				return false;//��鵱ǰ���ڵ�������������нڵ� ����Щ�ڵ���С�ڸ��ڵ��ֵ ��ô��������һ�������������ĺ������
		return Core(sequence,first,left-1)&&Core(sequence,left,last-1);//��ȥ�ݹ���ж���������������
	}
}
