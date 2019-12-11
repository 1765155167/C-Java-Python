// 堆排序.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>

void PrintArray(int data[], int len)
{
	for (size_t i = 0; i < len; i++)
	{
		std::cout << data[i] << " ";
	}
	std::cout << std::endl;
}
/*
 * 调整堆
 *@param@ data:待调整数组
 *@param@ index:调整位置 父节点大于子节点
 *@param@ len:数组长度
 */
void HeapAdjust(int data[], int index, int len)
{
	int max = index;
	int lchild = index * 2 + 1;
	int rchild = index * 2 + 2;
	//计算当前节点与孩子节点的最大值节点位置
	if (lchild < len && data[lchild] > data[max])
	{
		max = lchild;
	}
	if (rchild < len && data[rchild] > data[max])
	{
		max = rchild;
	}
	if (max != index)//需要调整
	{
		std::swap(data[max],data[index]);//交换
		HeapAdjust(data, max, len);//在继续调整孩子中较大的值的节点
	}
}
//堆排序
void HeapSort(int data[], int len)
{
	//初始化堆 大顶堆 父节点大于子节点
	//从子最后一个非叶子节点开始向前调整堆
	for (int i = len / 2 - 1; i >= 0 ; i--)
	{
		HeapAdjust(data, i, len);
	}
	//根节点与第i个节点交换在重新调整根节点到i-1节点
	for (int i = len - 1; i >= 0; i--)
	{
		std::swap(data[i], data[0]);
		HeapAdjust(data, 0, i);
	}
}
int main()
{
	int data[] = { 4,2,8,9,7,1,3,0,5,6,7,2,45,6,4 };
	PrintArray(data, sizeof(data)/sizeof(data[0]));
	HeapSort(data, sizeof(data) / sizeof(data[0]));
	PrintArray(data, sizeof(data) / sizeof(data[0]));
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
