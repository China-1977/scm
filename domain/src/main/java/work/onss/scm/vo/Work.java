package work.onss.scm.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangchanghao
 */
@Data
public class Work<T> implements Serializable {

    private String code;
    private String message;
    private T content;

    public Work(String code, String message, T t) {
        this.code = code;
        this.message = message;
        this.content = t;
    }

    public static <T> Work<T> success() {
        return new Work<>("SUCCESS", "操作成功", null);
    }

    public static <T> Work<T> success(T t) {
        return new Work<>("SUCCESS", "操作成功", t);
    }

    public static <T> Work<T> success(String message, T t) {
        return new Work<>("SUCCESS", message, t);
    }

    public static <T> Work<T> fail() {
        return new Work<>("FAIL", "操作失败", null);
    }

    public static <T> Work<T> fail(String message) {
        return new Work<>("FAIL", message, null);
    }

    public static <T> Work<T> fail(String code,String message) {
        return new Work<>(code, message, null);
    }

    public static <T> Work<T> fail(T t) {
        return new Work<>("FAIL", "操作失败", t);
    }

    public static <T> Work<T> fail(String message, T t) {
        return new Work<>("FAIL", message, t);
    }

    public static <T> Work<T> message(String code, String message, T t) {
        return new Work<>(code, message, t);
    }

}
