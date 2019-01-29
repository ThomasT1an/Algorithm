import java.util.ArrayList;

/*
 * P182面试题34：二叉树中和为某一值的路径
 * 题目：输入一棵二叉树和一个整数 打印出二叉树中节点值的和为输入整数的所有路径
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径
 */
public class T34
{
	private ArrayList<ArrayList<Integer>> ret=new ArrayList<>();
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) 
	{
		Core(root,target,new ArrayList<>());
		return ret;
    }
	private void Core(TreeNode root,int target,ArrayList<Integer> res)
	{
		if(root==null)
			return;
		res.add(root.val);//先假设当前节点在路径中
		target=target-root.val;
		if(target==0&&root.left==null&&root.right==null)//一直到叶子节点
			ret.add(new ArrayList<>(res));
		else
		{
			Core(root.left,target,res);
			Core(root.right,target,res);
		}
		res.remove(res.size()-1);//如果到达这一步时没有完成条件 那么就说明这个之前假设在路径中的节点实际上不应在路径中
											   //那么将它去掉 类似于回溯法的思想
	}
}
