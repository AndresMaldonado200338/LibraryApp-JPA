package edu.uptc.swii.librayapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.uptc.swii.librayapp.domain.Editorial;
import edu.uptc.swii.librayapp.repository.EditorialRepository;

@Service
public class EditorialService {
    private final EditorialRepository editorialRepository;

    public EditorialService(EditorialRepository editorialRepository) {
        this.editorialRepository = editorialRepository;
    }

    public List<Editorial> buscarTodos() {
        return editorialRepository.findAll();
    }

    public Editorial buscarPorId(Integer id) {
        return editorialRepository.findById(id).orElseThrow();
    }
}
