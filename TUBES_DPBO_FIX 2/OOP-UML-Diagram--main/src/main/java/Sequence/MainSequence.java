// File: MainUsecase.java
package Sequence;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainSequence {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, SequenceDiagram> sequenceDiagrams = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Sequence Diagram Management System ===");
            System.out.println("1. Buat Sequence Diagram Baru");
            System.out.println("2. Tambah Lifeline");
            System.out.println("3. Tambah Message");
            System.out.println("4. Tampilkan Sequence Diagram");
            System.out.println("5. Tampilkan Semua Diagram");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createNewSequenceDiagram();
                    break;
                case 2:
                    addLifeline();
                    break;
                case 3:
                    addMessage();
                    break;
                case 4:
                    displaySequenceDiagram();
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

    private static void createNewSequenceDiagram() {
        System.out.print("Masukkan nama sequence diagram: ");
        String name = scanner.nextLine();

        sequenceDiagrams.put(name, new SequenceDiagram(name));
        System.out.println("Sequence diagram " + name + " berhasil dibuat!");
    }

    private static void addLifeline() {
        if (sequenceDiagrams.isEmpty()) {
            System.out.println("Belum ada sequence diagram yang dibuat!");
            return;
        }

        System.out.println("Sequence diagram yang tersedia:");
        sequenceDiagrams.keySet().forEach(System.out::println);

        System.out.print("Pilih nama sequence diagram: ");
        String diagramName = scanner.nextLine();

        SequenceDiagram diagram = sequenceDiagrams.get(diagramName);
        if (diagram == null) {
            System.out.println("Sequence diagram tidak ditemukan!");
            return;
        }

        System.out.print("Masukkan nama lifeline: ");
        String lifelineName = scanner.nextLine();

        System.out.println("Tipe lifeline:");
        System.out.println("1. Actor");
        System.out.println("2. Object");
        System.out.println("3. Component");
        System.out.print("Pilih tipe (1-3): ");
        int type = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String lifelineType;
        switch (type) {
            case 1: lifelineType = "Actor"; break;
            case 2: lifelineType = "Object"; break;
            case 3: lifelineType = "Component"; break;
            default: lifelineType = "Object";
        }

        diagram.addLifeline(lifelineName, lifelineType);
        System.out.println("Lifeline berhasil ditambahkan!");
    }

    private static void addMessage() {
        if (sequenceDiagrams.isEmpty()) {
            System.out.println("Belum ada sequence diagram yang dibuat!");
            return;
        }

        System.out.println("Sequence diagram yang tersedia:");
        sequenceDiagrams.keySet().forEach(System.out::println);

        System.out.print("Pilih nama sequence diagram: ");
        String diagramName = scanner.nextLine();

        SequenceDiagram diagram = sequenceDiagrams.get(diagramName);
        if (diagram == null) {
            System.out.println("Sequence diagram tidak ditemukan!");
            return;
        }

        System.out.print("Masukkan nama lifeline pengirim: ");
        String from = scanner.nextLine();

        System.out.print("Masukkan nama lifeline penerima: ");
        String to = scanner.nextLine();

        System.out.print("Masukkan pesan: ");
        String message = scanner.nextLine();

        System.out.println("Tipe pesan:");
        System.out.println("1. Synchronous");
        System.out.println("2. Asynchronous");
        System.out.println("3. Reply");
        System.out.print("Pilih tipe (1-3): ");
        int type = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String messageType;
        switch (type) {
            case 1: messageType = "sync"; break;
            case 2: messageType = "async"; break;
            case 3: messageType = "reply"; break;
            default: messageType = "sync";
        }

        diagram.addMessage(from, to, message, messageType);
        System.out.println("Pesan berhasil ditambahkan!");
    }

    private static void displaySequenceDiagram() {
        if (sequenceDiagrams.isEmpty()) {
            System.out.println("Belum ada sequence diagram yang dibuat!");
            return;
        }

        System.out.println("Sequence diagram yang tersedia:");
        sequenceDiagrams.keySet().forEach(System.out::println);

        System.out.print("Pilih nama sequence diagram: ");
        String name = scanner.nextLine();

        SequenceDiagram diagram = sequenceDiagrams.get(name);
        if (diagram == null) {
            System.out.println("Sequence diagram tidak ditemukan!");
            return;
        }

        System.out.println("\nSequence Diagram " + name + ":");
        System.out.println(diagram);
    }

    private static void displayAllDiagrams() {
        if (sequenceDiagrams.isEmpty()) {
            System.out.println("Belum ada sequence diagram yang dibuat!");
            return;
        }

        System.out.println("\nSemua Sequence Diagram:");
        for (Map.Entry<String, SequenceDiagram> entry : sequenceDiagrams.entrySet()) {
            System.out.println("\nDiagram: " + entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}