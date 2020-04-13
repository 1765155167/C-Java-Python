// 多继承与虚继承.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>

enum Texture
{
	Mahogany = 0,//桃木
	Sandalwood,//檀木
	Iron//铁
};

class Furniture {
public:
	Furniture() {}
	Furniture(int t) {}
	virtual void fun() = 0;
private:
	Texture m;
};

class Bad :virtual public Furniture{
public:
	void sleep() {
		std::cout << "在床上睡觉" << std::endl;
	}
private:
};

class Sofa1 :virtual public Furniture {
public:
	void sleep()
	{
		std::cout << "在沙发休息" << std::endl;
	}
private:
};

class Sofa :virtual public Furniture {
public:
	void sleep()
	{
		std::cout << "在沙发休息" << std::endl;
	}
private:
};

class SofaBad1: public Sofa, public Bad, public Sofa1 {
public:
	void SofaBad_sleep()
	{
		Sofa::sleep();
		Bad::sleep();
	}

private:
};

int main()
{
	/*SofaBad sb;
	sb.SofaBad_sleep();
	sb.Sofa::sleep();*/
	std::cout << "Furniture大小：" << sizeof(Furniture) << std::endl;
	std::cout << "Sofa大小：" << sizeof(Sofa) << std::endl;
	std::cout << "Bad大小：" << sizeof(Bad) << std::endl;
	std::cout << "SofaBad大小：" << sizeof(SofaBad1) << std::endl;
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
