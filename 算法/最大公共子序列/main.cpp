#include <iostream>
#include <vector>
#include <algorithm>
#include <list>
using namespace std;

/**
 * string1 string2
 * dp[i][j] 代表string1[0-i] string2[0-j]的最大公共子序列长度
 * 第一行和第一列 最大为1
 * dp[i][j] = dp[i-1][j], dp[i][j-1], dp[i-1][j-1] + 1(string1[i] == string2[j]),
**/

template<class T>
struct MyPrint {
	void operator()(T s) {
		cout << s << " ";
	}
};

int main()
{
	string s1("1A2BCD2E0"), s2("A1B2C34D6E0");
	vector<vector<int>> dp(s1.length(), vector<int>(s2.length(), 0));
	/*对第一行和第一列单独赋值*/
	for (int i = 0; i < s1.length(); i++)
	{
		dp[i][0] = 0;
		if (s1[i] == s2[0])
		{
			for (int j = i; j < s1.length(); j++)
			{
				dp[j][0] = 1;
			}
			break;
		}
	}
	for (int i = 0; i < s2.length(); i++)
	{
		dp[0][i] = 0;
		if (s2[i] == s1[0])
		{
			for (int j = i; j < s2.length(); j++)
			{
				dp[0][j] = 1;
			}
			break;
		}
	}
	/*动态规划*/
	for (int i = 1; i < s1.length(); i++)
	{
		for (int j = 1; j < s2.length(); j++)
		{
			if (s1[i] == s2[j])
			{
				dp[i][j] = max(dp[i - 1][j - 1] + 1, max(dp[i - 1][j], dp[i][j - 1]));
			}
			else
			{
				dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
	}
	/*打印动态规划表格*/
	cout << "  ";
	for (int i = 0; i < s2.length(); i++)
	{
		cout << s2[i] << " ";
	}
	cout << endl;
	for (int i = 0; i < s1.length(); i++)
	{
		for (int j = 0; j < s2.length(); j++)
		{
			if (j == 0)
			{
				cout << s1[i] << " ";
			}
			cout << dp[i][j] << " ";
		}
		cout << endl;
	}
	/*打印最长公共子序列*/
	list<char> s;
	for (int i = s1.length() - 1, j = s2.length() - 1; i >= 0 && j >= 0; )
	{
		if (s1[i] == s2[j])//相同 插入并向左上走
		{
			s.push_front(s1[i]);
			i--;
			j--;
		}
		else //向左或者向上
		{
			//查看是否可以向左走
			if (j - 1 >= 0 && dp[i][j] == dp[i][j - 1])
			{
				j--;
			}
			else if (i - 1 >= 0) {
				i--;
			}
		}
	}
	for_each(s.begin(), s.end(), MyPrint<char>());
	return 0;
}