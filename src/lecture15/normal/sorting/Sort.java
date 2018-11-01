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
					// TODO: Try and find a way to do this without making a clone of the array
					int[] copy = arr.clone();
					for (int k = j; k < i; k++)
						arr[k + 1] = copy[k];
					arr[j] = temp;
				}
			}
		}
	}
	
	public static void mergeSort(int[] arr) {
		
	}
}
