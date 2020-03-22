package com.fse.projectmanager.service;

import com.fse.projectmanager.dto.ParentTaskDto;
import com.fse.projectmanager.entity.ParentTask;

import java.util.List;

public interface ParentTaskService {
    List<ParentTask> getAllParentTasks();
    ParentTask getParentTaskById(Long parentId);
    void addParentTask(ParentTask parentTask);
    ParentTaskDto getParentTaskDtoFromParentTask(ParentTask parentTask);
    ParentTask getParentTaskFromParentTaskDto(ParentTaskDto parentTaskDto);
}
