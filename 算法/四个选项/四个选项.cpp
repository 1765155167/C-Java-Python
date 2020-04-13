#include <iostream>
using namespace std;
struct XT {
    int x;
    int y;
};
struct MyStruct {
    int an;
    int bn;
    int cn;
    int dn;
};
int arr[12] = { 0 };//12个题目
XT xt[6];//相同答案位置
int res = 0;
int na, nb, nc, nd, m;
bool isOK() {
    int a = 0, b = 0, c = 0, d = 0;
    for (int i = 0; i < 12; i++) {
        if (arr[i] == 0) a++;
        if (arr[i] == 1) b++;
        if (arr[i] == 2) c++;
        if (arr[i] == 3) d++;
    }
    if (a == na && b == nb && c == nc && d == nd) {
        for (int i = 0; i < m; i++) {
            if (arr[xt[i].x] != arr[xt[i].y]) {
                return false;
            }
        }
        return true;
    }
    return false;
}

MyStruct getMyStruct(int k) {
    int res = 0;
    MyStruct a = { 0,0,0,0 };
    for (int i = 0; i <= k; i++) {
        if (arr[i] == 0) a.an++;
        if (arr[i] == 1) a.bn++;
        if (arr[i] == 2) a.cn++;
        if (arr[i] == 3) a.dn++;
    }
    return a;
}

void dns(int k) {
    if (k == 12) {
        if (isOK()) {
            res++;
        }
        return;
    }
    for (int i = 0; i < 4; i++) {
        arr[k] = i;
        MyStruct st = getMyStruct(k);
        if (st.an > na || st.bn > nb || st.cn > nc || st.dn > nd) continue;
        dns(k + 1);
    }
}

int main()
{
    cin >> na >> nb >> nc >> nd >> m;
    for (int i = 0; i < m; i++) {
        cin >> xt[i].x >> xt[i].y;
    }
    dns(0);
    cout << res << endl;
    return 0;
}