/*
一年一度的快手运动会又要开始了，同学们终于有一天可以离开鼠标键盘显示器，全身心的投入到各种体育项目中。UED设计师小红虽然没有参加体育项目，但她的责任重大，因为她是拉拉队的队长，她需要在每个项目中为参赛的同学们加油助威。
因为运动会的项目众多，很多项目在同一时间会同时进行着。作为拉拉队长，小红需要遵守以下规则：
不能同时给多个体育项目加油助威
给每个体育项目加油的时长必须超过项目时长的一半，每个体育项目只能加油一次
体育项目的开始和结束时间都是整点，如果项目进行到一半想要离开，也只能选择整点离开
不考虑往返于各个体育项目比赛场地中花费的时间
请帮小红设计一个算法，在已知所有体育项目日程的前提下，计算是否能在每个体育项目中为参赛的同学们加油。
说明：
如果体育项目时长为2，超过时长的一半为2;
如果体育项目时长为3，超过时长的一半为2;
如果体育项目时长为4，超过时长的一半为3；

输入描述:
输入包括1+N行 第一行输入一个整数N, 1 <= N <= 10，表示今天要参加多少个讨论会 后续N行，每行输入开始和结束时间，均为整数，用空格分隔，0 <= startTime < endTime <= 24

输出描述:
输出包括一行 如果小红能够参加全部讨论会，返回1 如果小红不能够参加全部讨论会，返回-1
*/

#include <iostream>
#include <map>
#include <vector>
#include <algorithm>

using namespace std;

//获取最短开始时间
int getFinishTime(pair<int, int> p) {
	return p.second - (p.second - p.first) / 2 - 1;
}

//获取需要时间
int getNeedTime(pair<int, int> p) {
	return (p.second - p.first) / 2 + 1;
}

class MyCompare :public std::binary_function<pair<int, int>, pair<int, int>, bool>
{
public:
	bool operator()(pair<int, int> a, pair<int, int> b)const
	{
		if (getFinishTime(a) != getFinishTime(b))
			return getFinishTime(a) < getFinishTime(b);
		else return a.first < b.first;
	}
};

struct MyPrint {
	void operator()(pair<int, int> p) {
		cout << p.first << " " << p.second << endl;
	}
};

void right(vector<pair<int, int>> table) {
	int start = table[0].first;
	int num = table.size();
	for (int i = 0; i < num; i++) {
		if (start > getFinishTime(table[i]))
		{
			cout << -1 << endl;
			break;
		}
		if (i == num - 1)
		{
			cout << 1 << endl;
			break;
		}
		int end = start + getNeedTime(table[i]);
		start = max(end, table[i + 1].first);
	}
	return;
}
int main() {
	int N = 0;
	vector<pair<int, int>> v;//[最晚开始时间， ]
	cin >> N;
	for (size_t i = 0; i < N; i++)
	{
		int start, end;
		cin >> start >> end;
		v.push_back(make_pair(start, end));
	}
	std::sort(v.begin(), v.end(), MyCompare());
	//for_each(v.begin(), v.end(), MyPrint());
	right(v);
	return 0;
}