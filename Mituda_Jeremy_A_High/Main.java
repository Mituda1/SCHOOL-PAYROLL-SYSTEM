import java.util.Scanner;

public class Main {

    // TASK 6
    public static <T> T getItem(T[] items, int index) {

        if (index < 0 || index >= items.length) {
            return null;
        }

        return items[index];
    }

    // TASK 6
    public static String formatId(String id) {
        return id.trim()
                .toUpperCase()
                .replace("-", "_");
    }

    public static void main(String[] args) {

        Payable[] list = {

                new Teacher(
                        "Ana Reyes",
                        "T-01",
                        28000,
                        10
                ),

                new Teacher(
                        "Ben Cruz",
                        "T-02",
                        26000
                ),

                new AdminStaff(
                        "Carla Diaz",
                        "A-01",
                        24000,
                        3000
                ),

                new AdminStaff(
                        "Dan Lim",
                        "A-02",
                        22000,
                        2500
                ),

                new Honorarium(
                        "Guest Speaker",
                        5000
                )
        };

        Scanner sc = new Scanner(System.in);

        // TASK 5
        int choice;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Display all");
            System.out.println("2. Search by keyword");
            System.out.println("3. Show total and highest");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    for (Payable p : list) {
                        p.printReport();
                    }

                    break;

                case 2:

                    System.out.print("Enter keyword: ");
                    String keyword = sc.nextLine();

                    boolean found = false;

                    for (Payable p : list) {

                        if (p.getLabel()
                                .toLowerCase()
                                .contains(keyword.toLowerCase())) {

                            p.printReport();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("No match found.");
                    }

                    break;

                case 3:

                    double total = 0;
                    double highest = 0;
                    String highestName = "";

                    for (Payable p : list) {

                        double pay = p.computePay();

                        total += pay;

                        if (pay > highest) {
                            highest = pay;
                            highestName = p.getLabel();
                        }
                    }

                    System.out.printf(
                            "Total: %.2f%n",
                            total
                    );

                    System.out.printf(
                            "Highest: %s (%.2f)%n",
                            highestName,
                            highest
                    );

                    break;

                case 0:

                    System.out.println("Goodbye!");
                    break;

                default:

                    System.out.println("Invalid option.");
            }

        } while (choice != 0);

        // TASK 6

        System.out.println("\n=== TASK 6 ===");

        System.out.println("getItem(2):");

        Payable item = getItem(list, 2);

        if (item != null) {
            item.printReport();
        } else {
            System.out.println("Invalid selection");
        }

        System.out.println("\ngetItem(10):");

        item = getItem(list, 10);

        if (item != null) {
            item.printReport();
        } else {
            System.out.println("Invalid selection");
        }

        System.out.println("\ngetItem(-1):");

        item = getItem(list, -1);

        if (item != null) {
            item.printReport();
        } else {
            System.out.println("Invalid selection");
        }

        System.out.println(
                "\nformatId(\" t-01 \") -> "
                        + formatId(" t-01 ")
        );

        System.out.println(
                "Staff count: "
                        + Staff.getStaffCount()
        );

        sc.close();
    }
}