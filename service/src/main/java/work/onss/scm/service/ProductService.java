package work.onss.scm.service;

import work.onss.scm.domain.Product;

import java.util.List;

/**
 * @author jiangxiaojing
 * 产品信息操作
 */
public interface ProductService {

    /**
     * 根据产品编码获取产品信息
     * @param code 产品编码
     * @return 产品信息
     */
    Product findProductByCode(String code);

    void insert(Product product);
}
