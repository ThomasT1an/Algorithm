/*
 * P89面试题12：矩阵中的路径
 * 题目：请设计一个函数 用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径
 * 路径可以从矩阵中的任意一格开始 每一步可以向上下左右任意移动一格
 * 不能重复进入某个格子
 * 例如 
 * a b c e 
 * s f c s 
 * a d e e 
 * 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径
 * 但是矩阵中不包含"abcb"路径
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子
 */
public class T12
{
	/*
	 * 思路：首先遍历这个矩阵 找到与目标字符串str的首字符相同的矩阵元素ch 将ch作为起点
	 * 遍历ch的上下左右四个字符 如果有何str中的下一个字符相同的
	 * 就把那个字符划入路径的下一步 若走到某一步时 这一步的上下左右均没有str的下一个字符
	 * 那么就需要回退到当前路径的上一步去重新选择 因为矩阵中可以出现重复元素
	 * 所以说每一步可能不止有一个选择
	 * 同时为了避免重复访问 需要设置visit矩阵记录每个元素的访问情况
	 * 在回退时 也要将visit矩阵中这个元素的状态回退为未访问
	 * 一直重复这个过程 直到路径中所有字符都在矩阵中找到相应的位置
	 */
	private int rows;
	private int cols;//记录矩阵的规格
	public boolean hasPath(char[] array, int rows, int cols, char[] str)
    {
		if(array==null||rows<1||cols<1||str==null)
		{
			return false;
		}
		this.rows=rows;
		this.cols=cols;
		boolean visit[][]=new boolean[rows][cols];
		/*
		 * 原书中给出的矩阵实际上为一维矩阵 通过将row与col相乘再加上col来寻找当前元素
		 * 将其重建为二维矩阵 可以更为直观的表示寻找过程
		 */
		char matrix[][]=new char[rows][cols];
		int rebuildindex=0;
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				matrix[i][j]=array[rebuildindex++];
			}
		}
		//重建完成
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				if(hasPathCore(matrix,str,visit,0,i,j))//从每个位置开始尝试
				{
					return true;
				}
			}
		}
		return false;
    }
	private boolean hasPathCore(char[][] matrix,char[] str,boolean[][] visit,int pathLen,int rownow,int colnow)
	{
		//注意！ 该if与下一个if位置不能颠倒 因为下一个if中会访问str[pathLen]
		if(str.length==pathLen)
		{
			return true;//成功条件 即每个str都找到对应的位置
		} 
		/*
		 * 若当前位置元素不为当前步骤的str元素 或当前位置元素已经被访问 或超出边界
		 * 超出边界的情况应最先判断 不然会数组越界
		 */
		if(rownow<0||rownow>=rows||colnow<0||colnow>=cols||matrix[rownow][colnow]!=str[pathLen]||visit[rownow][colnow])
		{
			return false;
		}	
		visit[rownow][colnow]=true;
		if(hasPathCore(matrix,str,visit,pathLen+1,rownow-1,colnow)||//上
				hasPathCore(matrix,str,visit,pathLen+1,rownow+1,colnow)||//下
				hasPathCore(matrix,str,visit,pathLen+1,rownow,colnow-1)||//左
				hasPathCore(matrix,str,visit,pathLen+1,rownow,colnow+1))//右
		{
			return true;
		}
		visit[rownow][colnow]=false;//回退
		return false;
	}
}
