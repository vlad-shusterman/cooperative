package by.bsuir.core.service.impl;

import by.bsuir.core.entity.Test;
import by.bsuir.core.repository.TestRepository;
import by.bsuir.core.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    @Override
    public List<Test> findAllTestEntities() {
        return testRepository.findAll();
    }

    @Override
    public Test save(Test test) {
        return testRepository.save(test);
    }
}
