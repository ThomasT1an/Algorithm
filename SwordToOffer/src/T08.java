/*
 * P65面试题8：二叉树的下一个节点
 * 题目：给定一棵二叉树和其中的一个节点，如何找出中序遍历序列的下一个节点？
 * 树中的节点除了有两个分别指向左、右子节点的指针，还有一个指向父节点的指针
 */
public class T08
{
	/*
	 * 情况1：某节点有右子树，下一节点为右子树中的最左子节点
	 * 情况2：某节点无右子树，且为他父节点的左子节点 下一节点为父节点
	 * 情况3：某节点无右子树，且为他父节点的右子节点，则向上递归寻找它的父节点直到根节点或某个父节点是它自身父节点的左子节点（即情况2），这个父节点的父节点则为目标点
	 */
	public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
		if(pNode.right!=null)//情况1
        {
			TreeLinkNode res=pNode.right;
			while(res.left!=null)
        	{
        		res=res.left;
        	}
			return res;
        }
		
		//情况2、3
		else
		{
			TreeLinkNode res=pNode;
			while(res.next!=null)
			{
				if(res.next.left==res)
				{
					return res.next;
				}
				res=res.next;
			}
		}
		return null;
    }
}
