#pragma once
#include <iostream>
#include <string>

class Player
{
public:
	Player(std::string name);
	Player(Player& another);
	~Player();
	std::string getName()const;
	void setScore(int i, double score);
	double getScore(int i)const;
private:
	std::string name;
	double Score[3];//存放三轮比赛的得分
};

