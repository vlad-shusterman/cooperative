package by.bsuir.registry.service;

import by.bsuir.registry.exceptions.DataManipulateException;
import com.mongodb.lang.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collection;
import java.util.function.Predicate;

// Delete is unsupported by BaseManager due to history logic.
@ParametersAreNonnullByDefault
public interface BaseManager<T> {

    @Nullable
    T find(String id) throws DataManipulateException;

    Collection<T> find(Collection<String> ids) throws DataManipulateException;

    Collection<T> find(Predicate<T> predicate) throws DataManipulateException;

    Collection<T> find(Predicate<T> predicate, int page, int limit) throws DataManipulateException;

    Collection<T> findAll() throws DataManipulateException;

    Collection<T> findAll(int page, int limit) throws DataManipulateException;

    T register(T t) throws DataManipulateException;

    T update(T t) throws DataManipulateException;

}
