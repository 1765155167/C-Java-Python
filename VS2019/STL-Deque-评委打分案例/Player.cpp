#include "Player.h"

Player::Player(std::string name, int score):
	name(name),score(score)
{
}

void Player::setScore(int score)
{
	this->score = score;
}

int Player::getScore()
{
	return this->score;
}

void Player::show()
{
	std::cout << "ÐÕÃû£º" << this->name
		<< " µÃ·Ö£º" << this->score << std::endl;
}

Player::~Player()
{
}
