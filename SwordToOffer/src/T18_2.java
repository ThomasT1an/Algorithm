/*
 * P122题目二：删除链表中重复的节点
 * 在一个排序的链表中 如何删除重复的节点？
 */
public class T18_2
{
	/*
	 * 需要考虑几种特殊情况
	 * 如 链表只有一个元素 重复的节点是头结点 某个节点重复多次的情况
	 * 用以下思路处理：
	 * 对某个节点 如果它的下个节点的值与它的值相等 那么说明该节点重复
	 * 对于重复的节点 如1-2-3-3-4  3出现2次 要将所有3删除 而不是留下1个
	 * 找到这个节点的下一个值不相等的节点 将这个节点的上一个节点的下一个节点指向这个找到的节点
	 * 那么这个已经处理过的节点是目前的“头结点” 将这个节点作为参数传入自身函数
	 * 递归地处理 直到到达最后一个节点
	 * 对于不重复的节点 将它的下一个节点作为参数
	 * 由于这两种情况的传入参数不同（一个为当前节点 一个为当前节点的下一个节点）
	 * 所以边界条件需要注意
	 */
	public ListNode deleteDuplication(ListNode pHead)
    {
		if(pHead==null||pHead.next==null)
		{
			return pHead;
		}
		ListNode next=pHead.next;
		if(pHead.val==next.val)
		{
			while(next!=null&&pHead.val==next.val)//需要先判断是否为空
			{
				next=next.next;//找到下一个
			}
			return deleteDuplication(next);
		}
		else
		{
			pHead.next=deleteDuplication(next);
			return pHead;
		}
    }
}
