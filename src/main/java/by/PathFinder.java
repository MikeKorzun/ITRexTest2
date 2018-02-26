package by;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class PathFinder {

    private static final int movementTime = 5;

    private ArrayList<Point> graph = new ArrayList<>();
    private char[][][] matrix;
    private int H_levels;
    private int M_rows;
    private int N_columns;
    private Point prince;
    private Point princess;

    PathFinder(Labyrinth labyrinth) {
        this.matrix = labyrinth.getMatrix();
        H_levels = labyrinth.getH_levels();
        M_rows = labyrinth.getM_rows();
        N_columns = labyrinth.getN_columns();
        this.prince = labyrinth.getPrince();
        this.princess = labyrinth.getPrincess();
    }

    private void createGraph() {
        // заполняем соседей со значением '.' или '2'
        for (int i=0; i<H_levels; i++) {
            for (int j = 0; j < M_rows; j++) {
                for (int k = 0; k < N_columns; k++) {
                    Point p = new Point(i, j, k, matrix[i][j][k]);
                    if (i < H_levels-1 && (matrix[i + 1][j][k] == '.' || matrix[i + 1][j][k] == '2'))
                        p.getNeighbors().add(new Point(i + 1, j, k, matrix[i + 1][j][k]));
                    if (j < M_rows-1 && (matrix[i][j + 1][k] == '.' || matrix[i][j + 1][k] == '2'))
                        p.getNeighbors().add(new Point(i, j + 1, k, matrix[i][j + 1][k]));
                    if (j > 0 && (matrix[i][j - 1][k] == '.' || matrix[i][j - 1][k] == '2'))
                        p.getNeighbors().add(new Point(i, j - 1, k, matrix[i][j - 1][k]));
                    if (k < N_columns-1 && (matrix[i][j][k + 1] == '.' || matrix[i][j][k + 1] == '2'))
                        p.getNeighbors().add(new Point(i, j, k + 1, matrix[i][j][k + 1]));
                    if (k > 0 && (matrix[i][j][k - 1] == '.' || matrix[i][j][k - 1] == '2'))
                        p.getNeighbors().add(new Point(i, j, k - 1, matrix[i][j][k - 1]));
                    graph.add(p);
                }
            }
        }
    }

    // применяем немного модифицированный BFS, т.к. "вес" ребер графа одинаковый
    int findPath() {
        createGraph();
        Point point = getPointFromGraph(prince);
        Queue<Point> queue = new ArrayDeque<>();
        // добавляем стартовую точку в очередь и отмечаем как посещенную
        queue.add(point);
        point.setVisited();
        // пока в очереди есть точки...
        while (!queue.isEmpty()) {
            // извлекаем первую в очереди точку
            Point p = queue.poll();
            // если она != финиш
            if (p.getValue() !='2') {
                // если у точки есть соседи
                if (!p.getNeighbors().isEmpty()) {
                    ArrayList<Point> temp = p.getNeighbors();
                    // то проходимся по соседям
                    for (int i=0; i<temp.size(); i++) {
                        Point neighbor = getPointFromGraph(temp.get(i));
                        // если сосед еще не посещался, то добавляем в очередь и отмечаем как посещенный
                        if (!neighbor.isVisited()) {
                            neighbor.setVisited();
                            // увеличиваем расстояние от стартовой точки
                            neighbor.setSteps(p.getSteps()+1);
                            queue.add(neighbor);
                        }
                    }
                }
            } else break;
        }
        return getPointFromGraph(princess).getSteps()*movementTime;
    }

    // поиск точек в графе
    private Point getPointFromGraph(Point point) {
        for (Point p: graph) {
            if (point.getZ_level()==p.getZ_level() &&
                    point.getX_row()==p.getX_row() &&
                    point.getY_column()==p.getY_column()) {
                return p;
            }
        }
        return null;
    }
}