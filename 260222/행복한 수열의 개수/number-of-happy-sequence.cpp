#include <cstdio>
using namespace std;

// ---------------------------------------------------------

constexpr int MAX_BOARD_SIZE = 100;

int answer;
int board_size;
int seq_len;
int board[MAX_BOARD_SIZE][MAX_BOARD_SIZE];

// ---------------------------------------------------------

inline void input() {
    scanf("%d %d", &board_size, &seq_len);

    for (int y = 0; y < board_size; ++y) {
        for (int x = 0; x < board_size; ++x) {
            scanf("%d", &board[y][x]);
        }
    }
}

// ---------------------------------------------------------

void count_horizontal() {
    for (int y = 0; y < board_size; ++y) {
        int cnt = 1;
        for (int x = 1; x < board_size; ++x) {
            if (board[y][x - 1] == board[y][x]) {
                if (++cnt == seq_len) {
                    ++answer;
                    break;
                }
            } else {
                cnt = 1;
            }
        }
    }
}

void count_vertical() {
    for (int x = 0; x < board_size; ++x) {
        int cnt = 1;
        for (int y = 1; y < board_size; ++y) {
            if (board[y - 1][x] == board[y][x]) {
                if (++cnt == seq_len) {
                    ++answer;
                    break;
                }
            } else {
                cnt = 1;
            }
        }
    }
}

inline void solve() {
    if (seq_len == 1) {
        answer = 2 * board_size;
        return;
    }

    count_horizontal();
    count_vertical();
}

// ---------------------------------------------------------

inline void print() {
    printf("%d\n", answer);
}

// ---------------------------------------------------------

int main() {
    setbuf(stdout, NULL);

    input();
    solve();
    print();

    return 0;
}
