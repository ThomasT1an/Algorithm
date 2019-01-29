import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/*
 * P176��Ŀ����֮���δ�ӡ������
 * ��ʵ��һ����������֮���δ�ӡ������
 * �� ��һ�а��մ����ҵ�˳���ӡ �ڶ��а��մ��ҵ����˳���ӡ �������ٰ��մ����ҵ�˳���ӡ
 * �������Դ�����
 */
public class T32_3
{
	/*
	 * ������һ��ķ���ʵ��
	 * ֻ��Ҫ����һ��ֵ��¼��ǰ���� ����ǰ��Ϊż�� ��ߵ���ǰ�е�˳�� 
	 * ʹ��Collections.reverse���� Ҳ���ֶ�ʵ��
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
