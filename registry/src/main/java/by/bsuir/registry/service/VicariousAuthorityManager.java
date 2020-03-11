package by.bsuir.registry.service;

import by.bsuir.core.exceptions.DataManipulateException;
import by.bsuir.core.service.BaseManager;
import by.bsuir.registry.model.VicariousAuthority;

import java.util.Collection;

public interface VicariousAuthorityManager extends BaseManager<VicariousAuthority> {

    Collection<VicariousAuthority> findByPersonId(String personId) throws DataManipulateException;

    Collection<VicariousAuthority> findByProprietorId(String proprietorId) throws DataManipulateException;

    Collection<VicariousAuthority> findActiveByPersonId(String personId) throws DataManipulateException;

    Collection<VicariousAuthority> findActiveByProprietorId(String proprietorId) throws DataManipulateException;

}
