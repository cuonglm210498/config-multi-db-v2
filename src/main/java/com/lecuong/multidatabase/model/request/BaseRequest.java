package com.lecuong.multidatabase.model.request;

import lombok.Data;

/**
 * @author CuongLM
 * @created 06/07/2024 - 01:20
 * @project multi-database
 */
@Data
public class BaseRequest {

    private int pageIndex = 1;
    private int pageSize = 10;
}
