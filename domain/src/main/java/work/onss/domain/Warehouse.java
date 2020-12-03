package work.onss.domain;

import lombok.Data;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 仓库
 */
@Data
public class Warehouse implements Serializable {

    /**
     * 仓库ID
     */
    private String id;
    /**
     * 地址用户ID
     */
    private String cid;
    /**
     * 商户ID
     */
    private String mid;
    /**
     * 仓库名称
     */
    private String name;
    /**
     * 地址坐标
     */
    @NotNull(message = "请重新定位收货地址")
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE, useGeneratedName = true)
    private Point location;
    /**
     * 仓库联系姓名
     */
    private String contactName;
    /**
     * 仓库联系电话
     */
    private String contactPhone;
    /**
     * 仓库联系地址
     */
    private String contactAddress;
    /**
     * 仓库联系邮箱
     */
    private String contactEmail;
}
