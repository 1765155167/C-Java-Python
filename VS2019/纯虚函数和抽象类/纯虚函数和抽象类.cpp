// 纯虚函数和抽象类.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <cmath>

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
	Rect(double a) :a(a) {};
	~Rect() {};
	virtual double getArea() {
		return this->a * this->a;
	}
	virtual void print() {
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
	Cricle(double r) :r(r) {};
	~Cricle() {};
	virtual double getArea() {
		return PI * this->r * this->r;
	}
	virtual void print() {
		std::cout << "圆形半径为: " << this->r
			<< " 面积为: " << this->getArea() << std::endl;
	}
private:
	double r;
};
#define E 0.000002
//三角形类
class Triangle : public Shape
{
public:
	Triangle() :a(0), b(0), c(0) {};
	Triangle(double a, double b, double c) {
		if (a <= 0 || b <= 0 || c <= 0) {
			std::cout << "边长小于0" << std::endl;
			this->a = 0;
			this->b = 0;
			this->c = 0;
		}
		else if (a + b - E > c && abs(a - b) < c - E) {
			this->a = a;
			this->b = b;
			this->c = c;
		}
		else
		{
			std::cout << "构不成三角形" << std::endl;
			this->a = 0;
			this->b = 0;
			this->c = 0;
		}
	}
	~Triangle() {};
	virtual double getArea() {
		double p = (this->a + this->b + this->c) / 2;
		return sqrt(p * (p - a) * (p - b) * (p - c));
	}
	virtual void print() {
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
	sp->print();
}

int main()
{
	Shape*sp1 =new  Rect(5);
	ShapePrint(sp1);
	Shape* sp2 = new Cricle(2);
	ShapePrint(sp2);
	Shape* sp3 = new Triangle(2, 2, 3);
	ShapePrint(sp3);
	delete sp1;
	delete sp2;
	delete sp3;
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
