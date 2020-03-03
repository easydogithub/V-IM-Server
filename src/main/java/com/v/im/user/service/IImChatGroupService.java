package com.v.im.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.v.im.user.entity.ImChatGroup;
import com.v.im.user.entity.ImUser;

/**
 * <p>
 * 群 服务类
 * </p>
 *
 * @author 乐天
 * @since 2018-10-28
 */
public interface IImChatGroupService extends IService<ImChatGroup> {

    /**
     * 根据群名查找群
     * @param chatName 群名 
     * @return 群
     */
	ImChatGroup getByChatName(String chatName);
}
