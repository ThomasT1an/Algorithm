import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * P174题目二：分行从上到下打印二叉树
 * 从上到下按层打印二叉树 同一层的节点按从左到右的顺序打印 每一层打印到一行
 */
public class T32_2
{
	/*
	 * 和上一题类似 但是加入一个变量num记录当前层的节点数
	 * 例如
	 *      	   8
	 *   	6				10
	 *   5    7		9       11
	 *   这棵树 当8进入队列时 队列中有1个元素 记录num为1 
	 *   每当打印一个元素时 num-1 直到num=0
	 *   此时再次统计队列中元素个数 为2 那么再打印2个元素后再次统计
	 *   每次统计时换行即可
	 */
	ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) 
	{
		ArrayList<ArrayList<Integer>> res=new ArrayList<>();
		Queue<TreeNode> queue=new LinkedList<>();
		if(pRoot==null)
			return res;
		queue.add(pRoot);
		int num=queue.size();
		while(!queue.isEmpty())
		{
			ArrayList<Integer> row=new ArrayList<>();
			while(num!=0)
			{
				TreeNode temp=queue.poll();
				num--;
				row.add(temp.val);
				if(temp.left!=null)
					queue.add(temp.left);
				if(temp.right!=null)
					queue.add(temp.right);
			}
			res.add(row);
			num=queue.size();
		}
		return res;
    }	
}
