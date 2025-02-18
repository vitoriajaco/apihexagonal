package com.br.project.core.usecase.impl;

import com.br.project.core.usecase.port.ProjectServicePort;
import com.br.project.core.usecase.port.ProjectUseCase;
import org.springframework.stereotype.Service;

@Service
public class ProjectUseCaseImpl implements ProjectUseCase {

    private final ProjectServicePort projectServicePort;

    public ProjectUseCaseImpl(ProjectServicePort projectServicePort) {
        this.projectServicePort = projectServicePort;
    }


    @Override
    public String process() {
        return projectServicePort.teste("Funciona");
    }
}
