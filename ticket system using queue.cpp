#include <iostream>
#include <cstdlib>
using namespace std;

const int seats = 50;  // Define the maximum size of the queue
const int max_ticket = 5;
struct Bus {
    string name;
    int phone_no;
    int numTickets;
    int level;
    string plate_no;
    string destination;
};
Bus myqueue[seats];// Declare the queue array to hold customers

// Variables to track available and reserved tickets
int AvailableTicket = seats;
int ReservedTicket = 0;
// Variables to track the front and rear of the queue
int FRONT = 0, REAR = -1; 
int QUEUESIZE = 0;
// Function prototypes
void enqueue(string name, int phone_no, int numTickets, int level, string plate_no, string destination);
void dequeue();
void display();
int menu();

// Function to add a customer to the queue
void enqueue(string name, int phone_no, int numTickets, int level, string plate_no, string destination) {
    if (QUEUESIZE == seats) {
        cout << "Queue is full. There is no space available for ticket reservations." << endl;
    } else {
        REAR++;
        myqueue[REAR].name = name;
        myqueue[REAR].phone_no = phone_no;
        myqueue[REAR].numTickets = numTickets;
        myqueue[REAR].level = level;
        myqueue[REAR].plate_no = plate_no;
        myqueue[REAR].destination = destination;

        // Update available and reserved tickets
        QUEUESIZE++;
        AvailableTicket -= numTickets;
        ReservedTicket += numTickets;
        
        cout << "You have successfully reserved a ticket for a customer." << endl;
    }
}

// Function to cancel a customer from the queue
void dequeue() {
    if (QUEUESIZE == 0) {
        cout << "Queue is empty. Queue Underflow" << endl;
    } else {
        // Update available and reserved tickets
        AvailableTicket += myqueue[FRONT].numTickets;
        ReservedTicket -= myqueue[FRONT].numTickets;

        // Shift remaining elements in the queue
        for (int i = FRONT; i < REAR; i++) {
            myqueue[i] = myqueue[i + 1];
        }

        REAR--;
        QUEUESIZE--;
    }
}


// Function to display the current status of the queue
void display() {
    cout << "Queue status:" << endl;
    cout << "--------------" << endl;
    
    if (QUEUESIZE == 0) {
        cout << "No customers in the queue." << endl;
    } else {
        cout << "Customers in queue:" << endl;
        cout << "----------------------------------------" << endl;
        for (int i = FRONT; i <= REAR; i++) {
            cout << "Name: " << myqueue[i].name << "\nPhone: " << myqueue[i].phone_no << "\nTickets: " << myqueue[i].numTickets << "\nLevel: " << myqueue[i].level << "\nPlate No: " << myqueue[i].plate_no << "\nDestination: " << myqueue[i].destination << endl;
            cout << "----------------------------------------\n" << endl;
        }
        cout << "Available Tickets: " << AvailableTicket << endl;
        cout << "Reserved Tickets: " << ReservedTicket << endl;
    }
}


// Function to display the menu and handle user input
int menu() {
    int choice;
    cout << "**********TICKET SYSTEM USING QUEUE****************" << endl;
    cout << "*****************  MENU     *******************" << endl;
    cout << "1. TO ENQUEUE CUSTOMER==" << endl;
    cout << "2. TO DEQUEUE CUSTOMER==" << endl;
    cout << "3. TO DISPLAY QUEUE STATUS==" << endl;
    cout << "**ENTER ANY OTHER KEY TO EXIT**" << endl;
    cout << "****************************************************" << endl;
    cout << "ENTER YOUR CHOICE : ";
    cin >> choice;

    string cus_name;
    int cus_phone_no;
    int ticket;
    int bus_level;
    string bus_plate_no;
    string bus_destination;

    switch (choice) {
        case 1: {
        	cout << "Enter bus plate number : ";
            cin >> bus_plate_no;
            cout << "Enter bus level : ";
            cin >> bus_level;
            cout << "Enter customer name : ";
            cin >> cus_name;
            cout << "Enter customer's phone number : ";
            cin >> cus_phone_no;
            cout << "Enter number of ticket : ";
            cin >> ticket;
            cout << "Enter bus destination : ";
            cin >> bus_destination;
            if (ticket <= max_ticket) {
                enqueue(cus_name, cus_phone_no, ticket, bus_level, bus_plate_no, bus_destination);
                system("pause");
                system("CLS");
                menu();
            } else {
                cout << "You Can't reserve More Than 5 Tickets !" << endl;
                system("pause");
                system("CLS");
                menu();
            }
            break;
        }
        case 2: {
            dequeue();
            system("pause");
            system("CLS");
            menu();
            break;
        }
        case 3: {
            display();
            system("pause");
            system("CLS");
            menu();
            break;
        }
        default: return 0; break;
    }
}

int main(){
    menu();
    return 0;
}
