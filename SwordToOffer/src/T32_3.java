import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/*
 * P176题目三：之字形打印二叉树
 * 请实现一个函数按照之字形打印二叉树
 * 即 第一行按照从左到右的顺序打印 第二行按照从右到左的顺序打印 第三行再按照从左到右的顺序打印
 * 其他行以此类推
 */
public class T32_3
{
	/*
	 * 按照上一题的方法实现
	 * 只需要设置一个值记录当前行数 若当前行为偶数 则颠倒当前行的顺序 
	 * 使用Collections.reverse函数 也可手动实现
	 */
	public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) 
	{
		ArrayList<ArrayList<Integer>> res=new ArrayList<>();
		Queue<TreeNode> queue=new LinkedList<>();
		if(pRoot==null)
			return res;
		queue.add(pRoot);
		int num=queue.size();
		int rownum=1;
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
			if(rownum%2==0)
			{
				Collections.reverse(row);
			}
			res.add(row);
			rownum++;
			num=queue.size();
		}
		return res;
    }	
}
