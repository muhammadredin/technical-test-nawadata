package io.github.muhammadredin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("TES TEKNIKAL NAWADATA M. REDIN BIREZQIC");
        System.out.println("=".repeat(50));
        System.out.println("1. Soal 1 (Sort Character)");
        System.out.println("2. Soal 2 (PSBB)");
        System.out.println("=".repeat(50));
        System.out.print("Masukkan angka 1 atau 2: ");
        int option = scan.nextInt();

        switch (option) {
            case 1:
                SortCharacter.start();
                break;
            case 2:
                PSBB.start();
                break;
            default:
                System.out.println("Hanya Masukkan Pilihan 1 atau 2");
        }
    }
}