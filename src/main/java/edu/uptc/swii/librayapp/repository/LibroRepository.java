package edu.uptc.swii.librayapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.uptc.swii.librayapp.domain.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
    @Query("from Libro l order by l.nombre")
    List<Libro> buscarTodos();

    @Query("from Libro l where l.editorial.id = ?1 order by l.nombre")
    List<Libro> buscarPorEditorial(int idEditorial);

    @Query("from Libro l where l.nombre like %?1%")
    List<Libro> buscar(String consulta);
}
