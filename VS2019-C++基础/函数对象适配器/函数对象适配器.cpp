// 函数对象适配器.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <vector>
#include <functional>
#include <algorithm>
#include <iomanip>
class MyPrint:public std::binary_function<int, int, void>
{
public:
	void operator()(int val,int num)const
	{
		std::cout << val + num << " ";
	}
};

//bind1st bing2nd 绑定适配器
void test01()
{
	std::vector<int> v;
	for (int i = 0; i < 10; i++)
	{
		v.push_back(i);
	}
	int num = 100;
	for_each(v.begin(), v.end(), std::bind2nd(MyPrint(),num));
	//bind1st 将num绑定为函数对象的第一个参数
	//bing2nd 将num绑定为函数对象的第二个参数
}

//取反适配器
class MyCompare:public std::binary_function<int, int, bool>
{
public:
	bool operator()(int a, int b)const
	{
		return a > b;
	}
};
class MyCompareMore30 :public std::unary_function<int, bool>
{
public:
	bool operator()(int a)const
	{
		return a > 30;
	}
};
class MyPrint02
{
public:
	void operator()(int val)
	{
		std::cout << val << " ";
	}
};
void test02()
{
	std::vector<int> v;
	for (int i = 0; i < 10; i++)
	{
		v.push_back(rand() % 100);
	}
	for_each(v.begin(), v.end(), MyPrint02());
	std::cout << std::endl;
	std::sort(v.begin(),v.end(),MyCompare());//倒叙排序
	for_each(v.begin(), v.end(), MyPrint02());
	std::cout << std::endl;
	//利用std::not2 std::not1取反适配器来反转排序规则参数
	//std::not2(取反二元谓词)
	//std::not1(取反一员谓词)
	std::sort(v.begin(), v.end(), std::not2(MyCompare()));//升序排序
	for_each(v.begin(), v.end(), MyPrint02());
	std::cout << std::endl;
	//规则为查找第一个大于30的元素位置
	auto it = std::find_if(v.begin(),v.end(),MyCompareMore30());
	if (it != v.end()) std::cout << "(*it) = " << *it << std::endl;
	//通过取反适配器std::not1()来查找第一个不大于30的元素位置
	it = std::find_if(v.begin(), v.end(), std::not1(MyCompareMore30()));
	if (it != v.end()) std::cout << "(*it) = " << *it << std::endl;
}
//仿函数适配器
//ptr_fun()将普通函数转换成函数对象（仿函数）
void Print2(int val,int num)
{
	std::cout << std::setw(2)<< val + num << " ";
}
void Print1(int val)
{
	std::cout << std::setw(2) << val << " ";
}
void test03()
{
	std::vector<int> v;
	for (int i = 0; i < 10; i++)
	{
		v.push_back(rand() % 100);
	}
	for_each(v.begin(), v.end(), Print1);
	std::cout << std::endl;
	//先将普通函数通过ptr_fun()转变成仿函数
	//再通过绑定适配器bind2nd()进项仿函数绑定
	for_each(v.begin(), v.end(), std::bind2nd(std::ptr_fun(Print2), 20));
	std::cout << std::endl;
}
//std::mem_fun()用于类对象指针 std::mem_fun_ref()类对象
//std::mem_fun_ref(&类名::函数)
//std::mem_fun_ref(&Person::show)
class Person {
public:
	Person(std::string name, int age) {
		this->name = name;
		this->age = age;
	}
	void show() {
		std::cout << "姓名:" << std::setw(8) <<this->name
			<< " 年龄:" << std::setw(2) << this->age << std::endl;
	}
	~Person() {}
private:
	int age;
	std::string name;
};
void test04()
{
	//如果容器中存放对象或者对象指针
	//for_each()遍历时我们想通过类提供的方法打印对象
	std::vector<Person> vp;
	vp.push_back(Person("jfjh", 21));
	vp.push_back(Person("mlxg", 22));
	vp.push_back(Person("hmgj", 23));
	//mem_fun_ref()使用对象
	for_each(vp.begin(), vp.end(), std::mem_fun_ref(&Person::show));
	std::cout << "---------------------------->" << std::endl;
	std::vector<Person*> vp2;
	vp2.push_back(new Person("dmxy", 21));
	vp2.push_back(new Person("Prince", 21));
	vp2.push_back(new Person("Frost", 21));
	vp2.push_back(new Person("zhaoxin", 21));
	//std::mem_fun()对象指针
	for_each(vp2.begin(), vp2.end(), std::mem_fun(&Person::show));
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
