// File: MainUsecase.java
package ActivityDiagram;

import java.util.*;

public class MainActivity {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, ActivityDiagram> activityDiagrams = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Activity Diagram Management System ===");
            System.out.println("1. Buat Activity Diagram Baru");
            System.out.println("2. Tambah Node");
            System.out.println("3. Tambah Flow");
            System.out.println("4. Tampilkan Activity Diagram");
            System.out.println("5. Tampilkan Semua Diagram");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createNewActivityDiagram();
                    break;
                case 2:
                    addNode();
                    break;
                case 3:
                    addFlow();
                    break;
                case 4:
                    displayActivityDiagram();
                    break;
                case 5:
                    displayAllDiagrams();
                    break;
                case 6:
                    System.out.println("Terima kasih!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private static void createNewActivityDiagram() {
        System.out.print("Masukkan nama activity diagram: ");
        String name = scanner.nextLine();

        activityDiagrams.put(name, new ActivityDiagram(name));
        System.out.println("Activity diagram " + name + " berhasil dibuat!");
    }

    private static void addNode() {
        if (activityDiagrams.isEmpty()) {
            System.out.println("Belum ada activity diagram yang dibuat!");
            return;
        }

        System.out.println("Activity diagram yang tersedia:");
        activityDiagrams.keySet().forEach(System.out::println);

        System.out.print("Pilih nama activity diagram: ");
        String diagramName = scanner.nextLine();

        ActivityDiagram diagram = activityDiagrams.get(diagramName);
        if (diagram == null) {
            System.out.println("Activity diagram tidak ditemukan!");
            return;
        }

        System.out.print("Masukkan ID node: ");
        String id = scanner.nextLine();

        System.out.println("Tipe node:");
        System.out.println("1. Start Node");
        System.out.println("2. End Node");
        System.out.println("3. Activity");
        System.out.println("4. Decision");
        System.out.println("5. Merge");
        System.out.println("6. Fork");
        System.out.println("7. Join");
        System.out.print("Pilih tipe (1-7): ");
        int type = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String nodeType;
        switch (type) {
            case 1: nodeType = "start"; break;
            case 2: nodeType = "end"; break;
            case 3: nodeType = "activity"; break;
            case 4: nodeType = "decision"; break;
            case 5: nodeType = "merge"; break;
            case 6: nodeType = "fork"; break;
            case 7: nodeType = "join"; break;
            default: nodeType = "activity";
        }

        System.out.print("Masukkan label node: ");
        String label = scanner.nextLine();

        diagram.addNode(id, nodeType, label);
        System.out.println("Node berhasil ditambahkan!");
    }

    private static void addFlow() {
        if (activityDiagrams.isEmpty()) {
            System.out.println("Belum ada activity diagram yang dibuat!");
            return;
        }

        System.out.println("Activity diagram yang tersedia:");
        activityDiagrams.keySet().forEach(System.out::println);

        System.out.print("Pilih nama activity diagram: ");
        String diagramName = scanner.nextLine();

        ActivityDiagram diagram = activityDiagrams.get(diagramName);
        if (diagram == null) {
            System.out.println("Activity diagram tidak ditemukan!");
            return;
        }

        System.out.print("Masukkan ID node asal: ");
        String fromId = scanner.nextLine();

        System.out.print("Masukkan ID node tujuan: ");
        String toId = scanner.nextLine();

        diagram.addFlow(fromId, toId);
        System.out.println("Flow berhasil ditambahkan!");
    }

    private static void displayActivityDiagram() {
        if (activityDiagrams.isEmpty()) {
            System.out.println("Belum ada activity diagram yang dibuat!");
            return;
        }

        System.out.println("Activity diagram yang tersedia:");
        activityDiagrams.keySet().forEach(System.out::println);

        System.out.print("Pilih nama activity diagram: ");
        String name = scanner.nextLine();

        ActivityDiagram diagram = activityDiagrams.get(name);
        if (diagram == null) {
            System.out.println("Activity diagram tidak ditemukan!");
            return;
        }

        System.out.println("\nActivity Diagram " + name + ":");
        System.out.println(diagram);
    }

    private static void displayAllDiagrams() {
        if (activityDiagrams.isEmpty()) {
            System.out.println("Belum ada activity diagram yang dibuat!");
            return;
        }

        System.out.println("\nSemua Activity Diagram:");
        for (Map.Entry<String, ActivityDiagram> entry : activityDiagrams.entrySet()) {
            System.out.println("\nDiagram: " + entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}