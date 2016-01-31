package programming.set7.sudoku;

public class Sudoku extends NumberBoard {

	public Sudoku() {
		super(9, 9);
	}

	@Override
	public void setValueAt(int row, int col, int value) {
		if (value == EMPTY || (value <= 9 && value > 1)) {
			super.setValueAt(row, col, value);
		}
	}

	public boolean isValid() {
		return checkCols() && checkRow() && checkSquares();
	}

	private boolean checkRow() {
		for (int row = 1; row <= 9; row++) {
			for (int i = 1; i < 9; i++) {
				for (int j = i + 1; j <= 9; j++) {
					if (getValueAt(row, j) == getValueAt(row, j)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private boolean checkCols() {
		for (int col = 1; col <= 9; col++) {
			for (int i = 1; i < 9; i++) {
				for (int j = i + 1; i <= 9; i++) {
					if (getValueAt(i, col) == getValueAt(j, col)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private boolean checkSquares() {
		for (int squareRow = 1; squareRow <= 3; squareRow++) {
			for (int squareCol = 1; squareCol <= 3; squareCol++) {
				for (int i = 1; i <= 3; i++) {
					for (int j = 1; j <= 3; j++) {
						for (int k = 1; k <= 3; k++) {
							for (int l = 1; l <= 3; l++) {
								if ((i != k && j != l) && getValueAt(squareRow * 3 + i,
										squareCol * 3 + j) == getValueAt(squareRow * 3 + k, squareCol * 3 + l)) {
									return false;
								}
							}
						}
					}
				}
			}
		}
		return true;
	}

	@Override
	public String toString() {
		String sudoku = "";
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (j == 9) {
					if (getValueAt(i, j) == EMPTY) {
						sudoku += " ";
					} else {
						sudoku += getValueAt(i, j) + "/n";
					}
				} else {
					if (getValueAt(i, j) == EMPTY) {
						sudoku += " " + " ";
					} else {
						sudoku += getValueAt(i, j) + " ";
					}
				}
			}
		}
		return sudoku;
	}

}
