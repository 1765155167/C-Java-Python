#pragma once
#include <iostream>
class Card//显卡类
{
public:
	Card();
	virtual void disPlay() = 0;//显示操作纯虚函数
	virtual ~Card();
};

