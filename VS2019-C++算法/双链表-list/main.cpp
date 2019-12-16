#include "list.hpp"
#include <ctime>


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
		std::cout << "姓名: " << this->name
			<< " 年龄: " << this->age << std::endl;
	}
	friend std::ostream& operator<<(std::ostream& os, Person& another)
	{
		os << "姓名: " << another.name
			<< " 年龄: " << another.age << std::endl;
		return os;
	}
	friend bool ComparePerson(Person* a, Person* b);
	bool compare(Person& another)
	{
		if (this->age > another.age )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
private:
	std::string name;
	int age;
};


void initList(list<int>& l1, int len)
{
	for (int i = 0; i < len; i++)
	{
		l1.push_back(rand() % 99 + 1);
	}
}

void test01()
{
	list<int> l1;
	initList(l1, 10);
	std::cout << "front:" << l1.Front() << std::endl;
	std::cout << "back:" << l1.Back() << std::endl;
	std::cout << "size:" << l1.size() << std::endl;

	if (l1.find(3))
	{
		std::cout << "查找成功" << std::endl;
	}
	else
	{
		std::cout << "查找失败" << std::endl;
	}

	while (!l1.empty())
	{
		std::cout << l1.Front() << " ";
		l1.pop_front();
	}
	std::cout << std::endl;
}


//排序规则
bool ComPare(int a, int b)
{
	return a < b;
}

void test02()
{
	list<int> l1;
	initList(l1, 10);
	l1.sort(ComPare);
	l1.traversal();
}


bool ComparePerson(Person* a, Person* b)
{
	if (a->age > b->age)
	{
		return true;
	}
	else
	{
		return false;
	}
}

void test03()
{
	list<Person*> l1;
	l1.push_back(new Person("aaa", 20));
	l1.push_back(new Person("bbb", 25));
	l1.push_back(new Person("ccc", 21));
	l1.push_back(new Person("ddd", 20));
	l1.sort(ComparePerson);//排序
	l1.traversal_ptr();//遍历
}

int main()
{
	srand(static_cast<int>(time(NULL)));
	test03();
	return 0;
}