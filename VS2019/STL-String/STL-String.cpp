// STL-String.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <string>

//赋值操作
void test01()
{
	std::string s1 = "Hello";
	std::string s2 = s1;
	try
	{
		//取值操作at()方法 []操作符
		s1.at(10) = 'h';//越界抛出out_of_range异常
		//s1[10] = 'h';//越界错误
	}
	catch (const std::out_of_range & e)
	{
		std::cout << e.what() << std::endl;
	}
	std::cout << s1 << ":" << s2 << std::endl;
	std::string s3;
	s3.assign("Hello s3");
	//s3.assign("你好啊！");//赋值操作 s3 = "你好啊！";
	std::cout << s3 << std::endl;
	
}

//拼接操作
void test02()
{
	std::string name = "Hello";
	std::string world = "World";
	//name += "World";
	//name += world;
	//name += 'W';
	//name.append(world);
	//name.append("World");
	//name.append("World", 5);
	//name.append(world, 0, world.length());
	std::cout << name << std::endl;
}

//查找操作与替换
void test03()
{
	std::string s1 = "1765155167hu@gmail.com";
	std::string name;
	std::string type;
	//find查找第一次出现的位置
	//rfing查找最后一次出现的位置
	type.append(s1, s1.find('@') + 1, s1.find('.') - s1.find('@') - 1);
	name.append(s1,0,s1.find('@'));
	std::cout << type << std::endl;
	std::cout << name << std::endl;
	//替换
	std::cout << s1 << std::endl;
	s1.replace(s1.find('@') + 1, s1.find('.') - s1.find('@') - 1, "qq");
	std::cout << s1 << std::endl;
}

//插入与删除
void test04()
{
	std::string s1 = "1765155167@.com";
	s1.insert(s1.find('@') + 1, "qq");//在位置a之前插入元素
	std::cout << s1 << std::endl;
	s1.erase(s1.find('@'),s1.length() - s1.find('@'));//从位置a开始删除b个元素
	std::cout << s1 << std::endl;
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
