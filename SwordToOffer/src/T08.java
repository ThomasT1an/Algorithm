/*
 * P65������8������������һ���ڵ�
 * ��Ŀ������һ�ö����������е�һ���ڵ㣬����ҳ�����������е���һ���ڵ㣿
 * ���еĽڵ�����������ֱ�ָ�������ӽڵ��ָ�룬����һ��ָ�򸸽ڵ��ָ��
 */
public class T08
{
	/*
	 * ���1��ĳ�ڵ�������������һ�ڵ�Ϊ�������е������ӽڵ�
	 * ���2��ĳ�ڵ�������������Ϊ�����ڵ�����ӽڵ� ��һ�ڵ�Ϊ���ڵ�
	 * ���3��ĳ�ڵ�������������Ϊ�����ڵ�����ӽڵ㣬�����ϵݹ�Ѱ�����ĸ��ڵ�ֱ�����ڵ��ĳ�����ڵ����������ڵ�����ӽڵ㣨�����2����������ڵ�ĸ��ڵ���ΪĿ���
	 */
	public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
		if(pNode.right!=null)//���1
        {
			TreeLinkNode res=pNode.right;
			while(res.left!=null)
        	{
        		res=res.left;
        	}
			return res;
        }
		
		//���2��3
		else
		{
			TreeLinkNode res=pNode;
			while(res.next!=null)
			{
				if(res.next.left==res)
				{
					return res.next;
				}
				res=res.next;
			}
		}
		return null;
    }
}
