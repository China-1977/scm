package work.onss.scm.domain;

import org.springframework.data.jpa.repository.JpaRepository;


public interface StockRepository extends JpaRepository<Stock,String> {
}
