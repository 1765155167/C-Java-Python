#pragma once
#include <iostream>


template<class T>
class vector
{
public:
	vector();
	vector(const vector& another);
	vector(int len, T elem);//len个elem初始化容器
	vector(T* begin, T* end);//[begin,end)初始化数组
	vector<T>& operator=(vector<T> another);
	~vector();
	int size() const;
	int getcapacity() const;
	void push_back(T elem);
	void pop_back(void);
	T* begin() const;
	T* end() const;
	T& front();
	T& back();
	bool empty() const;
	T& operator[](int pop);
	T& at(int pop);
private:
	T* space;
	int len;//容器中元素个数
	int capacity;//容器容量
};

template<class T>
inline vector<T>::vector()
{
	this->space = NULL;
	this->len = 0;
	this->capacity = 0;
}

template<class T>
inline vector<T>::vector(const vector& another)
{
	if (&another == this)
	{
		this->space = NULL;
		this->len = 0;
		this->capacity = 0;
	}
	this->len = another.len;
	this->capacity = another.capacity;
	this->space = new T[another.capacity];
	memcpy(this->space, another.space,
		another.len * sizeof(T));
}

//len个elem初始化容器
template<class T>
inline vector<T>::vector(int len, T elem)
{
	this->len = len;
	this->capacity = len * 2;//默认容量为len 2 倍
	this->space = new T[this->capacity];
	for (size_t i = 0; i < len; i++)
	{
		this->space[i] = elem;
	}
}

template<class T>
inline vector<T>::vector(T* begin, T* end)
{
	if (end <= begin)
	{
		throw "end <= begin";
	}
	this->len = end - begin;
	this->capacity = this->len * 2;
	this->space = new T[this->capacity];
	memcpy(this->space, begin, this->len * sizeof(T));
}

template<class T>
inline vector<T>& vector<T>::operator=(vector<T> another)
{
	if (this->space != NULL)
	{
		delete[] this->space;
	}
	if (this == &another)//自我赋值
	{
		return *this;
	}
	this->len = another.len;
	this->capacity = another.capacity;
	this->space = new T[this->capacity];//申请
	memcpy(this->space, another.space, this->len * sizeof(T));//拷贝
	return *this;
}

template<class T>
inline vector<T>::~vector()
{
	if (this->space != NULL)
	{
		delete[] this->space;
	}
}

template<class T>
inline int vector<T>::size() const
{
	return this->len;
}

template<class T>
inline int vector<T>::getcapacity() const
{
	return this->capacity;
}

template<class T>
inline T* vector<T>::begin() const
{
	if (this->space == NULL)
	{
		throw "容器为空";
	}
	return &(this->space[0]);
}

template<class T>
inline T* vector<T>::end() const 
{
	if (this->space == NULL)
	{
		throw "容器为空";
	}
	return &(this->space[len - 1]) + 1;
}

template<class T>
inline bool vector<T>::empty() const
{
	if (this->len == 0)
	{
		return true;
	}
	else
	{
		return false;
	}
}

template<class T>
inline T& vector<T>::operator[](int pop)
{
	return this->space[pop];
}

template<class T>
inline T& vector<T>::at(int pop)
{
	if (pop >= this->len || pop < 0)
	{
		throw "越界";
	}
	else
	{
		return this->space[pop];
	}
}

template<class T>
inline void vector<T>::push_back(T elem)
{
	//需要重新申请容量
	if (this->len == this->capacity)
	{
		//申请
		T* newSpace = new T[this->capacity * 2 + 1];
		//拷贝
		memcpy(newSpace, this->space, this->capacity * sizeof(T));
		//释放
		delete[] this->space;
		this->space = newSpace;
		this->capacity = this->capacity * 2 + 1;
	}
	//尾部插入
	this->space[len++] = elem;
}

template<class T>
inline void vector<T>::pop_back(void)
{
	if (this->len > 0)
	{
		this->len--;
	}
	else
	{
		throw "容器中没有数据";
	}
}

template<class T>
inline T& vector<T>::front()
{
	if (this->len > 0) {
		return this->space[0];
	}
	else
	{
		throw "容器为空";
	}	
}

template<class T>
inline T& vector<T>::back()
{
	if (this->len > 0) {
		return this->space[len - 1];
	}
	else
	{
		throw "容器为空";
	}
}
