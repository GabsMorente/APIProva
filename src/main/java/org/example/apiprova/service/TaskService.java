package org.example.apiprova.service;

import org.springframework.stereotype.Service;

import org.example.apiprova.model.Task;
import org.example.apiprova.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task create(Task task) {
        return repository.save(task);
    }

    public List<Task> findAll() {
        return repository.findAll();
    }

    public Task findById(Integer id) {
        return repository.findById(id);
    }

    public Task update(Integer id, Task task) {

        Task existing = repository.findById(id);

        if (existing == null) {
            return null;
        }

        if (task.getTitulo() != null) {
            existing.setTitulo(task.getTitulo());
        }

        if (task.getDescricao() != null) {
            existing.setDescricao(task.getDescricao());
        }

        existing.setConcluida(task.isConcluida());

        return existing;
    }

    public boolean delete(Integer id) {

        Task existing = repository.findById(id);

        if (existing == null) {
            return false;
        }

        repository.delete(existing);

        return true;
    }
}