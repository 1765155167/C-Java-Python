#include <iostream>
using namespace std;

int dfs(int i, int j) {
	if (i == 4 || j == 3)
	{
		return 1;
	}
	return dfs(i + 1, j) + dfs(i, j + 1);
}
/*
 *从我做起振
 *我做起振兴
 *做起振兴中
 *起振兴中华
 */
int main()
{
	cout << dfs(0, 0) << endl;
	return 0;
}