#include <iostream>
#include <ctime>

void swap(int& a, int& b)
{
	int temp = a;
	a = b;
	b = temp;
}
/*冒泡排序降序*/
void mySort(int data[], int len)
{
	//data: 1 5 6 8 4 1 2 
	//i = 0 时冒泡[0~len-1] [0~len-1 -i] 
	//i = 1 时冒泡[0~len-2] [0~len-1 -i] 

	for (int i = 0; i < len; i++)
	{
		for (int j = 0; j < len - i - 1; j++)
		{
			if (data[j] < data[j + 1])/*用到了j+1 那么j + 1的范围不能超过len - i - 1 */
			{
				swap(data[j], data[j + 1]);
			}
		}
	}
}

#define MAX 20
int main()
{
	int data[MAX];
	srand((unsigned)time(NULL));//设置随机种子
	for (size_t i = 0; i < MAX; i++)
	{
		data[i] = rand() % 100;//数组赋值（100以内的随机数）
	}
	std::cout << "排序前data为：";
	for (size_t i = 0; i < MAX; i++)
	{
		std::cout << data[i] << " ";
	}
	std::cout << std::endl;

	mySort(data, MAX);

	std::cout << "排序后data为：";
	for (size_t i = 0; i < MAX; i++)
	{
		std::cout << data[i] << " ";
	}
	std::cout << std::endl;
}