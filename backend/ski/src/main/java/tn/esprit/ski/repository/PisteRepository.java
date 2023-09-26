package tn.esprit.ski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.ski.entity.Piste;

import java.util.List;

@Repository
public interface PisteRepository extends JpaRepository<Piste, Long> {
    List<Piste> findAllByPenteLessThanAndLongGreaterThan(int P, int L);
}
