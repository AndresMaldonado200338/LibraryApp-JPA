package edu.uptc.swii.librayapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uptc.swii.librayapp.domain.Editorial;

public interface EditorialRepository extends JpaRepository<Editorial, Integer> {
    
}
