#include <iostream>
#include <string>
#include <unistd.h>
class Student{
public:
    Student();
    Student(Student& stu);
    Student(int id, std::string name);
    ~Student();
    Student& operator=(Student& stu);
    friend std::ostream& operator<<(std::ostream& os, Student stu);
private:
    int id;
    std::string name;
};

Student& Student::operator=(Student& stu)
{
    std::cout << "重载=运算符" << std::endl;
    if(this != &stu)
    {
        this->id = stu.id + 1;
        this->name = stu.name;
    }
    return *this;
}

Student::Student(Student& stu)
{
    std::cout << "拷贝构造函数" << std::endl;
    if(&stu != this)
    {
        this->id = stu.id + 1;
        this->name = stu.name;
    }
}

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
    std::cout << "~Student: " << this->id << std::endl;
}


std::ostream& operator<<(std::ostream& os, Student stu)
{
    os << "id " << stu.id << " name " << stu.name << std::endl;
    return os;
}

int main()
{
    int id = 0;
    Student stu(123, "胡秋峰");
    //Student stu1 = stu;
    std::cout << stu;
    //std::cout << stu1;
    std::cout << R"(Hello "I'am" Hqf, Let's to meet you)" << std::endl;
    std::cout << sizeof(stu) << std::endl;
    sleep(10);
    return 0;
}

