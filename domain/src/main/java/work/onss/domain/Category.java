package work.onss.domain;

import lombok.Data;

@Data
public class Category {
    private String id;
    private String value;
    private String label;
    private Boolean disabled;
}
