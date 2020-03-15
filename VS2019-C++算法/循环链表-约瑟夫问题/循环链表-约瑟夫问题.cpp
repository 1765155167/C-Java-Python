// 循环链表-约瑟夫问题.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include "Joseph.h"

class Person
{
public:
	Person(std::string name, int age)
	{
		this->name = name;
		this->age = age;
	}
	void show()
	{
		std::cout << "姓名: " << this->name
			<< " 年龄: " << this->age << std::endl;
	}
	bool compare(Person& another)
	{
		if (another.age == this->age && another.name == this->name)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
private:
	Node node;
	std::string name;
	int age;
};

void PrintPerson(Node* data)
{
	Person* p = (Person*)data;
	p->show();
}

bool Compare(Node* a, Node* b)
{
	Person* pa = (Person*)a;
	Person* pb = (Person*)b;
	if (pa->compare(*pb))
	{
		return true;
	}
	else
	{
		return false;
	}
}

int main()
{
	Joseph list;
	Person p1("aaa", 20);//
	Person p2("bbb", 21);
	Person p3("ccc", 22);//
	Person p4("ddd", 23);
	Person p5("eee", 24);//
	list.push_pos((Node*)(&p1), 0);
	list.push_pos((Node*)(&p2), 1);
	list.push_pos((Node*)(&p3), 2);
	list.push_pos((Node*)(&p4), 3);
	list.push_pos((Node*)(&p5), 4);
	list.traversal(PrintPerson);//遍历
	std::cout << "--------------------->" << std::endl;
	list.JosephProblem(3, Compare, PrintPerson);
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
