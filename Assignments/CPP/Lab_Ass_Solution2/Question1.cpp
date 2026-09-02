#include <iostream>
#include <iomanip>
#include <string>
using namespace std;


// Overloaded function for integer quantity
double reorderCost(int qty, double unitPrice)
{
    return qty * unitPrice;
}


// Overloaded function for fractional quantity
double reorderCost(double qty, double unitPrice)
{
    return qty * unitPrice;
}


// Overloaded function with tax
double reorderCost(int qty, double unitPrice, double taxRate)
{
    double cost = qty * unitPrice;

    return cost + (cost * taxRate / 100);
}


// Default discount is 10%
double applyDiscount(double price, double discountPercent = 10.0)
{
    return price - (price * discountPercent / 100);
}


class Product
{
private:
    int productId;
    string name;
    double price;
    int quantity;

public:

    void acceptDetails()
    {
        cout << "\nEnter Product ID: ";
        cin >> productId;

        cout << "Enter Product Name: ";
        cin >> name;

        cout << "Enter Price: ";
        cin >> price;

        cout << "Enter Quantity: ";
        cin >> quantity;
    }


    void displayDetails() const
    {
        cout << left
             << setw(10) << productId
             << setw(15) << name
             << setw(12) << fixed << setprecision(2) << price
             << setw(10) << quantity
             << setw(15) << totalValue();

        cout << endl;
    }


    // Calculate total value of product
    double totalValue() const
    {
        return price * quantity;
    }


    // Check whether product quantity is below threshold
    bool isLowStock(int threshold) const
    {
        return quantity < threshold;
    }


    string getName() const
    {
        return name;
    }
};


int main()
{
    const int SIZE = 5;

    // Array of 5 Product objects
    Product products[SIZE];


    // Taking product details
    cout << "===== ENTER PRODUCT DETAILS =====\n";

    for (int i = 0; i < SIZE; i++)
    {
        cout << "\nProduct " << i + 1 << endl;
        products[i].acceptDetails();
    }


    // Display inventory report
    cout << "\n\n===== INVENTORY REPORT =====\n";

    cout << left
         << setw(10) << "ID"
         << setw(15) << "Name"
         << setw(12) << "Price"
         << setw(10) << "Qty"
         << setw(15) << "Total Value"
         << endl;

    for (int i = 0; i < SIZE; i++)
    {
        products[i].displayDetails();
    }


    // Finding product with highest total value
    int maxIndex = 0;

    for (int i = 1; i < SIZE; i++)
    {
        if (products[i].totalValue() >
            products[maxIndex].totalValue())
        {
            maxIndex = i;
        }
    }


    cout << "\nHighest Value Product: "
         << products[maxIndex].getName()
         << " (Rs. "
         << fixed << setprecision(2)
         << products[maxIndex].totalValue()
         << ")" << endl;


    // Taking low stock threshold
    int threshold;

    cout << "\nEnter Low Stock Threshold: ";
    cin >> threshold;


    cout << "\nLow Stock Products:\n";

    bool found = false;

    for (int i = 0; i < SIZE; i++)
    {
        if (products[i].isLowStock(threshold))
        {
            cout << products[i].getName() << endl;
            found = true;
        }
    }


    if (!found)
    {
        cout << "No low stock products found." << endl;
    }


    // Function overloading examples
    cout << "\n===== REORDER COST =====\n";

    cout << "Integer Quantity Cost: "
         << reorderCost(10, 50.0)
         << endl;

    cout << "Fractional Quantity Cost: "
         << reorderCost(2.5, 50.0)
         << endl;

    cout << "Cost With Tax: "
         << reorderCost(10, 50.0, 18.0)
         << endl;


    // Default argument example
    cout << "\nPrice after default 10% discount: "
         << applyDiscount(1000)
         << endl;

    cout << "Price after 20% discount: "
         << applyDiscount(1000, 20)
         << endl;


    return 0;
}