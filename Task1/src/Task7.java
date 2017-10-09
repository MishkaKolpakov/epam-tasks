
public class Task7 {
	public int[][] diaginalReverse(int[][] matrix) {
		int k = 0;
		int m = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (i == j) {
					continue;
				}
				k = i;
				m = j;
				change(matrix, k, m);

			}
		}
		return matrix;
	}

	public void change(int[][] reversed, int k, int m) {
		
		for (int i = k; i < reversed.length; i++) {
			for (int j = 0; j < reversed.length; j++) {
				if (k == j && m == i) {
					int tmp = reversed[k][m];
					reversed[k][m] = reversed[i][j];
					reversed[i][j] = tmp;
				}
			}
		}
	}
}
