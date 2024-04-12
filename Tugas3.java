import java.util.*;

class HashTable {
    LinkedList<String>[] tabel;

    public HashTable(int size) {
        tabel = new LinkedList[size];
    }

    public void masukKata(String kalimat) {
        for (int i = 0; i < kalimat.length(); i++) {
            char karakter = kalimat.charAt(i);
            int index = hash(karakter);
            
            if (tabel[index] == null) {
                tabel[index] = new LinkedList<>();
                tabel[index].add(String.valueOf(karakter));
            } else {
                // Double hashing
                int probeIndex = (index + doubleHash(karakter)) % tabel.length;
                while (tabel[probeIndex] != null && probeIndex != index) {
                    probeIndex = (probeIndex + doubleHash(karakter)) % tabel.length;
                }
                if (probeIndex == index) {
                    // Tabel sudah penuh, tidak ada ruang kosong
                    System.out.println("Tabel sudah penuh, karakter " + karakter + " tidak dapat dimasukkan.");
                } else {
                    tabel[probeIndex] = new LinkedList<>();
                    tabel[probeIndex].add(String.valueOf(karakter));
                }
            }
        }
    }

    private int hash(char karakter) {
        int stringToInt = posisiKarakter(karakter);
        return (11 * stringToInt) % tabel.length;
    }

    private int doubleHash(char karakter) {
        return (karakter % 3) + 1;
    }

    private int posisiKarakter(char huruf) {
        return Math.abs(huruf - 'A' + 1);
    }

    public void print() {
        for (int i = 0; i < tabel.length; i++) {
            if (tabel[i] != null) {
                System.out.print("Index " + i + ": ");
                for (String karakter : tabel[i]) {
                    System.out.print(karakter + " ");
                }
                System.out.println();
            } else {
                System.out.println("Index " + i + ": null");
            }
        }
    }
}

public class Tugas3 {
    public static void main(String[] args) {
        HashTable tabel = new HashTable(16);

        String kalimat = "ANOTHERXMPL";

        tabel.masukKata(kalimat);

        tabel.print();
    }
}