package by;

public class Labyrinth {

    private char[][][] matrix;
    private int H_levels;
    private int M_rows;
    private int N_columns;
    private Point prince;
    private Point princess;

    public char[][][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][][] matrix) {
        this.matrix = matrix;
    }

    public int getH_levels() {
        return H_levels;
    }

    public void setH_levels(int h_levels) {
        H_levels = h_levels;
    }

    public int getM_rows() {
        return M_rows;
    }

    public void setM_rows(int m_rows) {
        M_rows = m_rows;
    }

    public int getN_columns() {
        return N_columns;
    }

    public void setN_columns(int n_columns) {
        N_columns = n_columns;
    }

    public Point getPrince() {
        return prince;
    }

    public void setPrince(Point prince) {
        this.prince = prince;
    }

    public Point getPrincess() {
        return princess;
    }

    public void setPrincess(Point princess) {
        this.princess = princess;
    }
}