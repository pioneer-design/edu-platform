package cn.com.dhcc.edu.pojo.entity;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

/**
 * <p>
 * 
 * </p>
 *
 * @author testjava
 * @since 2020-06-21
 */
@Data
@Table(name = "edu_teacher")
@Entity
@ApiModel(value="Teacher对象", description="")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "讲师ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @ApiModelProperty(value = "讲师姓名")
    private String name;

    @Column
    @ApiModelProperty(value = "讲师简介")
    private String intro;

    @Column
    @ApiModelProperty(value = "讲师资历")
    private String career;

    @Column
    @ApiModelProperty(value = "头衔")
    private Integer level;

    @Column
    @ApiModelProperty(value = "讲师头像")
    private String avatar;

    @Column
    @ApiModelProperty(value = "排序")
    private Integer sort;

    @Column
    @ApiModelProperty(value = "逻辑删除 1-已删除 0-未删除")
    private String isDeleted;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间")
    private Date begin;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "更新时间")
    private Date end;
}
