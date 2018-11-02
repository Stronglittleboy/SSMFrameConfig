package com.service;

import com.bean.Problem;

public interface ProblemService {
    int insert(Problem record);

    int insertSelective(Problem record);
}