package com.service.Impl;

import com.bean.Leavebill;
import com.dao.LeavebillMapper;
import com.service.LeavebillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LeavebillServiceImpl  implements LeavebillService {
    @Autowired
    private LeavebillMapper leavebillMapper;

    @Override
    public List<Leavebill> getallbyfield(Map map) {
        List<Leavebill> list = leavebillMapper.getallbyfield(map);
        return list;
    }

    @Override
    public int delete(int id) {
        return leavebillMapper.delete(id);
    }

    @Override
    public int update(Leavebill leavebill) {
        return leavebillMapper.update(leavebill);
    }

    @Override
    public int insert(Leavebill leavebill) {
        return leavebillMapper.insert(leavebill);
    }
}