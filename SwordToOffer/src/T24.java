/*
 * P142������24����ת����
 * ��Ŀ������һ������ ����һ�������ͷ��� ��ת�����������ת�������ͷ���
 */
public class T24
{
	/*
	 * ������������ǰ�������δ��� ֱ��ѭ��������β
	 * Ϊ��ֹ����Ͽ� ��Ҫ��������ָ��
	 * �ֱ�ָ��ǰ�������Ľڵ� ����ǰһ���ڵ��Լ���һ���ڵ�
	 * ��ԭʼ����1-->2-->3-->NULLΪ��
	 * ��ָ��Pָ��ڵ�1 ͬʱ�½�һ���ڵ� ��ֵΪ-1 ��ָ��newHeadָ����
	 * ֮��ѭ��ִ�������Ĳ�����ֱ�������β
	 * 1. ListNode tmp=P.next  ��������ڵ� 
	 * 2. P.next=newHead  ��ʱ��1��next������-1
	 * 3. newHead=P  ��ʱ������newHeadָ��ָ���λ�� ��Ϊָ��1
	 * 4.P=tmp
	 */
	public ListNode ReverseList(ListNode head) 
	{
		ListNode reverseList=new ListNode(-1);
		while(head!=null)
		{
			ListNode next=head.next;//��������ڵ�
			head.next=reverseList.next;
			reverseList.next=head;
			head=next;
		}
		return reverseList.next;
    }	
	
	/*
	 * �ݹ��Ǵ���β����ͷ��ת����
	 * ͨ���ݹ��ߵ������ĩ�� ֮�������з�ת
	 * ����ԭʼ����1-->2-->3-->NULLΪ��
	 * ͨ�����ϵ������� ���ߵ�3ʱ����if��� ������ײ� 
	 * ��ʱ��ָ��P��ָ��newHeadָ��3 ��Ϊ3���Ƿ�ת֮���ͷ��� ����newHeadָ����ʼ���ն�ָ��3 ������һ��
	 * ��ʱPָ��2 ����else���
	 * ��Pָ��ĵ�ַ����P.next.next ����3������P.next����next����2 ��ô��ʱ2��nextΪ3 3��nextΪ2 �ɻ�
	 * ������Ҫ��P.next=null �Ͽ�2ָ��3 
	 * ֮��Pָ��1 ��2��next����1 �ٶϿ�1����2
	 * ���
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
