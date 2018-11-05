package lecture15.standard.sorting;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] arr = {8, 4, 12, 3, 7, 6, 9, 3, 1, 8, 42, 15, 7, 3};
		
		System.out.println(Arrays.toString(arr));
		
		Sort.mergeSort(arr);
		
		System.out.println(Arrays.toString(arr));
	}
}
