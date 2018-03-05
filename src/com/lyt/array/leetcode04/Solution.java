package com.lyt.array.leetcode04;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * 
 * @author liaoyuntai
 * 
 * 获取两个数组的中位数
 *
 */
public class Solution {
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int numsAll[] = new int[length1 + length2];
        if(length1 == 0 && length2 == 0) {
        	return 0.0;
        }else if(length1 == 0) {
        	return findMedian(nums2);
        }else if(length2 == 0) {
        	return findMedian(nums1);
        }else if(nums1[length1 - 1] <= nums2[0]) {
        	System.arraycopy(nums1, 0, numsAll, 0, length1);
        	System.arraycopy(nums2, 0, numsAll, length1, length2);
        	return findMedian(numsAll);
        }else if(nums2[length2 - 1] <= nums1[0]) {
        	System.arraycopy(nums2, 0, numsAll, 0, length2);
        	System.arraycopy(nums1, 0, numsAll, length2, length1);
        	return findMedian(numsAll);
        }else {
        	int index1 = 0;
        	int index2 = 0;
        	int indexAll = 0;
        	while(index1 < length1 && index2 < length2) {
        		if(nums1[index1] < nums2[index2]) {
        			numsAll[indexAll] = nums1[index1];
        			index1++;
        			indexAll++;
        		}else {
        			numsAll[indexAll] = nums2[index2];
        			index2++;
        			indexAll++;
        		}
        	}
        	if(indexAll <= numsAll.length / 2) {
        		if(index1 == length1) {
        			System.arraycopy(nums2, index2, numsAll, indexAll, numsAll.length / 2);
        		}else{
        			System.arraycopy(nums1, index1, numsAll, indexAll, numsAll.length / 2);
        		}
        	}
        	return findMedian(numsAll);
        }
    }
	
	public double findMedian(int[] nums) {
		if(nums.length % 2 == 1) {
    		return (double)nums[nums.length / 2];
    	}else {
    		return ((double)nums[nums.length / 2] + (double)nums[nums.length / 2 - 1]) / 2;
    	}
	}
	
    public static void main(String[] args) {
        Solution s = new Solution();
        int nums1[] = {2};
        int nums2[] = {1, 3, 4};
    	System.out.println(s.findMedianSortedArrays(nums1, nums2));
    }
}
