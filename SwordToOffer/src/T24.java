/*
 * P142面试题24：反转链表
 * 题目：定义一个函数 输入一个链表的头结点 反转该链表并输出反转后链表的头结点
 */
public class T24
{
	/*
	 * 迭代方法：从前往后依次处理 直到循环到达链尾
	 * 为防止链表断开 需要定义三个指针
	 * 分别指向当前遍历到的节点 它的前一个节点以及后一个节点
	 * 以原始链表1-->2-->3-->NULL为例
	 * 令指针P指向节点1 同时新建一个节点 赋值为-1 令指针newHead指向它
	 * 之后循环执行以下四步操作直到到达结尾
	 * 1. ListNode tmp=P.next  保存后续节点 
	 * 2. P.next=newHead  此时将1的next连向了-1
	 * 3. newHead=P  此时更改了newHead指针指向的位置 改为指向1
	 * 4.P=tmp
	 */
	public ListNode ReverseList(ListNode head) 
	{
		ListNode reverseList=new ListNode(-1);
		while(head!=null)
		{
			ListNode next=head.next;//保存后续节点
			head.next=reverseList.next;
			reverseList.next=head;
			head=next;
		}
		return reverseList.next;
    }	
	
	/*
	 * 递归是从链尾往链头翻转链表
	 * 通过递归走到链表的末端 之后逐层进行翻转
	 * 仍以原始链表1-->2-->3-->NULL为例
	 * 通过不断调用自身 在走到3时触发if语句 到达最底层 
	 * 此时将指针P与指针newHead指向3 因为3就是翻转之后的头结点 所以newHead指针自始至终都指向3 返回上一层
	 * 此时P指向2 触发else语句
	 * 将P指向的地址赋给P.next.next 即令3（就是P.next）的next连向2 那么此时2的next为3 3的next为2 成环
	 * 所以需要另P.next=null 断开2指向3 
	 * 之后P指向1 令2的next连向1 再断开1连向2
	 * 完成
	 */
	public ListNode ReverseList2(ListNode head)
	{
		if(head==null||head.next==null)
			return head;
		else
		{
			ListNode newHead=ReverseList2(head.next);
			head.next.next=head;
			head.next=null;
			return newHead;
		}
	}
}
