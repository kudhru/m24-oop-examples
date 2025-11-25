public class MediaAdapterExample {

    // ===== Target interface =====
    interface MediaPlayer {
        void play(String fileName);
    }

    // ===== Adaptees (existing/3rd-party players) =====
    static class VlcPlayer {
        void playVlc(String fileName) {
            System.out.println("Playing VLC file: " + fileName);
        }
    }

    static class Mp4Player {
        void playMp4(String fileName) {
            System.out.println("Playing MP4 file: " + fileName);
        }
    }

    // ===== Object Adapter: one adapter, multiple adaptees inside =====
    static class AudioPlayer implements MediaPlayer {

        private final VlcPlayer vlcPlayer = new VlcPlayer();
        private final Mp4Player mp4Player = new Mp4Player();

        @Override
        public void play(String fileName) {
            if (fileName == null || !fileName.contains(".")) {
                System.out.println("Invalid file: " + fileName);
                return;
            }

            String extension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();

            switch (extension) {
                case "vlc":
                    vlcPlayer.playVlc(fileName); // delegate to adaptee
                    break;
                case "mp4":
                    mp4Player.playMp4(fileName); // delegate to adaptee
                    break;
                default:
                    System.out.println("Unsupported format: " + extension);
            }
        }
    }

    // ===== Client code =====
    public static void main(String[] args) {
        MediaPlayer player = new AudioPlayer();

        player.play("song.vlc");
        player.play("movie.mp4");
        player.play("image.png");
    }
}
