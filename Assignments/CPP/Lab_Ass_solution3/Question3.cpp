#include <iostream>
#include <cstring> // for strlen() and memcpy()

using namespace std;

// ============================================================
//                  CLASS: LogBuffer
// ============================================================

class LogBuffer
{
private:
    // Dynamically allocated character array
    char *buffer;

    // Maximum capacity of the buffer
    int capacity;

    // Number of characters currently stored
    int size;

    // Static variable:
    // Only ONE copy exists for the entire class.
    // It keeps track of how many LogBuffer objects are alive.
    static int instanceCount;

    // BONUS:
    // mutable allows print() to modify accessCount
    // even though print() is a const member function.
    mutable int accessCount = 0;

public:
    // ========================================================
    // CONSTRUCTOR
    // ========================================================

    LogBuffer(int capacity)
    {
        this->capacity = capacity;

        // Initially, buffer contains nothing
        size = 0;

        // Allocate character array dynamically
        //
        // +1 is used for '\0'
        // because C-style strings need a null terminator.
        buffer = new char[capacity + 1];

        // Initially empty string
        buffer[0] = '\0';

        // One more LogBuffer object is now alive
        instanceCount++;

        cout << "[LogBuffer Created] capacity="
             << capacity << endl;
    }

    // ========================================================
    // COPY CONSTRUCTOR
    // ========================================================
    //
    // Called when a NEW object is created from an existing
    // object.
    //
    // Example:
    //
    // LogBuffer log2 = log1;
    //
    // IMPORTANT:
    // We must perform DEEP COPY.
    //
    // We cannot do:
    //
    // buffer = other.buffer;
    //
    // because then both objects would point to the same
    // dynamically allocated memory.
    // ========================================================

    LogBuffer(const LogBuffer &other)
    {
        // Copy capacity
        capacity = other.capacity;

        // Copy current size
        size = other.size;

        // Allocate NEW memory
        buffer = new char[capacity + 1];

        // Copy actual characters from other's buffer
        memcpy(buffer, other.buffer, size + 1);

        // New object has its own access counter
        accessCount = 0;

        // Another LogBuffer object is now alive
        instanceCount++;

        cout << "[LogBuffer Deep Copied] capacity="
             << capacity << endl;
    }

    // ========================================================
    // COPY ASSIGNMENT OPERATOR
    // ========================================================
    //
    // Called when BOTH objects already exist.
    //
    // Example:
    //
    // LogBuffer log3(128);
    // log3 = log1;
    //
    // ========================================================

    LogBuffer &operator=(const LogBuffer &other)
    {
        // ----------------------------------------------------
        // SELF-ASSIGNMENT CHECK
        // ----------------------------------------------------
        //
        // Example:
        //
        // log1 = log1;
        //
        // Here this and other refer to the same object.
        //
        // We should not delete our buffer and then try to
        // copy from the same deleted buffer.
        //
        if (this == &other)
        {
            cout << "[Self-assignment detected — no operation]"
                 << endl;

            return *this;
        }

        // ----------------------------------------------------
        // Delete old memory
        // ----------------------------------------------------
        //
        // log3 already has its own buffer.
        // We don't need that old buffer anymore.
        //
        delete[] buffer;

        // ----------------------------------------------------
        // Copy capacity and size
        // ----------------------------------------------------

        capacity = other.capacity;
        size = other.size;

        // ----------------------------------------------------
        // Allocate NEW memory
        // ----------------------------------------------------

        buffer = new char[capacity + 1];

        // ----------------------------------------------------
        // Deep copy the contents
        // ----------------------------------------------------

        memcpy(buffer, other.buffer, size + 1);

        // Copy assignment does not create a new object,
        // so instanceCount is NOT incremented.

        cout << "[LogBuffer Assigned]" << endl;

        // Return current object.
        //
        // Returning *this allows expressions like:
        //
        // a = b = c;
        //
        return *this;
    }

    // ========================================================
    // DESTRUCTOR
    // ========================================================
    //
    // Automatically called when an object is destroyed.
    // ========================================================

    ~LogBuffer()
    {
        // Release dynamically allocated memory
        delete[] buffer;

        // One less LogBuffer object is alive
        instanceCount--;

        cout << "[LogBuffer Destroyed]" << endl;
    }

    // ========================================================
    // append()
    // ========================================================
    //
    // Adds message to the current buffer.
    //
    // Only copies characters that can fit inside capacity.
    // ========================================================

