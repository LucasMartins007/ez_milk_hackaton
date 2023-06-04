package com.hackaton.ezmilk.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class ChartDTO {

    private List<List<Object>> values;

}
