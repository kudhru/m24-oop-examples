

// 1. Event/Observer Interface

import java.util.ArrayList;
import java.util.List;

interface GameEventListener {
    void onPlayerEvent(String eventType, String message);
}

// 2. Subject (Player Class)
class Player {
    private List<GameEventListener> listeners = new ArrayList<>();
    private int level = 1;

    public void addListener(GameEventListener listener) {
        listeners.add(listener);
    }

    public void removeListener(GameEventListener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners(String eventType, String message) {
        for (GameEventListener listener : listeners) {
            listener.onPlayerEvent(eventType, message);
        }
    }

    public void levelUp() {
        level++;
        System.out.println("\nPlayer Leveled Up to Lvl " + level + "!");
        notifyListeners("LEVEL_UP", "Player reached level " + level);
    }

    public void takeDamage(int amount) {
        System.out.println("Player took " + amount + " damage.");
        notifyListeners("DAMAGE_TAKEN", "Player health dropped.");
    }
}

// 3. Concrete Observer A (Achievements Manager)
class AchievementsManager implements GameEventListener {
    @Override
    public void onPlayerEvent(String eventType, String message) {
        if (eventType.equals("LEVEL_UP")) {
            System.out.println("[Achievement Manager]: Checking for 'Level " + message.split(" ")[2] + "' achievement!");
        }
    }
}

// 4. Concrete Observer B (Sound Manager)
class SoundManager implements GameEventListener {
    @Override
    public void onPlayerEvent(String eventType, String message) {
        if (eventType.equals("DAMAGE_TAKEN")) {
            System.out.println("[Sound Manager]: Playing 'ouch' sound effect.");
        } else if (eventType.equals("LEVEL_UP")) {
            System.out.println("[Sound Manager]: Playing 'fanfare' sound effect.");
        }
    }
}

// 5. Demo
public class ObserverExample3 {
    public static void main(String[] args) {
        Player player = new Player();
        AchievementsManager achManager = new AchievementsManager();
        SoundManager soundManager = new SoundManager();

        player.addListener(achManager);
        player.addListener(soundManager);

        player.levelUp(); // Triggers two different actions in separate classes

        player.takeDamage(10); // Triggers only the sound manager action
    }
}
