/*
 * P119������18��ɾ������Ľڵ�
 * ��Ŀһ����O(1)ʱ����ɾ������ڵ�
 * �������������ͷָ���һ���ڵ�ָ�� ����һ��������O��1��ʱ����ɾ���ýڵ�
 */
public class T18_1
{
	/*
	 * ˼·������ýڵ㲻��β�ڵ� ��ô����ɾ�ڵ����һ���ڵ��ֵ������ɾ�ڵ�
	 * Ҳ�͵��ڽ���ɾ�ڵ��ֵ���ǵ���
	 * ֮�󽫸ýڵ㣨��ɾ�ڵ㣩����һ�ڵ�ָ���������¸��ڵ�
	 * ����ýڵ���β�ڵ� ��ô����������� �ҵ�����ǰһ���ڵ� Ȼ����ǰһ���ڵ�ָ��null
	 * ���� �ܵ�ƽ��ʱ�临�Ӷ�����O(1)
	 */
	public ListNode deleteNode(ListNode head, ListNode tobeDelete) 
	{
		if(head==null||tobeDelete==null)
			return null;
		if(tobeDelete.next!=null)
		{
			ListNode temp=tobeDelete.next;
			tobeDelete.val=temp.val;
			tobeDelete.next=temp.next;
		}
		else
		{
			ListNode temp=head;
			while(temp.next!=tobeDelete)
				temp=temp.next;
			temp.next=null;
		}
		return head;
	}
}
