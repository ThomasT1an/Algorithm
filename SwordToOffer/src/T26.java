/*
 * P148面试题26：树的子结构
 * 题目：输入两棵二叉树A和B 判断B是不是A的子结构
 */
public class T26
{
	/*
	 * 思路：递归地在树A中查找与B的根节点的值一样的节点
	 * 之后再判断树A中以B根节点的值为根节点的子树是否与B树具有相同的结构
	 * 同样使用递归的思路 如果节点R的值和树B的根节点不相同 则肯定不具有相同的节点
	 * 如果值相同 则递归地判断它们各自的左右节点的值是不是相同
	 * 终止条件是 到达了树A或者树B的叶子节点
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
