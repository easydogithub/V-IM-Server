package com.v.im.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.v.im.user.entity.TLoginuser;
import com.v.im.user.mapper.TLoginuserMapper;
import com.v.im.user.service.ITLoginuserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("tLoginuserService")
public class TLoginuserServiceImpl extends ServiceImpl<TLoginuserMapper, TLoginuser> implements ITLoginuserService {
}
