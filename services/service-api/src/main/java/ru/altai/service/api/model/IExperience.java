package ru.altai.service.api.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public interface IExperience {

    default java.time.Period getPeriod() {
        LocalDate dateEnd = getDateEnd();
        LocalDate dateStart = getDateStart();
        if (dateStart != null) {
            if (dateEnd == null) dateEnd = LocalDate.now();
            java.time.Period period = java.time.Period.between(dateStart, dateEnd);
            if (period.getDays() > 0 || period.getMonths() > 0 || period.getYears() > 0) {
                return period;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    default void calculateDifference() {
        LocalDate dateEnd = getDateEnd();
        LocalDate dateStart = getDateStart();
        if (dateStart != null) {
            if (dateEnd == null) dateEnd = LocalDate.now();
            Long totalDaysBetween = ChronoUnit.DAYS.between(dateStart, dateEnd);
            Long totalMonthsBetween = ChronoUnit.MONTHS.between(dateStart, dateEnd);
            Long totalYearsBetween = ChronoUnit.YEARS.between(dateStart, dateEnd);
            setDifferenceToDays(totalDaysBetween);
            setDifferenceToMonths(totalMonthsBetween);
            setDifferenceToYears(totalYearsBetween);
        }

    }

    Long getId();

    LocalDate getDateStart();
    LocalDate getDateEnd();

    Long getDifferenceToYears();
    Long getDifferenceToMonths();
    Long getDifferenceToDays();

    void setDifferenceToYears(Long years);
    void setDifferenceToMonths(Long months);
    void setDifferenceToDays(Long days);

}
