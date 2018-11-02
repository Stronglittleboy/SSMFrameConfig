package com.service.Impl;

import com.bean.Problem;
import com.dao.ProblemMapper;
import com.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProblemServiceImpl implements ProblemService {
    @Autowired
    private ProblemMapper problemMapper;
    @Override
    public int insert(Problem record) {
        return problemMapper.insert(record);
    }

    @Override
    public int insertSelective(Problem record) {
        return 0;
    }
}
