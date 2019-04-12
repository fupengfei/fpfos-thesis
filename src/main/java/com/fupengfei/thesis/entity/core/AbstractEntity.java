package com.fupengfei.thesis.entity.core;

import com.fupengfei.thesis.annotation.RedisMapping;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @Description: IntelliJ IDEA: com.fupengfei.thesis.entity.core.AbstractEntity
 * @Author: fpfos
 * @Date: 2019-04-08 23:11
 */

@Getter
@MappedSuperclass
public abstract class AbstractEntity extends JsonBaseObject {

    @RedisMapping
    @Id // spring data rdis id
    @javax.persistence.Id // spring data jpa id
    @Setter
    @Column(name = "primary_code", updatable = false, nullable = false, unique = true)
    private String primaryCode;

    @Setter
    @Column(name = "is_del", nullable = false)
    private Boolean isDel;

    @Setter
    @Column(name = "create_primary_code", updatable = false, nullable = false)
    private String createPrimaryCode;
    @Setter
    @Column(name = "created_name", updatable = false, nullable = false)
    private String createdName;
    @RedisMapping
    @Setter
    @Column(name = "created_time", updatable = false, nullable = false)
    private LocalDateTime createdTime;

    @RedisMapping
    @Setter
    @Column(name = "modified_primary_code", nullable = false)
    private String modifiedPrimaryCode;
    @RedisMapping
    @Setter
    @Column(name = "modified_name", nullable = false)
    private String modifiedName;
    @RedisMapping
    @Setter
    @Column(name = "modified_time", nullable = false)
    private LocalDateTime modifiedTime;


    @Setter
    @Column(name = "deleted_primary_code")
    private String deletedPrimaryCode;
    @Setter
    @Column(name = "deleted_name")
    private String deletedName;
    @Setter
    @Column(name = "deleted_time")
    private LocalDateTime deletedTime;


}
