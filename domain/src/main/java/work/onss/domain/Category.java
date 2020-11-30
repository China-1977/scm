package work.onss.domain;

import lombok.Data;

/**
 * 分类
 */
@Data
public class Category {
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
