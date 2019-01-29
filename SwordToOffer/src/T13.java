/*
 * P92面试题13：机器人的运动范围
 * 题目：地上有一个m行n列的方格。一个机器人从坐标（0，0）的格子开始移动
 * 他每次可以向上下左右移动一格 但不能进入行坐标和列坐标的数位之和大于k的格子
 * 例如 当k为18时 机器人能够进入方格（35，37）因为3+5+3+7=18
 * 但它不能进入方格（35，38）因为和为19
 * 请问该机器人能够到达多少个格子？
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
        //直接将每个方格的数位和算出并保留
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
