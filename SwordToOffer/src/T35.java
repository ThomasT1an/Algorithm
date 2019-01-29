/*
 * P187������35����������ĸ���
 * ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩
 * ���ؽ��Ϊ���ƺ��������head��ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
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
 * ˼·�������Ƚ�������һ�� ��һ�鸴���н�next��������� ������random�� ���ڶ���ĳ���ڵ���� ����random����ָ��
 * ��ǰ��Ľڵ� Ҳ����ָ��������Ľڵ� ����ֻ��ͨ���ٱ���һ������ķ�ʽ�ҵ�����ڵ㲢������
 * ��ÿ���ڵ㶼Ҫ����һ������ ʱ�临�Ӷ�ΪO(n^2)
 * 
 * ����������ʱ����Ҫ�����ڶ�λrandomָ��Ľڵ��� �����ڵ�һ������ʱ ���ڵ�N�����ĸ���N'�������Ϣ�洢�ڹ�ϣ����
 * ���������ԭʼ������N��randomָ��S ��ô��Ӧ��N'Ӧָ��S' ͨ��S��S'�������Ϣ �Ϳ���ͨ��S�ҵ�S'
 * ʱ�临�Ӷ�O(n) ����Ҫ����Ŀռ䣨n��
 * 
 * ʹ�õķ����� �ڸ�������ʱ ֱ�ӽ��½ڵ��������Ͻڵ��
 * ����1--1'--2--2'--3--3'--4--4'..........
 * �������1��randomָ��3
 * ��ô1'ָ��3'�����÷ǳ��� ��1.next.rondomָ��1.rondom.next����
 * ����ٽ��в�� ��ż��λ�Ľڵ�������һ�𼴿�
 */
public class T35
{
	public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null)
        	return null;
       //����
        RandomListNode cur=pHead;
        while(cur!=null)
        {
        	RandomListNode temp=new RandomListNode(cur.label);
        	temp.next=cur.next;
        	cur.next=temp;
        	cur=cur.next.next;
        }
      //����random
        cur=pHead;
        while(cur!=null)
        {
        	if(cur.random!=null)
        		cur.next.random=cur.random.next;
        	cur=cur.next.next;
        }
       //���
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
