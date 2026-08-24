import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder output = new StringBuilder();
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer input;

    public static void main(String[] args) throws Exception {
        new Main().run();
        System.out.print(output.toString());
    }

    static final int[][][] blockArr = {
        {
            {1,0},
            {1,1},
        },
        {
            {1,1},
            {1,0},
        },
        {
            {1,1},
            {0,1},
        },
        {
            {0,1},
            {1,1},
        },
        {
            {1,1,1},
        },
        {
            {1},
            {1},
            {1},
        }
    };

    int answer;
    int width;
    int height;
    int[][] board;

    public Main() {}
    public void run() throws Exception { input(); solve(); print(); }

    private void input() throws IOException {
        height = nextInt();
        width = nextInt();
        board = new int[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                board[y][x] = nextInt();
            }
        }
    }

    private void solve() {
        answer = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                for (int blockIdx = 0; blockIdx < blockArr.length; blockIdx++) {
                    answer = Math.max(answer, scoring(x, y, blockIdx));
                }
            }
        }
    }

    private int scoring(int x, int y, int blockIdx) {
        int score = 0;
        final int[][] blockVal = blockArr[blockIdx];
        final int blockHeight = blockVal.length;
        final int blockWidth = blockVal[0].length;
        for (int by = 0; by < blockHeight; by++) {
            for (int bx = 0; bx < blockWidth; bx++) {
                if (blockVal[by][bx] == 0) continue;
                score += getVal(x + bx, y + by);
            }
        }
        return score;
    }

    private int getVal(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) return 0;
        return board[y][x];
    }

    private void print() {
        output.append(answer);
        output.append('\n');
    }

    static String next() throws IOException {
        if (input == null || !input.hasMoreTokens())
            input = new StringTokenizer(reader.readLine().trim());
        return input.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
}
