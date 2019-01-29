/*
 * P92������13�������˵��˶���Χ
 * ��Ŀ��������һ��m��n�еķ���һ�������˴����꣨0��0���ĸ��ӿ�ʼ�ƶ�
 * ��ÿ�ο��������������ƶ�һ�� �����ܽ�������������������λ֮�ʹ���k�ĸ���
 * ���� ��kΪ18ʱ �������ܹ����뷽��35��37����Ϊ3+5+3+7=18
 * �������ܽ��뷽��35��38����Ϊ��Ϊ19
 * ���ʸû������ܹ�������ٸ����ӣ�
 */
public class T13
{
	private int sum[][];
	int rows;
	int cols;
	int res;
	public int movingCount(int threshold, int rows, int cols)
    {
        this.rows=rows;
        this.cols=cols;
        this.sum=new int[rows][cols];
        //ֱ�ӽ�ÿ���������λ�����������
        for(int i=0;i<rows;i++)
        {
        	for(int j=0;j<cols;j++)
        	{
        		sum[i][j]=getSum(i)+getSum(j);
        	}
        }
        return res;
    }
	private int getSum(int num)
	{
		int res=0;
		while(num!=0)
		{
			res+=num%10;
			num=num/10;
		}
		return res;
	}
}
