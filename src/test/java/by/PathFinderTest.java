package by;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class PathFinderTest {

    private int testTime = 60;

    @Test
    public void execute() {
        File file = new File("src/test/resources/INPUT_TEST.TXT");
        FileParser fileParser = new FileParser();
        PathFinder pathFinder = new PathFinder(fileParser.parseFile(file));
        int original = pathFinder.findPath();

        assertEquals(testTime, original);
    }
}