/*
 * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.

示例 1:

输入: [3, 1, 4, 1, 5], k = 2
输出: 2
解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
尽管数组中有两个1，但我们只应返回不同的数对的数量。
示例 2:

输入:[1, 2, 3, 4, 5], k = 1
输出: 4
解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
示例 3:

输入: [1, 3, 1, 5, 4], k = 0
输出: 1
解释: 数组中只有一个 0-diff 数对，(1, 1)。
注意:

数对 (i, j) 和数对 (j, i) 被算作同一数对。
数组的长度不超过10,000。
所有输入的整数的范围在 [-1e7, 1e7]。
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



