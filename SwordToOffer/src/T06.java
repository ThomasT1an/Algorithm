import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/*
 * P58面试题6:从尾到头打印链表
 * 题目：输入一个链表的头结点，从尾到头反过来打印出每个节点的值
 */
public class T06
{
	/*
	 * 解法一：使用栈
	 * 由于栈的“后进先出特性” 对链表进行一次遍历后依次弹出
	 * 得到的顺序即为逆序
	 */
	public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) 
	{
		Stack<Integer> stack=new Stack<Integer>();
		while(listNode!=null)
		{
			stack.add(listNode.val);
			listNode=listNode.next;
		}
		ArrayList<Integer> res=new ArrayList<Integer>();
		while(!stack.isEmpty())
		{
			res.add(stack.pop());
		}
		return res;
    }
	
	/*
	 * 解法二：使用递归
	 * 递归的本质就是一个栈结构 所以可以自然地想到用递归来实现
	 * 具体实现为：每访问到一个节点的时候，先递归输出它后面的节点，再输出该节点自身
	 * 但该方法若是输入的链表长度非常长时
	 * 会导致函数调用的层级过深
	 * 从而导致函数调用栈溢出（java.lang.StackOverflowError）
	 */
	public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) 
	{
		ArrayList<Integer> res=new ArrayList<Integer>();
		if(listNode!=null)
		{
			res.addAll(printListFromTailToHead2(listNode.next));
			res.add(listNode.val);
		}
		return res;
	}
	
	/*
	 * 解法三：使用头插法
	 * 由于头插法的性质是每次插入在头部
	 * 所以使用头插法重新构建链表后即为逆序
	 * 注意点：
	 * 头结点是在头插法中使用的一个额外节点，这个节点不存储值
	 * 第一个节点就是链表的第一个真正存储值的节点
	 */
	public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) 
	{
		ListNode head=new ListNode(-1);//头结点
		while(listNode!=null)
		{
			ListNode temp=new ListNode(listNode.val);
			temp.next=head.next;
			head.next=temp;
			listNode=listNode.next;
		}	
		ArrayList<Integer> res=new ArrayList<Integer>();
		head=head.next;
		while(head!=null)
		{
			res.add(head.val);
			head=head.next;
		}
		return res;
	}
	
	
	/*
	 * 解法四：使用Collection.reverse()
	 */
	public ArrayList<Integer> printListFromTailToHead4(ListNode listNode) 
	{
		ArrayList<Integer> res=new ArrayList<Integer>();
		while(listNode!=null)
		{
			res.add(listNode.val);
			listNode=listNode.next;
		}
		Collections.reverse(res);
		return res;
	}
}
