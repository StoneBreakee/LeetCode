package com.lyj.array;

import java.util.*;

public class ThreeSum2 {

	public List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> res = new LinkedList<>();
		for (int i = 0; i < num.length - 2; i++) {
			if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
				int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
				while (lo < hi) {
					if (num[lo] + num[hi] == sum) {
						res.add(Arrays.asList(num[i], num[lo], num[hi]));
						while (lo < hi && num[lo] == num[lo + 1])
							lo++;
						while (lo < hi && num[hi] == num[hi - 1])
							hi--;
						lo++;
						hi--;
					} else if (num[lo] + num[hi] < sum)
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
		ThreeSum2 x = new ThreeSum2();
		x.threeSum(a);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

}
