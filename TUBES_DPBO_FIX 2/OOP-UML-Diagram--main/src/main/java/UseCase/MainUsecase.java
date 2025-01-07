// File: MainUsecase.java
package UseCase;

import java.util.Scanner;

public class MainUsecase {

    private static Scanner scanner = new Scanner(System.in);
    private static UseCaseDiagram currentDiagram = null;

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createNewDiagram();
                    break;
                case 2:
                    addActor();
                    break;
                case 3:
                    addUseCase();
                    break;
                case 4:
                    addRelationship();
                    break;
                case 5:
                    displayDiagram();
                    break;
                case 6:
                    System.out.println("Terima kasih!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n=== Use Case Diagram Manager ===");
        System.out.println("1. Buat Diagram Baru");
        System.out.println("2. Tambah Actor");
        System.out.println("3. Tambah Use Case");
        System.out.println("4. Tambah Relationship");
        System.out.println("5. Tampilkan Diagram");
        System.out.println("6. Keluar");
        System.out.print("Pilih menu: ");
    }

    private static void createNewDiagram() {
        System.out.print("Masukkan nama diagram: ");
        String name = scanner.nextLine();
        currentDiagram = new UseCaseDiagram(name);
        System.out.println("Diagram berhasil dibuat!");
    }

    private static void addActor() {
        if (currentDiagram == null) {
            System.out.println("Buat diagram terlebih dahulu!");
            return;
        }

        System.out.print("ID Actor: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nama Actor: ");
        String name = scanner.nextLine();

        System.out.print("Tipe Actor (1: Primary, 2: Secondary): ");
        int type = scanner.nextInt();
        scanner.nextLine();

        Actor actor = new Actor(id, name, type == 1 ? "Primary" : "Secondary");
        currentDiagram.addActor(actor);
        System.out.println("Actor berhasil ditambahkan!");
    }

    private static void addUseCase() {
        if (currentDiagram == null) {
            System.out.println("Buat diagram terlebih dahulu!");
            return;
        }

        System.out.print("ID Use Case: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nama Use Case: ");
        String name = scanner.nextLine();

        System.out.print("Deskripsi Use Case: ");
        String description = scanner.nextLine();

        UseCase useCase = new UseCase(id, name, description);
        currentDiagram.addUseCase(useCase);
        System.out.println("Use Case berhasil ditambahkan!");
    }

    private static void addRelationship() {
    if (currentDiagram == null) {
        System.out.println("Buat diagram terlebih dahulu!");
        return;
    }

    if (currentDiagram.getActors().isEmpty() || currentDiagram.getUseCases().isEmpty()) {
        System.out.println("Tambahkan minimal satu aktor dan satu use case terlebih dahulu!");
        return;
    }

    try {
        // Pilih aktor
        System.out.println("\nDaftar Aktor:");
        for (int i = 0; i < currentDiagram.getActors().size(); i++) {
            System.out.println((i + 1) + ". " + currentDiagram.getActors().get(i).getName());
        }
        System.out.print("Pilih aktor (nomor): ");
        int actorIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        // Pilih use case
        System.out.println("\nDaftar Use Case:");
        for (int i = 0; i < currentDiagram.getUseCases().size(); i++) {
            System.out.println((i + 1) + ". " + currentDiagram.getUseCases().get(i).getName());
        }
        System.out.print("Pilih use case (nomor): ");
        int useCaseIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        // Validasi indeks
        if (actorIndex < 0 || actorIndex >= currentDiagram.getActors().size() ||
            useCaseIndex < 0 || useCaseIndex >= currentDiagram.getUseCases().size()) {
            System.out.println("Indeks tidak valid!");
            return;
        }

        // Tambahkan relationship
        System.out.println("\nTipe Relationship:");
        System.out.println("1. Association");
        System.out.println("2. Include");
        System.out.println("3. Extend");
        System.out.print("Pilih tipe (nomor): ");
        int typeChoice = scanner.nextInt();
        scanner.nextLine();

        String type = switch (typeChoice) {
            case 1 -> "association";
            case 2 -> "includes";
            case 3 -> "extends";
            default -> "association";
        };

        Actor actor = currentDiagram.getActors().get(actorIndex);
        UseCase useCase = currentDiagram.getUseCases().get(useCaseIndex);
        currentDiagram.addRelationship(actor, useCase, type);
        System.out.println("Relationship berhasil ditambahkan!");

    } catch (IndexOutOfBoundsException e) {
        System.out.println("Indeks tidak valid!");
    }
}


    private static void displayDiagram() {
    if (currentDiagram == null) {
        System.out.println("Buat diagram terlebih dahulu!");
        return;
    }

    if (currentDiagram.getActors().isEmpty() || currentDiagram.getUseCases().isEmpty()) {
        System.out.println("Diagram tidak dapat ditampilkan karena tidak ada aktor atau use case yang tersedia!");
        return;
    }

    System.out.println("\nUse Case Diagram:");
    System.out.println(currentDiagram);
}
}