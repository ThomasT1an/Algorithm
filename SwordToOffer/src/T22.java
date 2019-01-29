/*
 * P134面试题22：链表中倒数第k个节点
 * 题目：输入一个链表 输出该链表中倒数第k个节点
 * 从1开始计数 即链表的尾节点是倒数第一个节点
 */
public class T22
{
	/*
	 * 思路：假设整个链表有n个节点 那么倒数第k个节点就是正数的n-k+1个节点
	 * 所以只要知道了节点总个数n 那么再往后走n-k+1步就可以了 这样需要遍历2次链表
	 * 第一次统计出总结点个数 第二遍找到倒数第k个节点
	 * 也有只需要遍历一次链表的方法：
	 * 设置两个指针p1与p2 他们初始都指向头结点
	 * 此时若要找的是倒数第k个节点
	 * 那么指针p1先出发走k-1步
	 * 之后从第k步开始 p1走一步 p2也走一步 他们之间的距离保持k-1步
	 * 直到p1到达尾节点时 p2刚好到达倒数第k个节点 因为n-（k-1）为n-k+1 为正数的第n-k+1个节点
	 * 还需要考虑越界的情况 比如只有五个节点的链表  要求返回倒数第六个节点
	 */
	public ListNode FindKthToTail(ListNode head,int k) 
	{
		if(head==null||k==0)
			return null;
		ListNode p1=head;
		for(int i=0;i<k-1;i++)
			p1=p1.next;
		if(p1==null)
			return null;
		ListNode p2=head;
		while(p1.next!=null)
		{
			p1=p1.next;
			p2=p2.next;
		}
		return p2;
    }	
}
