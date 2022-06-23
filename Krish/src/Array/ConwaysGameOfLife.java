package Array;

public class ConwaysGameOfLife {
	public static void main(String[] args) {
		int R = 10, C = 5;
		int matrix[][] = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 1, 1, 0 },
				{ 0, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };

		System.out.println("1st Generation:");
		generation2(matrix, R, C);
		System.out.println("\n2nd Generation:");
		int secondGenMat[][] = generation2(matrix, R, C);
		System.out.println("\n3rd Generation:");
		generation2(secondGenMat, R, C);
	}

	static int[][] generation2(int m[][], int row, int col) {
		int futureMatrix[][] = new int[row][col];

		// Loop through every cell
		for (int i = 1; i < row - 1; i++) {
			for (int j = 1; j < col - 1; j++) {

				// Finding no of neighbors that are alive
				int count = 0;
				for (int x = -1; x <= 1; x++)
					for (int y = -1; y <= 1; y++)
						count = count + m[i + x][j + y];

				// The cell needs to be subtracted from its neighbors as it was counted before
				count = count - m[i][j];

				// Applying the rules
				if (m[i][j] == 1 && count < 2) {
					futureMatrix[i][j] = 0;
				} else if (m[i][j] == 1 && count > 3) {
					futureMatrix[i][j] = 0;
				} else if (m[i][j] == 0 && count == 3) {
					futureMatrix[i][j] = 1;
				} else if (m[i][j] == 1 && (count == 2 || count == 3)) {
					futureMatrix[i][j] = 1;
				} else {
					futureMatrix[i][j] = m[i][j];
				}
			}
		}

		// Displaying the matrix
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(futureMatrix[i][j] + " ");
			}
			System.out.println();
		}
		return futureMatrix;
	}
}