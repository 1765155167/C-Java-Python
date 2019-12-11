#include "vector.h"

int main()
{
	int data[] = { 1,2,3,4,5,6,7,8,8,4,5,4,9 };
	vector<int> v1(data, data + sizeof(data) / sizeof(data[0]));
	vector<int> v = v1;
	for (int i = 0; i < 100; i++)
	{
		v.push_back(i);
	}
	std::cout << "容量:" << v.getcapacity() << std::endl;
	std::cout << "size:" << v.size() << std::endl;
	/*while (!v.empty())
	{
		std::cout << v.back() << " ";
		v.pop_back();
	}
	std::cout << std::endl;*/
	/*for (auto it = v.begin(); it != v.end(); it++)
	{
		std::cout << *it << " ";
	}
	std::cout << std::endl;*/
	
	for (size_t i = 0; i < v.size() + 1; i++)
	{
		try
		{
			std::cout << v.at(i) << " ";
		}
		catch (const char * str)
		{
			std::cout << str << std::endl;
		}
		catch (...)
		{
			std::cout << "其他异常" << std::endl;
		}
	}
	std::cout << std::endl;
	return 0;
}
