package ClassDiagram;

import java.util.*;

public class MainClassDiagram {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, ClassDiagram> classDiagrams = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Class Diagram Management System ===");
            System.out.println("1. Buat Class Diagram Baru");
            System.out.println("2. Tambah Atribut ke Class");
            System.out.println("3. Tambah Method ke Class");
            System.out.println("4. Tambah Relasi Antar Class");
            System.out.println("5. Tampilkan Class Diagram");
            System.out.println("6. Tampilkan Semua Class");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createNewClass();
                    break;
                case 2:
                    addAttribute();
                    break;
                case 3:
                    addMethod();
                    break;
                case 4:
                    addRelationship();
                    break;
                case 5:
                    displayClassDiagram();
                    break;
                case 6:
                    displayAllClasses();
                    break;
                case 7:
                    System.out.println("Terima kasih!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private static void createNewClass() {
        System.out.print("Masukkan nama class: ");
        String className = scanner.nextLine();

        System.out.println("Tipe class:");
        System.out.println("1. Normal Class");
        System.out.println("2. Abstract Class");
        System.out.println("3. Interface");
        System.out.print("Pilih tipe (1-3): ");
        int type = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        ClassDiagram classDiagram = new ClassDiagram(className);

        switch (type) {
            case 2:
                classDiagram.setAbstract(true);
                break;
            case 3:
                classDiagram.setInterface(true);
                break;
        }

        classDiagrams.put(className, classDiagram);
        System.out.println("Class " + className + " berhasil dibuat!");
    }

    private static void addAttribute() {
        if (classDiagrams.isEmpty()) {
            System.out.println("Belum ada class yang dibuat!");
            return;
        }

        System.out.println("Class yang tersedia:");
        classDiagrams.keySet().forEach(System.out::println);

        System.out.print("Pilih nama class: ");
        String className = scanner.nextLine();

        ClassDiagram classDiagram = classDiagrams.get(className);
        if (classDiagram == null) {
            System.out.println("Class tidak ditemukan!");
            return;
        }

        System.out.println("Visibility:");
        System.out.println("1. Public (+)");
        System.out.println("2. Private (-)");
        System.out.println("3. Protected (#)");
        System.out.println("4. Package (~)");
        System.out.print("Pilih visibility (1-4): ");
        int visibility = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String visibilitySymbol;
        switch (visibility) {
            case 1: visibilitySymbol = "+"; break;
            case 2: visibilitySymbol = "-"; break;
            case 3: visibilitySymbol = "#"; break;
            case 4: visibilitySymbol = "~"; break;
            default: visibilitySymbol = "+";
        }

        System.out.print("Nama atribut: ");
        String attributeName = scanner.nextLine();

        System.out.print("Tipe data: ");
        String dataType = scanner.nextLine();

        classDiagram.addAttribute(visibilitySymbol, attributeName, dataType);
        System.out.println("Atribut berhasil ditambahkan!");
    }

    private static void addMethod() {
        if (classDiagrams.isEmpty()) {
            System.out.println("Belum ada class yang dibuat!");
            return;
        }

        System.out.println("Class yang tersedia:");
        classDiagrams.keySet().forEach(System.out::println);

        System.out.print("Pilih nama class: ");
        String className = scanner.nextLine();

        ClassDiagram classDiagram = classDiagrams.get(className);
        if (classDiagram == null) {
            System.out.println("Class tidak ditemukan!");
            return;
        }

        System.out.println("Visibility:");
        System.out.println("1. Public (+)");
        System.out.println("2. Private (-)");
        System.out.println("3. Protected (#)");
        System.out.println("4. Package (~)");
        System.out.print("Pilih visibility (1-4): ");
        int visibility = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String visibilitySymbol;
        switch (visibility) {
            case 1: visibilitySymbol = "+"; break;
            case 2: visibilitySymbol = "-"; break;
            case 3: visibilitySymbol = "#"; break;
            case 4: visibilitySymbol = "~"; break;
            default: visibilitySymbol = "+";
        }

        System.out.print("Nama method: ");
        String methodName = scanner.nextLine();

        System.out.print("Return type: ");
        String returnType = scanner.nextLine();

        List<String> parameters = new ArrayList<>();
        while (true) {
            System.out.print("Tambah parameter? (y/n): ");
            if (scanner.nextLine().toLowerCase().equals("n")) break;

            System.out.print("Nama parameter: ");
            String paramName = scanner.nextLine();
            System.out.print("Tipe parameter: ");
            String paramType = scanner.nextLine();
            parameters.add(paramType + " " + paramName);
        }

        classDiagram.addMethod(visibilitySymbol, methodName, returnType, parameters);
        System.out.println("Method berhasil ditambahkan!");
    }

    private static void addRelationship() {
        if (classDiagrams.size() < 2) {
            System.out.println("Minimal butuh 2 class untuk membuat relasi!");
            return;
        }

        System.out.println("Class yang tersedia:");
        classDiagrams.keySet().forEach(System.out::println);

        System.out.print("Pilih nama class pertama: ");
        String className1 = scanner.nextLine();

        System.out.print("Pilih nama class kedua: ");
        String className2 = scanner.nextLine();

        if (!classDiagrams.containsKey(className1) || !classDiagrams.containsKey(className2)) {
            System.out.println("Class tidak ditemukan!");
            return;
        }

        System.out.println("Tipe relasi:");
        System.out.println("1. Inheritance (extends)");
        System.out.println("2. Implementation (implements)");
        System.out.print("Pilih tipe relasi (1-2): ");
        int relationType = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        ClassDiagram class1 = classDiagrams.get(className1);

        switch (relationType) {
            case 1:
                class1.setSuperClass(className2);
                System.out.println("Relasi inheritance berhasil ditambahkan!");
                break;
            case 2:
                class1.addInterface(className2);
                System.out.println("Relasi implementation berhasil ditambahkan!");
                break;
            default:
                System.out.println("Tipe relasi tidak valid!");
        }
    }

    private static void displayClassDiagram() {
        if (classDiagrams.isEmpty()) {
            System.out.println("Belum ada class yang dibuat!");
            return;
        }

        System.out.println("Class yang tersedia:");
        classDiagrams.keySet().forEach(System.out::println);

        System.out.print("Pilih nama class: ");
        String className = scanner.nextLine();

        ClassDiagram classDiagram = classDiagrams.get(className);
        if (classDiagram == null) {
            System.out.println("Class tidak ditemukan!");
            return;
        }

        System.out.println("\nClass Diagram untuk " + className + ":");
        System.out.println(classDiagram);
    }

    private static void displayAllClasses() {
        if (classDiagrams.isEmpty()) {
            System.out.println("Belum ada class yang dibuat!");
            return;
        }

        System.out.println("\nSemua Class Diagram:");
        for (Map.Entry<String, ClassDiagram> entry : classDiagrams.entrySet()) {
            System.out.println("\nClass: " + entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}