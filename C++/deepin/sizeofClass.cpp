#include <iostream>
class Empty {};
class HoldsAnInt {
    int x;
    Empty e;
};
int main()
{
    HoldsAnInt hold;
    std::cout << "sizeof(HoldsAnInt)" << sizeof(hold) << std::endl;
    return 0;
}

