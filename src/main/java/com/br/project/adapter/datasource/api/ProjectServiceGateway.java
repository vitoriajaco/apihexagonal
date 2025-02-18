package com.br.project.adapter.datasource.api;

import com.br.project.core.usecase.port.ProjectServicePort;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceGateway implements ProjectServicePort {
    @Override
    public String teste(String teste) {
        return "Funciona tambem";
    }
}
