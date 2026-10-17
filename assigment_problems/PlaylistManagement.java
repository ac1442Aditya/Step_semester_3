import java.util.Arrays;

class Playlist {
    private String[] songs;
    private int count;

    public Playlist(int maxSize) {
        this.songs = new String[maxSize];
        this.count = 0;
    }

    public void addSong(String title) {
        if (count >= songs.length) {
            System.out.println("Playlist is full, cannot add " + title);
            return;
        }
        songs[count] = title;
        count++;
    }

    // returns a copy so callers cannot touch the real array
    public String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    public int getSongCount() {
        return count;
    }
}

public class PlaylistManagement {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        System.out.println("Songs: " + Arrays.toString(copy));

        copy[0] = "Hacked";
        System.out.println("Modified copy: " + Arrays.toString(copy));
        System.out.println("Playlist still holds: " + Arrays.toString(p.getSongs()));
        System.out.println("Song count: " + p.getSongCount());
    }
}
