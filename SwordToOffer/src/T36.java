/*
 * P191面试题36：二叉搜索树与双向链表
 * 题目：输入一棵二叉搜索树 将该二叉搜索树转换成一个排序的双向链表
 * 要求不能创建任何新的节点 只能调整数中节点指针的指向	
 */
public class T36
{
	/*
	 * 递归解决 对根节点而言 他的左子树都小于他 右子树都大于他 即是一个排序的序列 将这个根节点的next域与pre域指向左、右子树
	 * 本题用TreeNode代替双向链表 对于根节点的pre 它应该指向左子树中的最大节点 如果这棵左子树已经是处理好的双向链表
	 * 那么它的最后一个元素就是想要的 对于根节点的next 它应该指向右子树中的最小节点 同样如果已经处理好 那么它的第一个元素就是想要的
	 * 
	 * 用原题中给的例子进行分析 先分析根节点10的左子树 6 4 8
	 * 形成的双向链表应该为4===6===8 目前6连向4和6连向8的连接已经存在 
	 * 所以需要补全4指向6的 和8指向6的
	 * 即：对某个左 右子节点均为叶子节点的根节点而言 需要让他的左节点的next（即right）和右节点的pre（即left）指向自身
	 * 
	 * 而对于节点10这样的节点而言 他的pre应该指向8 而8是他的左子树构建成双向链表后的最后一个节点
	 * 他的next应该指向12 而12是他的右子树构建成双向链表后的第一个节点
	 * 所以 左 右子节点均为叶子节点的根节点就是递归处理的最底层
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
