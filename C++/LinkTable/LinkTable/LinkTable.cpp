// LinkTable.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include "LinkNodes.h"


void test()
{
	LinkNodes* link1 = createLinkNodes(1, "one");
	LinkNodes* link2 = createLinkNodes(2, "one");
	LinkNodes* link3 = createLinkNodes(3, "one");
	LinkNodes* link4 = createLinkNodes(4, "one");
	LinkNodes* link5 = createLinkNodes(5, "one");
	LinkNodes* link6 = createLinkNodes(6, "one");
	LinkNodes* link7 = createLinkNodes(7, "one");
	LinkNodes* link8 = createLinkNodes(8, "one");

	linkTwoNodes(link1, link3);
	linkTwoNodes(link3, link5);
	linkTwoNodes(link5, link7);

	linkTwoNodes(link2, link4);
	linkTwoNodes(link4, link6);
	linkTwoNodes(link6, link8);
	
	printLink(link1, false);
	printLink(link2, false);
	LinkNodes* p = mergeList(link1, link2);
	printLink(p, false);
	
	delLinkNode(link1);
	delLinkNode(link2);
	delLinkNode(link3);
	delLinkNode(link4);
	delLinkNode(link5);
}


int main()
{
	test();
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
