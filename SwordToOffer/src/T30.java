import java.util.Stack;

/*
 * P165������30������min������ջ
 * ��Ŀ������ջ�����ݽṹ ���ڸ�������ʵ��һ���ܹ��õ�ջ����СԪ�ص�min����
 * �ڸ�ջ�� ����min push ��pop��ʱ�临�Ӷȶ���O(1)
 */
public class T30
{
	/*
	 * ˼·��ʹ��һ������ջ����ѹ�뵯������ ʹ��һ������ջ��������Сֵ
	 * �����ڶ�̬�滮�е�ά�����Ž�����˼��
	 * ����ջ��ʼ�ձ��浱ǰ����ջ�е���СԪ��
	 * ������ջ��ջʱ ����Ԫ���븨��ջջ��Ԫ�ضԱ� ����ջԪ�ظ�С �򽫸�Ԫ��ѹ�븨��ջ ������ջջ��Ԫ�ظ�С ���ٴ�ѹ��һ��ջ��Ԫ��
	 * ������ջ��ջʱ ͬ�����ջ����һ�γ�ջ����
	 */
	private Stack<Integer> dataStack=new Stack<>();
	private Stack<Integer> supStack=new Stack<>();
	public void push(int node) 
	{
        dataStack.push(node);
        if(supStack.isEmpty())
        	supStack.push(node);
        else
        	supStack.push(Math.min(node, supStack.peek()));
    }
    
    public void pop() 
    {
        dataStack.pop();
        supStack.pop();
    }
    
    public int top() 
    {
        return dataStack.peek();
    }
    
    public int min() 
    {
        return supStack.peek();
    }	
}
