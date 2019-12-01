#pragma once
#include <string>
#include <iostream>
class Player
{
public:
	Player(std::string name, int score);
	void setScore(int score);
	int getScore();
	void show();
	~Player();
private:
	std::string name;
	int score;
};

