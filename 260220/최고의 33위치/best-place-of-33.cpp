#include <cstdio>
#include <cmath>
using namespace std;

constexpr int MAX_BOARD_SIZE = 20;
constexpr int SUB_BOARD_SIZE = 3;

int answer;
int board_size;
int board[MAX_BOARD_SIZE][MAX_BOARD_SIZE];

void input() {
    scanf("%d", &board_size);

    for (int y = 0; y < board_size; ++y) {
        for (int x = 0; x < board_size; ++x) {
            scanf("%d", &board[y][x]);
        }
    }
}

void solve() {
    answer = 0;
    int current;

    for (int y = 0; y < board_size - SUB_BOARD_SIZE + 1; ++y) {
        for (int x = 0; x < board_size - SUB_BOARD_SIZE + 1; ++x) {

            current = 0;

            for (int cy = 0; cy < SUB_BOARD_SIZE; ++cy) {
                for (int cx = 0; cx < SUB_BOARD_SIZE; ++cx) {
                    current += board[y + cy][x + cx];
                }
            }

            answer = max(answer, current);

        }
    }
}

void print() {
    printf("%d\n", answer);
}

int main() {
    setbuf(stdout, NULL);

    input();
    solve();
    print();

    return 0;
}
