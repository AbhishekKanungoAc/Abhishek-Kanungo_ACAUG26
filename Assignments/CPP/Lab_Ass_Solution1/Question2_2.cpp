#include <iostream>
#include <cmath>
using namespace std;

double computeRMS(double* signal, int n)
{
    double sum = 0;

    for (int i = 0; i < n; i++)
    {
        double value = *(signal + i);
        sum += value * value;
    }

    return sqrt(sum / n);
}

void normalise(double* signal, int n)
{
    double maxAbs = fabs(*signal);

    for (int i = 0; i < n; i++)
    {
        if (fabs(*(signal + i)) > maxAbs)
        {
            maxAbs = fabs(*(signal + i));
        }
    }

    if (maxAbs == 0)
        return;

    for (int i = 0; i < n; i++)
    {
        *(signal + i) = *(signal + i) / maxAbs;
    }
}

int countZeroCrossings(double* signal, int n)
{
    int count = 0;

    for (int i = 0; i < n - 1; i++)
    {
        double current = *(signal + i);
        double next = *(signal + i + 1);

        if ((current < 0 && next > 0) ||
            (current > 0 && next < 0))
        {
            count++;
        }
    }

    return count;
}

void applyGain(double* signal, int n, double gainFactor)
{
    for (int i = 0; i < n; i++)
    {
        *(signal + i) =
            *(signal + i) * gainFactor;
    }
}

void printArray(double* signal, int n)
{
    for (int i = 0; i < n; i++)
    {
        cout << *(signal + i) << " ";
    }

    cout << endl;
}

int main()
{
    double signal[] =
    {
        0.5, -1.2, 0.8, -0.3,
        1.0, -0.9, 0.1
    };

    int n = 7;

    cout << "Original Signal : ";
    printArray(signal, n);

    cout << "RMS : "
         << computeRMS(signal, n)
         << endl;

    cout << "Zero Crossings : "
         << countZeroCrossings(signal, n)
         << endl;

    normalise(signal, n);

    cout << "After Normalise : ";
    printArray(signal, n);

    applyGain(signal, n, 2.0);

    cout << "After Gain : ";
    printArray(signal, n);

    return 0;
}