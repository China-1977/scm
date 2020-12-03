package work.onss.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import work.onss.domain.Inventory;
import work.onss.vo.Work;

import java.util.List;

/**
 * 库存记录管理
 *
 * @author wangchanghao
 */
@Log4j2
@RestController
public class InventoryController {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * @param id  仓库ID
     * @param mid 商户ID
     * @return 仓库记录详情
     */
    @GetMapping(value = {"inventories/{id}"})
    public Work<Inventory> inventories(@PathVariable String id, @RequestParam(name = "mid") String mid) {
        Query query = Query.query(Criteria.where("id").is(id).and("mid").is(mid));
        Inventory inventoryRecord = mongoTemplate.findOne(query, Inventory.class);
        return Work.success("加载成功", inventoryRecord);
    }

    /**
     * @param mid 商户ID
     * @return 仓库记录列表
     */
    @GetMapping(value = {"inventories"})
    public Work<List<Inventory>> inventories(@RequestParam(name = "mid") String mid) {
        Query query = Query.query(Criteria.where("mid").is(mid));
        List<Inventory> inventoryRecords = mongoTemplate.find(query, Inventory.class);
        return Work.success("加载成功", inventoryRecords);
    }
}