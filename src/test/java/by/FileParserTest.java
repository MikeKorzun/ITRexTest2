package by;


import java.io.File;
import java.io.IOException;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class FileParserTest {

    private char[][][] matrix= {{{'1','.','.'},
                                 {'o','o','.'},
                                 {'.','.','.'}},
                                {{'o','o','o'},
                                 {'.','.','o'},
                                 {'.','o','o'}},
                                {{'o','o','o'},
                                 {'o','.','.'},
                                 {'o','.','2'}}};

    @Test
    public void execute() throws IOException {
        File file = new File("src/test/resources/INPUT_TEST.TXT");
        FileParser fileParser = new FileParser();
        Labyrinth original = fileParser.parseFile(file);
        Labyrinth test = new Labyrinth();
        test.setH_levels(3);
        test.setM_rows(3);
        test.setN_columns(3);
        test.setMatrix(matrix);
        test.setPrince(new Point(0,0,0,'1'));
        test.setPrincess(new Point(2,2,2,'2'));

        assertEquals(test.getH_levels(), original.getH_levels());
        assertEquals(test.getM_rows(), original.getM_rows());
        assertEquals(test.getN_columns(), original.getN_columns());
        assertArrayEquals(test.getMatrix(), original.getMatrix());
        assertEquals(test.getPrince().getValue(), original.getPrince().getValue());
        assertEquals(test.getPrincess().getValue(), original.getPrincess().getValue());
    }
}