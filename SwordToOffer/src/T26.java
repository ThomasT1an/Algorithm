/*
 * P148������26�������ӽṹ
 * ��Ŀ���������ö�����A��B �ж�B�ǲ���A���ӽṹ
 */
public class T26
{
	/*
	 * ˼·���ݹ������A�в�����B�ĸ��ڵ��ֵһ���Ľڵ�
	 * ֮�����ж���A����B���ڵ��ֵΪ���ڵ�������Ƿ���B��������ͬ�Ľṹ
	 * ͬ��ʹ�õݹ��˼· ����ڵ�R��ֵ����B�ĸ��ڵ㲻��ͬ ��϶���������ͬ�Ľڵ�
	 * ���ֵ��ͬ ��ݹ���ж����Ǹ��Ե����ҽڵ��ֵ�ǲ�����ͬ
	 * ��ֹ������ ��������A������B��Ҷ�ӽڵ�
	 */
	public boolean HasSubtree(TreeNode root1, TreeNode root2)
	{
		if(root1==null||root2==null)
			return false;
		return DoesTree1HaveTree2(root1,root2)||HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
	}
	
	private boolean DoesTree1HaveTree2(TreeNode root1,TreeNode root2)
	{
		if(root2==null)
			return true;
		if(root1==null)
			return false;
		if(root1.val!=root2.val)
			return false;
		return DoesTree1HaveTree2(root1.left,root2.left)&&DoesTree1HaveTree2(root1.right,root2.right);
	}
}
