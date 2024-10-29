package io.github.muhammadredin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PSBB {
    public static void start() {
        // Membuat objek Scanner untuk membaca input dari pengguna
        Scanner scan = new Scanner(System.in);

        // Meminta jumlah keluarga dari pengguna dan menyimpannya di variabel numFamilies
        System.out.print("Input the number of families: ");
        int numFamilies = scan.nextInt();
        scan.nextLine(); // Mengonsumsi sisa baris setelah membaca integer

        // Meminta jumlah anggota dari setiap keluarga dalam format string yang dipisahkan oleh spasi
        System.out.print("Input the number of members in the family (separated by a space): ");
        String members = scan.nextLine();

        // Deklarasi list untuk menyimpan jumlah anggota tiap keluarga
        List<Integer> familyMembers;

        try {
            // Mengubah input string menjadi list integer menggunakan ArrayList dan mengkonversinya ke Integer
            familyMembers = new ArrayList<>(List.of(members.split(" "))
                    .stream()
                    .map(Integer::parseInt) // Mengonversi setiap elemen string menjadi Integer
                    .toList());
        } catch (NumberFormatException e) {
            // Jika input tidak bisa dikonversi ke integer, maka program akan memberikan pesan error dan berhenti
            System.out.println("Failed to parse family members, must be separated only by single space");
            return;
        }

        // Memeriksa apakah jumlah elemen dalam list sesuai dengan jumlah keluarga yang diinputkan
        if (familyMembers.size() != numFamilies) {
            System.out.println("Input must be equal with count of family");
            return;
        }

        // Deklarasi variabel untuk menghitung total bus dan index yang akan digunakan dalam loop
        int totalBus = 0;
        int index = 0;
        int familyInBus = 1; // Variabel untuk menghitung jumlah keluarga dalam satu bus

        // Memulai loop untuk menghitung jumlah minimum bus yang diperlukan
        while (true) {
            // Memeriksa apakah indeks sudah melebihi ukuran list, jika ya keluar dari loop
            if (index > familyMembers.size() - 1) {
                break;
            } else if (index == familyMembers.size() - 1 && familyMembers.get(index) < 4) {
                // Jika hanya tersisa satu keluarga dan jumlah anggotanya kurang dari 4, maka tambahkan satu bus
                totalBus++;
                break;
            }

            // Memeriksa apakah jumlah anggota keluarga pada indeks saat ini adalah kelipatan dari 4
            if (familyMembers.get(index) % 4 == 0) {
                totalBus += familyMembers.get(index) / 4; // Jika ya, tambahkan jumlah bus yang diperlukan
                index++;
            } else if (familyMembers.get(index) > 4) {
                // Jika jumlah anggota lebih dari 4, maka tambahkan satu bus dan kurangi 4 anggota dari keluarga tersebut
                totalBus++;
                familyMembers.set(index, familyMembers.get(index) - 4);
            } else if (familyMembers.get(index) < 4) {
                // Jika jumlah anggota kurang dari 4, coba cari keluarga lain yang bisa digabungkan dalam satu bus
                int dividingIndex = 0;
                for (int i = index + 1; i < familyMembers.size(); i++) {
                    // Mencari keluarga yang jumlah anggotanya bisa digabungkan menjadi 4
                    if (familyMembers.get(index) + familyMembers.get(i) == 4) {
                        totalBus++; // Jika ditemukan, tambahkan satu bus
                        dividingIndex = i; // Menyimpan indeks keluarga yang akan digabung
                        break;
                    }
                }

                if (dividingIndex != 0) {
                    // Jika menemukan keluarga yang bisa digabung, hapus keluarga tersebut dari daftar
                    familyMembers.remove(dividingIndex);
                } else {
                    // Jika tidak ada keluarga yang bisa digabung
                    if (familyInBus == 2) {
                        totalBus++; // Tambahkan satu bus jika ada dua keluarga yang tidak dapat digabung
                        familyInBus = 1; // Reset familyInBus untuk bus berikutnya
                    } else {
                        // Jika hanya satu keluarga dalam bus, gabungkan dengan keluarga berikutnya
                        familyMembers.set(index + 1, familyMembers.get(index) + familyMembers.get(index + 1));
                        familyInBus++; // Tambahkan jumlah keluarga dalam bus menjadi dua
                    }
                }
                index++;
            }
        }

        // Menampilkan jumlah minimum bus yang diperlukan
        System.out.println("Minimum bus required is : " + totalBus);
    }
}
