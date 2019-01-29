import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * P171面试题32.1 从上到下打印二叉树
 * 题目一：不分行从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点 同一层的节点按照从左到右的顺序打印
 */
public class T32_1
{
	/*
	 * 借助队列来实现
	 * 每次打印一个节点的时候 如果该节点有子节点 则把该节点的子节点放到队列末尾 
	 * 接下来从队列头取出最早进入队列的节点 直到队列中所有的节点都被打印
	 */
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) 
	{
		ArrayList<Integer> res=new ArrayList<>();
		Queue<TreeNode> queue=new LinkedList<>();
		if(root==null)
			return res;
		queue.add(root);
		while(!queue.isEmpty())
		{
			TreeNode temp=queue.poll();
			res.add(temp.val);
			if(temp.left!=null)
				queue.add(temp.left);
			if(temp.right!=null)
				queue.add(temp.right);
		}
		return res;
    }	
}
