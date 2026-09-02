#include <iostream>
using namespace std;

struct Layout1
{
    char c1;
    int i;
    char c2;
};

struct Layout2
{
    int i;
    char c1;
    char c2;
};

int main()
{
    cout << "Size of Layout1 : "
         << sizeof(Layout1)
         << endl;

    cout << "Size of Layout2 : "
         << sizeof(Layout2)
         << endl;


    /*
    Layout1 and Layout2 can have different sizes because
    the compiler adds padding bytes for memory alignment.

    Padding helps data members align efficiently in memory.

    Member order matters because different ordering can
    reduce or increase padding. This is important for
    network packet headers and hardware register maps.
    */

    return 0;
}