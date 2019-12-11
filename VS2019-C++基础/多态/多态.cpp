// 多态.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <string>

class Person {
public:
	Person(std::string name) :name(name) {}
	virtual void work() {
		std::cout << this->name << " 去工作" << std::endl;
	}
	virtual std::string jobTitle() {
		std::string job_title("普通人类");
		return job_title;
	}
	virtual ~Person()
	{
		std::cout << "~Person()..." << std::endl;
	}
protected:
	std::string name;
};

class Student :public Person {
public:
	Student(std::string name) :Person(name) {};
	void work() {
		std::cout << this->name << " 去课堂上课" << std::endl;
	}
	std::string jobTitle() {
		std::string job_title("学生");
		return job_title;
	}
	~Student()
	{
		std::cout << "~Student()..." << std::endl;
	}
protected:
};

class Techer :public Person {
public:
	Techer(std::string name) :Person(name) {};
	void work() {
		std::cout << this->name << " 去课堂讲课" << std::endl;
	}
	std::string jobTitle() {
		std::string job_title("教师");
		return job_title;
	}
	~Techer() {
		std::cout << "~Techer()..." << std::endl;
	}
protected:
};

void what_doing(Person* person)
{
	std::cout << "下午两点身为" << person->jobTitle() << "的";
	person->work();
	delete person;
}
void what_doing(Person& person)
{
	std::cout << "下午两点身为" << person.jobTitle() << "的";
	person.work();
}
int main()
{
	Person* z3 = new Person("张三");
	Student* l4 = new Student("李四");
	Techer* w5 = new Techer("王五");
	what_doing(z3);
	what_doing(l4);
	what_doing(w5);
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
