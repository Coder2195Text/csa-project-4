package mod.coder2195.america.utils;

import java.util.ArrayList;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

public class TaskQueue {
    private static boolean registered = false;
    private static class Task {
        private final Runnable task;
        private int ticks;

        public Task(Runnable task, int delay) {
            this.task = task;
            this.ticks = delay;
        }

        public boolean tick() {
            if (ticks > 0) {
                ticks--;
                return false;
            }
            task.run();
            return true;
        }
    }

    private static final ArrayList<Task> tasks = new ArrayList<>();

    public static void queue(Runnable task, int delay) {
        if (!registered) {
            ServerTickEvents.END_SERVER_TICK.register(server -> {
                ArrayList<Task> toRemove = new ArrayList<>();
                for (Task t : tasks) {
                    if (t.tick()) {
                        toRemove.add(t);
                    }
                }
                tasks.removeAll(toRemove);
            });
            registered = true;
        }
        tasks.add(new Task(task, delay));
    }
}
