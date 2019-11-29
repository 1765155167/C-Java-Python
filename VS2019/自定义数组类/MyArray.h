#pragma once
#include <iostream>

template<class T>
class MyArray
{
public:
	MyArray();
	MyArray(int len);
	MyArray(const MyArray& p);
	//重载赋值运算符号
	MyArray& operator=(const MyArray& p);
	MyArray operator+(const MyArray& another);
	MyArray& operator+=(const MyArray& another);
	MyArray operator+(int num);
	MyArray& operator+=(int num);
	MyArray& operator++();//前置++
	const MyArray operator++(int);//后置++
	T& operator[](int i);
	template<class A>
	friend std::ostream& operator<<(std::ostream& os, MyArray<A>& another);
	~MyArray();
	int getLen();
	void setData(size_t i, T data);
	T getData(int i);
	void* operator new(size_t size);
	void* operator new[](size_t size);
	void operator delete(void* addr);
	void operator delete[](void* addr);
private:
	int len;
	T* speace;
};

template<class T>
inline MyArray<T>::MyArray()
{
	this->len = 0;
	this->speace = NULL;
}

template<class T>
inline MyArray<T>::MyArray(int len)
{
	this->len = len;
	this->speace = new T[len];
	for (size_t i = 0; i < len; i++)
	{
		this->speace[i] = 0;
	}
}

template<class T>
inline MyArray<T>::MyArray(const MyArray& p)
{
	this->len = p.len;
	this->speace = new T[len];
	for (size_t i = 0; i < len; i++)
	{
		this->speace[i] = p.speace[i];
	}
}

template<class T>
inline MyArray<T>::~MyArray()
{
	if (this->speace != NULL)
	{
		delete[] this->speace;
		this->speace = NULL;
	}
}

template<class T>
inline 	MyArray<T>& MyArray<T>::operator=(const MyArray& p)
{
	this->len = p.len;
	if (this->speace != NULL)
	{
		delete[] this->speace;
		this->speace = NULL;
	}
	this->speace = new T[len];
	for (size_t i = 0; i < len; i++)
	{
		this->speace[i] = p.speace[i];
	}
	return *this;
}

template<class T>
inline MyArray<T> MyArray<T>::operator+(const MyArray& another)
{
	int len1 = this->len;
	int len2 = another.len;
	int len = len1 + len2;
	MyArray<T> temp(len);
	for (int i = 0; i < len1; i++)
	{
		temp.speace[i] = this->speace[i];
	}
	for (int i = 0; i < len2; i++)
	{
		temp.speace[len1 + i] = another.speace[i];
	}
	return temp;
}

template<class T>
inline MyArray<T>& MyArray<T>::operator+=(const MyArray& another)
{
	int len1 = this->len;
	int len2 = another.len;
	int len = len1 + len2;
	T* speace = new T[len];
	for (int i = 0; i < len1; i++)
	{
		*(speace + i) = *(this->speace + i);
	}
	for (int i = 0; i < len2; i++)
	{
		*(speace + len1 + i) = *(another.speace + i);
	}
	delete[] this->speace;
	this->speace = speace;
	this->len = len;
	return *this;
}

template<class T>
inline MyArray<T> MyArray<T>::operator+(int num)
{
	MyArray<T> temp(this->len);
	for (size_t i = 0; i < this->len; i++)
	{
		temp.speace[i] = this->speace[i] + num;
	}
	return temp;
}

template<class T>
inline MyArray<T>& MyArray<T>::operator+=(int num)
{
	for (size_t i = 0; i < this->len; i++)
	{
		this->speace[i] += num;
	}
	return *this;
}

template<class T>
inline MyArray<T>& MyArray<T>::operator++()
{
	for (size_t i = 0; i < this->len; i++)
	{
		this->speace[i]++;
	}
	return *this;
}

template<class T>
inline const MyArray<T> MyArray<T>::operator++(int)
{
	MyArray<T> temp(*this);
	for (size_t i = 0; i < this->len; i++)
	{
		this->speace[i]++;
	}
	return temp;
}

template<class T>
inline T& MyArray<T>::operator[](int i)
{
	if (i > this->len)
	{
		std::cout << "数组越界" << std::endl;
		return *(this->speace);
	}
	return *(this->speace + i);
	//return this->speace[i];
}

template<class T>
inline int MyArray<T>::getLen()
{
	return this->len;
}

template<class T>
inline void MyArray<T>::setData(size_t i, T data)
{
	if (i > len)
	{
		std::cout << "数组越界" << std::endl;
		return;
	}
	*(this->speace + i) = data;
	//this->speace[i] = data;
	return;
}

template<class T>
inline T MyArray<T>::getData(int i)
{
	if (i > len)
	{
		std::cout << "数组越界" << std::endl;
		return T(0);
	}
	return *(this->speace + i);
	//return this->speace[i];
}
#if 1

template<class T>
inline void* MyArray<T>::operator new(size_t size)
{
	std::cout << "重载了new操作符" << std::endl;
	return malloc(size);
}

template<class T>
inline void* MyArray<T>::operator new[](size_t size)
{
	std::cout << "重载了new[]操作符" << std::endl;
	return malloc(size);
}

template<class T>
inline void MyArray<T>::operator delete(void* addr)
{
	if (addr != NULL) {
		std::cout << "重载了delete操作符" << std::endl;
		free(addr);
		addr = NULL;
	}
}

template<class T>
inline void MyArray<T>::operator delete[](void* addr)
{
	if (addr != NULL) {
		std::cout << "重载了delete[]操作符" << std::endl;
		free(addr);
		addr = NULL;
	}
}
#endif // 0

template<class A>
inline std::ostream& operator<<(std::ostream& os, MyArray<A>& another)
{
	for (size_t i = 0; i < another.len; i++)
	{
		os << another.speace[i] << " ";
	}
	return os;
}