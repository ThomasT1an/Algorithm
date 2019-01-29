import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * P209������40����С��k����
 * ��Ŀ������n������ �ҳ�������С��k����
 */
public class T40
{
	//����һ�����������ֱ�ӵõ� ���Ӷ�ΪO(nlogn)
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k)
	{
		ArrayList<Integer> ret = new ArrayList<>();
		if (k > input.length)
			return ret;
		Arrays.parallelSort(input);
		for (int i = 0; i < k; i++)
			ret.add(input[i]);
		return ret;
	}
	public static void main(String[] args)
	{
		int input[]={4,5,1,6,2,7,3,8};
		ArrayList<Integer> ret=GetLeastNumbers_Solution2(input,4);
	}
	/*
	 * ��������ʹ��Partition����ʵ�� 
	 * Partition������ʵ�ֿ�������ĺ��ĺ���
	 * �书���Ƿ���һ������ j ʹ�� a[0..j-1] С�ڵ��� a[j] �� a[j+1..���һ��Ԫ��] ���ڵ��� a[j]
	 * ��ʱ a[j] ��������ĵ� j ��Ԫ�� ����������������ҳ�����ĵ� K ��Ԫ��
	 * �����ڻ�׼����ѡȡ������ģ�����ʹ�õ�һ��Ԫ����Ϊ��׼����
	 * �����ܱ�ֱ֤�ӵõ���k������� ���������ص��±�j��10 ��ôֻ�ܵõ�ǰ9��С��data[10]����  ����ЩԪ�ص������������
	 * ������Ҫһ������ĺ�������֤Partition�������ص�j�պ�Ϊk
	 */
	
	public static ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k)
	{
		ArrayList<Integer> ret = new ArrayList<>();
		if (k > input.length)
			return ret;
		findKthNum(input,k-1);
		for(int i=0;i<k;i++)
			ret.add(input[i]);
		return ret;
	}
	private static void findKthNum(int nums[],int k)
	{
		int start=0;
		int end=nums.length-1;
		while(start<end)
		{
			int j=Partition(nums,start,end);
			if(j==k)
				break;
			if(j>k)//��j����k ������ǰj��Ԫ���в��Ҽ���
				end=j-1;
			if(j<k)//��jС��k ����j֮���Ԫ���в���
				start=j+1;
		}
	}
	private static int Partition(int data[],int start,int end)
	{
		int base=data[start];//ѡȡ��һ����Ϊ��׼��
		int i=start+1,j=end;//��������"�ڱ�"  (���������㷨��ͼ���������)
		while(true)
		{
			while(j!=start&&data[j]>base)
				j--;
			while(i!=end&&data[i]<base)
				i++;
			//i�����ҵ���һ�����ڻ�׼������ j�����ҵ���һ��С�ڻ�׼������
			if(j>i)
				swap(data,i,j);//��i��j��δ�غ� �򽻻���Ԫ��
			else
				break;
		}
		swap(data,start, j);//�غ�֮�󽻻���׼����j��λ��
		return j;
	}
	private static void swap(int[] nums, int i, int j) 
	{
	    int t = nums[i];
	    nums[i] = nums[j];
	    nums[j] = t;
	}
	/*
	 * ����������СΪ K ����С��
	 * ���Ӷȣ�O(NlogK) + O(K) �ʺϴ���������
	 * Ӧ��ʹ�ô󶥶���ά����С�ѣ�������ֱ�Ӵ���һ��С���Ѳ�����һ����С����ͼ��С�����е�Ԫ�ض�����СԪ�ء�
	 * ά��һ����СΪ K ����С�ѹ������£������һ��Ԫ��֮������󶥶ѵĴ�С���� K����ô��Ҫ���󶥶ѵĶѶ�Ԫ��ȥ����
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution3(int[] nums, int k) 
	{
	    if (k > nums.length || k <= 0)
	        return new ArrayList<>();
	    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
	    for (int num : nums) {
	        maxHeap.add(num);
	        if (maxHeap.size() > k)
	            maxHeap.poll();
	    }
	    return new ArrayList<>(maxHeap);
	}
}
