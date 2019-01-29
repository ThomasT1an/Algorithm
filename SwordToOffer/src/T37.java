/*
 * P194面试题37：序列化二叉树
 * 请实现两个函数 分别用来序列化和反序列化二叉树
 */
public class T37
{
	/*
	 * 1. 对于序列化：使用前序遍历，递归的将二叉树的值转化为字符，并且在每次二叉树的结点
		不为空时，在转化val所得的字符之后添加一个'   '作为分割。对于空节点则以 '#' 代替。
		2. 对于反序列化：按照前序顺序，递归的使用字符串中的字符创建一个二叉树
		
		对于这样的一棵二叉树：
						1
				2				3
			4				5       6
		他将被序列化成字符串
		"1 2 4 # # # 3 5 # # 6 # #"
		他的还原过程为：
		依次读出每一个数字 用递归的方式还原每一个子节点 每使用一个元素 使字符串下标+1
	 */
	String Serialize(TreeNode root)
	{
		if(root==null)
			return "#";
		return root.val+" "+Serialize(root.left)+" "+Serialize(root.right);
	}
	private int index=-1;//记录当前下标位置 每次反序列化一个节点 就使字符串前进一个位置
	TreeNode Deserialize(String str)
	{
		if(str.length() == 0)
            return null;
        String[] strs = str.split(" ");//由于节点值可能出现多位数 所以不能简单的使index++ 用字符串数组来得到每一个节点的值
        return Deserialize2(strs);
	}
	TreeNode Deserialize2(String[] strs)
	{
		index++;
		if (!strs[index].equals("#"))
		{
			TreeNode root = new TreeNode(0);
			root.val = Integer.parseInt(strs[index]);
			root.left = Deserialize2(strs);
			root.right = Deserialize2(strs);
			return root;
		}
		return null;
    }
}
