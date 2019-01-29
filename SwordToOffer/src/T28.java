/*
 * P159������28���ԳƵĶ�����
 * ��ʵ��һ������ �����ж�һ�ö������ǲ��ǶԳƵ�
 * ���һ�ö����������ľ���һ�� ��ô���ǶԳƵ�
 */
public class T28
{
	/*
	 * ˼·һ�����һ�ö������ǶԳƵ�
	 * ��ô����ͬһ���A B�����ڵ� A�ڵ������������B�ڵ�������� A�ڵ������������B�ڵ��������
	 * �ݹ���ж�ÿһ��ֱ��������Ҷ�ӽڵ�
	 */
	boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot==null)
        	return true;
        return core(pRoot.left,pRoot.right);
    }
	private boolean core(TreeNode root1,TreeNode root2)
	{
		if(root1==null&&root2==null)
			return true;
		if(root1==null||root2==null)
			return false;
		if(root1.val!=root2.val)
			return false;
		return core(root1.left,root2.right)&&core(root1.right,root2.left);
	}
	/*
	 * ˼·����ʹ��������27�ķ������������ľ���� �Ա������Ƿ���ȫһ��
	 * ������
	 */
	/*
	 * ˼·������������������� �õ��������Ǹ��ڵ㡢����
	 * ���Զ���һ�������������� �õ��������Ǹ��ڵ㡢�ҡ�������
	 * ��ô����������ȫһ�� ��������ǶԳƵ�
	 * ͬʱҲ��Ҫ�ѿսڵ��λ�ÿ��ǽ�ȥ
	 */
}
