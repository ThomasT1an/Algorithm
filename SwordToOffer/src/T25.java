/*
 * P145������25���ϲ��������������
 * ��Ŀ����������������������� �ϲ�����������ʹ�������еĽڵ���Ȼ�ǵ��������
 * ������������һ��1-3-5-7 �������2-4-6-8
 * ��ϲ�֮�������Ϊ1-2-3-4-5-6-7-8
 */
public class T25
{
	/*
	 * ����
	 */
	public ListNode Merge(ListNode list1, ListNode list2)
	{
		ListNode head=new ListNode(-1);
		ListNode temp=head;
		while(list1!=null&&list2!=null)
		{
			if(list1.val>list2.val)
			{
				head.next=list2;
				list2=list2.next;
				head=head.next;
			}
			else
			{
				head.next=list1;
				list1=list1.next;
				head=head.next;
			}
		}
		if(list1!=null)
			head.next=list1;
		if(list2!=null)
			head.next=list2;
		return temp.next;
	}
}
