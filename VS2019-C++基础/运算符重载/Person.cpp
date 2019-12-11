#include "Person.h"
#include <iostream>
using namespace std;
Person::Person(const Person& p)
{
	std::cout << "拷贝构造函数" << std::endl;
	this->m_a = p.m_a;
	this->m_b = p.m_b;
}

Person::~Person()
{
	std::cout << "析构函数" << std::endl;
}

void Person::show() const
{
	std::cout << "m_a: " << m_a 
		<< " m_b: " << m_b 
		<< std::endl;
}

const Person operator+(const Person& p1, const Person& p2)
{
	Person temp;
	temp.m_a = p1.m_a + p2.m_a;
	temp.m_b = p1.m_b + p2.m_b;
	return temp;
}

const Person operator-(const Person& p1, const Person& p2)
{
	Person temp;
	temp.m_a = p1.m_a - p2.m_a;
	temp.m_b = p1.m_b - p2.m_b;
	return temp;
}

const Person operator++(const Person& p)
{
	Person temp;
	temp.m_a = p.m_a + 1;
	temp.m_b = p.m_b + 1;
	return temp;
}
