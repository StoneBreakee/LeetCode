package com.lyj.array;

import java.util.*;

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		// {-1,0,1,2,-1,-4}
		int divide = 0, j = nums.length - 1, temp;
		while (divide < j) {
			while (divide < j && nums[j] > 0) {
				j--;
			}
			while (divide < j && nums[divide] < 0) {
				divide++;
			}
			if (divide < j) {
				temp = nums[j];
				nums[j] = nums[divide];
				nums[divide] = temp;
				divide++;
				j--;
			}
		}

		// O(n)[-1, -4, -1, 2, 1, 0] nums[i] --> 2;i = 3
		Arrays.sort(nums, 0, divide);
		Arrays.sort(nums, divide, nums.length);
		
		for (int i = 0; i <= divide; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
				while (lo < hi) {
					if (nums[lo] + nums[hi] == sum) {
						res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
						while (lo < hi && nums[lo] == nums[lo + 1])
							lo++;
						while (lo < hi && nums[hi] == nums[hi - 1])
							hi--;
						lo++;
						hi--;
					} else if (nums[lo] + nums[hi] < sum)
						lo++;
					else
						hi--;
				}
			}
		}
		return res;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		int[] a = { -10, -11, 13, 0, -11, 9, 1, -6, -1, -12, 10, -9, 0, -15, -13, 4, -13, -1, -12, 2, -11, -6, 10, 2,
				-6, 6, -8, -12, 11, -2, 1, 9, 2, -1, -14, -1, -6, -6, 0, 0, -3, -4, -2, 4, -12, -8, -7, -10, 6, -11, -1,
				2, -2, -14, -10, 7, 7, -3, 10, -4, 3, -11, -10, 12, 3, 13, -4, 4, -8, 4, -11, -4, -15, -6, -15, -12, 1,
				-15, -15, 14, -11, -8, 2, -6, -7, -1, -14, -14, 11, 4, -3, -1, 8, -6, -3, -12, -8, 0, 8, -1, 11, 4, 2,
				11, 14, 2, 6, -8, -6, -1, -8, -1, 6 };
		ThreeSum x = new ThreeSum();
		x.threeSum(a);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

}
