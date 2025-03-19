package com.devd.spring.bookstoreaccountservice.web;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Devaraj Reddy, Date : 2019-06-30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOAuthClientRequest {

  private List<String> authorized_grant_types;
  private List<String> authorities;
  private List<String> scope;
  private List<String> resource_ids;

}
