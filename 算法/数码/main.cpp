#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;


//获取首位数字
int getFirstNum(int x) {
    int ans = 0;
    while (x > 0)
    {
        ans = x % 10;
        x /= 10;
    }
    return ans;
}

vector<int> getNum(int x) {
    vector<int> data;
    for (int i = 1; i <= x; i++) {
        if (x % i == 0) {
            data.push_back(getFirstNum(i));
        }
    }
    return data;
}
int dataNum[10] = { 0 };

struct MyPrint {
    void operator()(int num) {
        //cout << num << " ";
        dataNum[num - 1]++;
    }
};
//[1,r] ret->a[];
void calc(int r, int* data)
{
    for (int a = 1; a * a <= r; a++)    //枚举一个因子a
    {
        int b = r / a;                //b的范围左界是i+1（为了不算重复），右界是r/i
        for (int j = 1; j <= r; j *= 10)   //枚举位数（直接用1后面若干个0，方便后面计算）
        {
            for (int k = 1; k <= 9; k++)   // 枚举首位数
            {
                int x = max(j * k, a + 1);      //x是最高位为k的时候的下界
                int y = min((j * (k + 1)) - 1, b);  //y是上界
                if (y - x >= 0) data[k] += y - x + 1;  //这个区间存在，算个数
            }
        }
        int tmp = getFirstNum(a);          //算a的首位
        data[tmp] += b - a + 1;            //算用了多少个a
    }
}


int main() {
    int l, r;
    
    cin >> l >> r;
    for (int i = l; i <= r; i++) {
        vector<int> data = getNum(i);
        //cout << i << ":";
        std::for_each(data.begin(), data.end(), MyPrint());
        //cout << endl;
    }
    for (size_t i = 0; i < 10; i++)
    {
        cout << dataNum[i] << endl;
    }
    return 0;
}