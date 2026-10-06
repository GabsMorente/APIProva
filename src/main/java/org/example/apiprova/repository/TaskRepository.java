package org.example.apiprova.repository;


import org.example.apiprova.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class TaskRepository {

    private final List<Task> tasks = new ArrayList<>();

    private final AtomicInteger nextId = new AtomicInteger(1);

    public Task save(Task task) {
        task.setId(nextId.getAndIncrement());
        tasks.add(task);
        return task;
    }

    public List<Task> findAll() {
        return tasks;
    }

    public Task findById(Integer id) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void delete(Task task) {
        tasks.remove(task);
    }
}