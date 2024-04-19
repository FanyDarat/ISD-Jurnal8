import java.util.*;

public class Jurnal8 {

    public static void main(String[] args) {
        HashMap<HashMap<String, String>, Integer> dataMahasiswa = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        boolean pengulangan = true;

        while (pengulangan) {
            System.out.println("\nPilih Menu Dibawah Ini:");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Hapus Data Mahasiswa");
            System.out.println("3. Cetak Data Mahasiswa");
            System.out.println("4. Cetak Nilai Mahasiswa berdasarkan NIM");
            System.out.println("5. Keluar");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 1) {
                addData(dataMahasiswa, scanner);
            } else if (pilihan == 2) {
                removeData(dataMahasiswa, scanner);
            } else if (pilihan == 3) {
                printData(dataMahasiswa);
            } else if (pilihan == 4) {
                printNilai(dataMahasiswa, scanner);
            } else if (pilihan == 5) {
                System.out.println("Terima kasih!");
                break;
            } else {
                System.out.println("Pilihan Tidak Ada Masukkan Pilihan Yang Tersedia!!!");
            }
        }
    }

    public static void addData(HashMap<HashMap<String, String>, Integer> dataMahasiswa, Scanner scanner) {
        HashMap<String, String> data = new HashMap<>();
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        data.put("nama", nama);

        System.out.print("Masukkan Kelas: ");
        String kelas = scanner.nextLine();
        data.put("kelas", kelas);

        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        data.put("nim", nim);

        System.out.print("Masukkan Nilai: ");
        int nilai = scanner.nextInt();
        scanner.nextLine();

        dataMahasiswa.put(data, nilai);
        System.out.println("Data berhasil ditambahkan!");
    }

    public static void removeData(HashMap<HashMap<String, String>, Integer> dataMahasiswa, Scanner scanner) {
        System.out.print("Masukkan NIM Mahasiswa Yang Ingin Dihapus: ");
        String nim = scanner.nextLine();

        boolean removed = false;
        for (HashMap<String, String> key : dataMahasiswa.keySet()) {
            if (key.containsKey("nim") && key.get("nim").equals(nim)) {
                dataMahasiswa.remove(key);
                removed = true;
                break;
            }
        }
        if (removed) {
            System.out.println("Data mahasiswa dengan NIM " + nim + " telah dihapus!");
        } else {
            System.out.println("Data mahasiswa dengan NIM " + nim + " tidak dapat ditemukan.");
        }
    }

    public static void printData(HashMap<HashMap<String, String>, Integer> dataMahasiswa) {
        if (dataMahasiswa.isEmpty()) {
            System.out.println("Belum ada data yang tersimpan.");
        } else {
            System.out.println("\nBerikut Data Yang Telah Disimpan:");
            int banyakData = 0;
            int totalNilai = 0;
            for (HashMap<String, String> key : dataMahasiswa.keySet()) {
                String nama = key.get("nama");
                String kelas = key.get("kelas");
                String nim = key.get("nim");
                int nilai = dataMahasiswa.get(key);

                totalNilai = totalNilai + nilai;
                banyakData++;

                System.out.println("\nNIM: " + nim + "\nNama: " + nama + "\nKelas: " + kelas + "\nNilai: " + nilai);
            }
            int rataRata = totalNilai / banyakData;
            System.out.println("\nRata-Rata Nilai: " + rataRata);
        }
    }

    public static void printNilai(HashMap<HashMap<String, String>, Integer> dataMahasiswa, Scanner scanner) {
        System.out.print("Masukkan NIM Mahasiswa: ");
        String nim = scanner.nextLine();
        boolean found = false;

        for (HashMap<String, String> key : dataMahasiswa.keySet()) {
            if (key.containsKey("nim") && key.get("nim").equals(nim)) {
                int nilai = dataMahasiswa.get(key);
                System.out.println("Nilai Mahasiswa dengan NIM " + nim + " adalah: " + nilai);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Data Mahasiswa Dengan NIM " + nim + " Tidak Dapat Ditemukan.");
        }
    }
}
