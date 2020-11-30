package work.onss.domain;

import lombok.Data;

/**
 * 分类
 */
@Data
public class Category {
    private String id;
    private String value;
    private String label;
    private Boolean disabled;
}
