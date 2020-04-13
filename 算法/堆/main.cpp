#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

//向下调整堆结构 大顶堆
void adjustHeap(int arr[], int index, int length) {
	int temp = arr[index];
	for (size_t k = 2 * index + 1; k < length; k = 2 * k + 1)
	{
		//k指向子节点最大的
		if (k + 1 < length && arr[k] < arr[k + 1])
		{
			k = k + 1;
		}
		if (temp < arr[k])
		{
			arr[index] = arr[k];
			index = k;
		}
		else
		{
			break;
		}
	}
	arr[index] = temp;
}
//插入节点
void add(int arr[], int* len, int elem)
{
	arr[*len] = elem;
	for (int i = *len; i > 0; i = (i -1) / 2)
	{
		if (arr[i] > arr[(i - 1) / 2]) {
			swap(arr[i], arr[(i - 1) / 2]);
		}
		else {
			break;
		}
	}
	(*len)++;
}

struct MyPrint {
	void operator()(int data) {
		cout << data << " ";
	}
};

int main() {
	int arr[20] = { 8, 5, 5, 9, 6, 7, 4, 1, 2, 3 };
	int len = 10;
	for (int i = len / 2 - 1; i >= 0; i--)
	{
		adjustHeap(arr, i, len);
	}
	add(arr, &len, 10);
	for (size_t i = len - 1; i > 0; i--)
	{
		swap(arr[0], arr[i]);
		adjustHeap(arr, 0, i);
	}
	vector<int> v(arr, arr + len);
	for_each(v.begin(), v.end(), MyPrint());
	cout << endl;
	return 0;
}