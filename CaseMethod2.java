import java.util.Scanner;

public class CaseMethod2 {
    static Scanner input = new Scanner(System.in);

    //maksimal data yang dapat disimpan
    static final int MAX = 100;

    //array 2 dimensi untuk menyimpan data prestasi         
    static String[][] data = new String[MAX][5];

    //menghitung jumlah data yang disimpan
    static int jumlahData = 0;

    //menampilkan menu
    public static void Menu() {
        System.out.println("=== PENCATATAN PRESTASI MAHASISWA ===");
        System.out.println("1. Tambah Data Prestasi");
        System.out.println("2. Tampilkan Semua Prestasi");
        System.out.println("3. Analisis Prestasi Berdasarkan Jenis");
        System.out.println("4. Keluar");
        System.out.print("Pilih Menu: ");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan;
 
        //looping menu hingga user memilih keluar
        do {
            Menu();
            pilihan = input.nextInt();
            input.nextLine();
            
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    data[jumlahData][0] = input.nextLine();
                    
                    System.out.print("Masukkan NIM Mahasiswa: ");
                    data[jumlahData][1] = input.nextLine();
                    
                    System.out.print("Masukkan Jenis Prestasi: ");
                    data[jumlahData][2] = input.nextLine();
                    
                    String tingkat;
                    boolean tingkatValid = false;
                    do {
                        System.out.print("Masukkan Tingkat Prestasi (Lokal/Nasional/Internasional): ");
                        tingkat = input.nextLine();
                        if (tingkat.equalsIgnoreCase("Lokal") || tingkat.equalsIgnoreCase("Nasional") || tingkat.equalsIgnoreCase("Internasional")) {
                            data[jumlahData][3] = tingkat;
                            tingkatValid = true;
                        } else {
                            System.out.println("Tingkat prestasi tidak valid. Hanya terima Lokal, Nasional, atau Internasional.");
                        }
                    } while (!tingkatValid);
                    
                    // Validasi input tahun antara 2010 dan 2025
                    int tahun;
                    boolean tahunValid = false;
                    do {
                        System.out.print("Masukkan Tahun Prestasi (2010-2025): ");
                        try {
                            tahun = input.nextInt();
                            if (tahun >= 2010 && tahun <= 2025) {
                                data[jumlahData][4] = String.valueOf(tahun);
                                tahunValid = true;
                            } else {
                                System.out.println("Tahun tidak valid. Masukkan tahun antara 2010 dan 2025");
                            }
                        } catch (Exception e) { // menangani input yang bukan angka
                            System.out.println("Input tidak valid. Masukkan angka.");
                            input.nextLine();
                        }
                    } while (!tahunValid);
                    
                    // Menambahkan data prestasi
                    jumlahData++;
                    System.out.println("Data prestasi berhasil ditambahkan.\n");
                    input.nextLine();
                    break;
                case 2:
                    System.out.println("\n=== DAFTAR PRESTASI MAHASISWA ===");
                    if (jumlahData == 0) {
                        System.out.println("Belum ada data prestasi. Mohon tambahkan data terlebih dahulu.");
                    } else {
                        System.out.println("No | Nama | NIM | Jenis | Tingkat | Tahun ");
                        System.out.println("------------------------------------------");
                        for (int i = 0; i < jumlahData; i++) {
                            System.out.println((i + 1) + " | " + data[i][0] + " | " + data[i][1] + " | " + data[i][2] + " | " + data[i][3] + " | " + data[i][4]);
                        }
                    }
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Masukkan Jenis Prestasi untuk Dianalisis: ");
                    String jenisAnalisis = input.nextLine();
                    System.out.println("\n=== ANALISIS PRESTASI: " + jenisAnalisis.toUpperCase() + " ===");
                    
                    boolean found = false;
                    System.out.println("No | Nama | NIM | Tingkat | Tahun ");
                    System.out.println("------------------------------------------");
                    
                    // Menampilkan data prestasi berdasarkan jenis yang dimasukkan
                    for (int i = 0; i < jumlahData; i++) {
                        if (data[i][2].equalsIgnoreCase(jenisAnalisis)) {
                            System.out.println((i + 1) + " | " + data[i][0] + " | " + data[i][1] + " | " + data[i][3] + " | " + data[i][4]);
                            found = true;
                        }
                    }
                    
                    // Jika tidak ada data yang ditemukan
                    if (!found) {
                        System.out.println("Tidak ada prestasi dengan jenis '" + jenisAnalisis + "'.");
                    }
                    System.out.println();
                    break;

                case 4:
                    System.out.println("KELUAR DARI PROGRAM. TERIMAKASIH.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.\n");
            }
        } while (pilihan != 4);
        
        input.close();
    }
}
