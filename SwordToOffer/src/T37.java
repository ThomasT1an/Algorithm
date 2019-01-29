/*
 * P194������37�����л�������
 * ��ʵ���������� �ֱ��������л��ͷ����л�������
 */
public class T37
{
	/*
	 * 1. �������л���ʹ��ǰ��������ݹ�Ľ���������ֵת��Ϊ�ַ���������ÿ�ζ������Ľ��
		��Ϊ��ʱ����ת��val���õ��ַ�֮�����һ��'   '��Ϊ�ָ���ڿսڵ����� '#' ���档
		2. ���ڷ����л�������ǰ��˳�򣬵ݹ��ʹ���ַ����е��ַ�����һ��������
		
		����������һ�ö�������
						1
				2				3
			4				5       6
		���������л����ַ���
		"1 2 4 # # # 3 5 # # 6 # #"
		���Ļ�ԭ����Ϊ��
		���ζ���ÿһ������ �õݹ�ķ�ʽ��ԭÿһ���ӽڵ� ÿʹ��һ��Ԫ�� ʹ�ַ����±�+1
	 */
	String Serialize(TreeNode root)
	{
		if(root==null)
			return "#";
		return root.val+" "+Serialize(root.left)+" "+Serialize(root.right);
	}
	private int index=-1;//��¼��ǰ�±�λ�� ÿ�η����л�һ���ڵ� ��ʹ�ַ���ǰ��һ��λ��
	TreeNode Deserialize(String str)
	{
		if(str.length() == 0)
            return null;
        String[] strs = str.split(" ");//���ڽڵ�ֵ���ܳ��ֶ�λ�� ���Բ��ܼ򵥵�ʹindex++ ���ַ����������õ�ÿһ���ڵ��ֵ
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
