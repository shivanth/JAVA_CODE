            /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Shivanth
 */
public class ProbTable {

    private static int ROW, COLUMN;
    private static final int GUESS_CONST = 10, GUESS_MAX = 27;

    /**
     * @param aROW the ROW to set
     */
    public static void setROW(int aROW) {
        ROW = aROW;
    }

    /**
     * @param aCOLUMN the COLUMN to set
     */
    public static void setCOLUMN(int aCOLUMN) {
        COLUMN = aCOLUMN;
    }

    /**
     * @return the ROW
     */
    public static int getROW() {
        return ROW;
    }

    /**
     * @return the COLUMN
     */
    public static int getCOLUMN() {
        return COLUMN;
    }
    int[][] data;
    private boolean tabledone;

    ProbTable() {
        data = new int[10][10];
        tabledone = false;

    }

    /**
     * @param tabledone the tabledone to set
     */
    public void setTabledone(boolean tabledone) {
        this.tabledone = tabledone;
    }

    public int getdata(int row, int col) {
        return data[row][col];
    }

    /**Fills all the ProbTables using the Sudoku table supplied
     *Called only once for initialisation*/
    public void init_fill_table(SudokuTable maintable, int index)
            throws DataInvalidException, ErrorInTable {
        for (int i = 1; i < 10; i++) {
            for (int k = 1; k < 10; k++) {
                if (maintable.getdata(i, k) == 0) {
                    continue;
                } else if (maintable.getdata(i, k) == index) {

                    kill_row(i);
                    kill_column(k);
                    kill_box(i,k);
                    data[i][k] = GUESS_MAX;
                } else if (maintable.getdata(i, k) < 10 && maintable.getdata(i, k) > 0) {
                    killcell(i, k);
                } else {
                    throw new DataInvalidException();
                }
            }
        }
    }

    /**Scans the probtable for any insertions that are
     * possible nto main table */
    public boolean scan_table(SudokuTable table) {
        int row_or_col;
        for (int l = 1; l < 10; l++) {
            if ((row_or_col = scan_row(l)) != -1) {
                
                setROW(l);
                setCOLUMN(row_or_col);
                return true;

            } else if ((row_or_col = scan_column(l)) != -1) {
                setROW(row_or_col);
                setCOLUMN(l);
                return true;

            }
            else if(scan_box(l)!=-1)
                return true;
        }
        return false;
    }

    /**
     * @return the tabledone
     */
    public boolean isTabledone() {
        return tabledone;
    }

    /**Increments the value in cell only if the value in
     * cell is positive or less than the allowed Maximum */
    private void inc(int row, int col) {
        if (data[row][col] == -1) {
            return;
        } else if (data[row][col] < GUESS_MAX) {
            data[row][col]++;
        }
    }

    /**
     *@param row  sets the cell corresponding to row,col to -1 and
     *increments the probability of the probability of all the cells in that
     *row ,column and box
     *@param col sets the cell corresponding to row,col to -1 and
     *increments the probability of the probability of all the cells in that
     *row ,column and box*/
    public void killcell(int row, int col) {
        data[row][col] = -1;
        for (int k = 1; k < 10; k++) {
            if (k == col) {
                continue;
            }
            inc(row, k);
            if (k == row) {
                continue;
            }
            inc(k, col);
        }
        for (int k = ((row - 1) / 3) * 3 + 1; k < ((row - 1) / 3) * 3 + 4; k++) {
            for (int j = ((col - 1) / 3) * 3 + 1; j < ((col - 1) / 3) * 3 + 4; j++) {
                if (k == row && j == col) {
                    continue;
                }
                inc(k, j);
            }
        }

    }

    /** function to scan for any sure candidates in a cell
     * by scanning a complete row

     * @param row The row to be scanned
     * @return The column number here the cell can use it and -1 if there's no such row
     */
    int scan_row(int row) {
        boolean one_possible = false;
        int col = -1;
        for (int i = 1; i < 10; i++) {
            if(data[row][i]==GUESS_MAX)
                return -1;
            if (data[row][i] == -1) {
                continue;
            } else if (data[row][i] != -1 && !one_possible && data[row][i] != GUESS_MAX) {
                one_possible = true;
                col = i;
            } else if (data[row][i] != -1 && one_possible) {
                return -1;
            }
        }
        return col;
    }

    /** function to scan for any sure candidates in a cell
     * by scanning a complete column

     * @param col The column to be scanned
     * @return The row number where the cell can use it and -1 if no such row
     */
    int scan_column(int col) {
        boolean one_possible = false;
        int row = -1;
        for (int i = 1; i < 10; i++) {
            if(data[i][col]==GUESS_MAX)
                return -1;
            if (data[i][col] == -1) {
                continue;
            } else if (data[i][col] != -1 && !one_possible) {
                one_possible = true;
                row = i;
            } else if (data[i][col] != -1 && one_possible) {
                return -1;
            }
        }
        return row;
    }

    int scan_box(int box){
        int row=0,col=0;
        boolean one_possible=false;
        for(int i=((box-1)/3)*3+1;i<((box-1)/3)*3+4;i++){
            for(int j=((box-1)%3)*3+1;j<((box-1)%3)*3+4;j++){
                if(data[i][j]==GUESS_MAX)
                return -1;
            if (data[i][j] == -1) {
                continue;
            } else if (data[i][j] != -1 && !one_possible) {
                one_possible = true;
                row = i;
                col=j;
            } else if (data[i][j] != -1 && one_possible) {
                return -1;
            }
            }
        }
        if(row==0 && col ==0)
            return -1;
        setROW(row);
        setCOLUMN(col);
        return 0;
    }

    /**
     *@param row the row of the cell to be modified
     *@param col column of the cell to be modfied
     *@param value value o be set to the column*/
    void writecell(int row, int col, int value) {
        //if (data[row][col] != -1 && data[row][col] != GUESS_MAX) {
            data[row][col] = value;
        //}
    }

    /**kills a complete row by setting its value to -1
     *@param row Row to be killed
     * @throws ErrorInTable if a cell tat has been alredy filled is to be killed
     *
     */
    void kill_row(int row) throws ErrorInTable {
        for (int i = 1; i < 10; i++) {
            if (data[row][i] == GUESS_MAX) {
                throw new ErrorInTable(row,i);
            } else if (data[row][i] != -1) {
                data[row][i] = -1;
            }
        }
    }

    void kill_column(int col) throws ErrorInTable {
        for (int i = 1; i < 10; i++) {
            if (data[i][col] == GUESS_MAX) {
                throw new ErrorInTable(i,col);
            } else if (data[i][col] != -1) {
                data[i][col] = -1;
            }
        }
    }

    void kill_box(int row, int col) throws ErrorInTable {
        for (int i = ((row-1) / 3) * 3 + 1; i < ((row-1) / 3) * 3 + 4; i++) {
            for (int j = ((col-1) / 3) * 3 + 1; j < ((col-1) / 3) * 3 + 4; j++) {
                if (data[i][j] == GUESS_MAX) {
                    throw new ErrorInTable();
                } else if (data[i][j] != -1) {
                    data[i][j] = -1;
                }
            }
        }
    }
}
