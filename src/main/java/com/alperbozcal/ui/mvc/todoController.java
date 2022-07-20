package com.alperbozcal.ui.mvc;

import com.alperbozcal.business.dto.todoDto;
import com.alperbozcal.data.entity.todoEntity;
import com.alperbozcal.data.repository.ItodoRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@Log4j2
public class todoController {

    @Autowired
    ItodoRepository repository;


    //http://localhost:8080/ToDo/save
    @GetMapping("ToDo/save")
    public String getForma(Model model, Model model1) {
        model.addAttribute("todo_save", new todoDto());

        List<todoEntity> list = repository.findAll();
        model1.addAttribute("todom_key", list);
        return "todoSave";
    }

    //http://localhost:8080/ToDo/save
    @PostMapping("ToDo/save")
    public String postForma(@Valid @ModelAttribute("todo_save") todoDto TodoDto, Model model1) {

        todoEntity TodoEntity = new todoEntity();
        TodoEntity.setTodoName(TodoDto.getTodoName());
        repository.save(TodoEntity);

        List<todoEntity> list = repository.findAll();
        model1.addAttribute("todom_key", list);
        return "todoSave";
    }


    @GetMapping("delete/ToDo/{id}")
    public String deleteToDoById(@PathVariable(name = "id") Long id, Model model) {
        Optional<todoEntity> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
            model.addAttribute("delete_success", optionalEntity.get());
            repository.deleteById(id);
        } else {
            model.addAttribute("failed", "Silinmedi");
        }
        return "redirect:/ToDo/save";
    }


    @GetMapping ("update/ToDo/{id}")
    public String updateToDo(@ModelAttribute("todo_update") @PathVariable(name = "id") Long id, Model model) {
        Optional<todoEntity> optionalTodoDto = repository.findById(id);
        model.addAttribute("update_me",optionalTodoDto.get());
        return "ToDoUpdate";
    }

    @PostMapping("update/ToDo/{id}")
    public String GetUpdateTodo(@Valid @ModelAttribute("todo_update") @PathVariable(name = "id") Long id, Model model)
    {
        todoEntity entity= repository.getById(id);
        entity.setTodoName(entity.getTodoName());
        repository.save(entity);
        model.addAttribute("update_me",entity);
        return "redirect:/ToDo/save";
    }
}


