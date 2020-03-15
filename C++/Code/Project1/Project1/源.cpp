#include<iostream>
using namespace std;
int main() {
    string *data = new string();
    cin >> *data;
    int num = 0;
    for (int i = data->length - 1; i >= 0; i++) {
        num++;
        if (data->at(i) == ' ') {
            break;
        }
    }
    cout << num << endl;
    return 0;
}