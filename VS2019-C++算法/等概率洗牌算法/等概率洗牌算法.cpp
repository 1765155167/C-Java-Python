// 等概率洗牌算法.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <Windows.h>
#include <ctime>
//等概率随机洗牌算法
void Shuffle(int data[], int len) {
	DWORD t_start, t_end;
	t_start = GetTickCount64();
	srand((int)t_start);
	for (int i = len - 1; i >= 0; i--)
	{
		std::swap(data[rand() % (i+1)], data[i]);
	}
}
//概率测试程序
void text() {
	int length = 10000;
	int num[10][10] = { 0 };
	for (size_t i = 0; i < length; i++)
	{
		Sleep(1);
		int data[] = { 0,1,2,3,4,5,6,7,8,9 };
		int len = sizeof(data) / sizeof(data[0]);
		Shuffle(data, len);
		for (int j = 0; j < len; j++)
		{
			std::cout << data[j] << " ";
			num[j][data[j]]++;
		}
		std::cout << std::endl;
	}
	for (size_t i = 0; i < 10; i++) {
		std::cout << i << ": ";
		for (size_t j = 0; j < 10; j++) {
			std::cout << num[i][j] << " ";
		}
		std::cout << std::endl;
	}
}

int main()
{
	text();
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
