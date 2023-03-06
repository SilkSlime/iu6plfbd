package l4;

import java.time.LocalDate;
import java.time.DayOfWeek;
import java.util.HashSet;

public class e1 {
    
    /**
     * Вариант 1. Задача 5.
     * Создать класс Календарь с внутренним классом, с помощью объектов
     * которого можно хранить информацию о выходных и праздничных днях.  
     */

    public static void main(String[] args) {
        Calendar calendar = new Calendar();
        calendar.addHoliday(LocalDate.of(2023, 1, 1)); // New Year's Day
        calendar.addHoliday(LocalDate.of(2023, 1, 16)); // Martin Luther King Jr. Day
        calendar.addHoliday(LocalDate.of(2023, 2, 20)); // Presidents Day
        calendar.addHoliday(LocalDate.of(2023, 5, 29)); // Memorial Day
        calendar.addHoliday(LocalDate.of(2023, 7, 4)); // Independence Day
        calendar.addHoliday(LocalDate.of(2023, 9, 4)); // Labor Day
        calendar.addHoliday(LocalDate.of(2023, 11, 23)); // Thanksgiving
        calendar.addHoliday(LocalDate.of(2023, 12, 25)); // Christmas
        
        LocalDate start = LocalDate.of(2023, 1, 1);
        LocalDate end = LocalDate.of(2023, 12, 31);
        
        Calendar.DayFilter dayFilter = calendar.new DayFilter();
        
        for (LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
            if (dayFilter.isAllowed(date)) {
                System.out.println(date);
            }
        }

    }
}

class Calendar {
    
    private HashSet<LocalDate> holidays;
    
    public Calendar() {
        holidays = new HashSet<LocalDate>();
    }
    
    public void addHoliday(LocalDate date) {
        holidays.add(date);
    }
    
    public boolean isWeekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }
    
    public boolean isHoliday(LocalDate date) {
        return holidays.contains(date);
    }
    
    public class DayFilter {
        public boolean isAllowed(LocalDate date) {
            return !isWeekend(date) && !isHoliday(date);
        }
    }
}