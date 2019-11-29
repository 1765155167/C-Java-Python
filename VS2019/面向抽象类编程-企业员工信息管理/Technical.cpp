#include "Technical.h"


Technical::Technical(size_t timeMonth, std::string name)
	:Employee(name), timeMonth(timeMonth),hourMoney(100)
{
}

void Technical::pay()
{
	this->salary = this->timeMonth * this->hourMoney;
}

void Technical::upLevel()
{
	this->level++;
	this->hourMoney += 10;
}

void Technical::setTimeMonth(size_t timeMonth)
{
	this->timeMonth = timeMonth;
}

Technical::~Technical()
{
}
