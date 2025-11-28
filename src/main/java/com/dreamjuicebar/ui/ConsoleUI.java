package com.dreamjuicebar.ui;

import com.dreamjuicebar.model.Juice;
import com.dreamjuicebar.service.MenuService;
import com.dreamjuicebar.util.IdUtil;
import com.dreamjuicebar.util.InputHelper;
import com.dreamjuicebar.util.MoneyUtil;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Console UI (Sprint 1):
 * - Runnable shell + Menu Management CRUD
 * - Other modules remain placeholders for next commits
 */
public class ConsoleUI {
    private static final String SHOP_NAME = "Dream Juice Bar";

    private final Scanner sc = new Scanner(System.in);
    private final InputHelper in = new InputHelper(sc);

    // Services (in-memory for now)
    private final MenuService menuService = new MenuService();

    // Simple ID counter for juices
    private int nextJuiceNo = 1;

    public ConsoleUI() {
        seedMenu(); // helps testing quickly; looks realistic for early dev
    }

    public void run() {
        printBanner();

        while (true) {
            printMainMenu();
            int choice = in.readInt("Select: ", 1, 5);

            switch (choice) {
                case 1 -> menuManagement();
                case 2 -> takeNewOrder();        // stub (next commits)
                case 3 -> inventoryManagement(); // stub
                case 4 -> salesSummary();        // stub
                case 5 -> {
                    System.out.println("✅ Exiting... Bye!");
                    return;
                }
            }
        }
    }

    private void seedMenu() {
        menuService.add(new Juice(IdUtil.nextId("J", nextJuiceNo++), "Banana Milkshake", new BigDecimal("450.00")));
        menuService.add(new Juice(IdUtil.nextId("J", nextJuiceNo++), "Mango Smoothie", new BigDecimal("520.00")));
        menuService.add(new Juice(IdUtil.nextId("J", nextJuiceNo++), "Orange Fresh Juice", new BigDecimal("400.00")));
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

    // ---------------- Menu Management ----------------

    private void menuManagement() {
        while (true) {
            System.out.println("\n--- Menu Management ---");
            System.out.println("1) View Menu");
            System.out.println("2) Add New Juice/Drink");
            System.out.println("3) Edit Juice Price");
            System.out.println("4) Delete Juice");
            System.out.println("0) Back");

            int c = in.readInt("Select: ", 0, 4);
            switch (c) {
                case 1 -> viewMenu();
                case 2 -> addJuice();
                case 3 -> editPrice();
                case 4 -> deleteJuice();
                case 0 -> { return; }
            }
        }
    }

    private void viewMenu() {
        System.out.println("\n--- Dream Juice Bar Menu ---");
        System.out.printf("%-6s %-25s %-12s%n", "ID", "Name", "Price");
        System.out.println("--------------------------------------------------");

        if (menuService.getAll().isEmpty()) {
            System.out.println("(menu is empty)");
            in.pause();
            return;
        }

        for (Juice j : menuService.getAll()) {
            System.out.printf("%-6s %-25s %-12s%n",
                    j.getId(),
                    j.getName(),
                    MoneyUtil.formatLKR(j.getPrice()));
        }
        in.pause();
    }

    private void addJuice() {
        System.out.println("\n--- Add New Juice/Drink ---");
        String name = in.readNonEmpty("Juice Name: ");
        BigDecimal price = in.readMoney("Price (e.g., 450 or 450.00): ");

        String id = IdUtil.nextId("J", nextJuiceNo++);
        menuService.add(new Juice(id, name, price));

        System.out.println("✅ Added: " + id + " - " + name);
        in.pause();
    }

    private void editPrice() {
        System.out.println("\n--- Edit Juice Price ---");
        quickMenuList();

        String id = in.readNonEmpty("Enter Juice ID: ");
        Juice j = menuService.findById(id);
        if (j == null) {
            System.out.println("⚠ Juice not found.");
            in.pause();
            return;
        }

        BigDecimal newPrice = in.readMoney("New Price: ");
        j.setPrice(newPrice);

        System.out.println("✅ Price updated for " + j.getName());
        in.pause();
    }

    private void deleteJuice() {
        System.out.println("\n--- Delete Juice ---");
        quickMenuList();

        String id = in.readNonEmpty("Enter Juice ID to delete: ");
        Juice j = menuService.findById(id);
        if (j == null) {
            System.out.println("⚠ Juice not found.");
            in.pause();
            return;
        }

        String confirm = in.readNonEmpty("Type YES to confirm deletion: ");
        if (!confirm.equalsIgnoreCase("YES")) {
            System.out.println("Cancelled.");
            in.pause();
            return;
        }

        boolean ok = menuService.deleteById(id);
        System.out.println(ok ? "✅ Deleted successfully." : "⚠ Delete failed.");
        in.pause();
    }

    private void quickMenuList() {
        if (menuService.getAll().isEmpty()) {
            System.out.println("(menu is empty)");
            return;
        }
        for (Juice j : menuService.getAll()) {
            System.out.println(" - " + j.getId() + " | " + j.getName() + " | " + MoneyUtil.formatLKR(j.getPrice()));
        }
    }

    // ---------------- Next Modules (stubs for next commits) ----------------

    private void takeNewOrder() {
        System.out.println("\n[Take New Order] - Coming next commit.");
        in.pause();
    }

    private void inventoryManagement() {
        System.out.println("\n[Inventory Management] - Coming next commit.");
        in.pause();
    }

    private void salesSummary() {
        System.out.println("\n[Sales Summary] - Coming next commit.");
        in.pause();
    }
}
