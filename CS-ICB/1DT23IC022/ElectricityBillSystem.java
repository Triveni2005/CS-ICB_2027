
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

class Customer {
    private int id;
    private String name;
    private String address;
    private int units;
    private double billAmount;

    public Customer(int id, String name, String address, int units) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.units = units;
        this.billAmount = calculateBill();
    }

    private double calculateBill() {
        if (units <= 100) {
            return units * 5;
        } else if (units <= 200) {
            return (100 * 5) + ((units - 100) * 7);
        } else {
            return (100 * 5) + (100 * 7) + ((units - 200) * 10);
        }
    }

    public void printBill() {
        System.out.println("\n----- Electricity Bill -----");
        System.out.println("Customer ID   : " + id);
        System.out.println("Name          : " + name);
        System.out.println("Address       : " + address);
        System.out.println("Units Consumed: " + units);
        System.out.println("Bill Amount   : ₹" + billAmount);
        System.out.println("Due Date      : " + LocalDate.now().plusDays(15));
    }

    public void saveBillToFile() {
        String fileName = "bill_" + id + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("----- Electricity Bill -----\n");
            writer.write("Customer ID   : " + id + "\n");
            writer.write("Name          : " + name + "\n");
            writer.write("Address       : " + address + "\n");
            writer.write("Units Consumed: " + units + "\n");
            writer.write("Bill Amount   : ₹" + billAmount + "\n");
            writer.write("Due Date      : " + LocalDate.now().plusDays(15) + "\n");
            System.out.println("\n✅ Bill saved to file: " + fileName);
        } catch (IOException e) {
            System.out.println("❌ Error saving bill: " + e.getMessage());
        }
    }
}

public class ElectricityBillSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Electricity Bill Generator ===");

        try {
            System.out.print("Enter Customer ID: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Customer Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Address: ");
            String address = sc.nextLine();

            System.out.print("Enter Units Consumed: ");
            int units = Integer.parseInt(sc.nextLine());

            Customer customer = new Customer(id, name, address, units);
            customer.printBill();
            customer.saveBillToFile();

        } catch (Exception e) {
            System.out.println("❌ Invalid input. Please enter valid data.");
        } finally {
            sc.close();
        }
    }
}
