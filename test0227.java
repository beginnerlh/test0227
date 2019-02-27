/*
 * ����һ�����������һ������ k, ����Ҫ���������ҵ���ͬ�� k-diff ���ԡ����ｫ k-diff ���Զ���Ϊһ�������� (i, j), ���� i �� j ���������е����֣�������֮��ľ���ֵ�� k.

ʾ�� 1:

����: [3, 1, 4, 1, 5], k = 2
���: 2
����: ������������ 2-diff ����, (1, 3) �� (3, 5)��
����������������1��������ֻӦ���ز�ͬ�����Ե�������
ʾ�� 2:

����:[1, 2, 3, 4, 5], k = 1
���: 4
����: ���������ĸ� 1-diff ����, (1, 2), (2, 3), (3, 4) �� (4, 5)��
ʾ�� 3:

����: [1, 3, 1, 5, 4], k = 0
���: 1
����: ������ֻ��һ�� 0-diff ���ԣ�(1, 1)��
ע��:

���� (i, j) ������ (j, i) ������ͬһ���ԡ�
����ĳ��Ȳ�����10,000��
��������������ķ�Χ�� [-1e7, 1e7]��
*/
package lianxi0227;

public class test0227 {
	public static void main(String[] args) {
		Solution S = new Solution();
		int[] nums = new int[] { 3, 1, 4, 1, 5};
		int k = 2;
		int a = S.findPairs(nums, k);
		System.out.println(a);
	}
}

class Solution {
    public int findPairs(int[] nums, int k) {
    	int len = nums.length;
    	int count = 0;
    	int[][] s = new int[len][2];
    	if(k<0)
    	{
    		return 0;
    	}
    	for(int i = 0; i<len;i++)
    	{
    		for(int j = i+1; j<len;j++)
    		{
    			if(nums[i]-nums[j]==k||nums[j]-nums[i]==k)
    			{
    				int a = judge(nums[i], nums[j], len,count,s);
    				count +=a;
    			}
    		}
    	}
        return count;
    }
    public int judge(int i,int j,int len,int count,int[][]a)
    {
    	
    	int m = 0;
    	if(count == 0 )
    	{
    		a[0][0] = i;
    		a[0][1] =j;
    		return 1;
    	}
    	else
    	{
    		for(; m<count;m++)
        	{
        		if( a[m][0]==i && a[m][1]==j || (a[m][0]==j && a[m][1]==i) )
        		{
        			return 0;
        		}
        			
        	}
    		a[m][0] = i;
    		a[m][1] = j;
    		return 1;
    	}
    }
}



