// 面向对象设计模式-观察者模式.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <list>
#include <algorithm>
#include <functional>
//观察者抽象类
class AbstractCat {
public:
	virtual void redLight() = 0;
	virtual void greenLight() = 0;
};
//具体的观察者
class BMW :public AbstractCat{
public:
	BMW() {
		std::cout << "BMW启动了..." << std::endl;
	}
	virtual void redLight() {
		std::cout << "我是宝马，红灯了，我停车。" << std::endl;
	}
	virtual void greenLight() {
		std::cout << "我是宝马，绿灯了，开始行走" << std::endl;
	}
};
//自行车
class Bicycle :public AbstractCat {
public:
	Bicycle() {
	}
	virtual void redLight() {
		std::cout << "我是自行车，虽然红灯了，我闯红灯。" << std::endl;
	}
	virtual void greenLight() {
		std::cout << "我是自行车，绿灯了，开始骑行。" << std::endl;
	}
};
//通知者抽象类
class AbstractNotice {
public:
	//添加通知对象
	virtual void addObject(AbstractCat* cat) = 0;
	//删除通知对象
	virtual void delObject(AbstractCat* cat) = 0;
	//通知所有的通知对象红灯了
	virtual void startNoticeRed() = 0;
	//通知所有的通知对象绿灯了
	virtual void startNoticeGreen() = 0;
};

struct MyNotice :public std::binary_function<AbstractCat*, bool, void>{
	void operator()(AbstractCat* car, bool flag) const{
		if (flag)
		{
			car->redLight();
		}
		else
		{
			car->greenLight();
		}
	}
};

//红绿灯 通知者
class TrafficLight :public AbstractNotice {
public:
	//添加通知对象
	virtual void addObject(AbstractCat * cat) {
		this->cat.push_back(cat);
	}
	//删除通知对象
	virtual void delObject(AbstractCat* cat) {
		this->cat.remove(cat);
	}
	//通知所有的通知对象红灯了
	virtual void startNoticeRed() {
		for_each(this->cat.begin(), this->cat.end(), bind2nd(MyNotice(),true));
	}
	//通知所有的通知对象绿灯了
	virtual void startNoticeGreen() {
		for_each(this->cat.begin(), this->cat.end(), bind2nd(MyNotice(), false));
	}
private:
	std::list<AbstractCat*> cat;
};

void test01() {
	BMW* bwmA = new BMW;
	BMW* bwmB = new BMW;
	Bicycle* bicycle = new Bicycle;
	TrafficLight* traffic = new TrafficLight;
	traffic->addObject(bwmA);
	traffic->addObject(bwmB);
	traffic->addObject(bicycle);
	std::cout << "绿灯了..." << std::endl;
	traffic->startNoticeGreen();
	std::cout << "红灯了..." << std::endl;
	traffic->startNoticeRed();
	std::cout << "宝马B毁了" << std::endl;
	traffic->delObject(bwmB);
	std::cout << "绿灯了..." << std::endl;
	traffic->startNoticeGreen();
	std::cout << "红灯了..." << std::endl;
	traffic->startNoticeRed();
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
