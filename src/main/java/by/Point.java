package by;

import java.util.ArrayList;

public class Point {
    private int x_row, y_column, z_level;
    private char value;
    private ArrayList<Point> neighbors = new ArrayList<>();
    private boolean isVisited;
    private int steps;

    public Point() {
    }

    Point(int z_level, int x_row, int y_column) {
        this.x_row = x_row;
        this.y_column = y_column;
        this.z_level = z_level;
    }

    Point(int z_level, int x_row, int y_column, char value) {
        this.x_row = x_row;
        this.y_column = y_column;
        this.z_level = z_level;
        this.value = value;
    }

    int getX_row() {
        return x_row;
    }

    public void setX_row(int x_row) {
        this.x_row = x_row;
    }

    int getY_column() {
        return y_column;
    }

    public void setY_column(int y_column) {
        this.y_column = y_column;
    }

    int getZ_level() {
        return z_level;
    }

    public void setZ_level(int z_level) {
        this.z_level = z_level;
    }

    char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    ArrayList<Point> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(ArrayList<Point> neighbors) {
        this.neighbors = neighbors;
    }

    boolean isVisited() {
        return isVisited;
    }

    void setVisited() {
        isVisited = true;
    }

    int getSteps() {
        return steps;
    }

    void setSteps(int steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return ""+z_level+x_row+y_column+" v="+value;
    }
}
