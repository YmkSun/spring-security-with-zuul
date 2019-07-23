package com.cogent.modal;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Sauravi
 */


@Entity
@Table(name = "sub_department")
@NoArgsConstructor
@Getter
@Setter
@ApiModel
public class SubDepartment implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Sub-department id i.e. auto generated by database")
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    @ApiModelProperty(value = "Sub-department name should be unique")
    private String name;

    @Column(name = "code", nullable = false, length = 50)
    @ApiModelProperty(value = "Sub-department Code should be unique")
    private String code;

    @Column(name = "status")
    @ApiModelProperty(value = "Y, N and D are only used")
    private Character status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="department_id")
    @JsonIgnore
    private Department department;

//    @Column(name = "created_date", nullable = false)
//    @ApiModelProperty
//    private Date createdDate;
//
//    @Column(name = "last_modified_date")
//    private Date lastModifiedDate;
//
//    @Column(name = "created_by_id")
//    private Long createdById;
//
//    @Column(name = "last_modified_by_id")
//    private Long modifiedById;


}
