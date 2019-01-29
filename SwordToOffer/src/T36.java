/*
 * P191������36��������������˫������
 * ��Ŀ������һ�ö��������� ���ö���������ת����һ�������˫������
 * Ҫ���ܴ����κ��µĽڵ� ֻ�ܵ������нڵ�ָ���ָ��	
 */
public class T36
{
	/*
	 * �ݹ��� �Ը��ڵ���� ������������С���� �������������� ����һ����������� ��������ڵ��next����pre��ָ����������
	 * ������TreeNode����˫������ ���ڸ��ڵ��pre ��Ӧ��ָ���������е����ڵ� �������������Ѿ��Ǵ���õ�˫������
	 * ��ô�������һ��Ԫ�ؾ�����Ҫ�� ���ڸ��ڵ��next ��Ӧ��ָ���������е���С�ڵ� ͬ������Ѿ������ ��ô���ĵ�һ��Ԫ�ؾ�����Ҫ��
	 * 
	 * ��ԭ���и������ӽ��з��� �ȷ������ڵ�10�������� 6 4 8
	 * �γɵ�˫������Ӧ��Ϊ4===6===8 Ŀǰ6����4��6����8�������Ѿ����� 
	 * ������Ҫ��ȫ4ָ��6�� ��8ָ��6��
	 * ������ĳ���� ���ӽڵ��ΪҶ�ӽڵ�ĸ��ڵ���� ��Ҫ��������ڵ��next����right�����ҽڵ��pre����left��ָ������
	 * 
	 * �����ڽڵ�10�����Ľڵ���� ����preӦ��ָ��8 ��8������������������˫�����������һ���ڵ�
	 * ����nextӦ��ָ��12 ��12������������������˫�������ĵ�һ���ڵ�
	 * ���� �� ���ӽڵ��ΪҶ�ӽڵ�ĸ��ڵ���ǵݹ鴦�����ײ�
	 */
	public TreeNode Convert(TreeNode pRootOfTree)
	{
		if (pRootOfTree == null)
			return null;
		if (pRootOfTree.left != null)
		{
			if (pRootOfTree.left.left == null && pRootOfTree.left.right == null)
				pRootOfTree.left.right = pRootOfTree;
			else
			{
				Convert(pRootOfTree.left);
				if (pRootOfTree.left.right != null)
					pRootOfTree.left = pRootOfTree.left.right;
				pRootOfTree.left.right = pRootOfTree;
			}
		}
		if (pRootOfTree.right != null)
		{
			if (pRootOfTree.right.left == null && pRootOfTree.right.right == null)
				pRootOfTree.right.left = pRootOfTree;
			else
			{
				Convert(pRootOfTree.right);
				if (pRootOfTree.right.left != null)
					pRootOfTree.right = pRootOfTree.right.left;
				pRootOfTree.right.left = pRootOfTree;
			}
		}
		return findLeft(pRootOfTree);
	}
	private TreeNode findLeft(TreeNode root)
	{
		while (root.left != null)
			root = root.left;
		return root;
	}
}
