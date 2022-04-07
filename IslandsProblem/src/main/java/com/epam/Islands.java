package com.epam;

import java.util.Scanner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class Islands {

	public static void main(String[] args) {
//		int[][] array = { { 1, 0, 0, 0 }, { 0, 1, 1, 0 }, { 0, 1, 0, 0 } };
		
		
		Scanner scan = new Scanner(System.in);
		
		log.info("Enter number of rows");
		int r = scan.nextInt();
		log.info("Enter number of columns");
		int c = scan.nextInt();
		int[][] array = new int[r][c];
		int islands = 0;
		log.info("enter elements");
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				array[i][j]=scan.nextInt();
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (array[i][j] == 1) {
					traverse(array, i, j);
					islands++;
				}
			}
		}
		
		log.info(String.valueOf(islands));
		
	}
	
	private static void traverse(int[][] array, int i, int j) {
		if (i < 0 || i >= array.length || j < 0 || j >= array[0].length || array[i][j] != 1) {
			return;
		}
		array[i][j] = 2;
		traverse(array, i + 1, j);
		traverse(array, i, j + 1);
		traverse(array, i - 1, j);
		traverse(array, i, j - 1);
	}
}
