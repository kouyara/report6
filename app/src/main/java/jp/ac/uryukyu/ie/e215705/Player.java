package jp.ac.uryukyu.ie.e215705;

import java.util.Scanner;
import static jp.ac.uryukyu.ie.e215705.OthelloBoard.aBoard;
import static jp.ac.uryukyu.ie.e215705.OthelloBoard.black;
import static jp.ac.uryukyu.ie.e215705.OthelloBoard.white;

public class Player {

    public String input() {
        // プレイヤーが置く石の位置を入力してもらう。
        String input;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input > ");
        input = scanner.nextLine();
        return input;
    }

    public boolean checkInput(String input) {
        // 正規表現を使って、プレイヤーが正しく置けているかチェックする。
        // 正しく置けていたら、trueを返す。

        return input.matches("[1-8]-[1-8]");
    }

    public String runUntilCanPut(String stone) {
        // プレイヤーが置くことのできるマスに置くまで、プレイヤーに入力し続けてもらうメソッド。
        // 正しく入力できたら、入力した文字列を返す。
        // 置くことのできるマスがない時、プレイヤーはパスを行い、nullを返す。
        int[] lineRow = new int[2];
        String input = "";
        int i = 1;
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
                    i++;
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

    public int[] inputToLineRow(String input) {
        // プレイヤーが入力した文字列を引数にとる。
        // 引数の文字列から、分解して横列と縦列の整数に変換する。
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

    public boolean checkOverlap(int[] lineRow) {
        // プレイヤーの置くマスが他の石とかぶっているかチェックする。
        // かぶっていなかったらtrueを返す。
        int line = lineRow[0];
        int row = lineRow[1];

        return aBoard[line][row] != black && aBoard[line][row] != white;
    }

    public boolean checkSandwich(String stone, int[] lineRow) {
        // プレイヤーの置くマスがちゃんと挟めているかチェックする。
        // 挟めていたらtrue、挟めていなかったらfalseを返す。
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

    public boolean checkCanPut(String stone) {
        // 置くことのできるマスがあるときtrueを返すメソッド。
        // 置くことのできるマスがない時、falseを返す。
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

    public void putAStone(String stone, int[] lineRow) {
        // プレイヤーが石を置くメソッド。
        int line = lineRow[0];
        int row = lineRow[1];

        aBoard[line][row] = stone;
    }

    public int[] directionSandwichStone(String stone, int[] lineRow) {
        // どの方向が挟まれているかチェックするメソッド。
        // int型の配列として、左上が挟まれていたら1、真上なら2、右上なら3、右なら4、右下なら5
        // 真下なら6、左下なら7、左なら8を代入していく。

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

    public void turnAStone(int[] direction, String stone, int[] lineRow) {
        // 挟んでいる時に、石をひっくり返すメソッド
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
