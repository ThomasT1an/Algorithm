import java.util.ArrayList;

/*
 * P197������38���ַ���������
 * ��Ŀ������һ���ַ��� ��ӡ�����ַ������ַ�����������
 * ���� �����ַ���abc
 * ��ô��ӡ�� abc acb bac bca cab��cba
 */
public class T38
{
	public static void main(String[] args)
	{
		ArrayList<String> res=new ArrayList<>();
		res=Permutation("aab");
		for(String temp:res)
			System.out.println(temp);
	}
	static ArrayList<String> res=new ArrayList<>();
	public static ArrayList<String> Permutation(String str) 
	{
		char arr[]=str.toCharArray();
	     fullSort(arr,0,arr.length-1);
		return res;
    }
	private static void fullSort(char arr[],int start,int end)
	{
		if(start==end)
		{
			String temp=new String(arr);
			if(!res.contains(temp))
			{
				res.add(new String(arr));
				return;
			}
		}
		for(int i=start;i<=end;i++)
		{
			char temp=arr[i];
			arr[i]=arr[start];
            arr[start]=temp;
            fullSort(arr,start+1,end);
            temp=arr[i];
            arr[i]=arr[start];
            arr[start]=temp;
		}
	}
}
	