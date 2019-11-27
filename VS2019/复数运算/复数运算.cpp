// 复数运算.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>

class Complex {
public:
	Complex() :a(0), b(0) {}
	Complex(int a, int b) :a(a), b(b) {}
	//全局函数：友元
	friend Complex complexAdd(Complex& c1, Complex& c2);
	//friend Complex operator+(Complex& c1, Complex& c2);
	friend std::ostream& operator<<(std::ostream& os, Complex p);
	//类成员函数：复数类相加操作
	Complex complexAdd(Complex& another) {
		Complex temp;
		temp.a = this->a + another.a;
		temp.b = this->b + another.b;
		return temp;
	}
	Complex operator+(Complex& another)
	{
		Complex temp;
		temp.a = this->a + another.a;
		temp.b = this->b + another.b;
		return temp;
	}
	Complex operator-(Complex& another)
	{
		Complex temp;
		temp.a = this->a - another.a;
		temp.b = this->b - another.b;
		return temp;
	}
	void show() {
		std::cout << a << " + " << b << "i" << std::endl;
	}
private:
	int a;
	int b;
};
//全局函数：复数类相加操作
Complex complexAdd(Complex& c1, Complex& c2)
{
	Complex temp;
	temp.a = c1.a + c2.a;
	temp.b = c1.b + c2.b;
	return temp;
}
#if 1
//全局函数：重载<<运算符
std::ostream& operator<<(std::ostream& os, Complex p)
{
	os << "[ " << p.a << " + " << p.b << "i ]";
	return os;
}
#endif
#if 0
//全局函数：重载+运算符 复数类相加操作
Complex operator+(Complex& c1, Complex& c2) {
	Complex temp;
	temp.a = c1.a + c2.a;
	temp.b = c1.b + c2.b;
	return temp;
}
#endif
int main()
{
	Complex c1(1, 2);
	Complex c2(2, 3);
	//Complex c3 = complexAdd(c1, c2);
	//Complex c3 = c1.complexAdd(c2);
	Complex c3 = c1 + c2;//隐式调用 类成员函数/全局写法
	//Complex c3 = c1.operator+(c2);//类成员函数
	//Complex c3 = operator+(c1, c2);//全局写法
	std::cout << "c1 = " << c1 << std::endl
		<< "c2 = " << c2 << std::endl
		<< "c3 = " << c3 << std::endl;
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
