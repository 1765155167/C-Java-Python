#include "Employee.h"
#include "Technical.h"
#include "Manager.h"
#include "Salesperson.h"
#include "SalesManager.h"

void test(Employee* tech)
{
	tech->upLevel();
	tech->upLevel();
	tech->pay();
	tech->displayStatus();
	delete tech;
}

int main()
{
	//test(new Technical(300, "胡秋峰"));
	//test(new Manager("小明"));
	//test(new Salesperson(500000,"小李"));
	test(new SalesManager(500000, "小张"));
	return 0;
}