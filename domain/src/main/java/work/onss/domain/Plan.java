package work.onss.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 计划
 * 主键 计划编号 存货编码 存货名称 存货分类	单位 参考单价 计划数量 订单数量 入库数量 退回数量 计划日期 创建者 创建时间 更新时间 更新者
 */
@Data
public class Plan implements Serializable {
    private String id;
    private String code;
    private String materialCode;
    private String materialName;
    private String materialUnit;
    private BigDecimal materialPrice = BigDecimal.ZERO;
    private BigDecimal quantity = BigDecimal.ZERO;
    private BigDecimal orderQuantity = BigDecimal.ZERO;
    private BigDecimal inQuantity = BigDecimal.ZERO;
    private BigDecimal returnQuantity = BigDecimal.ZERO;
    private LocalDate taskDate;
    private String creator;
    private String updater;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;
}
