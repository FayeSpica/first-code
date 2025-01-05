package org.faye.bc.bc147;

import java.util.*;

class TaskManager {

    public static class Task {
        public Integer userId;
        public Integer taskId;
        public Integer priority;

        public Task(Task t) {
            this.taskId = t.taskId;
            this.userId = t.userId;
            this.priority = t.priority;
        }

        public Task(Integer taskId) {
            this.taskId = taskId;
        }

        public Task(Integer userId, Integer taskId, Integer priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Task task = (Task) o;
            return Objects.equals(taskId, task.taskId);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(taskId);
        }
    }

    PriorityQueue<Task> taskQueue = new PriorityQueue<>((o1, o2) -> {
        if (Objects.equals(o1.priority, o2.priority)) {
            return o2.taskId.compareTo(o1.taskId);
        } else {
            return o2.priority.compareTo(o1.priority);
        }
    });
    Map<Integer, Task> taskHashMap = new HashMap<>();

    public TaskManager(List<List<Integer>> tasks) {
        taskQueue.clear();
        taskHashMap.clear();
        for (List<Integer> task : tasks) {
            Task t = new Task(task.get(0), task.get(1), task.get(2));
            taskQueue.add(t);
            taskHashMap.put(t.taskId, new Task(t));
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task t = new Task(userId, taskId, priority);
        taskQueue.offer(t);
        taskHashMap.put(taskId, new Task(t));
    }

    public void edit(int taskId, int newPriority) {
        Task t = taskHashMap.get(taskId);
        t.priority = newPriority;
        taskQueue.offer(new Task(t));
    }

    public void rmv(int taskId) {
        taskHashMap.get(taskId).userId = -1;
    }

    public int execTop() {
        while (!taskQueue.isEmpty()) {
            Task pendingTask = taskQueue.poll();
            Task acutalTask = taskHashMap.get(pendingTask.taskId);
            if (acutalTask == null) {
                continue;
            }
            if (Objects.equals(pendingTask.priority, acutalTask.priority) && Objects.equals(pendingTask.userId, acutalTask.userId)) {
                taskHashMap.remove(pendingTask.taskId);
                return acutalTask.userId;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        TaskManager obj = new TaskManager(tasks);
//        obj.add(userId,taskId,priority);
//        obj.edit(taskId,newPriority);
//        obj.rmv(taskId);
//        int param_4 = obj.execTop();
    }
}