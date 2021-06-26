package ecma.ai.transferapp.repository;

import ecma.ai.transferapp.entity.Card;
import ecma.ai.transferapp.entity.Outcome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutcomeRepository extends JpaRepository<Outcome, Integer> {
}
