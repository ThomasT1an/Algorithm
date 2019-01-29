import java.util.Stack;

/*
 * P168面试题31：栈的压入、弹出序列
 * 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序
 * 假设压入栈的所有数字均不相等
 * 例如 序列{1,2,3,4,5}是某栈的压栈序列 序列{4,5,3,2,1}是该压栈序列对应的一个弹出序列
 * 但{4,3,5,1,2}就不可能是该压栈序列的弹出序列
 */
public class T31
{
	/*
	 * 使用一个辅助栈模拟压入弹出过程
	 * 如果下一个弹出的数字刚好是栈顶数字 那么直接弹出
	 * 如果下一个弹出的数字不在栈顶 则把压栈序列中还没有入栈的数字压入辅助栈 
	 * 直到把下一个需要弹出的数字压入栈顶为止
	 * 如果所有数字都压入栈后依然没有找到下一个弹出的数字 则该序列不可能是一个弹出序列
	 */
	public boolean IsPopOrder(int [] pushA,int [] popA) 
	{
	      if(pushA.length==0||popA.length==0)
	    	  return false;
		  Stack<Integer> stack=new Stack<>();
	      stack.push(pushA[0]);
	      int index1=1;
	      int index2=0;
	      boolean flag=false;
	      while(!flag)
	      {
	    	  if(stack.peek()==popA[index2])
	    	  {
	    		  stack.pop();
	    		  index2++;
	    	  }
	    	  else
	    	  {
	    		  while(index1<pushA.length)
	    		  {
	    			  stack.push(pushA[index1]);
	    			  index1++;
	    			  if(stack.peek()==popA[index2])
	    				  break;
	    		  }
	    	  }
	    	  if(index1==pushA.length)
    			  flag=true;
	      }
	      while(!stack.isEmpty()&&stack.peek()==popA[index2])
	      {
	    	  {
	    		  stack.pop();
	    		  index2++;
	    	  }
	      }
	      return stack.isEmpty();
    }	
}
