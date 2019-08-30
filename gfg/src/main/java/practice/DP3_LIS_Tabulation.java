package practice;

public class DP3_LIS_Tabulation {

	public static void main(String[] args) {

		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };

		// create lis array
		int[] lis = new int[arr.length];

		// initialize all elements to 1
		for (int i = 0; i < lis.length; i++) {
			lis[i] = 1;
		}

		int[][] lismat = new int[lis.length][lis.length];

		for (int i = 1; i < arr.length; i++) {
			int ctr = 0;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
					lismat[i][ctr] = arr[j];
					ctr++;
				}
			}
			lismat[i][ctr] = arr[i];
		}

		int max = lis[0];
		int maxindex = 0;
		for (int i = 1; i < lis.length; i++) {
			if (lis[i] > max) {
				max = lis[i];
				maxindex = i;
			}

		}

		System.out.println(max);

		for (int i = 0; i < lismat[maxindex].length; i++) {
			System.out.print(lismat[maxindex][i] + " ");
		}

	}
}
