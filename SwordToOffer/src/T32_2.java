import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * P174��Ŀ�������д��ϵ��´�ӡ������
 * ���ϵ��°����ӡ������ ͬһ��Ľڵ㰴�����ҵ�˳���ӡ ÿһ���ӡ��һ��
 */
public class T32_2
{
	/*
	 * ����һ������ ���Ǽ���һ������num��¼��ǰ��Ľڵ���
	 * ����
	 *      	   8
	 *   	6				10
	 *   5    7		9       11
	 *   ����� ��8�������ʱ ��������1��Ԫ�� ��¼numΪ1 
	 *   ÿ����ӡһ��Ԫ��ʱ num-1 ֱ��num=0
	 *   ��ʱ�ٴ�ͳ�ƶ�����Ԫ�ظ��� Ϊ2 ��ô�ٴ�ӡ2��Ԫ�غ��ٴ�ͳ��
	 *   ÿ��ͳ��ʱ���м���
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
