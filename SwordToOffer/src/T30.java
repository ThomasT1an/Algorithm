import java.util.Stack;

/*
 * P165面试题30：包含min函数的栈
 * 题目：定义栈的数据结构 请在该类型中实现一个能够得到栈的最小元素的min函数
 * 在该栈中 调用min push 及pop的时间复杂度都是O(1)
 */
public class T30
{
	/*
	 * 思路：使用一个数据栈进行压入弹出操作 使用一个辅助栈来保存最小值
	 * 类似于动态规划中的维护最优解数组思想
	 * 辅助栈中始终保存当前数据栈中的最小元素
	 * 在数据栈入栈时 将该元素与辅助栈栈顶元素对比 若入栈元素更小 则将该元素压入辅助栈 若辅助栈栈顶元素更小 则再次压入一个栈顶元素
	 * 在数据栈出栈时 同样令辅助栈进行一次出栈操作
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
