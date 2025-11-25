public class AudioPlayerWithState {

    // ----- State interface -----
    interface PlayerState {
        void clickPlay(AudioPlayer player);
        void clickPause(AudioPlayer player);
        void clickStop(AudioPlayer player);
    }

    // ----- Context class -----
    static class AudioPlayer {
        private PlayerState state;

        public AudioPlayer() {
            // initial state
            this.state = new StoppedState();
        }

        // allow states to change the current state
        public void setState(PlayerState state) {
            this.state = state;
        }

        // public API – delegate to current state
        public void clickPlay() {
            state.clickPlay(this);
        }

        public void clickPause() {
            state.clickPause(this);
        }

        public void clickStop() {
            state.clickStop(this);
        }
    }

    // ----- Concrete States -----

    static class StoppedState implements PlayerState {

        @Override
        public void clickPlay(AudioPlayer player) {
            System.out.println("[Stopped] -> Starting playback");
            player.setState(new PlayingState());
        }

        @Override
        public void clickPause(AudioPlayer player) {
            System.out.println("[Stopped] -> Can't pause, player is stopped");
        }

        @Override
        public void clickStop(AudioPlayer player) {
            System.out.println("[Stopped] -> Already stopped");
        }
    }

    static class PlayingState implements PlayerState {

        @Override
        public void clickPlay(AudioPlayer player) {
            System.out.println("[Playing] -> Already playing");
        }

        @Override
        public void clickPause(AudioPlayer player) {
            System.out.println("[Playing] -> Pausing playback");
            player.setState(new PausedState());
        }

        @Override
        public void clickStop(AudioPlayer player) {
            System.out.println("[Playing] -> Stopping playback");
            player.setState(new StoppedState());
        }
    }

    static class PausedState implements PlayerState {

        @Override
        public void clickPlay(AudioPlayer player) {
            System.out.println("[Paused] -> Resuming playback");
            player.setState(new PlayingState());
        }

        @Override
        public void clickPause(AudioPlayer player) {
            System.out.println("[Paused] -> Already paused");
        }

        @Override
        public void clickStop(AudioPlayer player) {
            System.out.println("[Paused] -> Stopping from pause");
            player.setState(new StoppedState());
        }
    }

    // ----- Client demo -----
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();

        player.clickPlay();   // Stopped -> Playing
        player.clickPause();  // Playing -> Paused
        player.clickPlay();   // Paused -> Playing
        player.clickStop();   // Playing -> Stopped
        player.clickPause();  // Stopped -> invalid
    }
}
