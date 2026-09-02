#include <iostream>
#include <cmath>
using namespace std;

inline double distanceBetween(
    double x1,
    double y1,
    double x2,
    double y2
)
{
    return sqrt(
        pow(x2 - x1, 2) +
        pow(y2 - y1, 2)
    );
}

inline double toRadians(double degrees)
{
    return degrees * (M_PI / 180.0);
}

inline double clamp(
    double value,
    double minVal,
    double maxVal
)
{
    if (value < minVal)
        return minVal;

    if (value > maxVal)
        return maxVal;

    return value;
}

inline bool isInSafeZone(
    double x,
    double y,
    double cx,
    double cy,
    double radius
)
{
    double distance =
        distanceBetween(x, y, cx, cy);

    return distance <= radius;
}

int main()
{
    double homeX = 0.0;
    double homeY = 0.0;

    double safeRadius = 50.0;

    double x[3] = {10, 40, 60};
    double y[3] = {20, 30, 10};

    for (int i = 0; i < 3; i++)
    {
        double distance =
            distanceBetween(
                homeX,
                homeY,
                x[i],
                y[i]
            );

        cout << "Waypoint "
             << i + 1
             << endl;

        cout << "Distance from home : "
             << distance
             << endl;

        if (isInSafeZone(
                x[i],
                y[i],
                homeX,
                homeY,
                safeRadius
            ))
        {
            cout << "Inside Safe Zone" << endl;
        }
        else
        {
            cout << "Outside Safe Zone" << endl;
        }

        cout << endl;
    }

    return 0;
}