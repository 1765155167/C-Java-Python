// 类的继承方式.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>

class Person {
public://公有
	Person() :pub_data(0), pro_data(0), pri_data(0),a(0) {
		std::cout << "Person()..." << std::endl;
	}
	void pub_fun() {
		std::cout << "Person公有成员方法" << std::endl;
	}
	~Person() {
		std::cout << "~Person()..." << std::endl;
	}
	int pub_data;
protected://保护
	void pro_fun() {
		std::cout << "Person保护成员方法" << std::endl;
	}
	int a;
	static int sum;
	int pro_data;
private://私有
	void pri_fun() {
		std::cout << "Person私有成员方法" << std::endl;
	}
	int pri_data;
};
int Person::sum = 10;//静态数据成员与子类共享，但不能通过子类初始化
//子类可以访问父类的public与protected成员与方法
//公有方式继承 
class Child_pub :public Person {
public:
	Child_pub() :Person(){
		std::cout << "Child_pub()..." << std::endl;
	}
	void fun_Child_pub() {
		//无法访问父类私有成员与方法
		std::cout << this->pro_data << this->pub_data << std::endl;
		this->pro_fun();
		this->pub_fun();
		std::cout << "this->sum" << this->sum <<std::endl;
		//this->pri_fun();
		//std::cout << this->pri_data << std::endl;
	}
	~Child_pub() {
		std::cout << "~Child_pub()..." << std::endl;
	}
	//继承的父类的保护与公有权限均不变
}; 

class Child_pro :protected Person {
public:
	void fun_Child_pro() {
		//无法访问父类私有成员与方法
		std::cout << this->pro_data << this->pub_data << std::endl;
		this->pro_fun();
		this->pub_fun();
		//this->pri_fun();
		//std::cout << this->pri_data << std::endl;
	}
	//继承的父类的保护与公有权限均变成保护
};

class Child_pri :private Person {
public:
	void fun_Child_pri() {
		//无法访问父类私有成员与方法
		std::cout << this->pro_data << this->pub_data << std::endl;
		this->pro_fun();
		this->pub_fun();
		//this->pri_fun();
		//std::cout << this->pri_data << std::endl;
	}
	//继承的父类的保护与公有权限均变成私有
};

class Grandson1 :public Child_pri {
public:
	void fun()
	{
		//父类（Child_pri）均无法访问
		//this->fun_Child_pri();
	}
};

class Grandson2 :public Child_pro {
public:
	void fun()
	{
		//父类（Child_pri）可以访问
		this->pro_data;
		this->pub_data;
		this->pro_fun();
		this->pub_fun();
	}
};

class Grandson3 :public Child_pub {
public:
	void fun()
	{
		//父类（Child_pri）可以访问
		this->pro_data;
		this->pub_data;
		this->pro_fun();
		this->pub_fun();
	}
};

void test01()
{
	//public能在类外访问的均为pub权限
	Grandson1 sub1;
	Grandson2 sub2;
	Grandson3 sub3;
	sub1.fun();
	std::cout << "sizeof(Grandson1)=" << sizeof(Grandson1) << std::endl;
	sub2.fun();
	std::cout << "sizeof(Grandson2)=" << sizeof(Grandson2) << std::endl;
	sub3.fun();
	sub3.fun_Child_pub();
	sub3.pub_data;
	sub3.pub_fun();
	std::cout << "sizeof(Grandson3)=" << sizeof(Grandson3) << std::endl;
}

void test02()
{
	std::cout << "sizeof(Child_pub)=" << sizeof(Child_pub) << std::endl;
	std::cout << "sizeof(Child_pro)=" << sizeof(Child_pro) << std::endl;
	std::cout << "sizeof(Child_pri)=" << sizeof(Child_pri) << std::endl;
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
