// 面向对象设计模式-模板方法模式.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
//煮茶或者咖啡一般步骤 写成一个模板类
class DrinkTemplate {
protected:
	virtual void BoildWater() = 0;//煮水
	virtual void Brew() = 0;//冲泡
	virtual void PourInCup() = 0;//倒入杯中
	virtual void AddSomething() = 0;//加料
public:	
	//模板方法
	void Make()
	{
		this->BoildWater();
		this->Brew();
		this->PourInCup();
		this->AddSomething();
	}
};
class Tea :public DrinkTemplate {
	virtual void BoildWater() {
		std::cout << "煮山泉水" << std::endl;
	}
	virtual void Brew() {
		std::cout << "冲泡茶叶" << std::endl;
	}
	virtual void PourInCup() {
		std::cout << "导入茶杯" << std::endl;
	}
	virtual void AddSomething() {
		std::cout << "加糖" << std::endl;
	}
};
class Coffee :public DrinkTemplate {
	virtual void BoildWater() {
		std::cout << "煮白开水" << std::endl;
	}
	virtual void Brew() {
		std::cout << "冲泡咖啡" << std::endl;
	}
	virtual void PourInCup() {
		std::cout << "导入咖啡杯" << std::endl;
	}
	virtual void AddSomething() {
		std::cout << "加糖、牛奶、咖啡伴侣..." << std::endl;
	}
};

void test01()
{
	Tea tea;
	tea.Make();
	std::cout << "------------------->" << std::endl;
	Coffee coffee;
	coffee.Make();
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
