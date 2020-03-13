package by.bsuir.rest.document.populator;

/**
 * @author Vladislav Novitskiy
 */
public interface DataPopulator<SOURCE, TARGET> {
    void populate(SOURCE source, TARGET target);
}
