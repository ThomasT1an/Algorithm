/*
 * P145面试题25：合并两个排序的链表
 * 题目：输入两个递增排序的链表 合并这两个链表并使新链表中的节点仍然是递增排序的
 * 例如输入链表一：1-3-5-7 链表二：2-4-6-8
 * 则合并之后的链表为1-2-3-4-5-6-7-8
 */
public class T25
{
	/*
	 * 迭代
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
