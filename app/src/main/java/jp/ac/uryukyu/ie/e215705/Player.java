package jp.ac.uryukyu.ie.e215705;

import java.util.Scanner;
import static jp.ac.uryukyu.ie.e215705.OthelloBoard.aBoard;
import static jp.ac.uryukyu.ie.e215705.OthelloBoard.black;
import static jp.ac.uryukyu.ie.e215705.OthelloBoard.white;

public class Player {

    /**
     * プレイヤーに置く石の位置を入力してもらうメソッド。
     * @return プレイヤーが入力した文字列
     */
    public String input() {
        String input;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input > ");
        input = scanner.nextLine();
        return input;
    }

    /**
     * プレイヤーが正しく書けているかを、正規表現を使ってチェックするメソッド。
     * @param input プレイヤーが入力した文字列
     * @return 正しく置けていたら、trueを返す。
     */
    public boolean checkInput(String input) {

        return input.matches("[1-8]-[1-8]");
    }

    /**
     * プレイヤーが置くことのできるマスに置くまで、プレイヤーに入力し続けてもらうメソッド。
     * 置くことのできるマスがない時、プレイヤーはパスを行い、返り値はnullを返す。
     * @param stone プレイヤーが持っている石。（白または黒）OthelloBoard.black または、OthelloBoard.Whiteを使う。
     * @return 正しく入力できていたら、入力した文字列を返す。置くことのできるマスがない時、nullを返す。
     */
    public String runUntilCanPut(String stone) {
        int[] lineRow = new int[2];
        String input = "";
        int j = 1;

        if (checkCanPut(stone)) {
            do {
                if (j >= 2) {
                    System.out.println("ここは置けません");
                    System.out.println("もう一度入力してください。");
                }
                input = input();
                while (!checkInput(input)) {
                    // 正しかったら抜ける。
                        System.out.println("もう一度正しく入力してください。");
                    input = input();

                }
                lineRow = inputToLineRow(input);
                j++;

            } while ( ! (checkOverlap(lineRow) && checkSandwich(stone, lineRow)));
            return input;
        } else {
            System.out.println("パス");
            return null;
        }

    }

    /**
     * プレイヤーが入力した文字列から数字だけを抜き取り、int型に変換し、配列に格納して返すメソッド。
     * @param input プレイヤーが入力した文字列
     * @return 横の行数、縦の列数の情報が入ったint配列
     */
    public int[] inputToLineRow(String input) {
        String[] inputArray;
        int line;
        int row;
        int[] lineRow = new int[2];

        inputArray = input.split("-");
        line = Integer.parseInt(inputArray[0]);
        row = Integer.parseInt(inputArray[1]);
        lineRow[0] = line;
        lineRow[1] = row;
        return lineRow;
    }

    /**
     * プレイヤーの置くマスが他の石とかぶっているかチェックするメソッド。
     * @param lineRow 横の行数、縦の列数の情報が入ったint配列
     * @return 他の石とかぶっていなかったらtrueを返す。
     */
    public boolean checkOverlap(int[] lineRow) {
        int line = lineRow[0];
        int row = lineRow[1];

        return aBoard[line][row] != black && aBoard[line][row] != white;
    }

