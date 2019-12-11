// 面向对象设计原则-代理模式.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
//提供一种代理来控制对其他对象的访问
class AbstractCommonInterface {
public:
	virtual void run() = 0;
};
//我写好的系统
//想要验证成功才能使用我的系统
class MySystem :public AbstractCommonInterface{
public:
	virtual void run() {
		std::cout << "我的系统正在运行" << std::endl;
	}
};
//提供一个代理来访问我的系统MySystem
class MySystemProxy : public AbstractCommonInterface {
private:
	bool checkUserAndPasswd() {
		if (this->user == "admin" && this->passwd == "admin")
		{
			return true;
		}
		return false;
	}
public:
	MySystemProxy(std::string user, std::string passwd)
	{
		this->user = user;
		this->passwd = passwd;
		this->pSystem = new MySystem;
	}
	virtual void run() {
		if (this->checkUserAndPasswd())
		{
			this->pSystem->run();
		}
		else
		{
			std::cout << "用户名或者密码错误" << std::endl;
		}
	}
	~MySystemProxy() {
		if (this->pSystem != NULL) {
			delete this->pSystem;
			this->pSystem = NULL;
		}
	}
private:
	MySystem* pSystem;
	std::string user;
	std::string passwd;
};

void test01()
{
	//通过代理类来访问系统，需要验证用户
	AbstractCommonInterface* p = new MySystemProxy("root", "admin");
	p->run();
	delete p;
	std::cout << "----------------------->" << std::endl;
	p = new MySystemProxy("admin", "admin");
	p->run();
	delete p;
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
