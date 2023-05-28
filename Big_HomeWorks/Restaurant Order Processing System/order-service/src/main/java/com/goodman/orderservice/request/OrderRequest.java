package com.goodman.orderservice.request;

import com.goodman.orderservice.entity.Dish;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private String specialRequests;
    private List<String> dishNames;
}
