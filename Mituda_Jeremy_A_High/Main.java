import java.util.Scanner;

public class Main {

    // TASK 6: Returns an item or null when the index is invalid.
    public static Payable getItem(Payable[] items, int index) {
        if (index < 0 || index >= items.length) {
            return null;
        }

        return items[index];
    }

    // TASK 6: Trims, capitalizes, and replaces hyphens in an ID.
    public static String formatId(String id) {
        return id.trim()
                .toUpperCase()
                .replace("-", "_");
    }

    public static void main(String[] args) {

        // TASK 5: Stores different objects using Payable references.
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
        int choice;

        // TASK 5: Repeats the menu until the user enters zero.
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
                    // Displays every object using printReport().
                    for (Payable item : list) {
                        item.printReport();
                    }
                    break;

                case 2:
                    // Searches partially and ignores letter case.
                    System.out.print("Enter keyword: ");
                    String keyword = sc.nextLine().toLowerCase();

                    boolean found = false;

                    for (Payable item : list) {
                        if (item.getLabel()
                                .toLowerCase()
                                .contains(keyword)) {

                            item.printReport();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("No match found.");
                    }
                    break;

                case 3:
                    // Computes total pay and finds the highest pay.
                    double total = 0;
                    Payable highest = list[0];

                    for (Payable item : list) {
                        total += item.computePay();

                        if (item.computePay()
                                > highest.computePay()) {

                            highest = item;
                        }
                    }

                    System.out.printf(
                            "Total: %.2f%n",
                            total
                    );

                    System.out.printf(
                            "Highest: %s (%.2f)%n",
                            highest.getLabel(),
                            highest.computePay()
                    );
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 0);

        // TASK 6: Tests getItem() with index 2.
        System.out.println("\n=== TASK 6 ===");
        System.out.println("getItem(2):");

        Payable item = getItem(list, 2);

        if (item == null) {
            System.out.println("Invalid selection");
        } else {
            item.printReport();
        }

        // TASK 6: Tests getItem() with invalid index 10.
        System.out.println("getItem(10):");

        item = getItem(list, 10);

        if (item == null) {
            System.out.println("Invalid selection");
        } else {
            item.printReport();
        }

        // TASK 6: Tests getItem() with invalid index -1.
        System.out.println("getItem(-1):");

        item = getItem(list, -1);

        if (item == null) {
            System.out.println("Invalid selection");
        } else {
            item.printReport();
        }

        // TASK 6: Tests the required String method.
        System.out.println(
                "formatId(\" t-01 \") -> "
                        + formatId(" t-01 ")
        );

        // Displays the number of Staff objects.
        System.out.println(
                "Staff count: "
                        + Staff.getStaffCount()
        );

        sc.close();
    }
}
