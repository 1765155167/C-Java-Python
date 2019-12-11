#include "EmBeStudent.h"

EmBeStudent::EmBeStudent()
{
}

EmBeStudent::EmBeStudent(std::string mName, std::string mId, std::string mProfession, std::string mClass)
{
	this->mName = mName;
	this->mId = mId;
	this->mClass = mClass;
	this->mProfession = mProfession;
}

EmBeStudent::~EmBeStudent()
{
}

void EmBeStudent::show()
{
	std::cout << "姓名:" << this->getName()
		<< "学号:" << this->getId()
		<< "专业:" << this->getProfession()
		<< "班级" << this->getClass() << std::endl;
}
