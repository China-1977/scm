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
import work.onss.domain.Score;
import work.onss.domain.Warehouse;
import work.onss.vo.Work;

import java.util.List;

/**
 * 仓库管理
 *
 * @author wangchanghao
 */
@Log4j2
@RestController
public class WarehouseController {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * @param id  仓库ID
     * @param mid 商户ID
     * @return 仓库详情
     */
    @GetMapping(value = {"warehouses/{id}"})
    public Work<Warehouse> warehouses(@PathVariable String id) {
        Warehouse warehouse = mongoTemplate.findById(id, Warehouse.class);
        return Work.success("加载成功", warehouse);
    }

    /**
     * @param mid 商户ID
     * @return 仓库列表
     */
    @GetMapping(value = {"warehouses"})
    public Work<List<Score>> warehouses() {
        List<Score> scores = mongoTemplate.findAll(Score.class);
        return Work.success("加载成功", scores);
    }
}
