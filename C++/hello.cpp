#include <iostream>
#include <string>
#include <unistd.h>
class Student{
public:
    Student();
    Student(int id, std::string name);
    ~Student();
    friend std::ostream& operator<<(std::ostream& os, Student stu);
private:
    int id;
    std::string name;
};

Student::Student()
{
    this->id = 0;
    this->name = "NULL";
}

Student::Student(int id, std::string name)
{
    this->id = id;
    this->name = name;
}

Student::~Student()
{
    std::cout << "~Student()" << std::endl;
}


std::ostream& operator<<(std::ostream& os, Student stu)
{
    os << "id " << stu.id << " name " << stu.name << std::endl;
    return os;
}

int main()
{
    int id = 0;
    char16_t ch16;
    std::string name;
    std::cin >> id;
    std::getline(std::cin, name);
    Student stu(id, name);
    std::cout << stu;
    std::cout << R"(Hello "I'am" Hqf, Let's to meet you)" << std::endl;
    std::cout << sizeof(char32_t) << std::endl;
    sleep(10);
    return 0;
}

