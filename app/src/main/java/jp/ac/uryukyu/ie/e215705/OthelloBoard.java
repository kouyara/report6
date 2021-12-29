package jp.ac.uryukyu.ie.e215705;

public class OthelloBoard {
    String white = "○";
    String black = "●";
    String[][] line = new String[8][8];

    public void boardInitation() {
        line[3][3] = white;
        line[3][4] = black;
        line[4][3] = black;
        line[4][4] = white;
        boardPrint();
    }

    public void boardPrint() {
        System.out.println();
        System.out.println("   A B C D E F G H");
        for (int i = 1; i <= 8; i++) {
            System.out.print(i + " |");
            for (String j : line[i - 1]) {
                if (j == null) {
                    System.out.print(" ");
                    System.out.print("|");
                    continue;
                }
                System.out.print(j);
                System.out.print("|");
            }
            System.out.println("");
        }
        System.out.println();
    }
}