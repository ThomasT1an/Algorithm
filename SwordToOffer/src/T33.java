/*
 * P179面试题33：二叉搜索树的后序遍历序列
 * 题目：输入一个整数数组 判断该数组是不是某二叉搜索树的后序遍历结果
 * 假设输入的数组的任意两个数字都互不相同
 */
public class T33
{
	/*
	 * 	思路：后序遍历的最后一个数就是根节点
	 * 根据根节点的值可以确认左右子树 值小于根节点的就是左子树 大于的就是右子树
	 * 通过递归的方式处理 确定每一部分对应的子树的结构
	 */
	public boolean VerifySquenceOfBST(int [] sequence) 
	{
        if(sequence.length==0)
        	return false;
        return Core(sequence,0,sequence.length-1);
    }
	private boolean Core(int sequence[],int first,int last)
	{
		//当递归进行到某个叶子节点时 递归终止 叶子节点没有子节点 所以可以用下标间的距离判断
		if(last-first<2)
			return true;
		int rootnow=sequence[last];
		int left=first;
		while(left<last&&sequence[left]<rootnow)
			left++;//找到当前根节点的左子树的所有节点 这些节点都会小于根节点
		for(int i=left;i<last;i++)
			if(sequence[i]<rootnow)
				return false;//检查当前根节点的右子树的所有节点 若这些节点有小于根节点的值 那么不可能是一个二叉搜索树的后序遍历
		return Core(sequence,first,left-1)&&Core(sequence,left,last-1);//再去递归的判断左子树和右子树
	}
}
