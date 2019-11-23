// C++类模板.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <ctime>
#include "Vector.hpp"

void VectorTest()
{
	Vector<int, 21> vector;
	srand(static_cast<unsigned int>(time(NULL)));
	for (size_t i = 0; i < 20; i++)
	{
		vector.back_push(rand() % 100);
	}
	vector.back_push(50);
	auto v = vector.begin();
	while (v != vector.end())
	{
		std::cout << *v << " ";
		v++;
	}
	std::cout << std::endl;
}
float data[1024];
template<typename T> T GetValue(int i)
{
	return static_cast<T>(data[i]);//将data[i]强制转换成T型
}

/*强制转换*/
template< typename DstT, typename SrcT>
DstT c_style_cast(SrcT v)
{
	return (DstT)(v);
}

int main()
{
	using namespace std;
	VectorTest();
	cout << c_style_cast<int>(2.5) << endl;
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
