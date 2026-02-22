#include <iostream>

using namespace std;

int answer;
int n, m;
int grid[100][100];

int main() {
    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> grid[i][j];
        }
    }

    if (m == 1) {
        cout << 2 * n << "\n";
        return 0;
    }

    answer = 0;

    for (int y = 0; y < n; ++y) {
        int cnt = 1;
        for (int x = 1; x < n; ++x) {
            if (grid[y][x - 1] == grid[y][x]) {
                if (++cnt == m) {
                    ++answer;
                    break;
                }
            } else {
                cnt = 1;
            }
        }
    }

    for (int x = 0; x < n; ++x) {
        int cnt = 1;
        for (int y = 1; y < n; ++y) {
            if (grid[y - 1][x] == grid[y][x]) {
                if (++cnt == m) {
                    ++answer;
                    break;
                }
            } else {
                cnt = 1;
            }
        }
    }

    cout << answer << "\n";

    return 0;
}
