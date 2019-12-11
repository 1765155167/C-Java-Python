#pragma once
#include <iostream>
#include <set>
class AbstractStudent
{
public:
	AbstractStudent();
	virtual ~AbstractStudent();
	virtual void show() = 0;
	void setName(std::string Name);
	void setId(std::string Id);
	void setClass(std::string Class);
	void setProfession(std::string Profession);
	std::string getName()const;
	std::string getId()const;
	std::string getClass()const;
	std::string getProfession()const;
protected:
	std::string mName;
	std::string mId;
	std::string mClass;
	std::string mProfession;
	std::set<std::string, double> mScore;
};

