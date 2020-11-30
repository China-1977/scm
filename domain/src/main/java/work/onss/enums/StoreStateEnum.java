package work.onss.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public enum  StoreStateEnum implements Serializable {
    EDITING(0, "编辑中"),
    AUDITING(1, "审核中"),
    REJECTED(2, "已驳回"),
    TO_BE_CONFIRMED(3, "待账户验证"),
    TO_BE_SIGNED(4, "待签约"),
    SIGNING(5, "开通权限中"),
    FINISHED(6, "已完成"),
    CANCELED(7, "已作废");
    private final Integer code;
    private final String value;

}
