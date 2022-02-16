package kz.yamuz.services;

import kz.yamuz.domain.Habit;
import kz.yamuz.repositories.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class HabitServiceImpl implements HabitService {

    @Autowired
    HabitRepository habitRepository;

    @Override
    public List<Habit> listAllHabits() {
        return habitRepository.findAll();
    }

    @Override
    public Habit getHabitById(Long id) {
        Optional<Habit> optional =habitRepository.findById(id);
        if (optional.isEmpty())
            throw  new RuntimeException("No such habit with id : " + id);

        return optional.get();
    }

    @Transactional
    @Override
    public Habit saveHabit(Habit habit) {
        Habit habitSaved = null;
        try {
             habitSaved = habitRepository.save(habit);
         } catch (Exception e){
             e.printStackTrace();
         }
         return habitSaved;
    }

    @Override
    public void deleteHabit(Long id) {
        habitRepository.deleteById(id);
    }
}
