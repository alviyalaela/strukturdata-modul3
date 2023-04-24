package Modul3;

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;


public class AntrianPasien{
    Scanner in = new Scanner(System.in);
    private int tail;
    private int head;
    private final int size;
    private final String[] dataPasien;
    static AntrianPasien antrianPasien = new AntrianPasien(10);
    private String noTiket;

    public AntrianPasien(int size) {
        this.tail = tail -1;
        this.head = head -1;
        this.size = size;
        this.dataPasien = new String[size];
    }

    public void menu(){
        int pilih = 0;
        while (pilih != 6){
            System.out.println("[PROGRAM ANTRIAN PASIEN]");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Hapus Antrian");
            System.out.println("3. Panggil Antrian");
            System.out.println("4. Cari  Antrian");
            System.out.println("5. Tampilkan Antrian");
            System.out.println("6. Exit");
            System.out.print("Masukkan pilihan: ");
            pilih = in.nextInt();

            switch (pilih) {
                case 1:
                    in.nextLine();
                    System.out.println("[TAMBAHKAN ANTRIAN]");
                    System.out.print("Masukkan Nomor Tiket: ");
                    noTiket = in.nextLine();
                    System.out.print("Masukkan Nama Pasien: ");
                    String namaPasien = in.nextLine();
                    System.out.print("Nama Dokter: ");
                    String namaDokter = in.nextLine();
                    System.out.print("Tanggal Reservasi (dd/mm/yyyy): ");
                    String inputTanggal = in.nextLine();
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
                        Date tanggal = dateFormat.parse(inputTanggal);
                        System.out.println("Tanggal yang dimasukkan: " + tanggal);
                    } catch (Exception e) {
                        System.out.println("Format tanggal salah!");
                    }
                    tambahAntrian(noTiket, namaPasien, namaDokter, inputTanggal);
                    break;

                case 2:
                    in.nextLine();
                    System.out.print("Masukkan Nomor Tiket : ");
                    noTiket = in.nextLine();
                    hapusAntrian(noTiket);
                    break;

                case 3:
                    panggilAntrian();
                    break;

                case 4:
                    in.nextLine();
                    System.out.print("Masukkan Nomor Tiket: ");
                    noTiket = in.nextLine();
                    cariAntrian(noTiket);
                    break;

                case 5:
                    tampilAntrian();
                    break;

                case 6:
                    break;
            }
        }
    }

    public boolean isFull(){
        return tail == size -1;
    }

    public boolean isEmpty(){
        return head == -1;
    }

    public void tambahAntrian(String noTiket, String namaPasien, String namaDokter, String inputTanggal){
        if(isFull()){
            System.out.println("Antrian penuh. Silahkan datang di lain hari!");
        }else{
            if (isEmpty()){
                head = 0;
            }
            tail++;
            dataPasien[tail] = noTiket + ", " + namaPasien + ", " + namaDokter + ", " + inputTanggal;
            System.out.println("Data berhasil ditambahkan ke antrian");
            System.out.println();
        }
    }

    public void hapusAntrian(String noTiket){
        if (isEmpty()) {
            System.out.println("Antrian Kosong!");
        } else {
            boolean found = false;
            for (int i = head; i <= tail; i++) {
                if (dataPasien[i].startsWith(noTiket)) {
                    System.out.println(dataPasien[i] + " berhasil dihapus dari antrian");
                    // menggeser data ke kiri untuk menimpa data yang dihapus
                    for (int j = i; j < tail; j++) {
                        dataPasien[j] = dataPasien[j + 1];
                    }
                    tail--;
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println(noTiket + " tidak ditemukan di antrian");
            }
        }

    }

    public void panggilAntrian(){
        if (isEmpty()) {
            System.out.println("Antrian Kosong");
        } else {
            String item = dataPasien[head];
            if (head >= tail) {
                head = -1;
                tail = -1;
            } else {
                head++;
            }
            System.out.println("Antrian " + item + " telah dipanggil.");
        }
    }

    public void cariAntrian(String noTiket){
        if (isEmpty()) {
            System.out.println("Antrian Kosong!");
        } else {
            boolean found = false;
            for (int i = head; i <= tail; i++) {
                if (dataPasien[i].startsWith(this.noTiket)) {
                    System.out.println(dataPasien[i]);
                    found = true;
                }
            }
            if (!found) {
                System.out.println(this.noTiket + " tidak ditemukan di antrian");
            }
        }
    }

    public void tampilAntrian(){
        if (isEmpty()) {
            System.out.println("Antrian Kosong!");
        } else {
            System.out.println("Daftar Antrian: ");
            for (int i = head; i <= tail; i++) {
                System.out.println((i - head + 1) + ". " + dataPasien[i]);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        antrianPasien.menu();
    }
}
