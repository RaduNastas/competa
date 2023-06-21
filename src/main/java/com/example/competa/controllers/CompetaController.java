package com.example.competa.controllers;

import com.example.competa.models.Competa;
import com.example.competa.repo.CompetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Controller
public class CompetaController {

    @Autowired
    private CompetaRepository competaRepository;

    @GetMapping ("/competa") // переход на страницу
    public String competaMain (Model model){
        Iterable<Competa> competas = competaRepository.findAll();
        model.addAttribute("competas", competas);
        return "competa-main"; // вызывается шаблон
    }

    @GetMapping ("/competa/add")  // переход на страницу
    public String competaAdd (Model model){
        return "competa-add";  // вызывается шаблон
    }

    @PostMapping("/competa/add")
    public String competaAdd(@RequestParam("competa_type") String competa_type, @RequestParam("title") String title, @RequestParam("description") String description, @RequestParam("dateOut") @DateTimeFormat(pattern = "yyyy-mm-dd") Date dateOut, @RequestParam ("status") boolean status, Model model) {
        Competa competa = new Competa(title, description, competa_type, dateOut, status);
        competa.setTitel(title);
        competa.setDescription(description);
        competa.setCompeta_type(competa_type);
        competa.setDateOut(dateOut);
        competa.setStatus(status);
        competaRepository.save(competa);
        return "redirect:/competa"; // переход на страницу
    }

    @GetMapping ("/competa/{id}")  // переход на страницу
    public String competaDetails (@PathVariable(value ="id") long id, Model model){
        if(!competaRepository.existsById(id)){ // если не нашли в репозитории по id
            return "redirect:/competa";//  вернулись на страницу
        }
        Optional<Competa> competa = competaRepository.findById(id); // в классе Optional создали экземпляр
        ArrayList<Competa> res = new ArrayList<>(); // поместили находку в ArrayList
        competa.ifPresent(res::add); // перенесли объект
        model.addAttribute("competa", res);
        return "competa-details";
    }

    @GetMapping("/competa/{id}/edit")
    public String competaEdit( @PathVariable(value = "id") long id, Model model) {
        if(!competaRepository.existsById(id)){
            return "redirect:/competa";
        }
        Optional<Competa> competa = competaRepository.findById(id);
        ArrayList<Competa> res = new ArrayList<>();
        competa.ifPresent(res::add);
        model.addAttribute("competa", res);
        return "competa-edit";
    }

    @PostMapping("/competa/{id}/edit")
    public String competaUpdate(@PathVariable(value = "id") long id, @RequestParam ("competa_type") String competa_type, @RequestParam ("title") String title, @RequestParam("description") String description, @RequestParam("dateOut") @DateTimeFormat(pattern = "yyyy-mm-dd") Date dateOut, @RequestParam ("status") boolean status, Model model) {
        Competa competa = competaRepository.findById(id).orElseThrow();
        competa.setTitel(title);
        competa.setDescription(description);
        competa.setCompeta_type(competa_type);
        competa.setDateOut(dateOut);
        competa.setStatus(status);
        competaRepository.save(competa);
        return "redirect:/competa";
    }

    @PostMapping("/competa/{id}/remove")
    public String competaDelete(@PathVariable(value = "id") long id, Model model) {
        Competa competa = competaRepository.findById(id).orElseThrow();
        competaRepository.delete(competa);
        return "redirect:/competa";
    }
}
