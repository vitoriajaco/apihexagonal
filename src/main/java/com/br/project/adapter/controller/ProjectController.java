package com.br.project.adapter.controller;


import com.br.project.core.usecase.port.ProjectUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping (value="/v2/funcionalidades")
public class ProjectController {

   private final ProjectUseCase projectUseCase;

    List<String> sayHellos = Arrays.asList("Oi mundo", "Hello", "Bonjour", "le Monde!", "Ciao", "Mondo", "مرحبا بالعالم!");

    public ProjectController(ProjectUseCase projectUseCase) {
        this.projectUseCase = projectUseCase;
    }

    @GetMapping("/all")
    public String todosValores(@RequestParam(required = false, value= "xpto") String filter) {

        if (filter == null || filter.isEmpty()) {
            return sayHellos.get(1);
        }

      /*  return sayHellos.contains(filter) ? List.of(filter) : List.of()*/;
      return projectUseCase.process();
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


