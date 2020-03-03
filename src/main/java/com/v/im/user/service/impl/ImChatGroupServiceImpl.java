package com.v.im.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.v.im.user.entity.ImChatGroup;
import com.v.im.user.entity.ImChatGroupUser;
import com.v.im.user.entity.ImUser;
import com.v.im.user.mapper.ImChatGroupMapper;
import com.v.im.user.service.IImChatGroupService;
import com.v.im.user.service.IImChatGroupUserService;
import com.v.im.user.service.IImGroupService;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 群 服务实现类
 * </p>
 *
 * @author 乐天
 * @since 2018-10-28
 */
@Service
@Qualifier("imChatGroupService")
public class ImChatGroupServiceImpl extends ServiceImpl<ImChatGroupMapper, ImChatGroup> implements IImChatGroupService {

	@Override
	public ImChatGroup getByChatName(String chatName) {

		QueryWrapper<ImChatGroup> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("name", chatName);
		return baseMapper.selectOne(queryWrapper);
	}

}
