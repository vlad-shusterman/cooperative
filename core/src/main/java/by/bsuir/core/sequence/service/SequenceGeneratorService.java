package by.bsuir.core.sequence.service;

import by.bsuir.core.sequence.model.DatabaseSequence;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
@RequiredArgsConstructor
public class SequenceGeneratorService {

    private final MongoOperations mongoOperations;

    public Long generateSequence(String seqName) {
        var counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("sequence", 1), options().returnNew(true).upsert(true),
                DatabaseSequence.class);
        return !Objects.isNull(counter) && !Objects.isNull(counter.getSequence()) ? counter.getSequence() : 1L;
    }
}
