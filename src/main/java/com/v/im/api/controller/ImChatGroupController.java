package com.v.im.api.controller;

import com.v.im.api.entity.RegisterResult;
import com.v.im.api.entity.TreeNode;
import com.v.im.user.entity.ImChatGroup;
import com.v.im.user.entity.ImChatGroupUser;
import com.v.im.user.entity.ImPeople;
import com.v.im.user.service.IImChatGroupService;
import com.v.im.user.service.IImChatGroupUserService;
import com.v.im.user.service.IImPeopleService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/chatGroup")
public class ImChatGroupController {

	@Resource
	@Qualifier(value = "imChatGroupUserService")
	private IImChatGroupUserService imChatGroupUserService;

	@Resource
	@Qualifier(value = "imChatGroupService")
	private IImChatGroupService imChatGroupService;

	@Resource
	@Qualifier(value = "imPeopleService")
	private IImPeopleService iImPeopleService;

	/**
	 * 创建群组
	 * 
	 * @param imChatGroup
	 *            群信息
	 * @param groupUsers
	 *            用户list
	 * @return
	 */
	@RequestMapping("createChatGroup")
	@ResponseBody
	public RegisterResult createChatGroup(String imChatGroup, String groupUsers) {
		RegisterResult result = new RegisterResult();
		try {
			System.out.println("imChatGroup:" + imChatGroup);
			ImChatGroup img = JSON.parseObject(imChatGroup, ImChatGroup.class);
			if (imChatGroupService.getByChatName(img.getName()) != null) {
				result.setResultCode(RegisterResult.ERROR);
				result.setMessage("群名 【" + img.getName() + "】 已存在");
			} else {
				List<ImChatGroupUser> imChatGroupUsers = JSON.parseArray(groupUsers, ImChatGroupUser.class);
				String chatId = getUUID();
				img.setId(chatId);
				imChatGroupService.save(img);
				for (ImChatGroupUser groupUser : imChatGroupUsers) {
					groupUser.setChatGroupId(chatId);
					groupUser.setCreateDate(new Date());
				}
				imChatGroupUserService.saveBatch(imChatGroupUsers);
				result.setResultCode(RegisterResult.SUCCESS);
				result.setMessage(chatId);
			}

		} catch (Exception e) {
			e.printStackTrace();
			result.setResultCode(RegisterResult.ERROR);
			result.setMessage("创建新群失败");
		}
		return result;
	}

	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String uuidStr = uuid.toString();
		return uuidStr;
	}

	@RequestMapping("initOrgTree")
	@ResponseBody
	public List<TreeNode> initOrgTree(String id) {
		System.out.println("initOrgTree id==========="+id);
		List<TreeNode> treeNodes = new ArrayList<TreeNode>();
		try {
			List<ImPeople> imPeopleList = iImPeopleService.getPeopleByCode("","");
			for (ImPeople people : imPeopleList) {
				String type = people.getType();
				//组织类型
				if (null != type && "1".equals(type)) {
					TreeNode root = new TreeNode();
					root.setId(people.getCode());
					root.setPId("");
					root.setName(people.getName());
					root.setIsParent(true);
					treeNodes.add(root);
				}
			}
			//treeNodes = initTreeData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return treeNodes;
	}
	
	@RequestMapping("orgList")
	@ResponseBody
	public List<TreeNode> orgList(String id) {
		System.out.println("orgList id==========="+id);
		List<TreeNode> treeNodes = new ArrayList<TreeNode>();
		try {
			List<ImPeople> imPeopleList = iImPeopleService.getPeopleByCode(id,"");
			for (ImPeople people : imPeopleList) {
				String type = people.getType();
				switch (type) {
					case "1" : //组织
						TreeNode orgNode = new TreeNode();
						orgNode.setId(people.getCode());
						orgNode.setPId(id);
						orgNode.setName(people.getName());
						orgNode.setIsParent(true);
						treeNodes.add(orgNode);
						break;
					case "2" : //用户
						TreeNode userNode = new TreeNode();
						userNode.setId(people.getUser().getId());
						userNode.setPId(id);
						userNode.setName(people.getUser().getName());
						userNode.setIsParent(false);
						treeNodes.add(userNode);
				}
			}
			//treeNodes = orgListData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return treeNodes;
	}
	
	private List<TreeNode> initTreeData(){
		List<TreeNode> treeNodes = new ArrayList<TreeNode>();
		TreeNode parent = new TreeNode();
		parent.setId("0");
		parent.setPId(null);
		parent.setName("总部");
		parent.setIsParent(true);
		treeNodes.add(parent);
		return treeNodes;
	}
	
	private List<TreeNode> orgListData(){
		List<TreeNode> treeNodes = new ArrayList<TreeNode>();
		TreeNode user1 = new TreeNode();
		user1.setId("428edf4fcf0242a49198d32845b0b1ec");
		user1.setPId("0");
		user1.setName("13322211442");
		user1.setIsParent(true);
		treeNodes.add(user1);
		
		TreeNode user2 = new TreeNode();
		user2.setId("50b6da69b8dd4c87b0d2d91e41792b94");
		user2.setPId("0");
		user2.setName("老邱");
		user2.setIsParent(false);
		treeNodes.add(user2);
		
		TreeNode user3 = new TreeNode();
		user3.setId("6da3eb4299294a7280896fb3d6476f1d");
		user3.setPId("0");
		user3.setName("13966655333");
		user3.setIsParent(false);
		treeNodes.add(user3);
		
		
		TreeNode user4 = new TreeNode();
		user4.setId("c69787c134b04d6f8127d512c269360f");
		user4.setPId("0");
		user4.setName("王五");
		user4.setIsParent(false);
		treeNodes.add(user4);
		
		TreeNode user5 = new TreeNode();
		user5.setId("cb0c145a6c104497942525f8c984f9d9");
		user5.setPId("0");
		user5.setName("管理员");
		user5.setIsParent(false);
		treeNodes.add(user5);
		
		
		return treeNodes;
	}
	

}
