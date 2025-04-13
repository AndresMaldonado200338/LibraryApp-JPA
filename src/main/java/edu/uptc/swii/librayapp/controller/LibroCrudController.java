package edu.uptc.swii.librayapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.uptc.swii.librayapp.domain.Editorial;
import edu.uptc.swii.librayapp.domain.Libro;
import edu.uptc.swii.librayapp.service.EditorialService;
import edu.uptc.swii.librayapp.service.LibroService;

@Controller
@RequestMapping("/libros")
public class LibroCrudController {
   
    private final LibroService libroService;
    private final EditorialService editorialService;

    public LibroCrudController(LibroService libroService, EditorialService editorialService) {
        this.libroService = libroService;
        this.editorialService = editorialService;
    }

    @GetMapping("/crear")
    public String mostrarFormAlta(Model model) {
        model.addAttribute("libro", new Libro());
        model.addAttribute("editoriales", editorialService.buscarTodos());
        return "form-libro";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Libro libro, @RequestParam("editorial.id") Integer editorialId) {
        Editorial editorial = editorialService.buscarPorId(editorialId);
        libro.setEditorial(editorial);
        libroService.guardar(libro);
        return "redirect:/";
    }
}