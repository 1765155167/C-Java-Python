#ifndef VECTOR
#define VECTOR
#include <iostream>
#include <ctime>

template<typename T, int num>
class Vector
{
public:
	Vector();
	~Vector();
	void back_push(T data);/*尾部插入数据*/
	T* begin();
	T* end();
private:
	T *data;
	unsigned int len;
};

template<typename T, int num>
Vector<T,num>::Vector()
{
	data = new T[num];
	len = 0;
}

template<typename T, int num>
Vector<T, num>::~Vector()
{
	delete[] data;
}

template<typename T, int num>
void Vector<T, num>::back_push(T data)
{
	this->data[len++] = data;
}

template<typename T, int num>
T* Vector<T, num>::begin()
{
	return this->data;
}

template<typename T, int num>
T* Vector<T, num>::end()
{
	return this->data + len;
}

#endif