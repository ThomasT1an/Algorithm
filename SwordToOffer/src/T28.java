/*
 * P159面试题28：对称的二叉树
 * 请实现一个函数 用来判断一棵二叉树是不是对称的
 * 如果一棵二叉树和它的镜像一样 那么它是对称的
 */
public class T28
{
	/*
	 * 思路一：如果一棵二叉树是对称的
	 * 那么对于同一层的A B两个节点 A节点的左子树等于B节点的右子树 A节点的右子树等于B节点的左子树
	 * 递归的判断每一层直到均到达叶子节点
	 */
	boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot==null)
        	return true;
        return core(pRoot.left,pRoot.right);
    }
	private boolean core(TreeNode root1,TreeNode root2)
	{
		if(root1==null&&root2==null)
			return true;
		if(root1==null||root2==null)
			return false;
		if(root1.val!=root2.val)
			return false;
		return core(root1.left,root2.right)&&core(root1.right,root2.left);
	}
	/*
	 * 思路二：使用面试题27的方法求出这棵树的镜像后 对比两者是否完全一致
	 * 代码略
	 */
	/*
	 * 思路三：对于先序遍历而言 得到的序列是根节点、左、右
	 * 若自定义一个特殊的先序遍历 得到的序列是根节点、右、左排序
	 * 那么若两序列完全一致 这这棵树是对称的
	 * 同时也需要把空节点的位置考虑进去
	 */
}
