package in.ineuron.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import in.ineuron.model.QuotesModel;

@Repository
public interface QuotesRepository extends MongoRepository<QuotesModel,String> {

    List<QuotesModel> findByAuthor(String author);

    List<QuotesModel> findByQuoteContainsAllIgnoreCase(String author);

}