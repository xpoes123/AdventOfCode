import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class puzzle4 {
    public static boolean win(int[] board) {
        for (int i = 0; i < 5; i++) {
            if (board[i] == 1 && board[i + 5] == 1 && board[10 + i] == 1 && board[15 + i] == 1
                && board[20 + i] == 1) {
                return true;
            }
        }
        for(int i = 0; i < 25; i += 5) {
            if (board[i] == 1 && board[i + 1] == 1 && board[2 + i] == 1 && board[3 + i] == 1
                && board[4 + i] == 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fileByteStream = null;
        int boardNum = 100;
        fileByteStream = new FileInputStream("inputs4");
        Scanner scnr = new Scanner(fileByteStream);
        ArrayList<Integer> moves = new ArrayList<Integer>();
        int[][] board = new int[boardNum][25];
        String cancan = "";
        String wau = "";
        while (scnr.hasNextLine()) {
            cancan = scnr.nextLine();
            if (cancan == "") {
                break;
            } else {
                wau += cancan;
            }
        }
        wau = wau.replaceAll(",", " ");
        Scanner mover = new Scanner(wau);
        while (mover.hasNextInt()) {
            moves.add(mover.nextInt());
        }
        for (int i = 0; i < boardNum; i++) {
            for (int j = 0; j < 25; j++) {
                board[i][j] = scnr.nextInt();
            }
        }
        int[][] moveBoard = new int[boardNum][25];
        for (int i = 0; i < boardNum; i++) {
            for (int j = 0; j < 25; j++) {
                moveBoard[i][j] = 0;
            }
        }
        int[] boards2 = new int[boardNum];
        for(int i = 0; i < boardNum; i++) {
            boards2[i] = i;
        }
        outer: for (int i = 0; i < moves.size(); i++) {
            int first = moves.get(i);
            for (int a = 0; a < boardNum; a++) {
                for (int j = 0; j < 25; j++) {
                    if (board[a][j] == first) {
                        moveBoard[a][j] = 1;
                        if (win(moveBoard[a]) == true) {
                            boards2[a] = 0;
                            int count = 0;
                            for(int p: boards2) {
                            if(p != 0) {
                                count++;
                            }
                        }
                            if(count == 1) {
                                for(int p: boards2) {
                                    if(p != 0) {
                                        System.out.println(p);
                                    }
                                }
                            }
                        }
                    }
                }

            // Add win checker 0-4, 5-9, 10-14, 15-19, 20-24,
            // 0 mod 5, 1 mod 5, 2 mod 5

        }
        }
        }
}
