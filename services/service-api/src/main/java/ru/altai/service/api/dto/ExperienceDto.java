package ru.altai.service.api.dto;

import org.springframework.format.annotation.DateTimeFormat;
import ru.altai.service.api.model.IExperience;

import java.time.LocalDate;
import java.util.Objects;

public class ExperienceDto implements IExperience {

    private Long id;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate dateStart;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate dateEnd;

    private Long differenceToYears;

    private Long differenceToMonths;

    private Long differenceToDays;

    public ExperienceDto() { }

    public ExperienceDto(LocalDate dateStart, LocalDate dateEnd) {
        setDateStart(dateStart);
        setDateEnd(dateEnd);
    }

    @Override
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public LocalDate getDateStart() {
        return dateStart;
    }
    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
        calculateDifference();
    }

    @Override
    public LocalDate getDateEnd() {
        return dateEnd;
    }
    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
        calculateDifference();
    }

    @Override
    public Long getDifferenceToYears() {
        return differenceToYears;
    }
    @Override
    public void setDifferenceToYears(Long differenceToYears) {
        this.differenceToYears = differenceToYears;
    }

    @Override
    public Long getDifferenceToMonths() {
        return differenceToMonths;
    }
    @Override
    public void setDifferenceToMonths(Long differenceToMonths) {
        this.differenceToMonths = differenceToMonths;
    }

    @Override
    public Long getDifferenceToDays() {
        return differenceToDays;
    }
    @Override
    public void setDifferenceToDays(Long differenceToDays) {
        this.differenceToDays = differenceToDays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExperienceDto that = (ExperienceDto) o;
        return Objects.equals(dateStart, that.dateStart) &&
                Objects.equals(dateEnd, that.dateEnd) &&
                Objects.equals(differenceToYears, that.differenceToYears) &&
                Objects.equals(differenceToMonths, that.differenceToMonths) &&
                Objects.equals(differenceToDays, that.differenceToDays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateStart, dateEnd, differenceToYears, differenceToMonths, differenceToDays);
    }
}
