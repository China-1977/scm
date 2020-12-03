package work.onss.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import work.onss.domain.Product;
import work.onss.vo.Work;

import java.util.List;

/**
 * 产品管理
 *
 * @author wangchanghao
 */
@Log4j2
@RestController
public class ProductController {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * @param id 产品ID
     * @return 产品详情
     */
    @GetMapping(value = {"products/{id}"})
    public Work<Product> products(@PathVariable String id) {
        Product product = mongoTemplate.findById(id, Product.class);
        return Work.success("加载成功", product);
    }

    /**
     * @return 产品列表
     */
    @GetMapping(value = {"products"})
    public Work<List<Product>> products() {
        List<Product> products = mongoTemplate.findAll(Product.class);
        return Work.success("加载成功", products);
    }
}
