#pragma once

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
	T* data;
	unsigned int len;
};
