// 万万没想到之聪明的编辑.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <string>
#include <cstdio>
#include <cstdlib>

using namespace std;
/**
 * 1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
 * 2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
 * 3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
**/

int checkThree(string data, int start) {
    for (int i = start; i < data.length() - 2; i++)
    {
        if (data[i] == data[i + 1] && data[i] == data[i + 2]) {
            return i;
        }
    }
    return -1;
}
int checkTow(string data, int start) {
    for (int i = start; i < data.length() - 3; i++)
    {
        if (data[i] == data[i + 1] && data[i+2] == data[i + 3]) {
            return i;
        }
    }
    return -1;
}
void check(string data) {
    //判断是否有三个字符连载一起
    int index = 0;
    do
    {
        index = checkThree(data, index);
        if (index != -1) //存在
        {
            //string a = "";
            //a += data[index];
            //a += data[index + 1];
            ////data.replace(index, 3, a);
            data.erase(index, 1);
        }
    } while (index != -1);
    index = 0;
    do
    {
        index = checkTow(data, index);
        if (index != -1) //存在
        {
            //string a = "";
            //a += data[index];
            //a += data[index + 1];
            //a += data[index + 2];
            ////data.replace(index, 4, a);
            data.erase(index + 2, 1);
        }
    } while (index != -1);
    cout << data << endl;
}
int main()
{
    int n = 0;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        string data;
        cin >> data;
        check(data);
    }
    return 0;
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
