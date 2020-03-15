// 自定义String类.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include "MyString.h"
#include <string>

void test01()
{
	MyString string1;
	MyString string2("胡秋峰");
	MyString string3 = "你好！";
	MyString string4 = string3 + string2;
	MyString string5 = string3 + "你好啊！";
	std::cout << "请输入字符串：";
	std::cin >> string1;
	std::cout << "string1: " << string1 << ":" << string1.length() << std::endl;
	std::cout << "string2: " << string2 << ":" << string2.length() << std::endl;
	std::cout << "string3: " << string3 << ":" << string3.length() << std::endl;
	std::cout << "string4: " << string4 << ":" << string4.length() << std::endl;
	std::cout << "string4.to_str: " << string4.to_str() << std::endl;
	if (string1 == string2)
	{
		std::cout << "string1 == string2" << std::endl;
	}
	if (string1 != string2)
	{
		std::cout << "string1 != string2" << std::endl;
	}
}

void test02()
{
	std::string hqf("djaskldj");
	std::cout << hqf << hqf.length() << std::endl;
}

int main()
{
	MyString num = "Hello";
	MyString str;
	str = num + "hello";
	std::cout << str << std::endl;
	std::cout << num << std::endl;
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
