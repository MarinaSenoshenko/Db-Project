package db.controllers;

import db.repository.SportRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/main/sport")
@AllArgsConstructor
public class SportController {
    private SportRepository sportRepository;

    @GetMapping("")
    public String getAll(Model model) {
        model.addAttribute("sports", sportRepository.findAll());
        return "/pages/sport";
    }

    @GetMapping("/add")
    public String addRank() {
        return "/edit/post/add_sport";
    }

    @GetMapping("/delete")
    public String deleteSportClub(Model model) {
        model.addAttribute("sports", sportRepository.getNotUsedInOtherTablesSports());
        return "/edit/delete/delete_sport";
    }

    @GetMapping("/update")
    public String updateSportClub(Model model) {
        model.addAttribute("sports", sportRepository.findAll(
                Sort.by(Sort.Direction.ASC, "id")
        ));
        return "/edit/update/update_sport";
    }
}
