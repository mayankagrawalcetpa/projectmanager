package com.fse.projectmanager.service;

import com.fse.projectmanager.dto.ParentTaskDto;
import com.fse.projectmanager.entity.ParentTask;
import com.fse.projectmanager.repository.ParentTaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentTaskServiceImpl implements ParentTaskService{

    private final ParentTaskRepository parentTaskRepository;

    public ParentTaskServiceImpl(ParentTaskRepository parentTaskRepository) {
        this.parentTaskRepository = parentTaskRepository;
    }

    @Override
    public List<ParentTask> getAllParentTasks() {
        return parentTaskRepository.findAll();
    }

    @Override
    public ParentTask getParentTaskById(Long parentId) {
        Optional<ParentTask> parentTask = parentTaskRepository.findById(parentId);
        return parentTask.orElse(null);
    }

    @Override
    public void addParentTask(ParentTask parentTask) {
        parentTaskRepository.save(parentTask);
    }

    @Override
    public ParentTaskDto getParentTaskDtoFromParentTask(ParentTask parentTask)
    {
        ParentTaskDto parentTaskDto = new ParentTaskDto();
        parentTaskDto.setParentId(parentTask.getParentId());
        parentTaskDto.setParentTask(parentTask.getParentTask());
        return parentTaskDto;
    }

    @Override
    public ParentTask getParentTaskFromParentTaskDto(ParentTaskDto parentTaskDto)
    {
        ParentTask parentTask;
        Optional<ParentTask> optionalParentTask;
        if (parentTaskDto.getParentId() != null && (optionalParentTask = parentTaskRepository.findById(parentTaskDto.getParentId())).isPresent()) {
            parentTask = optionalParentTask.get();
        } else {
            parentTask = new ParentTask();
        }
        parentTask.setParentId(parentTaskDto.getParentId());
        parentTask.setParentTask(parentTaskDto.getParentTask());

        return parentTask;
    }

}
