package com.nttdata.creditservice.controller;


import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * * Class that defines the format of REST errors.
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorMessage {
  private String code;
  private List<Map<String, String>> message;

}
