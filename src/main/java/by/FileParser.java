package by;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

class FileParser {

    private int x_prince, y_prince, z_prince;
    private int x_princess, y_princess, z_princess;
    private char v_prince, v_princess;


    Labyrinth parseFile(File file) {
        int H_levels, M_rows, N_columns;
        Labyrinth labyrinth = new Labyrinth();
        List<String> lines = null;
        try {
            lines = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] sizes = lines.get(0).split("\\s+");
        H_levels = Integer.parseInt(sizes[0]);
        M_rows = Integer.parseInt(sizes[1]);
        N_columns = Integer.parseInt(sizes[2]);

        if (H_levels == 0 || M_rows == 0 || N_columns == 0) {
            System.out.println("Размеры лабиринта не могут быть равны 0");
            return null;
        } else {

            char[][][] matrix = new char[H_levels][M_rows][N_columns];

            // переменная для определения номера уровня лабиринта
            int level = 0;

            // проходим по заполненным линиям блоками по row строк минуя пробелы согласно файла
            for (int i = 2; i < lines.size(); i = i + M_rows + 1) {
                char[][] temp = new char[M_rows][N_columns];
                for (int j = 0; j < M_rows; j++) {
                    temp[j] = lines.get(i + j).toCharArray();
                    for (int k = 0; k < temp[j].length; k++) {
                        matrix[level][j][k] = temp[j][k];
                        if (matrix[level][j][k] == '1') {
                            x_prince = j;
                            y_prince = k;
                            z_prince = level;
                            v_prince = matrix[level][j][k];
                        }
                        if (matrix[level][j][k] == '2') {
                            x_princess = j;
                            y_princess = k;
                            z_princess = level;
                            v_princess = matrix[level][j][k];
                        }
                    }
                }
                level++;
            }

            labyrinth.setMatrix(matrix);
            labyrinth.setH_levels(H_levels);
            labyrinth.setM_rows(M_rows);
            labyrinth.setN_columns(N_columns);
            labyrinth.setPrince(new Point(z_prince, x_prince, y_prince, v_prince));
            labyrinth.setPrincess(new Point(z_princess, x_princess, y_princess, v_princess));
        }
        return labyrinth;
    }
}