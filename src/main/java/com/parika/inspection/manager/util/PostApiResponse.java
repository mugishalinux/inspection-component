package com.parika.inspection.manager.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostApiResponse {
  private String message;
  private HttpStatus responseCode;
}
