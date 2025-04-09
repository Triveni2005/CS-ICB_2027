# 🧾 Employee Payroll Management System (Java Console Application)

This is a simple console-based Java application for managing employee payroll data. The system allows you to add, view, search, and persist employee records using file serialization.

## 📋 Features

- Add new employees with ID, name, basic salary, HRA, and DA.
- View all saved employee records.
- Search for an employee by their ID.
- Save employee records to a file using Java Serialization.
- Load employee records on startup if data exists.

## 💻 Technologies Used

- Java (Core)
- Object-Oriented Programming (OOP)
- File I/O (Serialization)

## 🗂️ Project Structure

EmployeePayroll.java # Main program logic Employee.java # Serializable Employee class employees.ser # File where employee data is saved

bash
Copy
Edit

## 🏁 Getting Started

### Prerequisites

- JDK 8 or later
- A code editor or IDE (like VSCode, IntelliJ IDEA, or Eclipse)

### Run the Program

1. Clone this repository:

```bash
git clone https://github.com/your-username/employee-payroll-system.git
cd employee-payroll-system
Compile and run:

bash
Copy
Edit
javac EmployeePayroll.java
java EmployeePayroll
📂 Data Persistence
Employee records are stored in a file named employees.ser using Java's object serialization. On every program start, the file is read (if it exists), and on exit, the data is saved back.

📷 Sample Output
mathematica
Copy
Edit
--- Employee Payroll Management ---
1. Add Employee
2. View All Employees
3. Search by Employee ID
4. Save & Exit
Enter your choice: 1
Enter Employee ID: 101
Enter Name: Alice
Enter Basic Salary: 25000
Enter HRA: 5000
Enter DA: 3000
Employee added successfully.
✨ Future Enhancements
Delete or update employee records.

Export data to CSV.

Add GUI using JavaFX or Swing.

Input validation and error handling.
