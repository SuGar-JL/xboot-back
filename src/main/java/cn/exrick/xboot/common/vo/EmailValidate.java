package cn.exrick.xboot.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 邮箱验证
 * @author Exrickx
 */
@Data
public class EmailValidate implements Serializable {

    private String username;

    private String email;

    private String validateUrl;

    private String code;

    private String fullUrl;

    private String operation;
}
