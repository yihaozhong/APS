#include <iostream>
#include <stack>

using namespace std;

void displayStack(stack<int> s) {
    cout << "Stack: ";
    while (!s.empty()) {
        cout << s.top() << " ";
        s.pop();
    }
    cout << endl;
}

int main() {
    stack<int> myStack;
    int choice, value;

    while (1) {
        cout << "1. Push" << endl;
        cout << "2. Pop" << endl;
        cout << "3. Display" << endl;
        cout << "4. Exit" << endl;
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1:
                cout << "Enter the value to push: ";
                cin >> value;
                myStack.push(value);
                break;
            case 2:
                if (myStack.empty()) {
                    cout << "Stack is empty. Cannot pop." << endl;
                } else {
                    cout << "Popped value: " << myStack.top() << endl;
                    myStack.pop();
                }
                break;
            case 3:
                displayStack(myStack);
                break;
            case 4:
                exit(0);
            default:
                cout << "Invalid choice. Try again." << endl;
        }
    }

    return 0;
}
