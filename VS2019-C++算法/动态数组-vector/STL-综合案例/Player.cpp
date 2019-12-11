#include "Player.h"

Player::Player(std::string name)
{
	this->name = name;
	this->Score[0] = 0;
	this->Score[1] = 0;
	this->Score[2] = 0;
}

Player::Player(Player& another)
{
	this->name = another.name;
	this->Score[0] = another.Score[0];
	this->Score[1] = another.Score[1];
	this->Score[2] = another.Score[2];
}

Player::~Player()
{
}

std::string Player::getName() const
{
	return this->name;
}

void Player::setScore(int i, double score)
{
	if (i > 0 && i < 4)
	{
		this->Score[i - 1] = score;
	}
}

double Player::getScore(int i) const
{
	if (i > 0 && i < 4)
	{
		return this->Score[i - 1];
	}
	return 0;
}
