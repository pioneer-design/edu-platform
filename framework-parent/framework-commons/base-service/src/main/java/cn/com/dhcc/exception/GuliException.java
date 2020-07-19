package cn.com.dhcc.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor  //生成有参数构造方法
@NoArgsConstructor   //生成无参数构造
public class GuliException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private Integer code;//状态码
    private String msg;//异常信息
}
