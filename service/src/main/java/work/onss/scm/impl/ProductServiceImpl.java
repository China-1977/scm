package work.onss.scm.impl;

import work.onss.scm.domain.Product;
import work.onss.scm.domain.ProductRepository;
import work.onss.scm.service.ProductService;

import java.util.List;

/**
 * @author jiangxiaojing
 * 产品信息实现
 */
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public List<Product> page(){
        return productRepository.findAll();
    }

    /**
     * 根据产品编码获取产品信息
     * @param code 产品编码
     * @return 产品信息
     */
    @Override
    public Product findProductByCode(String code) {
        return productRepository.findByCode(code);
    }

    /**
     * 新增产品信息
     * @param product 产品信息
     */
    @Override
    public void insert(Product product) {
        productRepository.save(product);
    }

    /**
     * 删除产品信息
     * @param id 产品id
     */
    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
