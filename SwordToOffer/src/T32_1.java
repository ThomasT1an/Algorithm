import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * P171������32.1 ���ϵ��´�ӡ������
 * ��Ŀһ�������д��ϵ��´�ӡ������
 * ���ϵ��´�ӡ����������ÿ���ڵ� ͬһ��Ľڵ㰴�մ����ҵ�˳���ӡ
 */
public class T32_1
{
	/*
	 * ����������ʵ��
	 * ÿ�δ�ӡһ���ڵ��ʱ�� ����ýڵ����ӽڵ� ��Ѹýڵ���ӽڵ�ŵ�����ĩβ 
	 * �������Ӷ���ͷȡ�����������еĽڵ� ֱ�����������еĽڵ㶼����ӡ
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
