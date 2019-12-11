// 常用的查找算法.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <vector>
#include <algorithm>

//find() 按值查找 如果查找类需要重载等号运算符
//find_if() 查找满足给定规则的首个元素
//count_if() 统计满足给定规则元素个数
//binary_search()二分查找
//adjacent_find()查找相邻重复元素并返回第一个位置
void Print(int val)
{
	std::cout << val << " ";
}

void test01()
{
	int data[] = { 1,2,3,5,5,8,4,6,4,5,9 };
	std::vector<int> v(data, data + sizeof(data) / sizeof(data[0]));
	for_each(v.begin(), v.end(), Print);
	std::cout << std::endl;
	auto it = find(v.begin(), v.end(), 5);
	if (it != v.end())
	{
		std::cout << "找到了: " << *it << std::endl;
	}
}

class Person {
public:
	Person() :id(0) {}
	Person(std::string name, int id) :name(name), id(id) {}
	void show() {
		std::cout << "姓名: " << this->name 
			<< " id: " << this->id << std::endl;
	} 
	bool operator==(const Person& another) const
	{
		if (another.name == this->name &&
			another.id == this->id)
		{
			return true;
		}
		return false;
	}
	~Person() {
		std::cout << "析构函数:" << this->name << std::endl;
	}
private:
	int id;
	std::string name;
};
void test02()
{
	std::vector<Person> vp;
	vp.push_back(Person("hqf", 21));
	vp.push_back(Person("mlx", 22));
	vp.push_back(Person("777", 23));
	//查找类对象时需要类中重载==运算符
	auto it = find(vp.begin(), vp.end(), Person("777", 20));
	if (it != vp.end())
	{
		std::cout << "找到了: " << std::endl;
		(*it).show();
	}
	else
	{
		std::cout << "没有找到" << std::endl;
	}
}
//binary_search()二分查找
//所以数据实现得是有序的
void test03()
{
	int data[] = { 1,2,3,5,5,8,4,6,4,5,9 };
	std::vector<int> v(data, data + sizeof(data) / sizeof(data[0]));
	for_each(v.begin(), v.end(), Print);
	std::sort(v.begin(), v.end());
	std::cout << std::endl;
	bool ret = binary_search(v.begin(),v.end(),8);
	if (ret)
	{
		std::cout << "找到了" << std::endl;
	}
	else
	{
		std::cout << "没有找到了" << std::endl;
	}
}
//std::adjacent_find()查找相邻重复元素并返回第一个位置
bool Compare(int val)
{
	if (val == 5)
	{
		return true;
	}
	return false;
}
void test04()
{
	int data[] = { 1,2,3,5,5,8,8,4,6,4,5,9 };
	std::vector<int> v(data, data + sizeof(data) / sizeof(data[0]));
	for_each(v.begin(), v.end(), Print);
	std::cout << std::endl;
	auto it = adjacent_find(v.begin(),v.end());
	if (it != v.end())
	{
		std::cout << "找到了相邻重复元素:" << *it << std::endl;
	}
	else
	{
		std::cout << "没有找到相邻重复元素" << std::endl;
	}
	//find_if()给定条件进行查找
	it = find_if(v.begin(), v.end(), Compare);
	if (it != v.end())
	{
		std::cout << "find_if()找到了:" << *it << std::endl;
	}
	else
	{
		std::cout << "没有找到" << std::endl;
	}
	//count_if()给定条件统计
	int ret = count_if(v.begin(), v.end(), Compare);
	std::cout << "满足Compare规则的元素个数:" << ret << std::endl;
}
int main()
{
	test04();
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
