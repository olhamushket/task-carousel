package com.epam.rd.autotasks;

import java.util.ArrayList;

public class TaskCarousel {
    private final ArrayList<Task> tasks = new ArrayList<>();
    private int counter = 0;
    private final int COUNTER_MAX;
    public TaskCarousel(int capacity) {
        if (capacity <= 0) {
            throw new UnsupportedOperationException();
        }
        COUNTER_MAX = capacity;

    }
    public boolean addTask(Task task) {
//        throw new UnsupportedOperationException();
   if (!isFull()&&!task.isFinished()) {
       tasks.add(task);
       return true;
   }
   return false;
    }

    public boolean execute() {
//        throw new UnsupportedOperationException();
        if (isEmpty()) {                        //Carousel is Empty
            return false;
        }
        isEnd();
        tasks.get(counter).execute();
        if (tasks.get(counter).isFinished()) {      //deleting of finished task
            tasks.remove(counter);
        } else {
            counter++;
        }
        return true;
    }

    public boolean isFull() {
//        throw new UnsupportedOperationException();
        return tasks.size() == COUNTER_MAX;
    }

    public boolean isEmpty() {
//        throw new UnsupportedOperationException();
        return tasks.size() == 0;
    }
    private void isEnd() {
        if (counter >= tasks.size()) {      //execution by circle
            counter = 0;
        }
    }
}
