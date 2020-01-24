#include <iostream>
class Empty {};
class HoldsAnInt {
    Empty e1;
	Empty e2;
	int x;
	Empty e3;
	Empty e4;
};
int main()
{
    HoldsAnInt hold;
    std::cout << "sizeof(HoldsAnInt)" << sizeof(hold) << ":" << sizeof(Empty) << std::endl;
    return 0;
}

