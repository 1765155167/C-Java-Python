// 深搜-迷宫.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//
/*
UDDLUULRUL
UURLLLRRRU
RRUURLDLRD
RUDDDDUUUU
URUDLLRRUU
DURLRLDLRL
ULLURLLRDU
RDLULLRDDD
UUDDUDUDLL
ULRDLUURRR
U:上 D:下 R:右 L:左
*/
#include <iostream>
using namespace std;
char maze[10][11] = {
        "UDDLUULRUL",
        "UURLLLRRRU",
        "RRUURLDLRD",
        "RUDDDDUUUU",
        "URUDLLRRUU",
        "DURLRLDLRL",
        "ULLURLLRDU",
        "RDLULLRDDD",
        "UUDDUDUDLL",
        "ULRDLUURRR"
};
int v[10][10] = { 0 };
int ans = 0;

bool solve(int i, int j) 
{
    if (i < 0 || i > 9 || j < 0 || j > 9)//走出去了
    {
        return true;
    }
    if (v[i][j] == 1)//循环了
    {
        return false;
    }
    v[i][j] = 1;//标记走过了
    switch (maze[i][j])
    {
    case 'U':
        return solve(i - 1, j);
        break;
    case 'D':
        return solve(i + 1, j);
        break;
    case 'R':
        return solve(i, j + 1);
        break;
    case 'L':
        return solve(i, j - 1);
        break;
    default:
        return false;
    }
}
int main()
{
    ans = 0;
    for (int i = 0; i < 10; i++)
    {
        for (int j = 0; j < 10; j++)
        {
            memset(v, 0, sizeof(v));
            bool res = solve(i, j);
            if (res)
            {
                ans++;
            }
        }
    }
    cout << ans << endl;
}

// 运行程序: Ctrl + F5 或调试 >“开始执行(不调试)”菜单
// 调试程序: F5 或调试 >“开始调试”菜单

// 入门使用技巧: 
//   1. 使用解决方案资源管理器窗口添加/管理文件
//   2. 使用团队资源管理器窗口连接到源代码管理
//   3. 使用输出窗口查看生成输出和其他消息
//   4. 使用错误列表窗口查看错误
//   5. 转到“项目”>“添加新项”以创建新的代码文件，或转到“项目”>“添加现有项”以将现有代码文件添加到项目
//   6. 将来，若要再次打开此项目，请转到“文件”>“打开”>“项目”并选择 .sln 文件
