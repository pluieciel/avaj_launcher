package avajLauncher;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private final List<Flyable> observers;

    public Tower() {
        this.observers = new ArrayList<Flyable>();
    }

    public void register(Flyable flyable) {
        observers.add(flyable); }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionChanged() throws InvalidMethodException {
        for (int i = observers.size() - 1; i >= 0; i--) {
            observers.get(i).updateConditions();
        }
    }
}