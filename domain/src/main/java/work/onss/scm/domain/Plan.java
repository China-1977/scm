package work.onss.scm.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@Entity(name="plan")
public class Plan implements Serializable,Cloneable{
    /** 主键 */
    @Id
    @GeneratedValue
    private String id ;
    /** 计划编号;年月日+存货编码 */
    private String planCode ;
    /** 产品ID */
    private String productId ;
    /** 产品编号 */
    private String productCode ;
    /** 产品名称 */
    private String productName ;
    /** 类型;采购 purchase、生产 produce、委外 outsource */
    private TypeEnum type ;
    /** 开始时间 */
    private LocalDate startDate ;
    /** 截止时间 */
    private LocalDate endDate ;
    /** 状态;准备 read、开始 start、暂停 suspend、完成 finish、停止 stop */
    private StatusEnum status ;
    /** 计划数量 */
    private BigDecimal planQuantity ;
    /** 已分配数量 */
    private BigDecimal allocatedQuantity ;
    /** 已完成数量 */
    private BigDecimal completedQuantity ;
    /** 更新时间 */
    private LocalDateTime upateDatetime ;
    /** 创建时间 */
    private LocalDateTime crateDatetime ;

    @Getter
    @AllArgsConstructor
    public static enum StatusEnum implements Serializable,Cloneable{
        READ("准备"),
        START("开始"),
        SUSPEND("暂停"),
        FINISH("完成"),
        STOP("停止");
        private final String message;
    }
}