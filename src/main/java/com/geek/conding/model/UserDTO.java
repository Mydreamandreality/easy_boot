package com.geek.conding.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Administrator
 */
@Data
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -6226593098773490023L;

    private Integer id;

    private String name;
}
