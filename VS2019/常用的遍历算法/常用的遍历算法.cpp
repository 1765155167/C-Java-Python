// 常用的遍历算法.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <vector>
#include <algorithm>
//for_each()
//transfrom()将一个容器中的元素搬运到另一个容器
class MyCompare
{
public:
	int operator()(int val)
	{
		return val + 100;
	}
};
void Print(int val)
{
	std::cout << val << " ";
}
void test01()
{
	int data[] = { 1,2,3,4,5,6,7,8,9 };
	std::vector<int> v1(data, data + sizeof(data) / sizeof(data[0]));
	std::vector<int> v2;
	v2.resize(v1.size());
	//类似拷贝 v2.begin()需要先申请空间
	transform(v1.begin(),v1.end(),v2.begin(), MyCompare());
	for_each(v1.begin(), v1.end(), Print);
	std::cout << std::endl;
	for_each(v2.begin(), v2.end(), Print);
	std::cout << std::endl;
}
int main()
{
	test01();
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