    void append(const char *msg)
    {
        // Find length of incoming message
        int msgLength = strlen(msg);

        // How much space is still available?
        int available = capacity - size;

        // If message is bigger than available space,
        // only copy what can fit.
        int charactersToCopy;

        if (msgLength < available)
        {
            charactersToCopy = msgLength;
        }
        else
        {
            charactersToCopy = available;
        }

        // Copy characters at the end of current buffer
        memcpy(buffer + size, msg, charactersToCopy);

        // Update size
        size += charactersToCopy;

        // Add null terminator
        buffer[size] = '\0';
    }

    // ========================================================
    // print()
    // ========================================================
    //
    // const means this function promises not to change the
    // normal data members of the object.
    //
    // BUT accessCount is mutable, so we are allowed to
    // modify it.
    // ========================================================

    void print() const
    {
        // Because accessCount is mutable,
        // we can modify it inside a const function.
        accessCount++;

        cout << buffer << endl;
    }

    // ========================================================
    // clear()
    // ========================================================
    //
    // Removes all current log messages.
    // ========================================================

    void clear()
    {
        size = 0;

        // Make buffer an empty C-style string
        buffer[0] = '\0';
    }

    // ========================================================
    // getInstanceCount()
    // ========================================================
    //
    // static function can access static data members.
    // ========================================================

    static int getInstanceCount()
    {
        return instanceCount;
    }

    // ========================================================
    // getAccessCount()
    // ========================================================

    int getAccessCount() const
    {
        return accessCount;
    }
};

// ============================================================
// STATIC MEMBER INITIALIZATION
// ============================================================
//
// Static data member must be defined outside the class.
//
// Initially there are no LogBuffer objects.
// ============================================================

int LogBuffer::instanceCount = 0;

// ============================================================
//                       MAIN
// ============================================================

int main()
{
    // ========================================================
    // OBJECTIVE 1 : BASIC USAGE
    // ========================================================

    LogBuffer log1(256);

    log1.append("Server started on port 8080");

    log1.append(" | Request received from 192.168.1.10");

    log1.print();

    // ========================================================
    // OBJECTIVE 2 : DEEP COPY
    // ========================================================
    //
    // log2 is a NEW object.
    //
    // Therefore COPY CONSTRUCTOR is called.
    //
    // A completely separate buffer is created for log2.
    // ========================================================

    LogBuffer log2 = log1;

    // Append something only to log2
    log2.append(" | Cached response sent");

    // Print log1
    // It should NOT contain log2's new message.
    cout << "log1 : ";
    log1.print();

    // Print log2
    // It should contain the additional message.
    cout << "log2 : ";
    log2.print();

    // ========================================================
    // OBJECTIVE 3 : COPY ASSIGNMENT
    // ========================================================
    //
    // log3 already exists.
    // Therefore COPY ASSIGNMENT OPERATOR is called.
    // ========================================================

    LogBuffer log3(128);

    log3 = log1;

    log3.print();

    // ========================================================
    // OBJECTIVE 4 : SELF ASSIGNMENT
    // ========================================================

    log1 = log1;

    // Data should remain safe and unchanged.
    log1.print();

    // ========================================================
    // OBJECTIVE 5 : STATIC MEMBER
    // ========================================================
    //
    // Currently:
    //
    // log1
    // log2
    // log3
    //
    // Three objects are alive.
    // ========================================================

    cout << "Live LogBuffer objects : "
         << LogBuffer::getInstanceCount()
         << endl;

    // ========================================================
    // BONUS : const + mutable
    // ========================================================
    //
    // Create a const LogBuffer object using copy constructor.
    //
    // Because readOnly is const, we cannot call functions
    // that modify the object.
    //
    // But print() is declared const, so it can be called.
    // ========================================================

    const LogBuffer readOnly(log1);

    // print() is called three times.
    //
    // accessCount is mutable, so it can increase even though
    // readOnly is a const object.

    readOnly.print();
    readOnly.print();
    readOnly.print();

    cout << "Times printed: "
         << readOnly.getAccessCount()
         << endl;

    // ========================================================
    // END OF MAIN
    // ========================================================
    //
    // Objects are destroyed automatically in reverse order:
    //
    // readOnly
    // log3
    // log2
    // log1
    //
    // Their destructors call delete[] and decrease
    // instanceCount.
    // ========================================================

    return 0;
}