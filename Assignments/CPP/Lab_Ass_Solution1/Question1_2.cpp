#include <iostream>
using namespace std;

int printValidReading(double arr[], int num)
{
    int count = 0;

    cout << "Readings entered : " << num << endl;
    cout << "Valid Reading : ";

    for (int i = 0; i < num; i++)
    {
        if (arr[i] < 0)
        {
            count++;
            continue;
        }

        cout << arr[i] << " ";
    }

    cout << endl;

    return count;
}

void findFirstCritical(double arr[], int num)
{
    for (int i = 0; i < num; i++)
    {
        if (arr[i] >= 45)
        {
            cout << "First CRITICAL : Index " << i << " -> " << arr[i] << "C" << endl;
            break;
        }
    }
}

void calculate(double arr[], int num)
{
    double min;
    double max;
    double sum = 0;
    int count = 0;

    for (int i = 0; i < num; i++)
    {
        if (arr[i] < 0)
        {
            continue;
        }

        if (count == 0)
        {
            min = arr[i];
            max = arr[i];
        }

        if (arr[i] < min)
        {
            min = arr[i];
        }

        if (arr[i] > max)
        {
            max = arr[i];
        }

        sum = sum + arr[i];
        count++;
    }

    double avg = sum / count;

    cout << "Min : " << min << "C"
         << " Max : " << max << "C"
         << " Avg : " << avg << "C" << endl;
}

void countCategory(double arr[], int num)
{
    int normal = 0;
    int warning = 0;
    int critical = 0;
    int shutdown = 0;

    for (int i = 0; i < num; i++)
    {
        if (arr[i] < 0)
        {
            continue;
        }

        if (arr[i] < 25)
        {
            normal++;
        }
        else if (arr[i] < 45)
        {
            warning++;
        }
        else if (arr[i] < 60)
        {
            critical++;
        }
        else
        {
            shutdown++;
        }
    }

    cout << "Normal : " << normal << endl;
    cout << "Warning : " << warning << endl;
    cout << "Critical : " << critical << endl;
    cout << "Shutdown : " << shutdown << endl;
}

int main()
{
    int num;

    cout << "Enter the number of temperature values store in an array:" << endl;
    cin >> num;

    cout << "Enter Array Elements:" << endl;

    double arr[num];

    for (int i = 0; i < num; i++)
    {
        cin >> arr[i];
    }

    int skipped = printValidReading(arr, num);
    cout << "Skipped (error) : " << skipped << endl;

    findFirstCritical(arr, num);

    calculate(arr, num);
    countCategory(arr, num);
}