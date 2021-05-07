package work.onss.scm.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import work.onss.scm.domain.Plan;
import work.onss.scm.domain.PlanRepository;

@Log4j2
@RestController
public class PlanController {

    @Autowired
    private PlanRepository planRepository;

    /**
     * @param plan 主键
     * @return 店铺信息
     */
    @GetMapping(value = {"plans"})
    public Page<Plan> store(Plan plan, @PageableDefault Pageable pageable) {
        Example<Plan> of = Example.of(plan);
        return planRepository.findAll(of, pageable);
    }
}
