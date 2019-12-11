// STL-容器的深拷贝与浅拷贝问题.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <vector>

class Person {
public:
	Person() {
		this->name = NULL;
		this->age = 0;
	}
	Person(const char* name, int age) {
		this->name = new char[strlen(name) + 1];
		strcpy_s(this->name, strlen(name) + 1, name);
		this->age = age;
	}
	Person(const Person& another)
	{
		if (&another == this)
		{
			this->name = NULL;
			this->age = 0;
		}
		else
		{
			this->name = new char[strlen(another.name) + 1];
			strcpy_s(this->name, strlen(another.name) + 1, another.name);
			this->age = another.age;
		}
	}
	Person& operator=(const Person& another)
	{
		if (this != NULL)
		{
			delete this->name;
			this->name = NULL;
		}
		this->name = new char[strlen(another.name) + 1];
		strcpy_s(this->name, strlen(another.name) + 1, another.name);
		this->age = another.age;
	}
	void toString()
	{
		std::cout << "姓名:" << this->name
			<< " 年龄:" << this->age << std::endl;
	}
	~Person() {
		if (this->name != NULL)
		{
			delete this->name;
			this->name = NULL;
		}
		std::cout << "~Person()..." << std::endl;
	}
protected:
	char* name;
	int age;
};
void test01()
{
	Person p1("hqf", 21);
	std::vector<Person> vp;
	vp.push_back(p1);//插入元素到容器中时将元素[拷贝]一份到容器中
	for (auto it = vp.begin(); it != vp.end(); it++)
	{
		(*it).toString();
	}
}
int main()
{
	test01();
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
