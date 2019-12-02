// Vector.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <iomanip>
#include <vector>//单口容器，尾端插入尾端提取
#include <algorithm>

class Person {
public:
	Person() :id(0) {};
	Person(int id) :id(id) {};
	void show() {
		std::cout << "id = " << this->id << std::endl;
	}
	~Person() {
		std::cout << "析构函数:" << this->id << std::endl;
	}
private:
	int id;
};

template<class T>
void add1(T& a)
{
	a = a + 1;
}

template<class T>
void printInfo(T& a)
{
	std::cout.setf(std::ios::left);
	std::cout << std::setw(2) << a << " ";
}

void test01()
{
	std::vector<int> v;
	v.push_back(1);
	v.push_back(2);
	v.push_back(30);
	v.push_back(4);
	v.push_back(5);
	//auto start = v.begin();
	std::vector<int>::iterator start = v.begin();
	auto end = v.end();
	for_each(start, end, printInfo<int>);
	std::cout << std::endl;
	for_each(start, end, add1<int>);
	for_each(start, end, printInfo<int>);
	std::cout << std::endl;
	std::cout << "front:" << v.front() << std::endl;
	std::cout << "back:" << v.back() << std::endl;
	std::cout << std::endl;
}

void PrintPerson(Person* p)
{
	if (p != NULL)
	{
		p->show();
	}
}

void deletePerson(Person*& p)
{
	if (p != NULL) {
		delete p;
		p = NULL;
	}
}

void test02()
{
	std::vector<Person*> v;//序列式容器(容器中的位置有进入容器的顺序决定)
	v.push_back(new Person(1));
	v.push_back(new Person(2));
	v.push_back(new Person(3));
	v.push_back(new Person(4));//需要手动去析构
	auto pBegin = v.begin();
	auto pEnd = v.end();
	//std::for_each(pBegin, pEnd, PrintPerson);
	for (; pBegin!= pEnd;pBegin++) (*pBegin)->show();
	//v.resize(1);//失去的空间不会自动delete
	std::cout << "v.size() = " << v.size() << std::endl;
	std::for_each(v.begin(), v.end(), deletePerson);
}

void printVector(std::vector<int> v)
{
	std::for_each(v.begin(), v.end(), printInfo<int>);
	std::cout << std::endl;
}

void test03()
{
#if 0
	int data[] = { 1,3,4,6,4,8,5,9,0,3 };
	std::vector<int> v1;
	for (size_t i = 0; i < sizeof(data)/sizeof(data[0]); i++)
	{
		v1.push_back(data[i]);
		//v2.push_back(data[i] + 2);
	}
#endif

#if 1
	int data[] = { 1,3,4,6,4,8,5,9,0,3 };
	//初始化方法
	std::vector<int> v1(data, data + sizeof(data) / sizeof(data[0]));
	std::vector<int> v3(v1.begin(), v1.end());
	std::vector<int> v4(v1);
	std::vector<int> v5;
	v5.assign(v1.begin(), v1.end());
	//取值操作
	v5[0] = 1;//越界发生错误
	v5.at(0) = 2;//越界抛出异常
	v5.front() = 10000;//第一个元素
	v5.back() = 10000;//最后一个元素
	std::for_each(v5.begin(), v5.end(), printInfo<int>);
	std::cout << std::endl;
	v5.swap(v1);//交换两个容器
	//插入元素
	v5.insert(v5.begin() + 2, 1234);//指定位置前插入一个元素
	v5.push_back(125);//尾部插入
	std::for_each(v5.begin(), v5.end(), printInfo<int>);
	std::cout << std::endl;
	//删除 删除元素容器容量不会减小
	v5.erase(v5.begin());//删除一个元素
	v5.erase(v5.begin(), v5.end() - 2);//区间删除
	v5.clear();//清空
	//缩小容量大小为存放元素个数
	std::vector<int>(v5).swap(v5);
	//大小
	v5.resize(3);//强制改变容器元素个数 小于去除，大于不变
	v5.resize(20,1);//大于增加元素个数并且给个默认值
	std::cout << "size:" << v5.size() << std::endl;//返回元素个数
	std::cout << "容量:" << v5.capacity() << std::endl;//容量最多存放的元素个数>=size
	
#endif
	
	std::vector<int> v2 = v1;
	std::for_each(v2.begin(), v2.end(), add1<int>);
	std::vector<std::vector<int>> v;//容器嵌套
	v.push_back(v1);
	v.push_back(v2);
	std::for_each(v.begin(), v.end(), printVector);
}

//vector动态增长原理
void test04()
{
	std::vector<size_t> v;
	v.reserve(100000);//提前告诉容器需要100000空间、避免容器多次动态增长空间
	//reserve只是声明一下要存放100000元素，无法通过v[100000]访问
	//v[90001] = 100;//报错
	//v.resize(100000);//初始化100000
	
	size_t* addr = NULL;
	int num = 0;
	for (size_t i = 0; i < 100000; i++)
	{
		v.push_back(i);
		if (addr != &(v[0]))
		{
			num++;
			addr = &(v[0]);
			std::cout << "size:" << v.size() << std::endl;
			std::cout << "容量:" << v.capacity() << std::endl;
		}
	}
	v.resize(10);//强制缩小 容器存放元素个数、但容量并不会缩小
	std::cout << "size:" << v.size() << std::endl;
	std::cout << "容量:" << v.capacity() << std::endl;
	std::vector<size_t>(v).swap(v);//缩小容量为合适大小
	std::cout << "size:" << v.size() << std::endl;
	std::cout << "容量:" << v.capacity() << std::endl;
}

//vector动态增长原理：当插入元素时如果空间不足则会重新申请更大的空间
//赋值内容到新空间中并释放原来的空间
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
