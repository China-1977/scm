package work.onss.scm.domain;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,Long> {
    /**
     * 根据code查询实体
     * @param code
     * @return
     */
    Product findByCode(String code);
}
