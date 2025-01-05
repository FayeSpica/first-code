package org.faye.bc.bc147;

import java.util.*;

class TaskManager {

    public static class Task {
        public Integer userId;
        public Integer taskId;
        public Integer priority;

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
    Map<Integer, Integer> taskIdUserIdMap = new HashMap<>();

    public TaskManager(List<List<Integer>> tasks) {
        taskQueue.clear();
        taskIdUserIdMap.clear();
        for (List<Integer> task : tasks) {
            taskQueue.add(new Task(task.get(0), task.get(1), task.get(2)));
            taskIdUserIdMap.put(task.get(1), task.get(0));
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskQueue.add(new Task(userId, taskId, priority));
        taskIdUserIdMap.put(taskId, userId);
    }

    public void edit(int taskId, int newPriority) {
        Task newTask = new Task(taskIdUserIdMap.get(taskId), taskId, newPriority);
        taskQueue.remove(newTask);
        taskQueue.add(newTask);
    }

    public void rmv(int taskId) {
        taskQueue.remove(new Task(taskId));
        taskIdUserIdMap.remove(taskId);
    }

    public int execTop() {
        if (taskQueue.isEmpty()) {
            return -1;
        }
        Task pendingTask = taskQueue.poll();
        taskIdUserIdMap.remove(pendingTask.taskId);
        return pendingTask.userId;
    }

    public static void main(String[] args) {
//        TaskManager obj = new TaskManager(tasks);
//        obj.add(userId,taskId,priority);
//        obj.edit(taskId,newPriority);
//        obj.rmv(taskId);
//        int param_4 = obj.execTop();
    }
}