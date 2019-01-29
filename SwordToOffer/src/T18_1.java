/*
 * P119面试题18：删除链表的节点
 * 题目一：在O(1)时间内删除链表节点
 * 给定单向链表的头指针和一个节点指针 定义一个函数在O（1）时间内删除该节点
 */
public class T18_1
{
	/*
	 * 思路：如果该节点不是尾节点 那么将待删节点的下一个节点的值赋给待删节点
	 * 也就等于将待删节点的值覆盖掉了
	 * 之后将该节点（待删节点）的下一节点指向他的下下个节点
	 * 如果该节点是尾节点 那么仍需遍历链表 找到他的前一个节点 然后让前一个节点指向null
	 * 综上 总的平均时间复杂度仍是O(1)
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
