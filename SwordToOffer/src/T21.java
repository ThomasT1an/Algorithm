/*
 * P129������21����������˳��ʹ����λ��ż��ǰ��
 * ��Ŀ������һ���������� ʵ��һ�����������������������ֵ�˳��
 * ʹ����������λ�������ǰ�벿�� ����ż��λ������ĺ�벿��
 * ����֤������������ż����ż��֮������λ�ò��䣨ţ��������������
 */
public class T21
{
	/*
	 * ˼·һ��ʹ������ָ�� ����Ҫ��֤���������� ż����ż��֮������λ�ò���
	 * ���ܰ���ԭ���еķ������� ��������˳��
	 * ֻ�ܽ������ڵ�Ԫ�� ������ڵ�Ԫ��Ϊǰż���� ��ô��������
	 */
	public void reOrderArray1(int [] array) 
	{
        for(int i=0;i<array.length;i++)
        {
        	for(int j=array.length-1;j>i;j--)
        	{
        		if(array[j-1]%2==0&&array[j]%2==1)
        		{
        			int temp=array[j-1];
        			array[j-1]=array[j];
        			array[j]=temp;
        		}
        	}
        }	
    }
/*
 * ��һ���ÿռ任ʱ��ķ����ǽ���һ��������
 * ͳ��ԭ�����������ĸ��� 
 * �������������������Ϊ�ֽ��� ����ԭ���� ��������������������ײ�
 * ����ż�������������ķֽ���֮��
 */
	public void reOrderArray2(int [] array)
	{
		int count=0;//��������
		for(int i=0;i<array.length;i++)
		{
			if(array[i]%2==1)
				count++;
		}
		int[] copy = array.clone();
	    int a= 0;
	    for(int i=0;i<copy.length;i++)
	    {
	    	if(copy[i]%2==1)
	    		array[a++]=copy[i];
	    	else
	    		array[count++]=copy[i];
	    }
	}
}
