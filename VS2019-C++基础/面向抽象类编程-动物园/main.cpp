#include "AnimalInterFace.h"
#include "Cat.h"
#include "Dog.h"

int main()
{
	Cat* c = new Cat;
	Voice(c);
	Voice(new Dog, true);//使用完释放
	delete c;
}