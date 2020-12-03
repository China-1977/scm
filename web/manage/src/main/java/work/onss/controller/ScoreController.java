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
import work.onss.enums.OrderStatusEnum;
import work.onss.vo.Work;

import java.util.List;

/**
 * 订单管理
 *
 * @author wangchanghao
 */
@Log4j2
@RestController
public class ScoreController {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * @param id  订单ID
     * @param mid 商户ID
     * @return 订单详情
     */
    @GetMapping(value = {"scores/{id}"})
    public Work<Score> scores(@PathVariable String id) {
        Score score = mongoTemplate.findById(id, Score.class);
        return Work.success("加载成功", score);
    }

    /**
     * @param mid 商户ID
     * @return 订单列表
     */
    @GetMapping(value = {"scores"})
    public Work<List<Score>> scores( @RequestParam(name = "status") List<OrderStatusEnum> status) {
        Query query = Query.query(Criteria.where("status").in(status));
        List<Score> scores = mongoTemplate.find(query, Score.class);
        return Work.success("加载成功", scores);
    }

}
