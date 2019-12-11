#pragma once
#include <iostream>
#include <string>
class Worker
{
public:
	Worker();
	Worker(std::string name, std::string phone,
		unsigned int age, float salary);
	void show();
	~Worker();
protected:
	std::string name;
	std::string phone;
	unsigned int age;
	float salary;
};

