/*
 * P89������12�������е�·��
 * ��Ŀ�������һ������ �����ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·��
 * ·�����ԴӾ����е�����һ��ʼ ÿһ���������������������ƶ�һ��
 * �����ظ�����ĳ������
 * ���� 
 * a b c e 
 * s f c s 
 * a d e e 
 * ������3 X 4 �����а���һ���ַ���"bcced"��·��
 * ���Ǿ����в�����"abcb"·��
 * ��Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���ø���
 */
public class T12
{
	/*
	 * ˼·�����ȱ���������� �ҵ���Ŀ���ַ���str�����ַ���ͬ�ľ���Ԫ��ch ��ch��Ϊ���
	 * ����ch�����������ĸ��ַ� ����к�str�е���һ���ַ���ͬ��
	 * �Ͱ��Ǹ��ַ�����·������һ�� ���ߵ�ĳһ��ʱ ��һ�����������Ҿ�û��str����һ���ַ�
	 * ��ô����Ҫ���˵���ǰ·������һ��ȥ����ѡ�� ��Ϊ�����п��Գ����ظ�Ԫ��
	 * ����˵ÿһ�����ܲ�ֹ��һ��ѡ��
	 * ͬʱΪ�˱����ظ����� ��Ҫ����visit�����¼ÿ��Ԫ�صķ������
	 * �ڻ���ʱ ҲҪ��visit���������Ԫ�ص�״̬����Ϊδ����
	 * һֱ�ظ�������� ֱ��·���������ַ����ھ������ҵ���Ӧ��λ��
	 */
	private int rows;
	private int cols;//��¼����Ĺ��
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
		 * ԭ���и����ľ���ʵ����Ϊһά���� ͨ����row��col����ټ���col��Ѱ�ҵ�ǰԪ��
		 * �����ؽ�Ϊ��ά���� ���Ը�Ϊֱ�۵ı�ʾѰ�ҹ���
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
		//�ؽ����
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				if(hasPathCore(matrix,str,visit,0,i,j))//��ÿ��λ�ÿ�ʼ����
				{
					return true;
				}
			}
		}
		return false;
    }
	private boolean hasPathCore(char[][] matrix,char[] str,boolean[][] visit,int pathLen,int rownow,int colnow)
	{
		//ע�⣡ ��if����һ��ifλ�ò��ܵߵ� ��Ϊ��һ��if�л����str[pathLen]
		if(str.length==pathLen)
		{
			return true;//�ɹ����� ��ÿ��str���ҵ���Ӧ��λ��
		} 
		/*
		 * ����ǰλ��Ԫ�ز�Ϊ��ǰ�����strԪ�� ��ǰλ��Ԫ���Ѿ������� �򳬳��߽�
		 * �����߽�����Ӧ�����ж� ��Ȼ������Խ��
		 */
		if(rownow<0||rownow>=rows||colnow<0||colnow>=cols||matrix[rownow][colnow]!=str[pathLen]||visit[rownow][colnow])
		{
			return false;
		}	
		visit[rownow][colnow]=true;
		if(hasPathCore(matrix,str,visit,pathLen+1,rownow-1,colnow)||//��
				hasPathCore(matrix,str,visit,pathLen+1,rownow+1,colnow)||//��
				hasPathCore(matrix,str,visit,pathLen+1,rownow,colnow-1)||//��
				hasPathCore(matrix,str,visit,pathLen+1,rownow,colnow+1))//��
		{
			return true;
		}
		visit[rownow][colnow]=false;//����
		return false;
	}
}
