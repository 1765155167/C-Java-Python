#include <iostream>
#include "main.h"

using namespace std;

int fun1(int num1, int num2) {
	while (num1 != num2)
	{
		if (num1 > num2) {
			num1 -= num2;
		}
		else
		{
			num2 -= num1;
		}
	}
	return num1;
}

int fun2(int num1, int num2) {
	if (num1 > num2)
	{
		std::swap(num1, num2);
	}
	for (size_t i = num1; i > 0; i--)
	{
		if (num1 % i == 0 && num2 % i == 0)
		{
			return i;
		}
	}
	return -1;
}

int fun3(int num1, int num2) {
	while (num2 ^= num1 ^= num2 ^= num1 %= num2);
	return num1;
}

int main() 
{
	cout << "78 52 最大该公约数为：" << fun1(78, 52) << endl;
	cout << "78 52 最大该公约数为：" << fun2(78, 52) << endl;
	cout << "78 52 最大该公约数为：" << fun3(78, 52) << endl;
	return 0;
}