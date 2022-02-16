package kz.yamuz.controllers;

import kz.yamuz.domain.Habit;
import kz.yamuz.services.HabitService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HabitController {

    private HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    //ALL HABITS
    @GetMapping("/habits")
    public String listHabits(Model model){
        List<Habit> habitList = habitService.listAllHabits();
        for (Habit h: habitList  ) {
            System.out.println("habit .." + h.getDescription());
        }
        model.addAttribute("habits", habitList);
        return "habits/habit_list";
    }


    //ALL HABITS - needs @RestController annotation
    @GetMapping(value = "/habitsrest", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Habit> listHabitsRest(Model model){
        List<Habit> habitList = habitService.listAllHabits();
        for (Habit h: habitList  ) {
            System.out.println("habit .." + h.getDescription());
        }
        model.addAttribute("habits", habitList);
        return habitList; //"habits/habit_list";
    }

    //NEW
    @GetMapping("/habit/new")
    public String createNewHabit( Model model){
        model.addAttribute("habit", new Habit());
        return "habits/habit_edit_new";
    }

    //EDIT
    @GetMapping("/habits/edit/{id}")
    public String getHabitById(@PathVariable Long id, Model model){
        model.addAttribute("habit", habitService.getHabitById(id));
        return "habits/habit_edit_new";
    }

    //SAVE
    @PostMapping("/habit")
    public String savehabit(Habit habit){
        Habit habitSaved = habitService.saveHabit(habit);
        if (habitSaved == null)
            throw new RuntimeException("unable to save habit");

        System.out.println("habitSaved..." + habitSaved);
        return "redirect:/habits";
    }

    //DELETE
    @GetMapping("/habits/delete/{id}")
    public String deletehabit(@PathVariable Long id){
        habitService.deleteHabit(id);
        return "redirect:/habits";
    }


}
