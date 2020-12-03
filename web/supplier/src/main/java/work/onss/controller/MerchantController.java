package work.onss.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import work.onss.domain.Merchant;
import work.onss.vo.Work;

/**
 * 商户管理
 *
 * @author wangchanghao
 */
@Log4j2
@RestController
public class MerchantController {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * @param id 商户ID
     * @return 订单详情
     */
    @GetMapping(value = {"merchants/{id}"})
    public Work<Merchant> score(@PathVariable String id) {
        Merchant merchant = mongoTemplate.findById(id, Merchant.class);
        return Work.success("加载成功", merchant);
    }
}
