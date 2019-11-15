#include <iostream>

template<class T>
class Person {
public:
    Person(T age, T id);
    /*重载操作符*/
    template<class A>
    friend std::ostream& operator<<(std::ostream& os, Person<A>& p);
    /*友元函数*/
    template<class B>
    friend void PrintInfo(Person<B>& p);
    void show();

private:
    T mAge;
    T mId;
};

template<class T>
Person<T>::Person(T age, T id)
{
    this->mId = id;
    this->mAge = age;
}

template<class T>
void Person<T>::show()
{ 
    std::cout << "类成员函数: mAge: " << this->mAge << " mId: " << this->mId << std::endl;
}

template<class T>
std::ostream& operator<<(std::ostream& os, Person<T>& p)
{
    os << "重载操作符: mAge: " << p.mAge << " mId: " << p.mId << std::endl;
    return os;
}

template<class T>
void PrintInfo(Person<T>& p)
{
    std::cout << "普通友元函数: mAge: " << p.mAge << " mId: " << p.mId << std::endl; 
}

void test0()
{
    Person<int> p(10, 20);
    p.show();
    std::cout << p;
    PrintInfo(p);
}

int main()
{
    test0();
    return 0;
}

