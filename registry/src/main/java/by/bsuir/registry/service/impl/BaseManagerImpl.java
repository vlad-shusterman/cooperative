package by.bsuir.registry.service.impl;

import by.bsuir.registry.exceptions.DataManipulateException;
import by.bsuir.registry.service.BaseManager;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collection;
import java.util.function.Predicate;

@ParametersAreNonnullByDefault
public abstract class BaseManagerImpl<Y extends MongoRepository<T, String>, T> implements BaseManager<T> {

    private final static int FILTER_PAGE = 500;

    protected final Y mongoRepository;

    public BaseManagerImpl(Y mongoRepository) {
        this.mongoRepository = mongoRepository;
    }

    @Override
    public T find(String id) throws DataManipulateException {
        return mongoRepository.findById(id).orElse(null);
    }

    @Override
    public Collection<T> find(Collection<String> ids) throws DataManipulateException {
        return Lists.newArrayList(mongoRepository.findAllById(ids));
    }

    @Override
    public Collection<T> find(Predicate<T> predicate) throws DataManipulateException {
        ImmutableList.Builder<T> builder = ImmutableList.builder();
        int page = 0;
        Collection<T> res = findAll(page, FILTER_PAGE);
        while (!res.isEmpty()) {
            for (T t : res) {
                if (predicate.test(t)) {
                    builder.add(t);
                }
            }
            res = findAll(++page, FILTER_PAGE);
        }
        return builder.build();
    }

    @Override
    public Collection<T> find(Predicate<T> predicate, int page, int limit) throws DataManipulateException {
        Preconditions.checkArgument(limit > 0 && page >= 0);
        ImmutableList.Builder<T> builder = ImmutableList.builder();
        int localPage = 0;
        int count = 0;
        Collection<T> res = findAll(localPage, FILTER_PAGE);
        while (!res.isEmpty() || count <= limit * (page - 1) + limit) {
            for (T t : res) {
                boolean acceptable = predicate.test(t);
                if (acceptable) {
                    count++;
                }
                if (acceptable && count >= limit * (page - 1) + limit) {
                    builder.add(t);
                }
            }
            res = findAll(++localPage, FILTER_PAGE);
        }
        return builder.build();
    }

    @Override
    public Collection<T> findAll() throws DataManipulateException {
        return mongoRepository.findAll();
    }

    @Override
    public Collection<T> findAll(int page, int limit) throws DataManipulateException {
        Preconditions.checkArgument(limit > 0 && page >= 0);
        return mongoRepository.findAll(PageRequest.of(page, limit)).getContent();
    }

    @Override
    public T register(T t) throws DataManipulateException {
        return mongoRepository.insert(t);
    }

}
