import java.util.*;

class HashTable {
    LinkedList<Character>[] tabel;

    public HashTable(int size) {
        tabel = new LinkedList[size];
    }

    public void masukKata(String kalimat) {
        for (int i = 0; i < kalimat.length(); i++) {
            char karakter = kalimat.charAt(i);
            int index = hash(karakter);
            
            if (tabel[index] == null) {
                tabel[index] = new LinkedList<>();
                tabel[index].add(karakter);
            } else {
                int probing = (index + 1) % tabel.length;
                while (tabel[probing] != null && probing != index) {
                    probing = (probing + 1) % tabel.length;
                }
                if (probing == index) {
                    System.out.println("Tabel sudah penuh, karakter " + karakter + " tidak dapat dimasukkan.");
                } else {
                    tabel[probing] = new LinkedList<>();
                    tabel[probing].add(karakter);
                }
            }
        }
    }

    private int hash(char karakter) {
        int stringToInt = posisiKarakter(karakter);
        return (11 * stringToInt) % tabel.length;
    }

    private int posisiKarakter(char huruf) {
        return Math.abs(huruf - 'A' + 1);
    }

    public void print() {
        for (int i = 0; i < tabel.length; i++) {
            if (tabel[i] != null) {
                System.out.print("Index " + i + ": ");
                for (char karakter : tabel[i]) {
                    System.out.print(karakter + " ");
                }
                System.out.println();
            } else {
                System.out.println("Index " + i + ": null");
            }
        }
    }
}

public class Tugas2 {
    public static void main(String[] args) {
        HashTable tabel = new HashTable(16);

        String kalimat = "INDONESIA";

        tabel.masukKata(kalimat);

        tabel.print();
    }
}