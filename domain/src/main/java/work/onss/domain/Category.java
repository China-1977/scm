package work.onss.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 分类
 */
@Data
public class Category implements Serializable {
    /**
     * 分类ID
     */
    private String id;
    /**
     * 分类编码
     */
    private String value;
    /**
     * 分类名称
     */
    private String label;
}
