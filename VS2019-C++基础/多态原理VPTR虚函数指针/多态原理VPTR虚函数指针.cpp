
#include<iostream>
using namespace std;

class A
{
    char a[3];
public:
    virtual void fun1() {};
};

class B : public virtual A
{
    char b[3];
public:
    virtual void fun2() {};
};

class C : public virtual B
{
    char c[3];
public:
    virtual void fun3() {};
};

int main()
{
    cout << sizeof(A) << endl;
    cout << sizeof(B) << endl;
    cout << sizeof(C) << endl;
    return 0;
}