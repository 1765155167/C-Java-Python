#pragma once
#include <iostream>
class Person
{
public: 
	Person(){
		this->age = 0;
		this->name = { 0 };
	}
	Person(int age, std::string name) : age(age), name(name){}
	void show()
	{
		std::cout << "Age: " << age << " name: " << name << std::endl;
	}
public:
	int age;
	std::string name;
};

