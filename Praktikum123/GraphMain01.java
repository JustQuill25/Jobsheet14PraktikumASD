package Praktikum123;

import java.util.Scanner;

public class GraphMain01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph01 gedung = new Graph01(6);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Edge");
            System.out.println("2. Remove Edge");
            System.out.println("3. Degree");
            System.out.println("4. Print Graph");
            System.out.println("5. Cek Edge");
            System.out.println("6. Update Jarak");
            System.out.println("7. Hitung Edge");
            System.out.println("8. Exit");
            System.out.print("Pilih menu: ");
            int menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    System.out.print("Masukkan asal: ");
                    int asal = scanner.nextInt();
                    System.out.print("Masukkan tujuan: ");
                    int tujuan = scanner.nextInt();
                    System.out.print("Masukkan jarak: ");
                    int jarak = scanner.nextInt();
                    gedung.addEdge(asal, tujuan, jarak);
                    break;

                case 2:
                    System.out.print("Masukkan asal: ");
                    asal = scanner.nextInt();
                    System.out.print("Masukkan tujuan: ");
                    tujuan = scanner.nextInt();
                    try {
                        gedung.removeEdge(asal, tujuan);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    System.out.print("Masukkan gedung: ");
                    asal = scanner.nextInt();
                    try {
                        gedung.degree(asal);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 4:
                    try {
                        gedung.printGraph();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 5:
                    System.out.print("Masukkan asal: ");
                    asal = scanner.nextInt();
                    System.out.print("Masukkan tujuan: ");
                    tujuan = scanner.nextInt();
                    boolean adaJalur = gedung.hasPath(asal, tujuan);
                    if (adaJalur) {
                        System.out.println("Gedung " + (char) ('A' + asal) + " dan Gedung " + (char) ('A' + tujuan) + " bertetangga");
                    } else {
                        System.out.println("Gedung " + (char) ('A' + asal) + " dan Gedung " + (char) ('A' + tujuan) + " Tidak Bertetangga");
                    }
                    break;

                case 6:
                    System.out.print("Masukkan asal: ");
                    asal = scanner.nextInt();
                    System.out.print("Masukkan tujuan: ");
                    tujuan = scanner.nextInt();
                    System.out.print("Masukkan jarak baru: ");
                    jarak = scanner.nextInt();
                    gedung.updateJarak(asal, tujuan, jarak);
                    break;

                case 7:
                    int totalEdge = gedung.hitungEdge();
                    System.out.println("Total edge: " + totalEdge);
                    break;

                case 8:
                    System.out.println("Program selesai.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Menu tidak valid.");
            }
        }
    }
}
