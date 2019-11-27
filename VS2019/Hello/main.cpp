#include <iostream>
#include <vector>

template<class T>
auto Max(T a, T b)
{
	return a > b ? a : b;
}

long long int Fibonacci1(size_t n)
{
	if (n <= 0) {
		return 0;
	}
	if (n == 1)
	{
		return 1;
	}
	return Fibonacci1(n - 1) + Fibonacci1(n - 2);
}

long long int Fibonacci2(size_t n)
{
	int result[2] = { 0,1 };
	if (n < 2 && n >= 0)
	{
		return result[n];
	}
	long long int fibNumOne = 1;
	long long int fibNumTwo = 0;
	long long int fibNum = 0;
	for (size_t i = 2; i <= n; i++)
	{
		fibNum = fibNumOne + fibNumTwo;
		fibNumTwo = fibNumOne;
		fibNumOne = fibNum;
	}
	return fibNum;
}

int main()
{
	char* data = new char[20];
	char hello[] = "Hello ";
	char world[] = "world";
	memset(data, 0, 20);
	
	strcat_s(data, 20, hello);
	strcat_s(data, 20, world);
	std::cout << "sizeof(data) = " << sizeof(data) << std::endl;
	std::cout << "data = " << data << std::endl;
	std::cout << strchr(data, 'l') << std::endl;

	std::vector<size_t> vec;
	for (size_t i = 0; i < 20; i++)
	{
		vec.push_back(i);
	}
	for (auto i = vec.begin(); i != vec.end(); i++)
	{
		std::cout << *i << " ";
	}
	std::cout << std::endl;
	register int r = 0;
	unsigned int i = 10;
	auto a = 12.2568;
	std::cout << "r = " << ++r << std::endl;
	std::cout << "i = " << i << std::endl;
	std::cout << "a = " << a << std::endl;
	std::cout << "Max(10, 2) = " << Max(10, 2) << std::endl;
	delete[]data;
	return 0;
}