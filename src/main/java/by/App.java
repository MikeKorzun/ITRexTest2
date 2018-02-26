package by;

import java.io.File;

/*
* Код привязан к порядку заполнения файла INPUT.TXT
 */

public class App {
    public static void main(String[] args) {
        File file = new File("src/main/resources/INPUT.TXT");
        FileParser fileParser = new FileParser();
        if (fileParser.parseFile(file) !=null) {
            PathFinder pathFinder = new PathFinder(fileParser.parseFile(file));
            int time = pathFinder.findPath();
            System.out.println("==>> Time to find princess = " + time);
        }
    }
}