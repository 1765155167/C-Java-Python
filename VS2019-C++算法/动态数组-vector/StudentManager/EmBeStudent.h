#pragma once
#include "AbstractStudent.h"
class EmBeStudent :
	public AbstractStudent
{
public:
	EmBeStudent();
	EmBeStudent(std::string mName,
		std::string mId,
		std::string mProfession,
		std::string mClass
		);
	~EmBeStudent();
	virtual void show();
private:

};

