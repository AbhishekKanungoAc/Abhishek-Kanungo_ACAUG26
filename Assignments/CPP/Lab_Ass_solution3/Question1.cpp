#include <iostream>
#include <string>
#include <vector>
#include <utility>

using namespace std;
enum class HttpStatus
{
    OK = 200,
    Created = 201,
    BadRequest = 400,
    Unauthorized = 401,
    NotFound = 404,
    ServerError = 500
};


void handleResponse(HttpStatus status, const string &endpoint)
{
    
    cout << "[" << endpoint << "] -> ";

    
    switch (status)
    {
    case HttpStatus::OK:
        cout << "200 OK : Request successful";
        break;

    case HttpStatus::Created:
        cout << "201 Created : Resource created successfully";
        break;

    case HttpStatus::BadRequest:
        cout << "400 Bad Request : Invalid request";
        break;

    case HttpStatus::Unauthorized:
        cout << "401 Unauthorized : Authentication required";
        break;

    case HttpStatus::NotFound:
        cout << "404 Not Found : Endpoint does not exist";
        break;

    case HttpStatus::ServerError:
        cout << "500 Server Error : Internal server error - retry later";
        break;
    }

    cout << endl;
}

using Header = pair<string, string>;
using HeaderList = vector<Header>;
using Port = unsigned int;
using IPAddress = string;
typedef unsigned long long RequestId;

void printHeaders(const HeaderList &headers)
{
    cout << "Headers:" << endl;

    // Visit every Header inside HeaderList
    for (const Header &header : headers)
    {
        // first  = key/name
        // second = value

        cout << "  "
             << header.first
             << " : "
             << header.second
             << endl;
    }
}

int main()
{
    handleResponse(
        HttpStatus::OK,
        "GET /api/users");

    handleResponse(
        HttpStatus::Unauthorized,
        "POST /api/login");

    handleResponse(
        HttpStatus::NotFound,
        "GET /api/products/99");

    handleResponse(
        HttpStatus::ServerError,
        "POST /api/order");

    HeaderList headers =
        {
            {"Content-Type", "application/json"},
            {"Authorization", "Bearer token123"},
            {"Accept-Language", "en-US"}};

    Port serverPort = 8080;

    RequestId requestId = 1748293847;

    IPAddress serverIP = "192.168.1.10";

    cout << endl;

    cout << "Request ID : "
         << requestId << endl;

    cout << "Server Port : "
         << serverPort << endl;

    cout << "Server IP : "
         << serverIP << endl;

    printHeaders(headers);

    return 0;
}