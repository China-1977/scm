package work.onss.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * 订单状态枚举
 */
@Getter
@AllArgsConstructor
public enum OrderStatusEnum implements Serializable {
    EDITING(0, "编辑中"),
    AUDITING(1, "审核中"),
    REJECTED(2, "已驳回"),
    TO_BE_SIGNED(3, "待签约"),
    TO_BE_PRODUCED(4, "待生产"),
    PRODUCING(5, "生产中"),
    COMPLETED(6, "已完工"),
    FINISHED(7, "已完成");
    private final Integer code;
    private final String value;

}
