package com.epam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class Islands {

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

	public static void main(String[] args) {
		int[][] array = { { 1, 0, 0, 0 }, { 0, 1, 1, 0 }, { 0, 1, 0, 0 } };
		int r = array.length;
		int c = array[0].length;
		int count = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (array[i][j] == 1) {
					traverse(array, i, j);
					count++;
				}
			}
		}
		log.info("" + count);
	}
}
