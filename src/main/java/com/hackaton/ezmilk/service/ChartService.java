package com.hackaton.ezmilk.service;

import java.util.List;

public interface ChartService {
    List<List<Object>> getChart(Integer pessoaId);
}
