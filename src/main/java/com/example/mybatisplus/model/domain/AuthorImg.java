package com.example.mybatisplus.model.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author drb
 * @since 2021-07-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="AuthorImg对象", description="")
public class AuthorImg extends Model<AuthorImg> {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty(value = "表单ID")
            @TableId(value = "form_id")
    private Integer formId;

            @ApiModelProperty(value = "头像")
    private String imgPath;


    @Override
    protected Serializable pkVal() {
        return this.formId;
    }

}
