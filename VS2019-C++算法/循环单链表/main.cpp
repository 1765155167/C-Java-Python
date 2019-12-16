#include "CircleList.h"

class Person
{
public:
	Person(std::string name, int age)
	{
		this->name = name;
		this->age = age;
	}
	void show()
	{
		std::cout << "ÐÕÃû: " << this->name
			<< " ÄêÁä: " << this->age << std::endl;
	}
	bool compare(Person& another)
	{
		if (another.age == this->age && another.name == this->name)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
private:
	Node node;
	std::string name;
	int age;
};

void PrintPerson(Node* data)
{
	Person* p = (Person*)data;
	p->show();
}

bool Compare(Node* a, Node* b)
{
	Person* pa = (Person*)a;
	Person* pb = (Person*)b;
	if (pa->compare(*pb))
	{
		return true;
	}
	else
	{
		return false;
	}
}

int main()
{
	CircleList list;
	Person p1("hqf", 20);
	Person p2("lxl", 21);
	Person p3("wew", 22);
	Person p4("dat", 23);
	Person p5("dat", 23);
	list.push_pos((Node*)(&p1), 0);
	list.push_pos((Node*)(&p2), 0);
	list.push_pos((Node*)(&p3), 0);
	list.push_pos((Node*)(&p4), 0);
	list.remove((Node*)(&p5), Compare);
	list.traversal(PrintPerson);
}