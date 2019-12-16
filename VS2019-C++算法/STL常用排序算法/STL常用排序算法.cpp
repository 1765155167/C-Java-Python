// STL常用排序算法.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <vector>
#include <list>
#include <numeric>
#include <iomanip>
#include <algorithm>
#include <ctime>

void Print(int val)
{
	std::cout << val << " ";
}

void Printf(std::vector<int> v)
{
	auto it = v.begin();
	for (; it != v.end(); it++)
	{
		std::cout << std::setw(2) << std::setiosflags(std::ios::left)
			<< *it << " ";
	}
	std::cout << std::endl;
}

void Printf(std::list<int> v)
{
	auto it = v.begin();
	for (; it != v.end(); it++)
	{
		std::cout << std::setw(2) << std::setiosflags(std::ios::left)
			<< *it << " ";
	}
	std::cout << std::endl;
}
//比较规则
class MyCompare : public std::binary_function<int,int,bool> {
public:
	bool operator()(int a, int b)
	{
		return a > b;
	}
};

//merg 合并有序数列
void test01()
{
	int length = 10;
	std::vector<int> v1,v2;
	for (int i = 0; i < length; i++)
	{
		v1.push_back(rand() % 99 + 1);
		v2.push_back(rand() % 99 + 1);
	}
	sort(v1.begin(), v1.end(), MyCompare());
	sort(v2.begin(), v2.end(), MyCompare());
	std::vector<int> v3;
	v3.resize(v1.size() + v2.size());
	//std::merge()默认合并升序序列
	//std::merge(v1.begin(), v1.end(), v2.begin(), v2.end(), v3.begin());
	std::merge(v1.begin(), v1.end(), v2.begin(), v2.end(), v3.begin(), MyCompare());
	Printf(v1);
	Printf(v2);
	Printf(v3);
}

//random_shuffle() 打乱容器 
void test02()
{
	int length = 10;
	std::vector<int> v1, v2;
	for (int i = 0; i < length; i++)
	{
		v1.push_back(rand() % 99 + 1);
	}
	sort(v1.begin(), v1.end(), MyCompare());
	Printf(v1);
	std::random_shuffle(v1.begin(), v1.end());//打乱容器 不能打乱不支持随机访问的容器
	Printf(v1);
}

//reverse 反转
void test03()
{
	int length = 10;
	std::list<int> v1;
	for (int i = 0; i < length; i++)
	{
		v1.push_back(rand() % 99 + 1);
	}
	//sort(v1.begin(), v1.end(), MyCompare());
	v1.sort(MyCompare());
	Printf(v1);
	std::reverse(v1.begin(), v1.end());//反转 可以反转不支持随机访问的
	Printf(v1);
}

//copy() swap() 拷贝，容器替换
void test04()
{
	int length = 10;
	std::vector<int> v1,v2;
	for (int i = 0; i < length; i++)
	{
		v1.push_back(rand() % 99 + 1);
	}
	v2.resize(v1.size());
	//_OutIt copy(_InIt _First, _InIt _Last, _OutIt _Dest)
	copy(v1.begin(),v1.end(),v2.begin());
	//Printf(v2);
	//swap
	std::vector<int> v3;
	for (int i = 0; i < length; i++)
	{
		v3.push_back(rand() % 99 + 1);
	}
	std::cout << "------------------------>" << std::endl;
	Printf(v2);
	Printf(v3);
	std::cout << "------------------------>" << std::endl;
	swap(v2,v3);
	Printf(v2);
	Printf(v3);
}

//替换规则
struct MyCompare02 {
	bool operator()(int val) const
	{
		return val > 5;
	}
};

//replace replace_if;替换
void test05()
{
	int length = 10;
	std::vector<int> v1;
	for (int i = 0; i < length; i++)
	{
		v1.push_back(rand() % 9 + 1);
	}
	Printf(v1);
	std::cout << "------------------------>" << std::endl;
	//replace(v1.begin(),v1.end(), 5,100);//替换
	replace_if(v1.begin(), v1.end(), MyCompare02(), 200);//给定规则替换
	Printf(v1);
}

//算术生成算法 求和std::accumulate，填充fill
void test06()
{
	int length = 10;
	std::vector<int> v1;
	for (int i = 0; i < length; i++)
	{
		v1.push_back(rand() % 9 + 1);
	}
	int ret = std::accumulate(v1.begin(), v1.end(), 0);
	std::cout << "求和:" << ret << std::endl;

	//fill
	std::vector<int> v2;
	v2.resize(10);
	fill(v2.begin(), v2.end(), 5);//填充
	Printf(v2);
}

//集合：差集difference 交集intersection 并集union
void test07()
{
	std::vector<int> v1;
	for (int i = 0; i < 10; i++)
	{
		v1.push_back(i);
	}
	Printf(v1);
	std::vector<int> v2;
	for (int i = 0; i < 10; i++)
	{
		v2.push_back(i + 5);
	}
	Printf(v2);
	std::cout << "----------------->" << std::endl;
	//求交集std::set_intersection
	std::vector<int> v3;
	v3.resize(std::min(v1.size(), v2.size()));
	std::vector<int>::iterator it;
	it = std::set_intersection(v1.begin(),v1.end(),v2.begin(),v2.end(),v3.begin());
	std::cout << "交集:";
	for_each(v3.begin(),it, Print);
	std::cout << std::endl;
	//并集std::set_union
	std::vector<int> v4;
	v4.resize(v1.size() + v2.size());
	it = std::set_union(v1.begin(),v1.end(),v2.begin(),v2.end(),v4.begin());
	std::cout << "并集:";
	for_each(v4.begin(), it, Print);
	std::cout << std::endl;
	//差集std::set_difference
	std::vector<int> v5;
	v5.resize(std::max(v1.size(),v2.size()));
	it = std::set_difference(v1.begin(), v1.end(), v2.begin(), v2.end(), v4.begin());
	std::cout << "差集:";
	for_each(v4.begin(), it, Print);
	std::cout << std::endl;
}

int main()
{
	srand(static_cast<int>(time(NULL)));
	test07();
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
