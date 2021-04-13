package work.onss.scm.domain;

import org.springframework.data.jpa.repository.JpaRepository;


public interface OrdersItemRepository extends JpaRepository<OrdersItem,Long> {
}
