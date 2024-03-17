package com.do_bong_da.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class BaseDto<E> {
    private Long id;
    private Long modifiedUser;
    private Timestamp modifiedDate;
    private Long createdUser;
    private Timestamp createdDate;
    private boolean deleted = Boolean.FALSE;
}