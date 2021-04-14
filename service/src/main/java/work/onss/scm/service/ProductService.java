package work.onss.scm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import work.onss.scm.domain.Product;

import java.util.List;

/**
 * @author jiangxiaojing
 * 产品信息操作
 */
public interface ProductService {

    /**
     * 分页查询
     * @return 分页数据
     */
    Page<Product> page(Pageable pageable);

    /**
     * 根据产品编码获取产品信息
     * @param code 产品编码
     * @return 产品信息
     */
    Product findProductByCode(String code);

    /**
     * 新增产品信息
     * @param product 产品信息
     */
    void insert(Product product);

    /**
     * 删除产品信息
     * @param id 产品id
     */
    void delete(Long id);
}
