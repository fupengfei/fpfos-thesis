package com.fupengfei.thesis.entity.core;

import com.fupengfei.thesis.configure.annotation.RedisMapping;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Description: IntelliJ IDEA: com.fupengfei.thesis.entity.core.AbstractEntity
 * @Author: fpfos
 * @Date: 2019-04-08 23:11
 */

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity extends JsonBaseObject implements Serializable {

    @RedisMapping
    @Id // spring data rdis id
    @javax.persistence.Id // spring data jpa id
    @Column(name = "primary_code", updatable = false, nullable = false, unique = true)
    private String primaryCode;

    @Column(name = "is_del", nullable = false)
    private Boolean isDel;

    @Column(name = "create_primary_code", updatable = false, nullable = false)
    private String createPrimaryCode;

    @Column(name = "created_name", updatable = false, nullable = false)
    private String createdName;
    @RedisMapping
    @Column(name = "created_time", updatable = false, nullable = false, columnDefinition = "default CURRENT_TIMESTAMP")
    private LocalDateTime createdTime;

    @RedisMapping
    @Column(name = "modified_primary_code", nullable = false)
    private String modifiedPrimaryCode;
    @RedisMapping
    @Column(name = "modified_name", nullable = false)
    private String modifiedName;
    @RedisMapping
    @Column(name = "modified_time", nullable = false,columnDefinition = "default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private LocalDateTime modifiedTime;

    @Column(name = "deleted_primary_code",columnDefinition = "default ''")
    private String deletedPrimaryCode;
    @Column(name = "deleted_name",columnDefinition = "default ''")
    private String deletedName;
    @Column(name = "deleted_time")
    private LocalDateTime deletedTime;
}
