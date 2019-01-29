/*
 * P157面试题27：二叉树的镜像
 * 完成一个二叉树 该函数输出它的镜像	
 */
public class T27
{
	/*
	 * 逐层递归
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
