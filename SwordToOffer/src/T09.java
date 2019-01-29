import java.util.Stack;

/*
 * P68������9��������ջʵ�ֶ���
 * ��Ŀ��������ջʵ��һ������ ʵ������push��pop����
 */
public class T09
{
	/*
	 * ˼·����ջʱ����Ԫ�ش���stack1
	 * ��ջʱΪ�˵ߵ�˳�򣬽�stack1�е�Ԫ�س�ջ��ѹ��stack2��
	 * ��stack2��Ϊ��ʱ��ֱ����stack2�г�ջ
	 * ֱ��stack2Ϊ�գ��ٴν�stack1������Ԫ��ѹ��stack2
	 */
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	public void push(int node)
	{
		stack1.push(node);
	}
	
	public int pop()
	{
		if(stack2.isEmpty())
		{
			while(!stack1.isEmpty())
			{
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}
}
