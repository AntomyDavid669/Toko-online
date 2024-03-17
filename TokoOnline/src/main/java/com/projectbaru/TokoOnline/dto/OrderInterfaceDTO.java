package com.projectbaru.TokoOnline.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public interface OrderInterfaceDTO {
    // Table Order Interface
    Long getOrder_id();
    String getOrder_date();
    String getNama_lengkap();
    String getTotal_Amount();
    String getProduct_name();
    Integer getQuantity();
    Double getSubtotal();

    // Card -> earnings monthly OK
    // Card -> earnings annual OK
    // Card -> total order monthly OK
    // Card -> total order annual OK
}
