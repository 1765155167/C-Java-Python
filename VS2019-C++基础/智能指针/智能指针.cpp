// 智能指针.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <memory>

class MyClass
{
public:
	MyClass();
	~MyClass();
	void show()
	{
		std::cout << "a:" << a++ << std::endl;
	}
private:
	int a;
};

MyClass::MyClass() :a(0)
{
	std::cout << "MyClass()..." << std::endl;
}

MyClass::~MyClass()
{
	std::cout << "~MyClass()..." << std::endl;
}

template<class T>
class MyAutoPtr {
public:
	MyAutoPtr(T* ptr) {
		this->ptr = ptr;
	}
	~MyAutoPtr()
	{
		if (this->ptr != NULL)
		{
			delete (T*)this->ptr;
			this->ptr = NULL;
		}
	}
	T* operator->()
	{
		return this->ptr;
	}
	T& operator*()
	{
		return *(this->ptr);
	}
private:
	T* ptr;
};
/**/
int main()
{
	/*只能指针不需要手动释放内存*/
	std::shared_ptr<MyClass> ptr(new MyClass);
	auto share = ptr;
	std::weak_ptr<MyClass> weak(share);//配合share_ptr使用
	ptr->show();
	share->show();
	if (!weak.expired())
	{
		auto ptr2 = weak.lock();
		ptr2->show();
	}
	/*MyAutoPtr<MyClass> ptr(new MyClass);
	ptr->show();
	(*ptr).show();*/
    std::cout << "Hello World!\n";
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
