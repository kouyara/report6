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
}