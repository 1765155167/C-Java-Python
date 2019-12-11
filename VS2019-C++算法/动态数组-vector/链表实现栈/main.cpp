#include "Stack.h"

class Person
{
public:
	Person(std::string name, int age)
	{
		this->node.next = NULL;
		this->name = name;
		this->age = age;
	}
	void show()
	{
		std::cout << "姓名: " << this->name
			<< " 年龄: " << this->age << std::endl;
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
void test01()
{
	Stack s;
	Person p1("hqf", 20);
	Person p2("lxl", 21);
	Person p3("wew", 22);
	Person p4("dat", 23);
	Person p5("del", 24);
	s.push((Node*)(&p1));
	s.push((Node*)(&p2));
	s.push((Node*)(&p3));
	s.push((Node*)(&p4));
	s.push((Node*)(&p5));
	while (!s.empty())
	{
		((Person*)s.top())->show();
		s.pop();
	}
}
class Char {
public:
	Char(char ch, int index) {
		this->ch = ch;
		this->index = index;
		this->node.next = NULL;
		//std::cout << "Char" << std::endl;
	}
	~Char() {
		//std::cout << "~Char" << std::endl;
	}
public:
	Node node;
	char ch;
	int index;
};
bool isBracketPair(char a, char b)
{
	if (a == '(' && b == ')')
	{
		return true;
	}
	if (a == '<' && b == '>')
	{
		return true;
	}
	if (a == '[' && b == ']')
	{
		return true;
	}
	if (a == '{' && b == '}')
	{
		return true;
	}
	return false;
}

void PrintErr(char* str, int index) {
	std::cout << str << std::endl;
	for (int i = 0; i < index; i++)
	{
		std::cout << " ";
	}
	std::cout << 'A' << std::endl;
}

int main()
{
	Stack stack;
	char str[] = "1 + 2 * 3 / ( 4 + 5 ) (()]]";
	char* p = str;
	int index = 0;
	while (*p != '/0' && index < strlen(str))
	{
		if (*p == '(' || *p == '<' || *p == '{' || *p == '[')
		{
			//入栈
			stack.push(reinterpret_cast<Node*>(new Char(*p,index)));
		}
		if (*p == ')' || *p == '>' || *p == '}' || *p == ']')
		{
			Char * temp = reinterpret_cast<Char*>(stack.top());
			if (!isBracketPair(temp->ch, *p))
			{
				PrintErr(str, index);
				break;
			}
			//出栈
			stack.pop();
			delete temp;
		}
		p++;
		index++;
	}
	while (!stack.empty())
	{
		Char* temp = reinterpret_cast<Char*>(stack.top());
		stack.pop();
		PrintErr(str, temp->index);
		delete temp;
	}
	return 0;
}