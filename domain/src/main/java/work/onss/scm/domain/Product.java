package work.onss.scm.domain;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Data
@TypeDef(name = "json", typeClass = JsonStringType.class)
@Entity(name="product")
public class Product implements Serializable,Cloneable{
    /** 主键 */
    @Id
    @GeneratedValue
    private String id ;
    /** 合作商ID */
    private String merchantId ;
    /** 产品编号 */
    private String code ;
    /** 产品名称 */
    private String name ;
    /** 单位 */
    private String unit ;
    /** 类型 */
    private String type ;
    /** 单价 */
    private BigDecimal price ;
    /** 状态 */
    private boolean status ;
    /** 图片 */
    @Type(type = "json")
    @Column(columnDefinition = "json" )
    private Set<String> pictures ;

}