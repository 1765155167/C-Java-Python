#include <iostream>
#include <deque>
#include <map>
#include "Worker.h"
#include <time.h>
#include <algorithm>
//项目介绍
/*
 *今天招聘了5名员工，5名员工进入公司后，需要指派员工在那个部门工作
 *员工信息有:姓名 年龄 电话 工资等
 *通过MultiMap进行信息的插入 保存 显示
 *分部门显示员工信息
*/
const int SalDep = 1;//销售部门
const int TechDep = 2;//研发部门
//创建员工
void CreateWorker(std::deque<Worker*>& dWorker)
{
	Worker* p;
	p = new Worker("胡秋峰", "17550296339", 20, 10000);
	dWorker.push_back(p);
	p = new Worker("王大头", "17625525535", 21, 8000);
	dWorker.push_back(p);
	p = new Worker("小李子", "18595801890", 22, 18000);
	dWorker.push_back(p);
	p = new Worker("小明", "18958338972", 22, 15000);
	dWorker.push_back(p);
	p = new Worker("李小二", "12345678956", 22, 15001);
	dWorker.push_back(p);
}
//分组
void WorkerByGroup(std::deque<Worker*>& dWorker,
	std::multimap<int, Worker*>& mapWorkeyGroup)
{
	srand(static_cast<int>(time(NULL)));
	for (auto it = dWorker.begin(); it != dWorker.end(); it++)
	{
		int id = rand() % 2 + 1;
		switch (id)
		{
		case 1:
			mapWorkeyGroup.insert(std::make_pair(SalDep, *it));
			break;
		case 2:
			mapWorkeyGroup.insert(std::make_pair(TechDep, *it));
			break;
		default:
			break;
		}
	}
}
//打印各部门分组信息
void PrintWorkerByGroup(std::multimap<int, Worker*>& mapWorkeyGroup)
{
	auto it = mapWorkeyGroup.find(SalDep);
	if (it != mapWorkeyGroup.end())
	{
		std::cout << "销售部门员工信息" << std::endl;
		size_t num = mapWorkeyGroup.count(SalDep);
		for (size_t i = 0; i < num && it != mapWorkeyGroup.end(); i++)
		{
			if (((*it).second) != NULL)
			{
				((*it).second)->show();
			}
			it++;
		}
	}
	it = mapWorkeyGroup.find(TechDep);
	if (it != mapWorkeyGroup.end())
	{
		std::cout << "研发部门员工信息" << std::endl;
		int num = mapWorkeyGroup.count(TechDep);
		for (size_t i = 0; i < num && it != mapWorkeyGroup.end(); i++)
		{
			if (((*it).second) != NULL)
			{
				((*it).second)->show();
			}
			it++;
		}
	}
}
void DeleteWorker(std::deque<Worker*>& dWorker)
{
	while (!dWorker.empty())
	{
		Worker* p = dWorker.back();
		dWorker.pop_back();
		if (p != NULL)
		{
			delete p;
			p = NULL;
		}
	}
}

//遍历分组信息
void PrintInfo(std::pair<int, Worker*> p)
{
	std::cout << p.first << ":";
	p.second->show();
}

void PrintListMap(std::multimap<int, Worker*>& mapWorkeyGroup)
{
	for_each(mapWorkeyGroup.begin(), mapWorkeyGroup.end(), PrintInfo);
}

//MultiMap允许相同键值存在
int main()
{
	std::deque<Worker*> dWorker;//存放所有员工
	std::multimap<int, Worker*> mapWorkeyGroup;//员工分组信息
	//创建员工
	CreateWorker(dWorker);
	//分组
	WorkerByGroup(dWorker, mapWorkeyGroup);
	//遍历分组情况
	//PrintListMap(mapWorkeyGroup);
	//打印各部门分组信息
	PrintWorkerByGroup(mapWorkeyGroup);
	//释放员工对象
	DeleteWorker(dWorker);
	return 0;
}