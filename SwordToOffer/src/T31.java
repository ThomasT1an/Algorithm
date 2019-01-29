import java.util.Stack;

/*
 * P168������31��ջ��ѹ�롢��������
 * ��Ŀ�����������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳��
 * ����ѹ��ջ���������־������
 * ���� ����{1,2,3,4,5}��ĳջ��ѹջ���� ����{4,5,3,2,1}�Ǹ�ѹջ���ж�Ӧ��һ����������
 * ��{4,3,5,1,2}�Ͳ������Ǹ�ѹջ���еĵ�������
 */
public class T31
{
	/*
	 * ʹ��һ������ջģ��ѹ�뵯������
	 * �����һ�����������ָպ���ջ������ ��ôֱ�ӵ���
	 * �����һ�����������ֲ���ջ�� ���ѹջ�����л�û����ջ������ѹ�븨��ջ 
	 * ֱ������һ����Ҫ����������ѹ��ջ��Ϊֹ
	 * ����������ֶ�ѹ��ջ����Ȼû���ҵ���һ������������ ������в�������һ����������
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
