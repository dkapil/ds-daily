package practice;

public class DP3_LIS {

	public static void main(String[] args) {

		int[] arr = {50, 3, 10, 7, 40, 80};

		int[][] lis = new int[arr.length][arr.length];
		for (int i = 0; i < arr.length; i++) {
			int ctr = 0;
			lis[i][ctr] = arr[i];
			int pivot=arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] >= pivot) {
					lis[i][++ctr] = arr[j];
					pivot=arr[j];
				}
			}
		}

		System.out.println();
		for (int i = 0; i < lis.length; i++) {
			for (int j = 0; j < lis[i].length; j++) {
				System.out.print(lis[i][j] + " ");
			}
			System.out.println();
		}

	}
}
