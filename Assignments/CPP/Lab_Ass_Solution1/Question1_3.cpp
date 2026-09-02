#include <iostream>
using namespace std;

int main()
{
    // Row and Colums User Input
    int rows, colums;
    cout << "Enter the number of rows:" << endl;
    cin >> rows;
    cout << "Enter the number of colums:" << endl;
    cin >> colums;

    // Array user input
    double arr[rows][colums];

    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < colums; j++)

        {
            cout << "Enter the floor " << i + 1 << " room " << j + 1 << " Temp:" << endl;
            cin >> arr[i][j];
        }
    }

    // array printing in format
    cout << "         Room1 Room2 Room3" << endl;
    for (int i = 0; i < rows; i++)
    {
        cout << "Floor " << i + 1 << " : ";
        for (int j = 0; j < colums; j++)

        {

            cout << arr[i][j] << "   ";
        }
        cout << endl;
    }

    // hottest room location and temp
    double hottestTemp = arr[0][0];
    int hottestFloor = 1;
    int hottestRoom = 1;

    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < colums; j++)

        {
            if (arr[i][j] > hottestTemp)
            {
                hottestTemp = arr[i][j];
                hottestFloor = i + 1;
                hottestRoom = j + 1;
            }
        }
    }
    cout << "Hottest Room : Floor " << hottestFloor << ", Room " << hottestRoom << " -> " << hottestTemp << " C" << endl;

    // hottest floor with avg temp

    double hottestFloorAvg = 0;
    int hotFloor = 0;
    for (int i = 0; i < rows; i++)
    {
        double floorSum = 0;

        for (int j = 0; j < colums; j++)

        {
            floorSum += arr[i][j];
        }
        double floorAvg = floorSum / colums;
        if (floorAvg > hottestFloorAvg)
        {
            hottestFloorAvg = floorAvg;
            hotFloor = i + 1;
        }
    }
    cout << "Hottest Floor : Floor " << hotFloor
         << " (avg " << hottestFloorAvg << "C)" << endl;

    // Rooms at WARNING or above

    int warningCount = 0;

    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < colums; j++)
        {
            if (arr[i][j] >= 30)
            {
                warningCount++;
            }
        }
    }

    cout << "Rooms at WARNING or above : " << warningCount << endl;
}