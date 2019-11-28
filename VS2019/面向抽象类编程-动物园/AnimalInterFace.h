#pragma once
#include <iostream>
//动物抽象类（接口）
class AnimalInterFace {
public:
	virtual void voice() = 0;
	virtual ~AnimalInterFace();
};
//动物叫架构函数
void Voice(AnimalInterFace* p);
void Voice(AnimalInterFace* p, bool d);