package com.mascamo.dev.JavPgms;

import java.util.Scanner;

public class Javahourglass {

	public static void main(String[] args) {
		System.out.println("sachin");
		int arr[][] = new int[6][6];

		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++)
				arr[i][j] = sc.nextInt();
		}

		int sum = 0;
		int maxsum = Integer.MIN_VALUE;
		System.out.println(maxsum);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				sum = arr[i][j] + (arr[i][j + 1]) + (arr[i][j + 2]) 
						          + (arr[i + 1][j + 1]) 
						          + arr[i + 2][j]	+ arr[i + 2][j + 1] + arr[i+2][j + 2];
				if (maxsum < sum)
					maxsum = sum;
			}

		}
		System.out.println(maxsum);

	}
	

}
