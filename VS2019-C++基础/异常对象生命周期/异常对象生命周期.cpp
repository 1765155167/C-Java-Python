// 异常对象生命周期.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <stdexcept>
class A :public std::exception{
public:
	A(const char* buf) {
		int len = strlen(buf) + 1;
		this->buf = new char[len];
		strcpy_s(this->buf, len, buf);
		std::cout << "构造函数..." << std::endl;
	}
	A(const A& another) {
		std::cout << "拷贝构造函数" << std::endl;
		int len = strlen(another.buf) + 1;
		this->buf = new char[len];
		strcpy_s(this->buf, len, another.buf);
	}
	char const* what() const {
		return this->buf;
	}
	~A() {
		if (this->buf != NULL)
		{
			delete[] this->buf;
		}
		std::cout << "析构函数..." << std::endl;
	}
private:
	char* buf;
};

double device(int x, int y)
{
	if (y == 0)
	{
		throw A("分母等于0!");
	}
	return x / y;
}

int main()
{
	try
	{
		device(10, 0);
	}
	catch (std::exception& a)
	{
		std::cout << "异常捕获" << a.what() << std::endl;
	}
	catch (...) {
		std::cout << "其他异常" << std::endl;
	}
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
