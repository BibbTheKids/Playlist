class Song {
    String title; // Judul lagu
    Song next;    // Pointer ke lagu berikutnya

    // Konstruktor untuk inisialisasi judul lagu
    Song(String title) {
        this.title = title;
        this.next = null;
    }
}

// Kelas Playlist
class Playlist {
    private Song head; // Kepala dari linked list

    // Konstruktor untuk inisialisasi playlist
    public Playlist() {
        this.head = null;
    }

    // Metode untuk menambah lagu di akhir playlist
    public void addSong(String title) {
        Song newSong = new Song(title); // Membuat node baru
        if (head == null) { // Jika playlist kosong
            head = newSong; // Node baru menjadi kepala
        } else {
            Song current = head;
            // Menelusuri hingga node terakhir
            while (current.next != null) {
                current = current.next;
            }
            current.next = newSong; // Menambahkan node baru di akhir
        }
    }

    // Metode untuk menampilkan semua lagu dalam playlist
    public void displayPlaylist() {
        Song current = head; // Memulai dari kepala
        while (current != null) {
            System.out.println(current.title); // Menampilkan judul lagu
            current = current.next; // Melanjutkan ke node berikutnya
        }
    }


    // Contoh penggunaan
    public static void main(String[] args) {
        Playlist playlist = new Playlist(); // Membuat instance Playlist
        playlist.addSong("Lagu 1"); // Menambah lagu
        playlist.addSong("Lagu 2");
        playlist.addSong("Lagu 3");

        // Menampilkan semua lagu
        playlist.displayPlaylist();
    }
}
