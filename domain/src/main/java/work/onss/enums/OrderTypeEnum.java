package work.onss.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * 订单状态枚举
 */
@Getter
@AllArgsConstructor
public enum OrderTypeEnum implements Serializable {
    PURCHASE(0, "采购订单"),
    PRODUCE(1, "生产订单"),
    OUTSOURCE(2, "委外订单");
    private final Integer code;
    private final String value;

}
