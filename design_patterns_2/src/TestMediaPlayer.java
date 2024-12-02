// Target Interface
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Concrete Adaptee Classes
class AdvancedMediaPlayer {
    public void playVlc(String fileName) {
        System.out.println("Playing VLC file: " + fileName);
    }

    public void playMp4(String fileName) {
        System.out.println("Playing MP4 file: " + fileName);
    }
}

// Adapter Class
class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer;
    public MediaAdapter(AdvancedMediaPlayer advancedMediaPlayer) {
        this.advancedMediaPlayer = advancedMediaPlayer;
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}

// Client Code
public class TestMediaPlayer {
    public static void main(String[] args) {
        AdvancedMediaPlayer advancedMediaPlayer = new AdvancedMediaPlayer();
        MediaAdapter mediaAdapter = new MediaAdapter(advancedMediaPlayer);

        mediaAdapter.play("mp3", "song.mp3");
        mediaAdapter.play("mp4", "video.mp4");
        mediaAdapter.play("vlc", "movie.vlc");
        mediaAdapter.play("avi", "example.avi");
    }
}
