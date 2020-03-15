// STL-容器的深拷贝与浅拷贝问题.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <vector>

class Person {
public:
	Person() {
		this->name = new char[1];
		this->age = 0;
		init();
	}
	Person(const char* name, int age) {
		this->name = new char[strlen(name) + 1];
		strcpy_s(this->name, strlen(name) + 1, name);
		this->age = age;
		init("const char* name, int age");
	}
	Person(const Person& another)
	{
		this->name = new char[strlen(another.name) + 1];
		strcpy_s(this->name, strlen(another.name) + 1, another.name);
		this->age = another.age;
		init("const Person&");
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
	void setAge(int age) {
		this->age = age;
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
		del();
	}
protected:
	char* name;
	int age;
private:
	void init(std::string arg) {
		std::cout << "init()..." << arg << std::endl;
	}
	void init() {
		std::cout << "init()..."<< std::endl;
	}
	void del() {
		std::cout << "del()..." << std::endl;
	}
};
void test01()
{
	Person *p1 = new Person("hqf", 21);
	std::vector<Person*> vp;
	vp.push_back(p1);//插入元素到容器中时将元素[拷贝]一份到容器中
	for (auto it = vp.begin(); it != vp.end(); it++)
	{
		(*it)->toString();
	}
	vp.clear();
}

void test03() {
	std::vector<Person> a;
	Person p("hqf", 20);
	std::cout << "-------------------" << std::endl;
	a.push_back(p);
	std::cout << "-------------------" << std::endl;
	for(auto it = a.begin(); it != a.end(); it++)
	{
		auto num = *it;
		std::cout << "-------------------" << std::endl;
		num.setAge(21);
		num.toString();
	}
	for (auto num : a)
	{
		std::cout << "-------------------" << std::endl;
		num.toString();
	}
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
