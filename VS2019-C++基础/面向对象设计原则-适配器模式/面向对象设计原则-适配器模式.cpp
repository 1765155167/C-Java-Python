// 面向对象设计原则-适配器模式.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <vector>
#include <algorithm>
#include <functional>

struct MyCompare: public std::binary_function<int, int, void> 
{
	void operator()(int a, int b) const {
		std::cout << a + b << " ";
	}
};

//STL适配器
void test01()
{
	int data[] = { 1,2,3,4,5,4,7,8,4,9,8 };
	std::vector<int> v(data, data+sizeof(data)/sizeof(data[0]));
	for_each(v.begin(), v.end(), std::bind2nd(MyCompare(), 100));
}

//自己写一个适配器
struct MyCompare2
{
	void operator()(int a, int b) const {
		std::cout << a + b << " ";
	}
};
struct Abstract {
	virtual void operator()(int val) = 0;
};
//struct与class只是默认权限不同，其他一样，可任意互唤
class Adapter :public Abstract{
public:
	Adapter(int num) {
		this->num = num;
	}
	virtual void operator()(int val) {
		this->compare2(val, num);
	}
private:
	MyCompare2 compare2;
	int num;
};
Adapter MyBind2nd(int num)
{
	return Adapter(num);
}
void test02()
{
	int data[] = { 1,2,3,4,5,4,7,8,4,9,8 };
	std::vector<int> v(data, data + sizeof(data) / sizeof(data[0]));
	for_each(v.begin(), v.end(), MyBind2nd(100));
}

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
