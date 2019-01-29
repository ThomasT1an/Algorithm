import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/*
 * P58������6:��β��ͷ��ӡ����
 * ��Ŀ������һ�������ͷ��㣬��β��ͷ��������ӡ��ÿ���ڵ��ֵ
 */
public class T06
{
	/*
	 * �ⷨһ��ʹ��ջ
	 * ����ջ�ġ�����ȳ����ԡ� ���������һ�α��������ε���
	 * �õ���˳��Ϊ����
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
	 * �ⷨ����ʹ�õݹ�
	 * �ݹ�ı��ʾ���һ��ջ�ṹ ���Կ�����Ȼ���뵽�õݹ���ʵ��
	 * ����ʵ��Ϊ��ÿ���ʵ�һ���ڵ��ʱ���ȵݹ����������Ľڵ㣬������ýڵ�����
	 * ���÷�����������������ȷǳ���ʱ
	 * �ᵼ�º������õĲ㼶����
	 * �Ӷ����º�������ջ�����java.lang.StackOverflowError��
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
	 * �ⷨ����ʹ��ͷ�巨
	 * ����ͷ�巨��������ÿ�β�����ͷ��
	 * ����ʹ��ͷ�巨���¹��������Ϊ����
	 * ע��㣺
	 * ͷ�������ͷ�巨��ʹ�õ�һ������ڵ㣬����ڵ㲻�洢ֵ
	 * ��һ���ڵ��������ĵ�һ�������洢ֵ�Ľڵ�
	 */
	public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) 
	{
		ListNode head=new ListNode(-1);//ͷ���
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
	 * �ⷨ�ģ�ʹ��Collection.reverse()
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
