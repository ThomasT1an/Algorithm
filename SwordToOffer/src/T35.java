/*
 * P187面试题35：复杂链表的复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）
 * 返回结果为复制后复杂链表的head（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
/*
 * 思路：可以先将链表复制一遍 这一遍复制中将next域连接完成 而对于random域 由于对于某个节点而言 他的random可能指向
 * 它前面的节点 也可能指向它后面的节点 所以只能通过再遍历一遍链表的方式找到这个节点并连接上
 * 对每个节点都要遍历一遍链表 时间复杂度为O(n^2)
 * 
 * 上述方法的时间主要花费在定位random指向的节点上 所以在第一步复制时 将节点N与它的复制N'的配对信息存储在哈希表中
 * 这样如果在原始链表中N的random指向S 那么对应的N'应指向S' 通过S与S'的配对信息 就可以通过S找到S'
 * 时间复杂度O(n) 但需要额外的空间（n）
 * 
 * 使用的方法是 在复制链表时 直接将新节点连接在老节点后
 * 即：1--1'--2--2'--3--3'--4--4'..........
 * 这样如果1的random指向3
 * 那么1'指向3'的设置非常简单 令1.next.rondom指向1.rondom.next即可
 * 最后再进行拆分 将偶数位的节点连接在一起即可
 */
public class T35
{
	public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null)
        	return null;
       //复制
        RandomListNode cur=pHead;
        while(cur!=null)
        {
        	RandomListNode temp=new RandomListNode(cur.label);
        	temp.next=cur.next;
        	cur.next=temp;
        	cur=cur.next.next;
        }
      //连接random
        cur=pHead;
        while(cur!=null)
        {
        	if(cur.random!=null)
        		cur.next.random=cur.random.next;
        	cur=cur.next.next;
        }
       //拆分
        cur=pHead;
       RandomListNode res=pHead.next;
       while(cur.next!=null)
       {
    	   RandomListNode next = cur.next;
           cur.next = next.next;
           cur = next;
       }
       return res;
    }
}
