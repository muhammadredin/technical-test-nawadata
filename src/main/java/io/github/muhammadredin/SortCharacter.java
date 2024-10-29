package io.github.muhammadredin;

import java.util.Scanner;

public class SortCharacter {
    public static void start() {
        // Scanner untuk membaca input dari pengguna
        Scanner scan = new Scanner(System.in);

        // Meminta pengguna untuk memasukkan satu baris kata
        System.out.print("Input one line of words (S) : ");
        // Membaca input, mengubahnya menjadi huruf kecil dan menghapus spasi
        String input = scan.nextLine().toLowerCase().replace(" ", "");

        // Variabel untuk menyimpan huruf vokal dan konsonan
        String vowels = "";
        String consonants = "";

        // Mengiterasi setiap karakter dalam input
        for (char c : input.toCharArray()) {
            // Memeriksa apakah karakter adalah vokal
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowels += c; // Menambahkan karakter ke string vokal
            } else {
                consonants += c; // Menambahkan karakter ke string konsonan
            }
        }

        // Mengurutkan huruf vokal berdasarkan urutan kemunculan
        String orderVowels = sortOrder(vowels);
        // Mengurutkan huruf konsonan berdasarkan urutan kemunculan
        String orderConsonant = sortOrder(consonants);

        // Mengurutkan huruf vokal sesuai dengan urutan yang telah ditentukan
        String sortedVowels = customSort(vowels, orderVowels);
        // Mengurutkan huruf konsonan sesuai dengan urutan yang telah ditentukan
        String sortedConsonants = customSort(consonants, orderConsonant);

        // Menampilkan hasil urutan huruf vokal dan konsonan
        System.out.println(sortedVowels);
        System.out.println(sortedConsonants);
    }

    // Fungsi untuk mendapatkan urutan unik dari karakter dalam input
    private static String sortOrder(String input) {
        String order = "";
        // Mengiterasi setiap karakter dalam input
        for (int i = 0; i < input.length(); i++) {
            // Memeriksa apakah karakter belum ada dalam urutan
            if (i == 0 || !order.contains("" + input.charAt(i))) {
                order += input.charAt(i); // Menambahkan karakter ke urutan
            }
        }
        return order; // Mengembalikan urutan yang akan digunakan
    }

    // Fungsi untuk mengurutkan karakter berdasarkan urutan yang ditentukan
    private static String customSort(String input, String order) {
        String sorted = "";
        // Mengiterasi setiap karakter dalam urutan
        for (int i = 0; i < order.length(); i++) {
            // Mengiterasi setiap karakter dalam input
            for (int j = 0; j < input.length(); j++) {
                // Memeriksa apakah karakter dalam urutan sama dengan karakter dalam input
                if (order.charAt(i) == input.charAt(j)) {
                    sorted += input.charAt(j); // Menambahkan karakter yang cocok ke hasil urutan
                }
            }
        }
        return sorted; // Mengembalikan hasil urutan
    }
}
