/*
 * P139面试题23：链表中环的入口节点
 * 题目：如果一个链表中包含环 如何找出环的入口节点？
 */
public class T23
{
	/*
	 * 分析链表中存在环的情况 假定有链表1-2-3-4-5-6 其中6又指向3
	 * 首先要明确的是 如果存在环 那么在链表中指向前面节点的节点 如例子中的节点6
	 * 这样的节点最多只可能有1个 且在末尾 因为链表的节点只有一个next域
	 * 那么此时设置两个指针 均从头结点出发
	 * 快指针每走2步 慢指针走1步 若链表中存在环 则他们必定会在某个节点上重合
	 * 我们假设 链表开始到环的入口 共有x个节点 从入口到相遇的节点 共有y个节点 从这个相遇的节点 再到入口 共有z个节点
	 * 那么对于快节点 他走了x+y+z+y步 由于快节点与慢节点每次只差1步
	 *  所以不存在“快节点在环中跑了很多圈才遇上慢节点”的情况
	 *  而对于慢节点 他走了x+y步
	 *  由于速度已经知道 所以2*慢节点步数=快节点步数 得到x=z
	 *  所以我们得到 链表开始到入口的节点个数 就是相遇处再走到入口的节点个数
	 *  我们在相遇处保留一个指针 另一个指针放回头结点 
	 *  之后两个指针每次都走1步 当他们相遇时 相遇的节点即为入口节点
	 */
	public ListNode EntryNodeOfLoop(ListNode pHead)
    {
		if (pHead == null || pHead.next == null)
	        return null;
		ListNode fast=pHead.next.next;
        ListNode slow=pHead.next;//两者均进行了第一次前进
        while(fast!=slow)
        {
        	fast=fast.next.next;
        	slow=slow.next;
        }
        slow=pHead;//将slow放回起点
        while(fast!=slow)
        {
        	fast=fast.next;
        	slow=slow.next;
        }
        return fast;
    }	
}
