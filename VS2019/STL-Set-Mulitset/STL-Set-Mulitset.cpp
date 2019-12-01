// STL-Set-Mulitset.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <set>
#include <algorithm>


void fun(int a)
{
	std::cout << a << " ";
}

//set集合二叉排序树
//遍历：先序、后序、中序
//不需要有重复元素
//insert()插入元素插入后会自动排好序默认升序
//赋值重载= swap()交换
//clear()
//erase(start,end) erase(pos)指定位置删除 erase(elem)指定元素删除

//初始化-插入-遍历
void test01()
{
	std::set<int> s;//默认升序
	s.insert(1);
	s.insert(5);
	s.insert(4);
	//s.erase(s.begin());
	auto it = s.begin();
	for (; it != s.end(); it++)
	{
		std::cout << *it << " ";
	}
	//std::for_each(s.begin(), s.end(), fun);
}

//查找
//find()找到返回位置、找不到返回end()
//lower_bound()大于等于
//upper_bound()大于
//equal_range()返回pair<lower_bound(),upper_bound()>
void test02()
{
	std::set<int> s;
	s.insert(1);
	s.insert(10);
	s.insert(12);
	s.insert(7);
	s.insert(9);
	s.insert(11);
	if (s.find(9) != s.end())
	{
		std::cout << "fing 9." << std::endl;
	}
	else
	{
		std::cout << "not fing 9." << std::endl;
	}
	std::set<int>::iterator low = s.lower_bound(11);//第一个大于等于11的元素
	if (low != s.end())
	{
		std::cout << "第一个大于等于11的元素" << *low << std::endl;
	}
	else
	{
		std::cout << "没有大于等于11的元素" << std::endl;
	}
	std::set<int>::iterator upp = s.upper_bound(11);//第一个大于11的元素
	if (upp != s.end())
	{
		std::cout << "第一个大于11的元素" << *upp << std::endl;
	}
	else
	{
		std::cout << "没有大于11的元素" << std::endl;
	}

	std::pair<std::set<int>::iterator, std::set<int>::iterator> p;
	//返回lower_bound与upper_bound
	p= s.equal_range(11);
	if (p.first != s.end())
	{
		std::cout << "第一个大于等于11的元素" << *(p.first) << std::endl;
	}
	else
	{
		std::cout << "没有大于等于11的元素" << std::endl;
	}
	if (p.second != s.end())
	{
		std::cout << "第一个大于11的元素" << *(p.second) << std::endl;
	}
	else
	{
		std::cout << "没有大于11的元素" << std::endl;
	}
}

#if 1

//仿函数
class mycompare {
public:
	bool operator()(const int a,const int b) const
	{
		return a > b;
	}
};

void test03()
{
	std::set<int, mycompare> s;//利用仿函数更改为降序排序
	s.insert(1);
	s.insert(10);
	s.insert(12);
	s.insert(7);
	s.insert(9);
	s.insert(11);
	std::for_each(s.begin(), s.end(), fun);
}
#endif // 0

//set存放类对象
class Person {
public:
	Person(int id, std::string name) {
		this->id = id;
		this->name = name;
	}
	~Person() {

	}
public:
	int id;
	std::string name;
};
//反函数定义类的排序规则
class ComPerson {
public:
	bool operator()(const Person* a, const Person* b) const
	{
		return a->id < b->id;
	}
};
void printPerson(Person* p)
{
	std::cout << p->id << ":" << p->name << std::endl;
}

void test04()
{
	std::set<Person*, ComPerson> s;
	s.insert(new Person(5, "小明"));
	s.insert(new Person(9, "小红"));
	s.insert(new Person(8, "小张"));
	s.insert(new Person(4, "小李"));
	std::for_each(s.begin(), s.end(), printPerson);
}

int main()
{
	test04();
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
