package by.bsuir.core.service;

import by.bsuir.core.entity.Test;

import java.util.List;

public interface TestService {

    List<Test> findAllTestEntities();

    Test save(Test test);
}
