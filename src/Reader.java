import java.io.File;
import java.io.RandomAccessFile;

import java.util.*;

public class Reader{
    private File wordList = new File("words/English.txt");
    private RandomAccessFile f = new RandomAccessFile(wordList, "r");

    public Reader() throws Exception{
       generateWords();
    }

    public Stack<String> generateWords() throws Exception{
        Stack<String> text = new Stack<String>();

        for(int i=0;i<100;i++){
            long randomLocation = (long) (Math.random() * f.length());
            f.seek(randomLocation);
            f.readLine();
            text.push(f.readLine());
        }

        System.out.println(text);

        return text;
    }
}
