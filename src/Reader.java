import java.io.File;
import java.io.RandomAccessFile;

import java.util.*;

public class Reader{
    private File wordList = new File("words/English.txt");
    private RandomAccessFile f = new RandomAccessFile(wordList, "r");
    private long randomLocation;

    public Reader() throws Exception{

    }

    public Stack<String> generateWords() throws Exception{  
        Stack<String> text = new Stack<String>();

        for(int i=0;i<256;i++){
            randomLocation = (long) (Math.random() * f.length());
            
            f.seek(randomLocation);

            if(randomLocation==0){
                text.push(f.readLine());
            }else if((char)f.readByte()=='\n'){
                text.push(f.readLine());
            }else{
                while(true){
                    randomLocation-=2;
                    if(randomLocation < 0){
                        randomLocation = 0;
                    }
                    f.seek(randomLocation);

                    if(randomLocation==0){
                        text.push(f.readLine());
                        break;
                    }else if((char)f.readByte()=='\n'){
                        text.push(f.readLine());
                        break;
                    }
                }           
            }
        }
        System.out.println(text);

        return text;
    }
}
