#include "MyArray.h"
#include <iostream>
#include <ctime>

int main()
{
	MyArray<int> data(5);
	srand(time(NULL));
	for (size_t i = 0; i < data.getLen(); i++)
	{
		data.setData(i, rand() % 255);
	}
	std::cout << "data:" << data << std::endl;

	MyArray<int> data2;
	data2 = data + 1;
	std::cout << "data2 = data + 1----------->" << std::endl;
	std::cout << "data2:" << data2 << std::endl;

	MyArray<int> data3;
	data3 = data;
	data3 += data2;
	std::cout << "data3=data+data2----------->" << std::endl;
	std::cout << "data3:" << data3 << std::endl;
	std::cout << "data3[3]:" << data3[3] << std::endl;
	std::cout << "data3.getData(3):" << data3.getData(3) << std::endl;

	data3 += 10;
	std::cout << "data3 += 10;----------->" << std::endl;
	std::cout << "data3:" << data3 << std::endl;

	std::cout << "data3.getData(3):" << data3.getData(3) << std::endl;
	std::cout << "data3[3]:" << data3[3] << std::endl;

	MyArray<int> data4 = ++data3;
	std::cout << "data4 = ++data3----------->" << std::endl;
	std::cout << "data4:" << data4 << std::endl;

	MyArray<int> data5 = data3++;
	std::cout << "data5 = data3++----------->" << std::endl;
	std::cout << "data5:" << data5 << std::endl;

	return 0;
}

template<class A>
std::ostream& operator<<(std::ostream& os, MyArray<A>& another)
{
	for (size_t i = 0; i < another.len; i++)
	{
		os << another.speace[i] << " ";
	}
	return os;
}
