package com.example.doantwo.modal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseDto<T> {
    private long id;
    private Date createdDate;
    private String createdBy;
    private Date modifiedDate;
    private String modifieBy;
    
}
