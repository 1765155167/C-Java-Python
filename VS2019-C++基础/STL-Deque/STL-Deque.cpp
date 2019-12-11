// STL-Deque.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <deque>
#include <algorithm>

//打印容器
template<class T>
void printDeque(const std::deque<T>& deq)
{
	//std::deque<int>::iterator begin = deq.begin();
	auto begin = deq.begin();
	auto end = deq.end();
	for (;begin != end; begin++)
	{
		std::cout << *begin << " ";
	}
	std::cout << std::endl;
}

//双口容器，头尾插入提取效率都高，采用分段连续空间
//指定位置插入数据会移动降低效率
//支持随机存取
//front()返回第一个元素的引用
//back()返回最后一个元素的引用

//deque:初始化
//deque<T> deq;//默认构造
//deque(begin,end);
//deque(n,elem);//将n个elem拷贝给本身
//deque(const queue& que);//拷贝构造函数
void test01()
{
	std::deque<int> deq1(10, 5);//10个5进行初始化
	printDeque(deq1);
	std::string name = "I'am Mr.hu";
	std::deque<int> deq2(name.begin(), name.end());
	printDeque(deq2);
}

//赋值
//assign(begin,end)
//assign(n, elem)
//重载=运算符
//swap(deq)//交换
//empty()是否为空
//resize(num)
//resize(num,elem)
void test02()
{
	std::deque<int> deq1;
	deq1.assign(10, 5);//10个5进行初始化
	std::deque<int> deq2;//初始化
	deq2.assign(deq1.begin(),deq1.end());
	std::deque<int> deq3;//初始化
	deq3 = deq2;
	std::deque<int> deq4;//初始化
	deq4.swap(deq1);//交换两个容器
	//deque不需要通过swap缩放容量
	deq2.resize(5);//重新指定长度过长后面插入默认值，过段去掉后面的元素
	deq2.resize(10, 1);//重新指定长度过长后面插入1，过段去掉后面的元素
	printDeque(deq2);
	printDeque(deq3);
	printDeque(deq4);
	if (deq1.empty())
	{
		std::cout << "deq1为空";
	}
	else
	{
		std::cout << "size:" << deq1.size() << std::endl;
	}
}

//插入与删除
//push_back()尾部插入 pop_back()尾部删除
//push_front()头部插入 pop_front()头部删除
void test03()
{
	std::deque<int> deq1;
	deq1.push_back(2);
	deq1.push_back(3);
	deq1.push_back(4);
	deq1.push_front(5);
	deq1.push_front(6);
	printDeque(deq1);
	int front = deq1.front();
	deq1.pop_front();//只是删除头部元素没有返回值
	int back = deq1.back();
	deq1.pop_back();//只是删除头部元素没有返回值
	printDeque(deq1);
}


class Person {
public:
	Person(int id, std::string name) {
		this->id = id;
		this->name = name;
	}
	~Person() {
		std::cout << "~Person()..." << this->id << std::endl;
	}
public:
	int id;
	std::string name;
};

void printPerson(Person*& p)
{
	std::cout << p->id << ":" << p->name << std::endl;
}

void deleteDeque(std::deque<Person*>& que)
{
	while (!que.empty())
	{
		Person* p = que.front();
		que.pop_front();
		if (p != NULL)
		{
			delete p;
			p = NULL;
		}
	}
}

void test04()
{
	std::deque<Person*> que;
	que.push_back(new Person(10, "小明"));
	que.push_back(new Person(12, "小李"));
	que.push_back(new Person(11, "小红"));
	que.push_back(new Person(5, "小刚"));
	que.push_back(new Person(15, "小胡"));
	//std::for_each(que.begin(), que.end(), printPerson);
	printPerson(que.front());
	printPerson(que.back());
	deleteDeque(que);
}

int main()
{
	test04();
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
