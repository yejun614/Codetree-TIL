import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer input;

    public static void main(String[] args) throws Exception {
        new Main().run();
        System.out.println(output.toString());
    }

    int answer;
    int boardSize;
    char[][] board;

    public Main() {}
    public void run() throws Exception { input(); solve(); print(); }

    private void input() throws IOException {
        boardSize = nextInt();

        board = new char[boardSize][boardSize];

        for (int y = 0; y < boardSize; y++) {
            for (int x = 0; x < boardSize; x++) {
                board[y][x] = next().charAt(0);
            }
        }
    }

    private void solve() {
        answer = 0;

        for (int y = 0; y <= boardSize - 3; y++) {
            for (int x = 0; x <= boardSize - 3; x++) {
                answer = Math.max(answer, cntMat3x3(x, y));
            }
        }
    }

    private int cntMat3x3(int x, int y) {
        int cnt = 0;

        for (int cx = 0; cx < 3; cx++) {
            for (int cy = 0; cy < 3; cy++) {
                if (board[y + cy][x + cx] == '1') cnt++;
            }
        }

        return cnt;
    }

    private void print() {
        output.append(answer);
        output.append('\n');
    }

    String next() throws IOException {
        if (input == null || !input.hasMoreTokens()) {
            input = new StringTokenizer(reader.readLine().trim());
        }
        return input.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
}