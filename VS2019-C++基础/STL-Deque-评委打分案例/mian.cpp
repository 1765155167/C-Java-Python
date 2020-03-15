#include <iostream>
#include <vector>
#include <deque>
#include <ctime>
#include "Player.h"
#include <algorithm>
//评委打分案例(sort算法排序)
//创建5个选手(姓名，得分)，10个评委对5个选手进行打分
//得分规则：去除最高分，去除最低分，去平均得分
//按得分对5名选手进行排名

//创建选手
void createPlayer(std::vector<Player>& v)
{
	std::string nameSpeed = "ABCDE";
	for (size_t i = 0; i < 5; i++)
	{
		std::string name = "选手";
		Player p(name + nameSpeed[i], 0);
		v.push_back(p);
	}
}

//打分
void printVal(int val)
{
	std::cout << val << " ";
}

void setScorePlayer(Player& p)
{
	int score;
	std::deque<int> deq;
	//srand(static_cast<int>(time(NULL)));
	for (size_t i = 0; i < 10; i++)
	{
		deq.push_back(rand()%41 + 60);//随机打分
	}
	//对容器中分数进行排序
	sort(deq.begin(), deq.end());//默认升序排序
	//std::for_each(deq.begin(), deq.end(), printVal);
	//std::cout << std::endl;
	//去除最高分与最低分
	deq.pop_back();
	deq.pop_front();
	//求平均分
	int sum = 0;
	for (std::deque<int>::iterator begin = deq.begin();
		begin != deq.end(); begin++)
	{
		sum += *(begin);
	}
	p.setScore(sum / deq.size());
}

void setScore(std::vector<Player>& v)
{
	for (std::vector<Player>::iterator it = v.begin();
		it != v.end(); it++)
	{
		setScorePlayer(*it);
	}
}


//排名打印
class Comrelue {
public:
	bool operator()(Player& a, Player& b) const {
		return a.getScore() > b.getScore();
	}
};

bool comrelue(Player& a, Player& b)
{
	if (a.getScore() > b.getScore())
	{
		return true;
	}
	else
	{
		return false;
	}
}

void printInfo(Player& p)
{
	p.show();
}

void printPlayer(std::vector<Player>& v)
{
	//排名从大到小
	sort(v.begin(), v.end(), Comrelue());
	std::for_each(v.begin(), v.end(), printInfo);
}

int main()
{
	std::vector<Player> v;
	createPlayer(v);
	setScore(v);
	printPlayer(v);
	return 0;
}