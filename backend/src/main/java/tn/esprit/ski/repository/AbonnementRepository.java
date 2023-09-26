package tn.esprit.ski.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.ski.entity.Piste;

@Repository
public interface AbonnementRepository extends CrudRepository<Piste, Long> {
}
