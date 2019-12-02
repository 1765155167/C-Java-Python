// 函数对象.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <vector>
#include <functional>
#include <algorithm>
//函数对象、仿函数
struct Print
{
public:
	Print() :num(0) {

	}
	void operator()(int val) {
		std::cout << val << " ";
		num++;
	}
public:
	int num;
};

struct MyStruct
{

};

void test01()
{
	std::cout << "size:" << sizeof(MyStruct) << std::endl;
	std::vector<int> v;
	v.push_back(1);
	v.push_back(3);
	v.push_back(2);
	v.push_back(5);
	v.push_back(4);
	Print p = for_each(v.begin(), v.end(), Print());
	std::cout << "函数被调用了" << p.num << "次" << std::endl;
}
//内建函数对象
void test02()
{
	std::plus<int> p;
	std::cout << p(1, 5) << std::endl;
}
//谓词:返回值为bool类型的函数或者仿函数
//一个参数为一元谓词
//两个参数为二元谓词
int main()
{
	test02();
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
