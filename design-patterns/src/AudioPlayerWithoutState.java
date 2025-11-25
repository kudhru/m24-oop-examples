public class AudioPlayerWithoutState {

    enum State {
        STOPPED, PLAYING, PAUSED
    }

    static class AudioPlayer {
        private State currentState = State.STOPPED;

        public void clickPlay() {
            switch (currentState) {
                case STOPPED:
                    System.out.println("Starting playback");
                    currentState = State.PLAYING;
                    break;
                case PLAYING:
                    System.out.println("Already playing");
                    break;
                case PAUSED:
                    System.out.println("Resuming playback");
                    currentState = State.PLAYING;
                    break;
            }
        }

        public void clickPause() {
            switch (currentState) {
                case STOPPED:
                    System.out.println("Can't pause, player is stopped");
                    break;
                case PLAYING:
                    System.out.println("Pausing playback");
                    currentState = State.PAUSED;
                    break;
                case PAUSED:
                    System.out.println("Already paused");
                    break;
            }
        }

        public void clickStop() {
            switch (currentState) {
                case STOPPED:
                    System.out.println("Already stopped");
                    break;
                case PLAYING:
                case PAUSED:
                    System.out.println("Stopping playback");
                    currentState = State.STOPPED;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();
        player.clickPlay();   // START
        player.clickPause();  // PAUSE
        player.clickPlay();   // RESUME
        player.clickStop();   // STOP
        player.clickPause();  // invalid
    }
}
