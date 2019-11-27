#include <iostream>
#include <exception>
#include <string>

class MyExtern :public std::exception
{
public:
	MyExtern();
	~MyExtern();
	std::string what() throw() {//加throw()代表该函数禁止抛出异常
		return this->info;
	}
private:
	std::string info;
};

MyExtern::MyExtern()
{
	this->info = "分母为0";
}

MyExtern::~MyExtern()
{
}

float div(float a, float b)
{
	if (b == 0)
	{
		std::bad_cast a;
		throw a;
	}
	return a / b;
}

int main()
{
	float a, b;
	std::cin >> a >> b;
	try
	{
		std::cout << div(a, b) << std::endl;
	}
	catch (const char& e)
	{
		std::cout << __LINE__ << e << std::endl;
	}
	catch (MyExtern& e)
	{
		std::cout << __LINE__ << e.what() << std::endl;
	}
	catch (std::exception& e)
	{
		std::cout << __LINE__ << "std::exception err" << std::endl;
	}
	catch (...)
	{
		std::cout << __LINE__ << ":其他错误" << std::endl;
	}
	return 0;
}