import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class puzzle2 {
    public static void main(String[] args) throws FileNotFoundException {
        int leng = 1000;
        int horz  = 0;
        int aim = 0; 
        int depth = 0;
        FileInputStream fileByteStream = null;
        fileByteStream = new FileInputStream("inputs2");
        Scanner scnr = new Scanner(fileByteStream);
        String[] command = new String[leng*2];
        for( int i = 0; i < leng*2; i++) {
            command[i] = scnr.next();
        }
        for( int i = 0; i < command.length; i++) {
            if(i % 2 == 0) {
                if(command[i].equals("forward")) {
                    horz += Integer.valueOf(command[i+1]);
                    depth += aim * Integer.valueOf(command[i+1]);
                }
                else if(command[i].equals("up")) {
                    aim += Integer.valueOf(command[i+1]);
                }
                else if(command[i].equals("down")) {
                    aim -= Integer.valueOf(command[i+1]);
                }
            }
    }
        System.out.println(horz);
        System.out.println(depth);
    }
}

