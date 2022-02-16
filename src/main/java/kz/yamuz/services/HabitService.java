package kz.yamuz.services;

import kz.yamuz.domain.Habit;

import java.util.List;

public interface HabitService {
    List<Habit> listAllHabits();

    Habit getHabitById(Long id);

    Habit saveHabit(Habit habit);

    void deleteHabit(Long id);
}
