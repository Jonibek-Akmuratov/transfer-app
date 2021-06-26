package ecma.ai.transferapp.repository;

import ecma.ai.transferapp.entity.Card;
import ecma.ai.transferapp.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends JpaRepository<Income,Integer> {
}
