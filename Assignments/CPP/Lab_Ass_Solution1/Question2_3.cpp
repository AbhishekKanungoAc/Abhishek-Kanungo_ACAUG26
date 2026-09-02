#include <iostream>
using namespace std;

int main()
{
    int statusReg = 0b10110001;

    int controlReg = 0b00000000;

    int dataReg = 0b11001010;


    // Pointer to const
    const int* regPtr1 = &statusReg;

    cout << "Status Register : "
         << *regPtr1
         << endl;

    // *regPtr1 = 10;
    // ERROR: Cannot modify value through pointer to const

    regPtr1 = &dataReg;


    // Const pointer
    int* const regPtr2 = &controlReg;

    *regPtr2 = 100;

    cout << "Control Register : "
         << *regPtr2
         << endl;

    // regPtr2 = &dataReg;
    // ERROR: Const pointer cannot point to another address


    // Const pointer to const data
    const int* const regPtr3 = &statusReg;

    cout << "Read Only Register : "
         << *regPtr3
         << endl;

    // *regPtr3 = 50;
    // ERROR: Cannot modify value

    // regPtr3 = &dataReg;
    // ERROR: Cannot change address

    return 0;
}