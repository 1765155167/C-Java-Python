#include "AbstractStudent.h"

AbstractStudent::AbstractStudent()
{
}

AbstractStudent::~AbstractStudent()
{
}

void AbstractStudent::setName(std::string Name)
{
	this->mName = Name;
}

void AbstractStudent::setId(std::string Id)
{
	this->mId = Id;
}

void AbstractStudent::setClass(std::string Class)
{
	this->mClass = Class;
}

void AbstractStudent::setProfession(std::string Profession)
{
	this->mProfession = Profession;
}

std::string AbstractStudent::getName() const
{
	return std::string(this->mName);
}

std::string AbstractStudent::getId() const
{
	return std::string(this->mId);
}

std::string AbstractStudent::getClass() const
{
	return std::string(this->mClass);
}

std::string AbstractStudent::getProfession() const
{
	return std::string(this->mProfession);
}
