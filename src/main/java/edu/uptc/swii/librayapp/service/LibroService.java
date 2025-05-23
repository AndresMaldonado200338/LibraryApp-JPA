package edu.uptc.swii.librayapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.uptc.swii.librayapp.domain.Libro;
import edu.uptc.swii.librayapp.repository.LibroRepository;

@Service
public class LibroService {
    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> buscarDestacados() {
        return libroRepository.buscarTodos();
    }

    public List<Libro> buscarPorEditorial(int editorialId) {
        return libroRepository.buscarPorEditorial(editorialId);
    }

    public List<Libro> buscar(String consulta) {
        return libroRepository.buscar(consulta);
    }

    public void guardar(Libro libro) {
        libroRepository.save(libro);
    }
}