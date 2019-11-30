// 纯虚函数和抽象类.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <cmath>
#include <stdexcept>
class MyExcept :public std::exception {
public:
	MyExcept(const char* buf) {
		int len = strlen(buf) + 1;
		this->pError = new char[len];
		strcpy_s(this->pError, len, buf);
	}
	const char* what() const {
		return this->pError;
	}
	~MyExcept() {
		if (this->pError != NULL) {
			delete[] this->pError;
		}
	}
private:
	char* pError;
};

//图形类
//含有纯虚函数的类为抽象类
class Shape
{
public:
	Shape() {};
	~Shape() {};
	virtual double getArea() = 0;//求面积接口
	virtual void print() = 0;
private:
};
//正方形
//继承抽象类必须重写抽象函数
//不重写该类仍为抽象类
//抽象类无法实例化
class Rect:public Shape
{
public:
	Rect() :a(0) {};
	Rect(double a) {
		if (a <= 0) {
			throw MyExcept("正方形边长小于等于0...");
		}
		this->a = a;
	}
	~Rect() {};
	virtual double getArea() {
		if (a <= 0) {
			throw MyExcept("没有设置正方形边长...");
		}
		return this->a * this->a;
	}
	virtual void print() {
		if (a <= 0) {
			throw MyExcept("没有设置正方形边长...");
		}
		std::cout << "正方形边长为: " << this->a
			<< " 面积为: " << this->getArea() << std::endl;
	}
private:
	double a;
};

constexpr auto PI = 3.1415926;
//圆类
class Cricle :public Shape {
public:
	Cricle() :r(0) {};
	Cricle(double r) {
		if (r <= 0) {
			throw MyExcept("圆的半径小于等于0...");
		}
		this->r = r;
	}
	~Cricle() {};
	virtual double getArea() {
		if (r <= 0) {
			throw MyExcept("没有设置圆形边长...");
		}
		return PI * this->r * this->r;
	}
	virtual void print() {
		if (r <= 0) {
			throw MyExcept("没有设置圆形边长0...");
		}
		std::cout << "圆形半径为: " << this->r
			<< " 面积为: " << this->getArea() << std::endl;
	}
private:
	double r;
};
#define E 0.0000000002
//三角形类
class Triangle : public Shape
{
public:
	Triangle() :a(0), b(0), c(0) {};
	Triangle(double a, double b, double c) {
		if (a <= 0 || b <= 0 || c <= 0) {
			throw MyExcept("边长小于0");
		}
		else if (a + b - E > c && abs(a - b) < c - E) {
			this->a = a;
			this->b = b;
			this->c = c;
		}
		else
		{
			throw MyExcept("构不成三角形");
			this->a = 0;
			this->b = 0;
			this->c = 0;
		}
	}
	~Triangle() {};
	virtual double getArea() {
		if (a == 0 || b == 0 || c == 0)
		{
			throw MyExcept("没有设置三角形边长");
		}
		double p = (this->a + this->b + this->c) / 2;
		return sqrt(p * (p - a) * (p - b) * (p - c));
	}
	virtual void print() {
		if (a == 0 || b == 0 || c == 0)
		{
			throw MyExcept("没有设置三角形边长");
		}
		std::cout << "三角形三边为(" << this->a << ", "
			<< this->b << ", " << this->c
			<< ") 面积为: " << this->getArea() << std::endl;
	}
private:
	double a;
	double b;
	double c;
};

void ShapePrint(Shape* sp) {
	if (sp == NULL) {
		throw MyExcept("sp == NULL");
	}
	sp->print();
	delete sp;
}

int main()
{
	try
	{
		ShapePrint(new  Rect(5));//正方形
	}
	catch (const std::exception& e)
	{
		std::cout << e.what() << std::endl;
	}
	try
	{
		ShapePrint(new Cricle(2));//圆形
	}
	catch (const std::exception & e)
	{
		std::cout << e.what() << std::endl;
	}
	try
	{
		ShapePrint(new Triangle(2, 3, 1.001));//三角形
	}
	catch (const std::exception & e)
	{
		std::cout << e.what() << std::endl;
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
