
import java.util.HashMap;
import java.util.Map;

/*
 * P62������7���ؽ�������
 * ��Ŀ������ĳ��������ǰ���������������Ľ�������ؽ��ö�����
 */
public class T07
{
	private Map<Integer,Integer> inOrders=new HashMap<Integer,Integer>();
	public TreeNode reConstructBinaryTree(int[] pre, int[] in)
	{
		for(int i=0;i<in.length;i++)
		{
			inOrders.put(in[i], i);//���������������ÿ��ֵ��Ӧ������
		}
		return core(pre,0,pre.length-1,0);
		/*
		 * ǰ���������1 2 4 7 3 5 6 8
		 * �����������4 7 2 1 5 3 8 6����
		 */
	}
	
	private TreeNode core(int pre[],int preL,int preR,int inL)
	{
		if(preL>preR)
		{
			return null;
		}
		TreeNode root=new TreeNode(pre[preL]);//���ڵ�Ϊǰ������ĵ�һ��ֵ
		int inIndex=inOrders.get(root.val);//������������ҵ���һ���ĸ��ڵ���±�
		int leftTreeSize=inIndex-inL;
		root.left=core(pre,preL+1,preL+leftTreeSize,inL);//����������
		/*
		 * ��һ�Σ�
		 * ��������������� �ҵ�ǰ������ĵ�һ��Ԫ�ء�1�����±�Ϊ3
		 * ��ô���ڵ�Ϊ1�������������������Ԫ������Ϊ3-0=3��
		 * �ڶ��Σ�
		 * ���������Ԫ������Ϊ3�������� ������ǰ��������������ı�������������
		 * ����preL+1 Ҳ����ǰ���������һ��Ԫ�� ��Ϊ������ĸ��ڵ� 
		 * preR�������Ԫ�ص��յ� ����preL+������Ĺ�ģ
		 * inL�ڹ����������н���
		 */
		root.right=core(pre,preL+leftTreeSize+1,preR,inL+leftTreeSize+1);//����������
		/*
		 * ��һ�Σ�
		 * �ҵ���1�����±�3֮��
		 * ����������ĸ��ڵ㣨Ҳ������ǰ��������е���㣩Ϊ��ʼ���λ��+��������ģ+1
		 * ������5 3 8 6�������˵ Ҫ�����ĸ��ڵ�
		 * ��Ҫ��ǰ�����������ƫ��0+3+1��λ�� ����ǰ������е��±�Ϊ4
		 * preR���� ��Ϊ��ǰ����������� ��������Զ��ĩβ
		 * inL�������������Ĺ�ģ+1����Ϊ
		 * ��3 5 6 8������� ȥ�����������3���±� ����Ϊ5
		 * ��ø��ڵ�Ϊ3���� �����������Ĺ�ģ�ڼ���ʱ��Ҫ֪������������
		 * ������������ ����ȥ������ͬһ��ȵ����ֵ����Ĺ�ģ �ټ�ȥ���ĸ��ڵ�ռ�õ�1��λ��
		 * ����inL�������ڹ���������ʱ�����ģ��ƫ�Ƽ�¼��
		 * ���ڹ���������ʱ���ƫ��������Ҫ�仯����Ϊ�������������������ͷ�� ���Ը��ڵ���±�λ�õ����־����������Ĺ�ģ
		 * �������û������Ԫ��ռ��λ��
		 */
		return root;
	}
}