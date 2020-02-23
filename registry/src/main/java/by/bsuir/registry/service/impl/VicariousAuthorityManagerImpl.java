package by.bsuir.registry.service.impl;

import by.bsuir.registry.exceptions.DataManipulateException;
import by.bsuir.registry.model.Person;
import by.bsuir.registry.model.VicariousAuthority;
import by.bsuir.registry.repository.VicariousAuthorityRepository;
import by.bsuir.registry.service.BaseManager;
import by.bsuir.registry.service.VicariousAuthorityManager;
import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Service;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

@Service
@ParametersAreNonnullByDefault
public class VicariousAuthorityManagerImpl extends BaseManagerImpl<VicariousAuthorityRepository, VicariousAuthority> implements VicariousAuthorityManager {

    private final BaseManager<Person> personBaseManager;

    public VicariousAuthorityManagerImpl(VicariousAuthorityRepository mongoRepository, BaseManager<Person> personBaseManager) {
        super(mongoRepository);
        this.personBaseManager = personBaseManager;
    }

    @Override
    public Collection<VicariousAuthority> findByPersonId(String personId) {
        if (personBaseManager.find(personId) != null) {
            return mongoRepository.findByPersonIdIn(Collections.singleton(personId));
        }
        throw new DataManipulateException();
    }

    @Override
    public Collection<VicariousAuthority> findByProprietorId(String proprietorId) {
        if (personBaseManager.find(proprietorId) != null) {
            return mongoRepository.findByProprietorIdIn(Collections.singleton(proprietorId));
        }
        throw new DataManipulateException();
    }

    @Override
    public Collection<VicariousAuthority> findActiveByPersonId(String personId) {
        return filterActive(findByPersonId(personId));
    }

    @Override
    public Collection<VicariousAuthority> findActiveByProprietorId(String proprietorId) {
        return filterActive(findByProprietorId(proprietorId));
    }

    @Override
    public VicariousAuthority update(VicariousAuthority vicariousAuthority) throws DataManipulateException {
        if (personBaseManager.find(vicariousAuthority.getPersonId()) != null
                && personBaseManager.find(vicariousAuthority.getProprietorId()) != null
                && mongoRepository.findById(vicariousAuthority.getId()).isPresent()
        ) {
            return mongoRepository.save(vicariousAuthority);
        }
        throw new DataManipulateException();
    }

    private static Collection<VicariousAuthority> filterActive(Collection<VicariousAuthority> byProprietorIdId) {
        ImmutableList.Builder<VicariousAuthority> builder = ImmutableList.builder();
        for (VicariousAuthority vicariousAuthority : byProprietorIdId) {
            if (vicariousAuthority.getStartDate() + TimeUnit.DAYS.toSeconds(vicariousAuthority.getDuration()) > TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())) {
                builder.add(vicariousAuthority);
            }
        }
        return builder.build();
    }

}
