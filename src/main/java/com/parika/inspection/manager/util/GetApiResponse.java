package com.parika.inspection.manager.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetApiResponse {
    private Object data;
    private Integer currentPage;
    private Integer total;
    private HttpStatus responseCode;
}
