import java.util.ArrayList;

/*
 * P182������34���������к�Ϊĳһֵ��·��
 * ��Ŀ������һ�ö�������һ������ ��ӡ���������нڵ�ֵ�ĺ�Ϊ��������������·��
 * �����ĸ��ڵ㿪ʼ����һֱ��Ҷ�ڵ��������Ľڵ��γ�һ��·��
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
		res.add(root.val);//�ȼ��赱ǰ�ڵ���·����
		target=target-root.val;
		if(target==0&&root.left==null&&root.right==null)//һֱ��Ҷ�ӽڵ�
			ret.add(new ArrayList<>(res));
		else
		{
			Core(root.left,target,res);
			Core(root.right,target,res);
		}
		res.remove(res.size()-1);//���������һ��ʱû��������� ��ô��˵�����֮ǰ������·���еĽڵ�ʵ���ϲ�Ӧ��·����
											   //��ô����ȥ�� �����ڻ��ݷ���˼��
	}
}
