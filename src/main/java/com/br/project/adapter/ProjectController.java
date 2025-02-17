package com.br.project.adapter;

import com.br.project.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping (value="/v2/funcionalidades")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    List<String> sayHellos = Arrays.asList("Oi mundo", "Hello", "Bonjour", "le Monde!", "Ciao", "Mondo", "مرحبا بالعالم!");

    @GetMapping("/all")
    public List<String> todosValores(@RequestParam(required = false, value= "xpto") String filter) {

        if (filter == null || filter.isEmpty()) {
            return sayHellos;
        }

        return sayHellos.contains(filter) ? List.of(filter) : List.of();
    }

    @GetMapping
    public String helloWorld(){
        return projectService.helloWordService();
    }


    @RequestMapping(value = "/all2")
    public ResponseEntity<String> hellos(@RequestParam(required = false) String filtro) {


        for (String hello : sayHellos) {
            if (hello.equalsIgnoreCase(filtro)) {
                return ResponseEntity.ok(hello);
            }
        } return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filtro nao encontrado");

    }

}


