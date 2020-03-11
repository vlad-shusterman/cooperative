package by.bsuir.document.service.tag.impl;

import by.bsuir.document.service.tag.DelayFormatService;
import com.ibm.icu.text.RuleBasedNumberFormat;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author Vladislav Novitskiy
 */
@AllArgsConstructor
@Service
public class DelayFormatServiceImpl implements DelayFormatService {
    private RuleBasedNumberFormat textNumberFormatter;
    private DateTimeFormatter dateTimeFormatter;

    @Override
    public String formatDelay(long epochDay, long days) {
        LocalDate startDay = LocalDate.ofEpochDay(epochDay);
        LocalDate endDay = startDay.plus(days, ChronoUnit.DAYS);

        Period period = Period.between(startDay, endDay);
        int years = period.getYears();
        int months = period.getMonths();
        if (years != 0 && months == 0 && days == 0) {
            return "на " + years + " (" + textNumberFormatter.format(years) + ") " + getYearWord(years);
        } else if ((months == 1 || months == 3 || months == 6) && days == 0) {
            return "на " + months + " (" + textNumberFormatter.format(months) + ") " + getMonthWord(months);
        } else {
            return "до " + endDay.format(dateTimeFormatter);
        }
    }

    private String getYearWord(long number) {
        if (number < 1) {
            throw new IllegalArgumentException();
        }

        if (number == 1) {
            return "год";
        } else if (number < 5) {
            return "года";
        } else {
            return "лет";
        }
    }

    private String getMonthWord(long number) {
        if (number < 1) {
            throw new IllegalArgumentException();
        }

        if (number == 1) {
            return "месяц";
        } else if (number < 5) {
            return "месяца";
        } else {
            return "месяцев";
        }
    }
}
