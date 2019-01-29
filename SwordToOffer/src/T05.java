/*
 * P51面试题5：替换空格
 * 题目：请实现一个函数，把字符串中的每个空格替换成"%20"
 * 例如输入"We are happy."
 * 则输出"We%20are%20happy."
 */
public class T05
{
	/*
	 * 解题思路：
	 * 先遍历一遍数组 找到一共有多少个空格 在尾部添加2*空格个数的任意字符
	 * 令P1指向原末尾，P2指向延长后的末尾，两指针均从后往前遍历（P1开始）
	 * 每当P1遍历到一个字符时 将它复制到P2 两指针同时前移一位
	 * 当P1遍历到空格时 P1向前移一位 P2向前移动三位并填充02%
	 * 当P1与P2重合时 则结束
	 * 从后向前遍历是为了在改变P2所指向的内容时 不会影响到P1遍历原来的字符串内容 
	 */
	public String replaceSpace(StringBuffer str) 
	 {
		 int P1=str.length()-1;
		 for(int i=0;i<=P1;i++)
		 {
			 if(str.charAt(i)==' ')
			 {
				 str.append("  ");
			 }
		 }
		 int P2=str.length()-1;
		 while(P1!=P2)
		 {
			 if(str.charAt(P1)!=' ')
			 {
				 str.setCharAt(P2, str.charAt(P1));
				 P1--;
				 P2--;
			 }
			 else
			 {
				 P1--;
				 str.setCharAt(P2--, '0');
				 str.setCharAt(P2--, '2');
				 str.setCharAt(P2--, '%');
			 }
		 }
		 return str.toString();
	 }
}
