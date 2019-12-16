#include <iostream>
#include <vector>
#include <thread>

int Calculation(int val)
{
	if (val <= 0)
	{
		return 0;
	}
	if ((val == 1) || (val == 2))
	{
		return val;
	}
	return val * Calculation(val - 1);
}

long long int CalSum(std::vector<int> v,
	std::vector<int>::iterator start,
	std::vector<int>::iterator end)
{
	long long int sum = 0;
	for (auto it = start; it != end; it++)
	{
		sum += Calculation(*it);
	}
	return sum;
}

long long int CalOne()
{

}

int main(int argc, char* argv[])
{
	std::vector<int> v;
	
	for (size_t i = 0; i < 10000000; i++)
	{
		v.push_back(rand() % 20);
	}
	time_t start = time(NULL);
	long long int sum = 0;
	for (auto& info : v)
	{
		sum += Calculation(info);
	}
	std::cout << "time: "<< time(NULL)-start << " sum: " << sum << std::endl;
	return 0;
}