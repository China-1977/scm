package work.onss.scm.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public enum TypeEnum implements Serializable,Cloneable{
    purchase("采购"),
    produce("生产"),
    outsource("委外");
    private final String message;
}
