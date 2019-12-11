// 面向对象设计原则-合成复用原则.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
//优先使用组合而不是继承

//首先创建一个车的抽象类
class AbstractCat
{
public:
	virtual void run() = 0;  
};

//宝马
class BMW: public AbstractCat{
public:
	void run() {
		std::cout << "宝马开始启动！" << std::endl;
	}
};
//大众
class Volkswagen : public AbstractCat {
public:
	void run() {
		std::cout << "大众开始启动！！" << std::endl;
	}
};
//拖拉机
class Tractor: public AbstractCat {
public:
	void run() {
		std::cout << "拖拉机开始启动！！！" << std::endl;
	}
};

//一个人想开车
//继承方式开车不好
class PersonA: public BMW{
public:
	void doufeng()//兜风
	{
		this->run();
	}
};
class PersonB : public Volkswagen {
public:
	void doufeng()//兜风
	{
		this->run();
	}
};
//组合方式开车
class Person {
public:
	void setCat(AbstractCat* car) {
		this->car = car;
	}
	void doufeng()//兜风
	{
		this->car->run();
		if (this->car != NULL)
		{
			delete this->car;
		}
	}
	~Person()
	{
	}
private:
	AbstractCat* car;
};
void test01()
{
	Person* p = new Person;
	p->setCat(new BMW);
	p->doufeng();
	p->setCat(new Volkswagen);
	p->doufeng();
	p->setCat(new Tractor);
	p->doufeng();
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
