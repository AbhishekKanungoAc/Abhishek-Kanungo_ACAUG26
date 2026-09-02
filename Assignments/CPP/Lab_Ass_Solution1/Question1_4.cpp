#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

int main(int argc, char* argv[])
{
    // Check number of arguments
    if (argc != 4)
    {
        cout << "Usage : ./sensor_monitor <warn_threshold> <critical_threshold> <num_readings>" << endl;
        cout << "Error : Missing arguments." << endl;

        return 1;
    }

    // Convert command-line arguments to integers
    int warn = stoi(argv[1]);
    int critical = stoi(argv[2]);
    int numReadings = stoi(argv[3]);

    // Validate thresholds
    if (warn >= critical)
    {
        cout << "Error : Warning threshold must be less than Critical threshold." << endl;
        return 1;
    }

    // Validate number of readings
    if (numReadings < 1 || numReadings > 500)
    {
        cout << "Error : Number of readings must be between 1 and 500." << endl;
        return 1;
    }

    // Counters
    int normal = 0;
    int warning = 0;
    int criticalCount = 0;
    int shutdown = 0;

    // Generate random values
    srand(time(0));

    for (int i = 0; i < numReadings; i++)
    {
        int temperature = rand() % 70;

        if (temperature < warn)
        {
            normal++;
        }
        else if (temperature < critical)
        {
            warning++;
        }
        else if (temperature < 60)
        {
            criticalCount++;
        }
        else
        {
            shutdown++;
        }
    }

    // Print configuration
    cout << "Config  : "
         << "Warn=" << warn << "C "
         << "Critical=" << critical << "C "
         << "Readings=" << numReadings << endl;

    // Print results
    cout << "Results : "
         << "Normal:" << normal << " "
         << "Warning:" << warning << " "
         << "Critical:" << criticalCount << " "
         << "Shutdown:" << shutdown << endl;

    return 0;
}