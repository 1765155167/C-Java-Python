// C++类型转换.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
class A {
public:
	int a;
};
class B:public A {
	int b;
};
class C {

};
//static_cast<>();
//用于普通类型与具有继承关系的对象(指针或者引用)之间的转换
void test01()
{
	char ch = 'a';
	int num = static_cast<char>(ch);
	std::cout << "num: " << num << std::endl;

	//指针
	//char* p = NULL;
	//int* a = static_cast<int*>(p);//无法转化
	//对象指针转化
	A* a1 = new A;
	B* b1 = static_cast<B*>(a1);
	B* b2 = new B;
	A* a2 = static_cast<A*>(b2);
	//对象引用转换
	A a3;
	A& a4 = a3;
	B& b3 = static_cast<B&>(a4);
	B b4;
	B& b5 = b4;
	A& a = static_cast<A&>(b5);
}
//dynamic_cast<>()
//对具有继承关系的对象（指针或引用）进行转换
//转换前对其进行检查
void test02()
{
	A* a1 = new A;
	//B* b1 = dynamic_cast<B*>(a1);//失败
	B* b2 = new B;
	A* a2 = dynamic_cast<A*>(b2);

	A a3;
	A& a4 = a3;
	//B& b3 = dynamic_cast<B&>(a4);//失败
	B b4;
	B& b5 = b4;
	A& a = dynamic_cast<A&>(b5);
}
//const_cast<>()//引用 对象指针
//去除const性
void test03()
{
	int data = 10;
	const int& a  = data;
	int& b = const_cast<int&>(a);
	b = 20;
	std::cout << "data:" << data << std::endl;
	std::cout << "a:" << a << std::endl;
	std::cout << "b:" << b << std::endl;

	const A* a1 = new A;
	A* a2 = const_cast<A*>(a1);
}

//reinterpret_cast<>();强制类型转换
//无关的指针类型与函数指针都可以转
void test04()
{
	A* a = NULL;
	C* c = reinterpret_cast<C*>(a);
}

int main()
{
	test03();
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
