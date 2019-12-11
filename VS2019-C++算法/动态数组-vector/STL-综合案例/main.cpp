#include "Player.h"
#include <map>
#include <vector>
#include <deque>
#include <algorithm>
#include <numeric>
#include <time.h>

//创建24名选手 编号从1001 - 10024
void CreatePlayer(std::map<int, Player*>& mPlist, std::vector<int>& v)
{
	for (int i = 0; i < 24; i++)
	{
		std::string name = "选手";
		int id = 1001 + i;
		name += 'A' + i;
		mPlist.insert(std::make_pair(id, new Player(name)));
		v.push_back(id);
	}
}
//抽签
void Sortitlon(std::vector<int>& v)
{
	std::random_shuffle(v.begin(), v.end());
}

//随机获得分数
double getScore(Player* p)
{
	std::deque<int> d;
	for (int i = 0; i < 10; i++)
	{
		d.push_back(rand()%50 + 51);//51 - 100
	}
	sort(d.begin(),d.end());//默认升序
	//去除最高分与最低分
	d.pop_back();
	d.pop_front();
	int sum = std::accumulate(d.begin(),d.end(),0);
	return sum * 1.0 / d.size();//去平均分
}

//比赛返回晋级列表
struct mycompare
{
	bool operator()(double a, double b)const {
		return a > b;
	}
};
std::vector<int> Game(std::map<int, Player*>& mPlist, std::vector<int>& v, int a)
{
	std::multimap<double, int, mycompare> mGroup;//<分数，编号>
	int groupIndex = 0;
	std::vector<int> Promotion;
	//评委打分
	for (auto it = v.begin(); it != v.end(); it++)
	{
		Player* p = mPlist[*it];
		double score = getScore(p);
		p->setScore(a, score);
		mGroup.insert(std::make_pair(score, *it));
		groupIndex++;
		if (groupIndex%6 == 0)
		{
			int index = 0;
			for (auto mit = mGroup.begin(); mit != mGroup.end(); mit++)
			{
				if (index < 3)//取前三名
				{
					Promotion.push_back((*mit).second);
				}
				else
				{
					break;
				}
				index++;
				//std::cout << "分数:" << (*mit).first << ":" << "编号:" << (*mit).second << std::endl;
			}
			mGroup.clear();
		}
	}
	return Promotion;
}
//打印晋级名单
void PrintPromotionList(std::map<int, Player*>& mPlist, std::vector<int> v, int i)
{
	std::cout << "晋级选手名单如下:" << std::endl;
	for (auto it = v.begin(); it != v.end(); it++)
	{
		Player* p = mPlist[*it];
		if (i == 1)
		{
			std::cout << p->getName() << "第一轮:" << p->getScore(1) << std::endl;
		}
		if (i == 2)
		{
			std::cout << p->getName() << "第二轮:" << p->getScore(2) << std::endl;
		}
		if (i == 3)
		{
			std::cout << p->getName() << "第一轮:" << p->getScore(1) 
				<< "第二轮:" << p->getScore(2)
				<< "第三轮:" << p->getScore(3) << std::endl;
		}
	}
}

int main()
{
	srand(static_cast<unsigned int>(time(NULL)));
	std::map<int, Player*> mPlist;
	std::vector<int> v1, v2, v3, v4;
	CreatePlayer(mPlist, v1);
	Sortitlon(v1);//第一轮抽签
	v2 = Game(mPlist, v1, 1);//第一轮比赛
	PrintPromotionList(mPlist, v2, 1);
	Sortitlon(v2);//第二轮抽签
	v3 = Game(mPlist, v2, 2);//第二轮比赛
	PrintPromotionList(mPlist, v3, 2);
	Sortitlon(v3);//第三轮抽签
	v4 = Game(mPlist, v3, 3);//第三轮比赛
	PrintPromotionList(mPlist,v4, 3);
}
