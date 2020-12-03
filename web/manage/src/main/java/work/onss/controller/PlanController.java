package work.onss.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import work.onss.domain.Plan;
import work.onss.domain.Product;
import work.onss.vo.Work;

import java.util.List;

/**
 * 计划管理
 *
 * @author wangchanghao
 */
@Log4j2
@RestController
public class PlanController {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * @param id 计划ID
     * @return 计划详情
     */
    @GetMapping(value = {"plans/{id}"})
    public Work<Plan> plans(@PathVariable String id) {
        Plan plan = mongoTemplate.findById(id, Plan.class);
        return Work.success("加载成功", plan);
    }

    /**
     * @return 计划列表
     */
    @GetMapping(value = {"plans"})
    public Work<List<Plan>> plans() {
        List<Plan> plans = mongoTemplate.findAll(Plan.class);
        return Work.success("加载成功", plans);
    }
}
