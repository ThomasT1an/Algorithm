/*
 * P157������27���������ľ���
 * ���һ�������� �ú���������ľ���	
 */
public class T27
{
	/*
	 * ���ݹ�
	 */
	public void Mirror(TreeNode root)
	{
		if(root==null)
			return;
		swap(root);
		Mirror(root.left);
		Mirror(root.right);
	}
	private void swap(TreeNode root)
	{
		TreeNode temp=root.left;
		root.left=root.right;
		root.right=temp;
	}
}
