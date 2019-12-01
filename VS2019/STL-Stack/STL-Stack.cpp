// STL-Stack.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include <stack>

//栈单口容器
//不能遍历，不能中间插入元素，没有迭代器，不支持随机访问
//只能在头部插入删除元素、删除元素吗，没有返回值
//top()返回栈顶元素的引用
//push()入栈(头部插入元素)
//pop()出栈(尾部删除元素)
//swap()交换
//size()返回栈元素个数
int main()
{
	std::stack<int> s;
	s.push(1);
	s.push(2);
	s.push(3);
	s.top() = 5;
	std::stack<int> s2(s);
	std::cout << "size:" << s.size() << std::endl;
	while (!s.empty())
	{
		std::cout << s.top() << " ";
		s.pop();
	}
	std::cout << std::endl;
	s.swap(s2);
	while (!s.empty())
	{
		std::cout << s.top() << " ";
		s.pop();
	}
	std::cout << std::endl;
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
