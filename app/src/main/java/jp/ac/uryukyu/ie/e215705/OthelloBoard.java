package jp.ac.uryukyu.ie.e215705;

public class OthelloBoard {
    static String white = "●";
    static String black = "○";
    static String[][] aBoard = new String[10][10];


    public static void boardInitation() {
        aBoard[4][4] = white;
        aBoard[4][5] = black;
        aBoard[5][4] = black;
        aBoard[5][5] = white;
        boardPrint();
        System.out.println("");
        System.out.println("黒は”○”、白は”●”です。");
    }

    public static void boardPrint() {
        System.out.println();
        System.out.println("   1 2 3 4 5 6 7 8");
        for (int i = 1; i <= 8; i++) {
            System.out.print(i + " |");
            for (int j = 1; j <= 8; j++) {
                // 一行ずつプリントしていく
                if (aBoard[i][j] == null) {
                    System.out.print(" ");
                    System.out.print("|");
                    continue;
                } else {
                    System.out.print(aBoard[i][j]);
                    System.out.print("|");
                }
            }

            System.out.println("");
        }
        System.out.println();
    }

    public static void startBoard() {

    }

    public static boolean checkEndBoard() {
        // ゲームが終了しているか判定するメソッド
        // ボードが全て満たしていたら、trueを返す。

        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                if (aBoard[i][j] == black || aBoard[i][j] == white) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void endBoard() {
        //ゲームを終了させるメソッド
        int blackNumber = 0;
        int whiteNumber = 0;

        if (checkEndBoard()) {
            for (int i = 1; i <= 8; i++) {
                for (int j = 1; j <= 8; j++) {
                    if (aBoard[i][j] == black) {
                        blackNumber++;
                    } else if (aBoard[i][j] == white) {
                        whiteNumber++;
                    }
                }
            }
        }
        if (blackNumber > whiteNumber) {
            System.out.printf("黒：%d　白：%d枚で", blackNumber,whiteNumber);
            System.out.printf("黒の勝ち！！");
        } else if (whiteNumber > blackNumber) {
            System.out.printf("黒：%d　白：%d枚で", blackNumber,whiteNumber);
            System.out.printf("白の勝ち！！");
        } else if (blackNumber == whiteNumber){
            System.out.printf("黒：%d　白：%d枚で", blackNumber,whiteNumber);
            System.out.println("引き分け");
        }
    }
}