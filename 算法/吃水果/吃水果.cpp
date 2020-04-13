#include <iostream>
using namespace std;
/*
链接：https://ac.nowcoder.com/acm/contest/5026/B
来源：牛客网

题目描述
      最近米咔买了n个苹果和m个香蕉，他每天可以选择吃掉一个苹果和一个香蕉（必须都吃一个，即如果其中一种水果的数量为0，则他不能进行这个操作），或者使用魔法将某一种水果的数量翻倍。
      现在米咔想吃西瓜了，但是他的主人赛小息不让他买新水果，除非苹果和香蕉没有了，即数量都是0了。

      现在米咔想知道，最少用多少天他可以吃光苹果和香蕉。

      可以证明的是，一定存在一种方案可以让米咔在若干天后吃光苹果和香蕉。

输入描述:
第一行一个正整数T（T≤100），代表数据组数。

接下来T行每行两个正整数n，m（n，m ≤100000）。

输出描述:
共T行，每行一个正整数代表答案。*/
int main()
{
    int T;
    cin >> T;
    while (T--) {
        int n, m, res = 0;
        cin >> n >> m;//n个苹果和m个香蕉
        if (n > m) {
            swap(n, m);
        }
        while (n != 0) {
            if (n * 2 <= m) {
                res++;
                n *= 2;
                continue;
            }
            n--; m--; res++;
        }
        cout << res << endl;
    }
    return 0;
}