    /**
     * プレイヤーの置くマスが相手の石をひっくり返せるかチェックするメソッド。
     * @param stone プレイヤーが持っている石。（白または黒）OthelloBoard.black または、OthelloBoard.Whiteを使う。
     * @param lineRow 横の行数、縦の列数の情報が入ったint配列
     * @return 相手のマスと挟めていたらtrue、挟めていなかったらfalseを返す。
     */
    public boolean checkSandwich(String stone, int[] lineRow) {
        int line = lineRow[0];
        int row = lineRow[1];
        String anotherStone = "";
        boolean bool = false;

        if (stone == black) {
            anotherStone = white;
        } else if (stone == white) {
            anotherStone = black;
        }

        for (int i = 1; i <= 7; i++) {
            if (aBoard[line - i][row - i] == anotherStone) {
                // 左上のますを処理
            } else if (aBoard[line - i][row - i] == stone) {
                if (i == 1) {
                    break;
                }
                bool = true;
            } else if (aBoard[line - i][row - i] == null) {
                break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (aBoard[line - i][row] == anotherStone) {
                // 上のますを処理
            } else if (aBoard[line - i][row] == stone) {
                if (i == 1) {
                    break;
                }
                bool = true;
            } else if (aBoard[line - i][row] == null) {
                break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (aBoard[line - i][row + i] == anotherStone) {
                // 右上のますを処理
            } else if (aBoard[line - i][row + i] == stone) {
                if (i == 1) {
                    break;
                }
                bool = true;
            } else if (aBoard[line - i][row + i] == null) {
                break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (aBoard[line][row + i] == anotherStone) {
                // 右のますを処理
            } else if (aBoard[line][row + i] == stone) {
                if (i == 1) {
                    break;
                }
                bool = true;
            } else if (aBoard[line][row + i] == null) {
                break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (aBoard[line + i][row + i] == anotherStone) {
                // 右下のますを処理
            } else if (aBoard[line + i][row + i] == stone) {
                if (i == 1) {
                    break;
                }
                bool = true;
            } else if (aBoard[line + i][row + i] == null) {
                break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (aBoard[line + i][row] == anotherStone) {
                // 下のますを処理
            } else if (aBoard[line + i][row] == stone) {
                if (i == 1) {
                    break;
                }
                bool = true;
            } else if (aBoard[line + i][row] == null) {
                break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (aBoard[line + i][row - i] == anotherStone) {
                // 左下のますを処理
            } else if (aBoard[line + i][row - i] == stone) {
                if (i == 1) {
                    break;
                }
                bool = true;
            } else if (aBoard[line + i][row - i] == null) {
                break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (aBoard[line][row - i] == anotherStone) {
                // 左のますを処理
            } else if (aBoard[line][row - i] == stone) {
                if (i == 1) {
                    break;
                }
                bool = true;
            } else if (aBoard[line][row - i] == null) {
                break;
            }
        }
        if (bool == true) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 置くことのできるマスがあるかチェックするメソッド。
     * @param stone プレイヤーが持っている石。（白または黒）OthelloBoard.black または、OthelloBoard.Whiteを使う。
     * @return 置くことのできるマスがあるときtrueを返し、置くことのできるマスがない時、falseを返す。
     */
    public boolean checkCanPut(String stone) {
        int[] lineRow = new int[2];
        boolean bool = false;

        for (int line = 1; line <= 8; line++) {
            for (int row = 1; row <= 8; row++) {
                lineRow[0] = line;
                lineRow[1] = row;
                if (checkOverlap(lineRow) && checkSandwich(stone, lineRow)) {
                    return true;
                }
            }
        }
        return bool;
    }

    /**
     * プレイヤーが入力した場所に石を置くメソッド。
     * @param stone プレイヤーが持っている石。（白または黒）OthelloBoard.black または、OthelloBoard.Whiteを使う。
     * @param lineRow 横の行数、縦の列数の情報が入ったint配列。
     */
    public void putAStone(String stone, int[] lineRow) {
        int line = lineRow[0];
        int row = lineRow[1];

        aBoard[line][row] = stone;
    }

    /**
     * どの方向が挟まれているかチェックするメソッド。
     * @param stone プレイヤーが持っている石。（白または黒）OthelloBoard.black または、OthelloBoard.Whiteを使う。
     * @param lineRow 横の行数、縦の列数の情報が入ったint配列。
     * @return int型の配列として、左上が挟まれていたら0番目に1、上なら1番目に2、右上なら2番目に3、右なら3番目に4、右下なら4番目に5、下なら5番目に6、左下なら6番目に7、左なら7番目に8を代入する。
     */
    public int[] directionStone(String stone, int[] lineRow) {
        int line = lineRow[0];
        int row = lineRow[1];
        String anotherStone = "";
        int[] direction = new int[8];

        if (stone == black) {
            anotherStone = white;
        } else if (stone == white) {
            anotherStone = black;
        }

        for (int i = 1; i <= 7; i++) {
            if (aBoard[line - i][row - i] == anotherStone) {
                // 左上のますを処理
            } else if (aBoard[line - i][row - i] == stone) {
                if (i == 1) {
                    break;
                }
                direction[0] = 1;
            } else if (aBoard[line - i][row - i] == null) {
                break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (aBoard[line - i][row] == anotherStone) {
                // 上のますを処理
            } else if (aBoard[line - i][row] == stone) {
                if (i == 1) {
                    break;
                }
                direction[1] = 2;
            } else if (aBoard[line - i][row] == null) {
                break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (aBoard[line - i][row + i] == anotherStone) {
                // 右上のますを処理
            } else if (aBoard[line - i][row + i] == stone) {
                if (i == 1) {
                    break;
                }
                direction[2] = 3;
            } else if (aBoard[line - i][row + i] == null) {
                break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (aBoard[line][row + i] == anotherStone) {
                // 右のますを処理
            } else if (aBoard[line][row + i] == stone) {
                if (i == 1) {
                    break;
                }
                direction[3] = 4;
            } else if (aBoard[line][row + i] == null) {
                break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (aBoard[line + i][row + i] == anotherStone) {
                // 右下のますを処理
            } else if (aBoard[line + i][row + i] == stone) {
                if (i == 1) {
                    break;
                }
                direction[4] = 5;
            } else if (aBoard[line + i][row + i] == null) {
                break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (aBoard[line + i][row] == anotherStone) {
                // 下のますを処理
            } else if (aBoard[line + i][row] == stone) {
                if (i == 1) {
                    break;
                }
                direction[5] = 6;
            } else if (aBoard[line + i][row] == null) {
                break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (aBoard[line + i][row - i] == anotherStone) {
                // 左下のますを処理
            } else if (aBoard[line + i][row - i] == stone) {
                if (i == 1) {
                    break;
                }
                direction[6] = 7;
            } else if (aBoard[line + i][row - i] == null) {
                break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (aBoard[line][row - i] == anotherStone) {
                // 左のますを処理
            } else if (aBoard[line][row - i] == stone) {
                if (i == 1) {
                    break;
                }
                direction[7] = 8;
            } else if (aBoard[line][row - i] == null) {
                break;
            }
        }
        return direction;
    }

    /**
     * 石をひっくり返すメソッド
     * @param direction 石を挟んでいる方向。
     * @param stone プレイヤーが持っている石。（白または黒）OthelloBoard.black または、OthelloBoard.Whiteを使う。
     * @param lineRow 横の行数、縦の列数の情報が入ったint配列。
     */
    public void turnAStone(int[] direction, String stone, int[] lineRow) {
        int line = lineRow[0];
        int row = lineRow[1];
        String anotherStone = "";

        if (stone == black) {
            anotherStone = white;
        } else if (stone == white) {
            anotherStone = black;
        }

        for (int i : direction) {
            int j = 1;

            switch (i) {
                case 1:
                    while (aBoard[line - j][row - j] == anotherStone) {
                        aBoard[line - j][row - j] = stone;
                        j++;
                    }
                    j = 1;
                    break;
                case 2:
                    while (aBoard[line - j][row] == anotherStone) {
                        aBoard[line - j][row] = stone;
                        j++;
                    }
                    j = 1;
                    break;
                case 3:
                    while (aBoard[line - j][row + j] == anotherStone) {
                        aBoard[line - j][row + j] = stone;
                        j++;
                    }
                    j = 1;
                    break;
                case 4:
                    while (aBoard[line][row + j] == anotherStone) {
                        aBoard[line][row + j] = stone;
                        j++;
                    }
                    j = 1;
                    break;
                case 5:
                    while (aBoard[line + j][row + j] == anotherStone) {
                        aBoard[line + j][row + j] = stone;
                        j++;
                    }
                    j = 1;
                    break;
                case 6:
                    while (aBoard[line + j][row] == anotherStone) {
                        aBoard[line + j][row] = stone;
                        j++;
                    }
                    j = 1;
                    break;
                case 7:
                    while (aBoard[line + j][row - j] == anotherStone) {
                        aBoard[line + j][row - j] = stone;
                        j++;
                    }
                    j = 1;
                    break;
                case 8:
                    while (aBoard[line][row - j] == anotherStone) {
                        aBoard[line][row - j] = stone;
                        j++;
                    }
                    j = 1;
                    break;
            }
        }
    }
}
