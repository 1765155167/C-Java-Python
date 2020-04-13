#include <iostream>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

int getFinishTime(pair<int, int> p) {
	return p.second - (p.second - p.first) / 2 - 1;
}

int getNeedTime(pair<int, int> p) {
	return (p.second - p.first) / 2 + 1;
}

struct MyCompare :public binary_function<pair<int, int>, pair<int, int>, bool>
{
	bool operator()(pair<int, int> a, pair<int, int> b) {
		if (getFinishTime(a) != getFinishTime(b))
		{
			return getFinishTime(a) < getFinishTime(b);
		}
		return a.first < b.first;
	}
};

void process(vector<pair<int, int>> v) {
	int start = v[0].first;
	int length = v.size();
	for (size_t i = 0; i < length; i++)
	{
		if (start > getFinishTime(v[i]))
		{
			cout << -1 << endl;
			break;
		}
		if (i == length - 1)
		{
			cout << 1 << endl;
			break;
		}
		int end = start + getNeedTime(v[i]);
		start = max(end, v[i + 1].first);
	}
}

int main(int argc, char** argv)
{
	vector<pair<int, int>> v;
	int N = 0;
	cin >> N;
	for (size_t i = 0; i < N; i++)
	{
		int start, end;
		cin >> start >> end;
		v.push_back(make_pair(start, end));
	}
	sort(v.begin(), v.end(), MyCompare());
	process(v);
	return 0;
}