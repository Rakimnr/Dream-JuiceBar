package com.dreamjuicebar.ui;

import com.dreamjuicebar.util.InputHelper;

import java.util.Scanner;

/**
 * Day-1 UI shell:
 * - Runs reliably
 * - Provides navigation
 * - Stubs for features (to be implemented in next commits)
 *
 * This is how engineers start: make it runnable, then implement slices.
 */
public class ConsoleUI {
    private static final String SHOP_NAME = "Dream Juice Bar";

    private final Scanner sc = new Scanner(System.in);
    private final InputHelper in = new InputHelper(sc);

    public void run() {
        printBanner();

        while (true) {
            printMainMenu();
            int choice = in.readInt("Select: ", 1, 5);

            switch (choice) {
                case 1 -> menuManagement();      // stub
                case 2 -> takeNewOrder();        // stub
                case 3 -> inventoryManagement(); // stub
                case 4 -> salesSummary();        // stub
                case 5 -> {
                    System.out.println("✅ Exiting... Bye!");
                    return;
                }
            }
        }
    }

    private void printBanner() {
        System.out.println("========================================");
        System.out.println("   Welcome to " + SHOP_NAME + " (Console)");
        System.out.println("========================================");
    }

    private void printMainMenu() {
        System.out.println("\nMain Menu");
        System.out.println("1) Menu Management");
        System.out.println("2) Take New Order");
        System.out.println("3) Inventory Management");
        System.out.println("4) Sales Summary");
        System.out.println("5) Exit");
    }

    // -------- Feature Modules (stubs for next commits) --------

    private void menuManagement() {
        System.out.println("\n[Menu Management] - Coming next commit.");
        in.readNonEmpty("Press Enter to go back...");
    }

    private void takeNewOrder() {
        System.out.println("\n[Take New Order] - Coming next commit.");
        in.readNonEmpty("Press Enter to go back...");
    }

    private void inventoryManagement() {
        System.out.println("\n[Inventory Management] - Coming next commit.");
        in.readNonEmpty("Press Enter to go back...");
    }

    private void salesSummary() {
        System.out.println("\n[Sales Summary] - Coming next commit.");
        in.readNonEmpty("Press Enter to go back...");
    }
}
