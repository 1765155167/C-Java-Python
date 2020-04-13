// Fife.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <fstream>
#include <time.h>
#include <Windows.h>
#include <vector>
using namespace std;

template <class T>
class Stack {
private:
	vector<T> elems;     // 元素 
public:
	void push(T const& elem) {
		elems.push_back(elem);
	}
	void pop() {
		if (elems.empty())
		{
			throw out_of_range("Stack<>::top(): empty stack");
		}
		elems.pop_back();
	}
	T top() {
		if (elems.empty())
		{
			throw out_of_range("Stack<>::top(): empty stack");
		}
		return elems.back();
	}
	bool empty() const{
		return elems.empty();
	}
};


class MyException : public exception
{
public:
	const char* what() const throw() {
		return "C++ MyException";
	}
};

double division(double a, double b)
{
	if (b == 0)
	{
		throw MyException();
	}
	return a / b;
}

void ExceptionTest()
{
	double a, b;
	cin >> a >> b;
	try
	{
		cout << "a / b = " << division(a, b);
	}
	catch (MyException & e)
	{
		cout << e.what() << endl;
	}
	catch (const std::exception&)
	{
		cout << "其他错误" << endl;
	}
}

void  fileOpertion()
{
	ofstream out;
	char data[100];
	out.open("data.dat", ios::out | ios::trunc);
	out << "HelloWorld\n";
	out.close();

	{
		char data[100];
		ifstream infile;
		infile.open("data.dat");
		infile >> data;
		cout << data << endl;
		infile.close();
	}

	fstream file;

	file.open("data.dat", ios::in | ios::out);
	file.seekp(0, ios::end);//写位置
	file << "I'am Mr.Hu." << endl;
	file.seekp(0);//读位置
	while (file.good())//判断流是否是好的
	{
		file.getline(data, 100);
		cout << data << endl;
		Sleep(1000);
	}

	file.close();
}

void vectorTest()
{
	vector<int> p;
	for (int i = 0; i < 20; i++)
	{
		p.push_back(i);
	}
	vector<int>::iterator iter;
	for (iter = p.begin(); iter != p.end(); iter++)
	{
		cout << *iter << " ";
	}
}

int StackTest()
{
	try {
		Stack<int> intStack;
		for (int i = 0; i < 10; i++)
		{
			intStack.push(i);
		}
		while (!intStack.empty())
		{
			cout << intStack.top() << " ";
			intStack.pop();
		}

		Stack<string> stringStack;
		stringStack.push("I'am Mr.Hu");
		stringStack.push("Hello ");
		while (!stringStack.empty())
		{
			cout << stringStack.top() << " ";
			stringStack.pop();
		}
		stringStack.pop();
	}
	catch (exception const& ex) {
		cerr << "Exception: " << ex.what() << endl;
		return -1;
	}
}

int main()
{
	vector<int> a;
	a.push_back(1);
	a.push_back(2);
	while (!a.empty())
	{
		cout << a.back() << endl;
		a.pop_back();
	}
	
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
