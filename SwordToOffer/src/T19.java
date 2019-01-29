/*
 * P124面试题19：正则表达式匹配
 * 题目：请实现一个函数用来匹配包含'.'和'*'的正则表达式
 * 模式中的字符'.'表示任意一个字符 而'*'表示它前面的字符可以出现任意次（含0次）
 * 在本题中 匹配是指字符串的所有字符匹配整个模式
 * 例如 字符串"aaa"与模式"a.a" "ab*ac*a"匹配
 * 但与"aa.a"和"ab*a"均不匹配
 */
public class T19
{
	/*
	 * 思路一：
	 * 对字符串与模式串的各个元素进行依次对比 有以下几种情况
	 * A.首先若模式串中的元素与字符串的匹配 且模式串中这个元素的后一元素不为* 若两者匹配 则下标共同+1 不匹配则结果为不匹配
	 * B.在上一情况中 模式串中的元素若为. 则下标共同+1
	 * 若模式串中的某一元素的后一元素为* 则有3种情况 ：
	 * C.*表示模式串中的字符出现0次，则字符串下标不变 模式串下标+2
	 * D.*表示模式串中的字符出现1次，则字符串下标+1 模式串下标+2
	 * E.*表示模式串中的字符出现1次以上，则字符串下标+1 模式串下标不变
	 * 对于CDE三种情况 若当前下标元素两者不匹配 只能进行C操作 但是当匹配时 也可以进行C操作
	 * 还需要考虑.*连续出现的情况 
	 */
	public boolean match(char[] str, char[] pattern)
    {
		if(str==null||pattern==null)
			return false;
		return matchCore(str,pattern,0,0);
    }
	private boolean matchCore(char[] str,char[] pattern,int index1,int index2)//index1字符串下标 index2模式串下标
	{
		if(index1>=str.length&&index2>=pattern.length)//都匹配完成
			return true;
		if(index1<str.length&&index2>=pattern.length)//字符串没完但是模式串完了
			return false;
		//还有一种情况是 字符串完了 但是这种情况模式串可完可不完 因为模式串可能还有情况C发生 所以不用设置出口
		if(index2+1<pattern.length&&pattern[index2+1]=='*')//注意判断顺序
		{
			/*
			 * 这种情况就是字符串完了但是模式串没完的情况
			 */
			if(index1>=str.length)
				return matchCore(str,pattern,index1,index2+2);
			else
			{
				if(pattern[index2]==str[index1]||pattern[index2]=='.')
				{
					return matchCore(str,pattern,index1+1,index2+2)||//D
							matchCore(str,pattern,index1+1,index2)||//E
							matchCore(str,pattern,index1,index2+2);//C
				}
				else
					return matchCore(str,pattern,index1,index2+2);
			}
		}
		if(index1>=str.length)
			return false;
		else
		{
			if(pattern[index2]==str[index1]||pattern[index2]=='.')
				return matchCore(str,pattern,index1+1,index2+1);
		}
		return false;
	}
	
	/*
	 * 思路二：动态规划
	 * 维护一个布尔型二维数组 二维分别为字符串的长度和模式串的长度
	 * 例如dp[i][j]的值为true则表示字符串长度为i 模式串长度为j时两者可以匹配
	 * 具体的计算规则与思路一相似
	 * 仍需要考虑a* 表示0个、1个、多个a的情况 
	 */
	public boolean match2(char[] str,char[] pattern)
	{
		boolean dp[][]=new boolean[str.length+1][pattern.length+1];
		dp[0][0]=true;
		/*
		 * 以下一个for循环是处理字符串长度为0的对应测试数据
		 */
		for(int i=1;i<=pattern.length;i++)
		{
			if(pattern[i-1]=='*')
				dp[0][i]=dp[0][i-2];
		}
		for(int i=1;i<=str.length;i++)
		{
			for(int j=1;j<=pattern.length;j++)
			{
				if(str[i-1]==pattern[j-1]||pattern[j-1]=='.')
					dp[i][j]=dp[i-1][j-1];
				else if(pattern[j-1]=='*')
				{
					if(pattern[j-2]==str[i-1]||pattern[j-2]=='.')
					{
						dp[i][j]=dp[i][j]||dp[i][j-2];//*表示出现0次
						dp[i][j]=dp[i][j]||dp[i][j-1];//*表示出现1次
						dp[i][j]=dp[i][j]||dp[i-1][j];//*表示出现多次
					}
					else
						dp[i][j]=dp[i][j]||dp[i][j-2];//*不匹配时只能选择出现0次
				}
			}
		}
		return dp[str.length][pattern.length];
	}
}
