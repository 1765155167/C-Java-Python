#include<iostream>
#include<string>
using namespace std;

int main() {
	string data;
	getline(cin, data);
	int num = 0;
	for (int i = data.length() - 1; i >= 0; i--)
	{
		if (data[i] == ' ') {
			break;
		}
		num++;
	}
	cout << num << endl;
	return 0;
}