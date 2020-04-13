#include <iostream>
#include <algorithm>
using namespace std;

using ll = long long;

//求从1-x范围内约数首部为v的个数 x = 159 v = 2
ll get(int x, int v) {
    ll res = 0;//结果
    for (ll pw = 1; pw <= x / v; pw *= 10) {//1 10 
        int cur = v * pw,/*2 20*/ bound = min((ll)x, cur + pw - 1);/*2 29*/
        // 枚举区间[cur, bound][2,2] [20,29]
        for (int i = cur, j; i <= bound; i = j + 1) {
            j = min(x / (x / i), bound);
            res += 1ll * ((ll)j - (ll)i + 1ll) * (x / i);
        }
    }
    return res;
}

int main() {
    int l, r;
    cin >> l >> r;
    for (int i = 1; i <= 9; i++) {
        cout << get(r, i) - get(l - 1, i) << "\n";
    }
    return 0;
}