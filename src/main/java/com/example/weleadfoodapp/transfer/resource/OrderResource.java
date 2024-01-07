package com.example.weleadfoodapp.transfer.resource;

import com.example.weleadfoodapp.model.OrderStatus;
import com.example.weleadfoodapp.model.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
public class OrderResource extends BaseResource {
    private CustomerResource customer;
    private Set<OrderItemResource> orderItems = new HashSet<>();
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss.SSS")
    private Date submitDate;
    private OrderStatus status;
    private PaymentMethod paymentMethod;
    private BigDecimal cost;
}
