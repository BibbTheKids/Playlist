// Kelas Passenger
class Passenger {
    String name;         // Nama penumpang
    Passenger next;     // Pointer ke penumpang berikutnya

    // Konstruktor untuk inisialisasi nama penumpang
    Passenger(String name) {
        this.name = name;
        this.next = null;
    }
}

// Kelas Flight
class Flight {
    private Passenger head; // Kepala dari linked list penumpang

    // Konstruktor untuk inisialisasi daftar penumpang
    public Flight() {
        this.head = null;
    }

    // Metode untuk menambah penumpang di akhir daftar
    public void addPassenger(String name) {
        Passenger newPassenger = new Passenger(name); // Membuat penumpang baru
        if (head == null) { // Jika daftar penumpang kosong
            head = newPassenger; // Penumpang baru menjadi kepala
        } else {
            Passenger current = head;
            // Menelusuri hingga penumpang terakhir
            while (current.next != null) {
                current = current.next;
            }
            current.next = newPassenger; // Menambahkan penumpang baru di akhir
        }
    }

    // Metode untuk menghapus penumpang berdasarkan nama
    public void removePassenger(String name) {
        if (head == null) return; // Jika daftar kosong, tidak ada yang dihapus

        // Jika penumpang yang ingin dihapus adalah kepala
        if (head.name.equals(name)) {
            head = head.next; // Mengubah kepala ke penumpang berikutnya
            return;
        }

        Passenger current = head;
        // Menelusuri daftar untuk menemukan penumpang yang ingin dihapus
        while (current.next != null) {
            if (current.next.name.equals(name)) {
                current.next = current.next.next; // Menghapus penumpang
                return;
            }
            current = current.next;
        }
    }

    // Metode untuk menampilkan semua penumpang
    public void displayPassengers() {
        Passenger current = head; // Memulai dari kepala
        while (current != null) {
            System.out.println(current.name); // Menampilkan nama penumpang
            current = current.next; // Melanjutkan ke penumpang berikutnya
        }
    }
}

// Contoh penggunaan
public class PenumpangPesawat {
    public static void main(String[] args) {
        Flight flight = new Flight(); // Membuat instance Flight
        flight.addPassenger("Habib"); // Menambah penumpang
        flight.addPassenger("Apri");
        flight.addPassenger("Faad");

        System.out.println("Daftar Penumpang:");
        flight.displayPassengers(); // Menampilkan semua penumpang

        // Menghapus penumpang
        flight.removePassenger("Opuk");
        System.out.println("\nSetelah menghapus Opuk:");
        flight.displayPassengers(); // Menampilkan daftar penumpang setelah penghapusan
    }
}
