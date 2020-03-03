package com.v.im.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.v.im.user.entity.ImPeople;
import com.v.im.user.mapper.ImPeopleMapper;
import com.v.im.user.service.IImPeopleService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier(value = "imPeopleService")
public class ImPeopleServiceImpl extends ServiceImpl<ImPeopleMapper, ImPeople> implements IImPeopleService {
    @Override
    public List<ImPeople> getPeopleByCode(String code,String userid) {
        return baseMapper.getPeopleByCode(code,userid);
    }
}
