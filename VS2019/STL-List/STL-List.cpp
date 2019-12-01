// STL-List.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <list>
//list双端链表不支持随机访问
//重载了++了--运算符来指向下/上一个元素
//push_front()头部插入 pop_front()头部删除
//push_back()尾部插入 pop_back()尾部删除
//front()头引用
//back()尾引用
//next:下一个节点 prev:上一个结点
//begin() end() insert()

//初始化
void test01()
{
	std::list<int> l1(10,5);//10个5
	std::list<int> l2(l1);//拷贝构造
	std::list<int> l3(l1.begin(), l1.end());
	for (std::list<int>::iterator it = l3.begin();
		it != l3.end(); it++)
	{
		std::cout << *it << " ";
		//只能通过++或者--(不支持it+=1;)
	}
	std::cout << std::endl;
}

//插入和删除
void test02()
{
	std::list<int> l1;
	l1.push_back(1);
	l1.push_front(2);
	l1.push_front(2);
	l1.push_front(2);
	l1.insert(l1.begin(), 5);
	l1.insert(l1.end(), 2);
	//l1.erase(l1.begin(), l1.end());//区间删除
	//l1.erase(l1.begin());//位置删除
	//l1.erase(--l1.end());//位置删除
	l1.pop_back();//尾部删除
	l1.pop_front();//头部删除
	//l1.remove(2);//删除所有元素为2的
	for (std::list<int>::iterator it = l1.begin();
		it != l1.end(); it++)
	{
		std::cout << *it << " ";
		//只能通过++或者--(不支持it+=1;)
	}
	std::cout << std::endl;
}

bool fun(int a, int b)
{
	return a > b;
}

//list反转与排序
void test03()
{
	int data[] = { 41,25,13,54,50,62,75,87,91 };
	std::list<int> l1(data, data + sizeof(data) / sizeof(data[0]));
	l1.reverse();//反转列表
	l1.sort(fun);
	for (std::list<int>::iterator it = l1.begin();
		it != l1.end(); it++)
	{
		std::cout << *it << " ";
		//只能通过++或者--(不支持it += 1;)
	}
	std::cout << std::endl;
}

int main()
{
	test03();
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
