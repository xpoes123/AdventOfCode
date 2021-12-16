import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class puzzle9 {
    static int maxh = 99;
    static int maxv = 99;
    public static String constructLine(int len, char c) {
        String result = "";
        for (int i = 0; i < len; i++) {
            result += c;
        }
        result += '\n';
        return result;
    }
    
    public static void constructBoardString(int[][] board) {
        for(int i = 0; i < board.length; i++) {
            System.out.println("");
            for(int j = 0; j<board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
        }
    }
    public static int ul(int row, int col, int[][] board) {
        int result = -1;
        if(row == 0 || col == 0) {
            return 100;
        }
        else {
            result = board[row-1][col-1];
        }
        return 100;
    }
    public static int um(int row, int col, int[][] board) {
        int result = 100;
        if(row == 0) {
            return 100;
        }
        else {
            result = board[row-1][col];
        }
        return result;
    }
    public static int ur(int row, int col, int[][] board) {
        int result = 100;
        if(row == 0 || col == maxh) {
            return 100;
        }
        else {
            result = board[row-1][col+1];
        }
        return 100;
    }
    public static int ml(int row, int col, int[][] board) {
        int result = 100;
        if(col == 0) {
            return 100;
        }
        else {
            result = board[row][col-1];
        }
        return result;
    }
    public static int mr(int row, int col, int[][] board) {
        int result = 100;
        if(col == maxh) {
            return 100;
        }
        else {
            result = board[row][col+1];
        }
        return result;
    }
    public static int dl(int row, int col, int[][] board) {
        int result = 100;
        if(row == maxv || col == 0) {
            return 100;
        }
        else {
            result = board[row+1][col-1];
        }
        return 100;
    }
    public static int dm(int row, int col, int[][] board) {
        int result = 100;
        if(row == maxv) {
            return 100;
        }
        else {
            result = board[row+1][col];
        }
        return result;
    }
    public static int dr(int row, int col, int[][] board) {
        int result = -1;
        if(row == maxv || col == maxh) {
            return 100;
        }
        else {
            result = board[row+1][col+1];
        }
        return 100;
    }
    public static int[] neighbors(int row, int col, int[][]board) {
        int[] neighbor = new int[8];
        neighbor[0] = ul(row, col, board);
        neighbor[1] = um(row, col, board);
        neighbor[2] = ur(row, col, board);
        neighbor[3] = ml(row, col, board);
        neighbor[4] = mr(row, col, board);
        neighbor[5] = dl(row, col, board);
        neighbor[6] = dm(row, col, board);
        neighbor[7] = dr(row, col, board);
        
        return neighbor;
    }
    public static void main(String[] args) throws FileNotFoundException {
        int ROW = 100;
        int COL = 100;
        int[][] board = new int[ROW][COL];
        String number = "";
        FileInputStream fileByteStream = null;
        fileByteStream = new FileInputStream("inputs9");
        Scanner scnr = new Scanner(fileByteStream);
        for(int i = 0; i < ROW; i++) {
            if(scnr.hasNextLine()) {
            number = scnr.nextLine();
            }
            for(int j = 0; j < COL; j++) {
                board[i][j] = Character.getNumericValue(number.charAt(j));
            }
        }
        //constructBoardString(board);
        int[] neighbors = new int[8];
        int risk = 0; 
        for(int i = 0; i < ROW; i++) {
            for(int j = 0; j < COL; j++) {
                neighbors = neighbors(i,j,board);
                boolean lowes = true;
                int count = 0; 
                for(int k = 0; k < 8; k++) {
                    if(board[i][j] >= neighbors[k]) {
                        continue;
                    }
                    else {
                        count++;
                    }
                }
                if(count == 8) {
                    risk += board[i][j] +1;
                    System.out.println(i + " " + j + " " + board[i][j]);
                }
            }
        }
        System.out.println(risk);
    }
}
