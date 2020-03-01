package by.bsuir.document.service.dellayformat;

/**
 * @author Vladislav Novitskiy
 */
public interface DelayFormatService {
    /**
     * Method format given number of days as years/months number or as concrete date.
     *
     * @param epochDay TimeUnit seconds since 1970 (start date)
     * @param days     Days number between two dates (delay)
     * @return Formatted line for document
     * @see by.bsuir.document.TagType {@code AN}
     */
    String formatDelay(long epochDay, long days);
}
