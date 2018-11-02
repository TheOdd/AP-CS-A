package lecture15.normal.sorting;

public abstract class Sort {
	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int smallestIdx = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[smallestIdx])
					smallestIdx = j;
			}
			if (smallestIdx != i) {
				int temp = arr[i];
				arr[i] = arr[smallestIdx];
				arr[smallestIdx] = temp;
			}
		}
	}
	
	public static void bubbleSort(int[] arr) {
		for (int j = 1; j < arr.length; j++) {
			boolean swapped = false;
			for (int i = 0; i < arr.length - j; i++) {
				if (arr[i] > arr[i + 1]) {
					swapped = true;
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			if (!swapped)
				break;
		}
	}
	
	public static void insertionSort(int[] arr) {
		// Top-level array loop
		for (int i = 1; i < arr.length; i++) {
			// Sub-array loop
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[i]) {
					// Found target index to insert at
					int temp = arr[i];
					for (int k = i; k > j; k--)
						arr[k] = arr[k - 1];
					arr[j] = temp;
				}
			}
		}
	}
	
	public static void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}
	
	private static void mergeSort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			// Recursively sort first half
			mergeSort(arr, start, mid);
			// Recursively sort second half
			mergeSort(arr, mid + 1, end);
			// Merge halves
			merge(arr, start, mid, end);
		}
	}
	
	private static void merge(int[] arr, int start, int mid, int end) {
		// Array to store sorted subset of arr to be copied over later
		int[] newArr = new int[arr.length];
		
		// i is the first half's index tracker
		// j is the second half's index tracker
		// k is newArr's index tracker
		int i = start, j = mid + 1, k = 0;
		
		// Advance on both indices as far as you can
		while (i <= mid && j <= end) {
			if (arr[i] < arr[j])
				newArr[k++] = arr[i++];
			else
				newArr[k++] = arr[j++];
		}
		
		// Finish copying remaining vals to newArr
		
		while (i <= mid)
			newArr[k++] = arr[i++];
		
		while (j <= end)
			newArr[k++] = arr[j++];
		
		// Copy newArr back over arr
		for (i = end; i >= start; i--)
			arr[i] = newArr[--k];
	}
}
