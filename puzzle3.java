import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class puzzle3 {
    public static char big(int one, int zero) {
        if (one >= zero) {
            return '1';
        } 
        else {
            return '0';
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        int leng = 1000;
        int great = 0;
        char gamma;
        String beta = "";
        int gamma2 = 0;
        int beta2 = 0;
        FileInputStream fileByteStream = null;
        fileByteStream = new FileInputStream("inputs3");
        Scanner scnr = new Scanner(fileByteStream);
        ArrayList<String> command = new ArrayList<String>();
        ArrayList<String> command2 = new ArrayList<String>();
        for (int i = 0; i < leng; i++) {
            command.add(scnr.nextLine());
        }
        for( int j = 0; j < leng; j++) {
            command2.add(command.get(j));
        }
        String yuh = "";
        for (int i = 0; i < 12; i++) {
            int ic = 0;
            int oc = 0;
            for (int j = 0; j < command.size(); j++) {
                // System.out.println(j);
                if (command.get(j).charAt(i) == '1') {
                    ic++;
                }
                if (command.get(j).charAt(i) == '0') {
                    oc++;
                }
            }
            gamma = big(ic, oc);
            System.out.println(gamma);
            for(int k = 0; k < command.size(); k++) {
                if(command.size()  == 1) {
                    yuh = command.get(0);
                }
                if (command.get(k).charAt(i) != gamma) {
                    command.remove(k);
                    k--;
                }
            }
        }
        for(String k: command) {
            System.out.println(k);
        }
        if(command.size() != 0) {
            yuh = command.get(0);
        }
        String word = "";
        for (int i = 0; i < 12; i++) {
            int ic = 0;
            int oc = 0;
            for (int j = 0; j < command2.size(); j++) {
                // System.out.println(j);
                if (command2.get(j).charAt(i) == '1') {
                    ic++;
                }
                if (command2.get(j).charAt(i) == '0') {
                    oc++;
                }
            }
            gamma = big(ic, oc);
            System.out.println(gamma + " okeh");
            if(gamma == '1') {
                gamma = '0';
            }
            else {
                gamma = '1';
            }
            for(int k = 0; k < command2.size(); k++) {
                if(command2.size()  == 1) {
                    word = command2.get(0);
                }
                if (command2.get(k).charAt(i) != gamma) {
                    command2.remove(k);
                    k--;
                }
            }
        }
        if(command2.size() != 0) {
            word = command2.get(0);
        }
        int one = 0; 
        int two = 0;
        for (int i = 0; i < word.length(); i++) {
            //01010
            one += (int)(Character.getNumericValue(yuh.charAt(yuh.length()-1-i)) * Math.pow(2, i));

            two += (int)(Character.getNumericValue(word.charAt(word.length()-1-i)) * Math.pow(2, i));
            //System.out.println(two + " two");
       }
        System.out.println(one);
        System.out.println(two);
        System.out.println(yuh);
        System.out.println(word);
    }
}


/*
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class puzzle3 {
    public static String big(int one, int zero) {
        if (one > zero) {
            return "1";
        } else {
            return "0";
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        int leng = 1000;
        int great = 0;
        String gamma = "";
        String beta = "";
        int gamma2 = 0;
        int beta2 = 0;
        FileInputStream fileByteStream = null;
        fileByteStream = new FileInputStream("inputs3");
        Scanner scnr = new Scanner(fileByteStream);
        String[] command = new String[leng];
        for (int i = 0; i < leng; i++) {
            command[i] = scnr.nextLine();
        }
        for (int i = 0; i < 12; i++) {
            int ic = 0;
            int oc = 0;
            for (int j = 0; j < command.length; j++) {
                // System.out.println(j);
                if (command[j].charAt(i) == '1') {
                    ic++;
                }
                if (command[j].charAt(i) == '0') {
                    oc++;
                }
            }
            gamma += big(ic, oc);
        }
        for (int i = 0; i < gamma.length(); i++) {
            if (gamma.charAt(i) == '0') {
                beta += "1";
            } else {
                beta += "0";
            }
        }
        System.out.println(gamma);
        for (int i = 0; i < gamma.length(); i++) {
             
             gamma2 += (int)(Character.getNumericValue(gamma.charAt(gamma.length()-1-i)) * Math.pow(2, i));
             beta2 += (int)(Character.getNumericValue(beta.charAt(beta.length()-1-i)) * Math.pow(2, i));
        }
        System.out.println(gamma2);
        System.out.println(gamma2 * beta2);
    }
}



*/