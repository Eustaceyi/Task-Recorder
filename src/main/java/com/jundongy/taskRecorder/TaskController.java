package com.jundongy.taskRecorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @GetMapping()
    public String task() {
        return "this is task page";
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return repository.findAll();
    }

    @PostMapping("/create")
    public Task addTask(@RequestParam("owner") String owner,
                        @RequestParam("description") String description) {
        Task task = new Task();
        task.setOwner(owner);
        task.setStatus(false);
        task.setDescription(description);
        task.setCurrDate(new Date());
        return repository.save(task);
    }

    @PutMapping("/finish/{id}")
    public Task finishTask(@PathVariable("id") Integer id) {
        Optional<Task> optional = repository.findById(id);
        if (optional.isPresent()) {
            Task task = optional.get();
            task.setStatus(true);

            return repository.save(task);
        }

        return null;
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable("id") Integer id) {
        return repository.findById(id).orElse(null);
    }

    @GetMapping("/owner")
    public List<Task> getTaskByOwner(@RequestParam("owner") String owner) {
        List<Task> tasks = repository.findAll();
        List<Task> results = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getOwner().equals(owner)) {
                results.add(task);
            }
        }
        return results;
    }

    @PutMapping("/delete/{id}")
    public void deleteTask(@PathVariable("id") Integer id) {
        Optional<Task> optionalTask =  repository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            repository.delete(task);
        }
    }
}
