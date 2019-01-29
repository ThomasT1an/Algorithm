import java.util.Stack;

/*
 * P68面试题9：用两个栈实现队列
 * 题目：用两个栈实现一个队列 实现他的push和pop功能
 */
public class T09
{
	/*
	 * 思路：入栈时所有元素存入stack1
	 * 出栈时为了颠倒顺序，将stack1中的元素出栈并压入stack2中
	 * 当stack2不为空时，直接在stack2中出栈
	 * 直到stack2为空，再次将stack1中所有元素压入stack2
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
