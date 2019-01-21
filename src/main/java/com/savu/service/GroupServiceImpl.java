package com.savu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.savu.model.Group;
import com.savu.repositories.GroupRepository;

@Service("groupService")
@Transactional
public class GroupServiceImpl implements GroupService {
	@Autowired
	private GroupRepository groupRepository;

	@Override
	public Group findById(Long id) {
		return groupRepository.findOne(id);
	}

	@Override
	public Group findByName(String name) {
		return groupRepository.findByName(name);
	}

	@Override
	public void saveGroup(Group group) {
		groupRepository.save(group);
	}

	@Override
	public void updateGroup(Group group) {
		saveGroup(group);
	}

	@Override
	public void deleteGroupById(Long id) {
		groupRepository.delete(id);
	}

	@Override
	public void deleteAllGroups() {
		groupRepository.deleteAll();
	}

	@Override
	public List<Group> findAllGroups() {
		return groupRepository.findAll();
	}

	@Override
	public boolean isGroupExist(Group group) {
		return findByName(group.getName()) != null;
	}
}
