#include <iostream>

class Shape {
public:
    Shape(){
        std::cout << "Shape::Shape()" << std::endl;
    }
    virtual void fun(int b = 1){
        std::cout << "Shape::fun(" << b << ")" << std::endl;
    } 
    virtual void abc(){
        std::cout << "data:" << &data << "\na" << &a << std::endl;
    }
private:
    int data;
    char a;
};

class Triangle : public Shape{
public:
    Triangle(){
        std::cout << "Triangle::Triangle()" << std::endl;
    }
    void fun(int a = 0){
        std::cout << "Triangle::fun("<< a << ")" << std::endl;
    }
    void abc(){
       // std::cout << "&Shape::data" << &data << "&Shape::a" << &a << std::endl;
    }
};

int main()
{
    Shape *shape;
    Shape s;
    Triangle triangle;
    shape = &triangle;
    std::cout << "sizeof(shape) = " << sizeof(*shape) << std::endl;
    std::cout << "sizeof(triangle) = " << sizeof(triangle) << std::endl;
    shape->fun();
    s.abc();
    return 0;
}
