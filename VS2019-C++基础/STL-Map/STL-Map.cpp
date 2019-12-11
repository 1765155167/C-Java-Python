// STL-Map.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <map>

//map 不允许相同key的元素
//multimap允许相同元素个数存在
//基于红黑树 存放键值对
//初始化与插入元素方式
//insert(pair<>)
//find(key)查找key相同的第一个位置
//count(key)统计key个数 map只能为0或1 
void test01()
{
	//std::map<key, val>
	std::map<int, std::string> m;
	//插入元素 pait<key,val>四种方式
	std::pair<std::map<int, std::string>::iterator, bool> ret;
	ret = m.insert(std::pair<int, std::string>(1, "hqf"));
	if (ret.second == false)
	{
		std::cout << "第一次插入失败" << std::endl;
	}
	ret = m.insert(std::make_pair(3, "ming"));
	if (ret.second == false)
	{
		std::cout << "第二次插入失败" << std::endl;
	}
	ret = m.insert(std::map<int, std::string>::value_type(2,"mlxg"));
	if (ret.second == false)
	{
		std::cout << "第三次插入失败" << std::endl;
	}
	//插入与修改
	m[1] = "hmjg";//如果key不存在则插入//存在会修改
	//m[10];//插入<10,默认值>
	//打印
	for (std::map<int, std::string>::iterator it = m.begin();
		it != m.end(); it++)
	{
		std::cout << "key: " << (*it).first 
			<< " val: " << (*it).second << std::endl;
	}
	std::cout << "key = 1 的个数:" << m.count(1) << std::endl;
}

//当放自定义类型为key时需要定义仿函数声明排序规则
class Person {
public:
	Person(int id, int age) {
		this->id = id;
		this->age = age;
	}
	~Person() {

	}
public:
	int id;
	int age;
};
struct mycompare
{
	bool operator()(const Person& a, const Person& b)const {
		return a.id < b.id;
	}
};
void test02()
{
	std::map<Person, int, mycompare> m;
	m[Person(10, 20)] = 10;
	m[Person(11, 12)] = 20;
	m[Person(13, 14)] = 30;
	m[Person(15, 16)] = 40;
	for (std::map<Person, int, mycompare>::iterator it = m.begin();
		it != m.end(); it++)
	{
		std::cout << "id:" << (*it).first.id
			<< " age:" << (*it).first.age
			<< " val:" << (*it).second << std::endl;
	}
}

//查找
//find() count()
//lower_bound() upper_bound()
//
void test03()
{
	std::map<int, int> m;
	m.insert(std::make_pair(1, 20));
	m.insert(std::make_pair(2, 21));
	m.insert(std::make_pair(3, 22));
	m.insert(std::make_pair(4, 23));
	m.insert(std::make_pair(5, 24));
	auto b = m.lower_bound(5);
	
	auto a = m.equal_range(5);
	if (a.first != m.end())//>=
	{
		std::cout << (*(a.first)).first << std::endl;
	}
	else
	{
		std::cout << "没有找到key >= 5的元素" << std::endl;
	}
	if (a.second != m.end())//>
	{
		std::cout << (*(a.second)).first << std::endl;
	}
	else
	{
		std::cout << "没有找到key > 5的元素" << std::endl;
	}
}

int main()
{
	test03();
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
