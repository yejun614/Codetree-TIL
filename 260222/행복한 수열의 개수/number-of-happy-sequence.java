import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer input;

    // -------------------------------------------

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    // -------------------------------------------

    int answer;
    int boardSize;
    int seqLen;
    int[][] board;

    public void run() throws IOException {
        input();
        solve();
        print();
    }

    private void input() throws IOException {
        getLine();
        boardSize = Integer.parseInt(input.nextToken());
        seqLen = Integer.parseInt(input.nextToken());

        board = new int[boardSize][boardSize];

        for (int y = 0; y < boardSize; y++) {
            getLine();

            for (int x = 0; x < boardSize; x++) {
                board[y][x] = Integer.parseInt(input.nextToken());
            }
        }
    }

    private void solve() {
        if (seqLen == 1) {
            answer = 2 * boardSize;
            return;
        }

        countHorizontal();
        countVertical();
    }

    private void countHorizontal() {
        for (int y = 0; y < boardSize; y++) {
            int cnt = 1;
            for (int x = 1; x < boardSize; x++) {
                if (board[y][x - 1] == board[y][x]) {
                    if (++cnt == seqLen) {
                        ++answer;
                        break;
                    }
                } else {
                    cnt = 1;
                }
            }
        }
    }

    private void countVertical() {
        for (int x = 0; x < boardSize; x++) {
            int cnt = 1;
            for (int y = 1; y < boardSize; y++) {
                if (board[y - 1][x] == board[y][x]) {
                    if (++cnt == seqLen) {
                        ++answer;
                        break;
                    }
                } else {
                    cnt = 1;
                }
            }
        }
    }
    
    private void print() throws IOException {
        writer.write(answer + "\n");
        writer.flush();
    }

    // -------------------------------------------

    private static void getLine() throws IOException {
        input = new StringTokenizer(reader.readLine().trim());
    }
}
