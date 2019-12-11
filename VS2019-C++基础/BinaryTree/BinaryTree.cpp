// BinaryTree.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include "BinaryTree.h"
#include <queue>
#include "fun.h"

template<class T>
T max(T a, T b)
{
	return a > b ? a : b;
}

template<class T>
inline BinaryTree<T>::BinaryTree()
{
	this->data = 0;
	this->lChild = NULL;
	this->rChild = NULL;
	this->sum++;
}

template<class T>
inline BinaryTree<T>::BinaryTree(T data)
{
	this->data = data;
	this->lChild = NULL;
	this->rChild = NULL;
	this->sum++;
}

template<class T>
inline BinaryTree<T>::~BinaryTree()
{
	delete this->data;
	sum--;
}

template<class T>
inline void BinaryTree<T>::setRightChild(BinaryTree<T>* rChild)
{
	this->rChild = rChild;
}

template<class T>
inline void BinaryTree<T>::setLeftChild(BinaryTree<T>* lChild)
{
	this->lChild = lChild;
}

template<class T>
inline void BinaryTree<T>::setData(T data)
{
	this->data = data;
}

template<class T>
inline BinaryTree<T>* BinaryTree<T>::getRightChild() const
{
	return this->rChild;
}

template<class T>
inline BinaryTree<T>* BinaryTree<T>::getLeftChild() const
{
	return this->lChild;
}

template<class T>
inline T BinaryTree<T>::getData() const
{
	return this->data;
}

template<class T>
int BinaryTree<T>::getSum()
{
	return 0;
}

template<class T>
void fun(BinaryTree<T>* p)
{
	if (p == NULL)
	{
		return;
	}
	fun(p->getLeftChild());
	std::cout << p->getData() << " ";
	fun(p->getRightChild());
}

template<class T>
int deepBinaryTree(BinaryTree<T>* p)/*求深度*/
{
	if (p == NULL)
	{
		return 0;
	}
	return 1 + max(deepBinaryTree(p->getLeftChild()),
		           deepBinaryTree(p->getRightChild()));
}

template<class T>
void leverPrint(BinaryTree<T>* root)
{
	if (root == NULL)
	{
		return;
	}
	std::queue< BinaryTree<T>* > que;
	que.push(root);
	while (!que.empty())
	{
		BinaryTree<T>* p = que.front();
		que.pop();
		std::cout << p->getData() << " ";
		if(p->getLeftChild() != NULL)
			que.push(p->getLeftChild());
		if(p->getRightChild() != NULL)
			que.push(p->getRightChild());
	}
	std::cout << std::endl;
}
//递归求约瑟夫问题
int fun(int n, int m)
{
	if (n == 1)
	{
		return 1;
	}
	return (fun(n - 1, m) + m) % n + 1;
}
//约瑟夫问题
int test(int n, int m)
{
	int last = 0;
	for (int i = 2; i <= n; i++)
	{
		last = (last + m) % i;
	}
	return last + 1;
}

int main()
{
	/*BinaryTree<int>* root = new BinaryTree<int>(1);
	BinaryTree<int>* p2 = new BinaryTree<int>(2);
	BinaryTree<int>* p3 = new BinaryTree<int>(3);
	BinaryTree<int>* p4 = new BinaryTree<int>(4);
	BinaryTree<int>* p5 = new BinaryTree<int>(5);
	BinaryTree<int>* p6 = new BinaryTree<int>(6);
	BinaryTree<int>* p7 = new BinaryTree<int>(7);
	BinaryTree<int>* p8 = new BinaryTree<int>(8);
	BinaryTree<int>* p9 = new BinaryTree<int>(9);
	root->setLeftChild(p2);
	root->setRightChild(p3);
	p2->setLeftChild(p4);
	p2->setRightChild(p5);
	p3->setLeftChild(p6);
	p3->setRightChild(p7);
	p4->setLeftChild(p8);
	p4->setRightChild(p9);
	fun(root);
	//leverPrint(root);
	std::cout << "树深度为：" << deepBinaryTree(root) << std::endl;
    std::cout << "Hello World!\n";
	std::cout << "共有" << root->getSum() << "个节点" << std::endl;*/
	std::cout << test(7, 1) << std::endl;
	std::cout << fun(7, 1) << std::endl;
	print();
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
