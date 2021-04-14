package work.onss.scm.impl;

import work.onss.scm.domain.Product;
import work.onss.scm.service.ProductService;

/**
 * @author jiangxiaojing
 * 产品信息实现
 */
public class ProductServiceImpl implements ProductService {

    /**
     * 根据产品编码获取产品信息
     * @param code 产品编码
     * @return 产品信息
     */
    @Override
    public Product findProductByCode(String code) {
        return null;
    }

    /**
     * 新增产品信息
     * @param product 产品信息
     */
    @Override
    public void insert(Product product) {

    }

    /**
     * 删除产品信息
     * @param id 产品id
     */
    @Override
    public void delete(Long id) {

    }
}
