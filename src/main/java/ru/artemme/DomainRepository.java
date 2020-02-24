package ru.artemme;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

// No need implementation, just one interface, and you have CRUD, thanks Spring Data
public interface DomainRepository extends MongoRepository<Domain, Long>, DomainRemositoryCustom {

    Domain findFirstByDomain(String domain);

    Domain findByDomainAndDisplayAds(String domain, boolean displayAds);

    //Supports native JSON query string
    @Query("{domain:'?0'}")
    Domain findCustomByDomain(String domain);

    @Query("{domain: { $regex: ?0 } })")
    List<Domain> findCustomByRegExDomain(String domain);

}