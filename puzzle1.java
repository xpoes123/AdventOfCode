import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class puzzle1 {

    public static void main(String[] args) throws FileNotFoundException {
        int counter = 0;
        int leng = 2000;
        int threeSum = 0;
        FileInputStream fileByteStream = null;
        fileByteStream = new FileInputStream("inputs");
        Scanner scnr = new Scanner(fileByteStream);
        int[] values = new int[leng];
        for( int i = 0; i < leng; i++) {
            values[i] = scnr.nextInt();
        }
        int[] window = new int[leng-2];
        for( int j = 0; j < window.length-1; j=j) {
        for( int i = 0; i < leng-2; i++) {
            threeSum = values[i]+values[i+1]+values[i+2];
            window[j] = threeSum;
            j++;
            }
        }
        
        for(int i = 0; i < window.length-1; i++) {
            if(window[i] < window[i+1]) {
                counter++;
            }
        }
        System.out.println(counter);
      }
}
