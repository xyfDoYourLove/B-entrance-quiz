package com.thoughtworks.capability.gtb.entrancequiz.trainee.service;

import com.thoughtworks.capability.gtb.entrancequiz.common.constants.TraineeConstants;
import com.thoughtworks.capability.gtb.entrancequiz.trainee.domain.Group;
import com.thoughtworks.capability.gtb.entrancequiz.trainee.domain.Trainee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TraineeService {

  public List<Trainee> findALlTrainees() {
    if (TraineeConstants.TRAINEE_LIST.isEmpty()) {
      return initTrainees();
    }else {
      return TraineeConstants.TRAINEE_LIST;
    }
  }

  public List<Trainee> addTrainee(String name) {
    TraineeConstants.TRAINEE_LIST.add(new Trainee(TraineeConstants.TRAINEE_LIST.size() + 1, name));
    return TraineeConstants.TRAINEE_LIST;
  }

  public List<Group> groupTrainee() {
    if (TraineeConstants.GROUP_LIST.isEmpty()) {
      initGroups();
    }else {
      clearGroups();
    }

    List<Trainee> newTraineeList = new ArrayList<>();
    for (Trainee trainee : TraineeConstants.TRAINEE_LIST) {
      newTraineeList.add(trainee);
    }
    Collections.shuffle(newTraineeList);

    int size = TraineeConstants.TRAINEE_LIST.size() / 6;
    int moreGroupCount = TraineeConstants.TRAINEE_LIST.size() % 6;
    for (int i = 0, startIndex = 0; i < TraineeConstants.GROUP_LIST.size(); i++) {
      if (i < moreGroupCount) {
        addGroup(startIndex, size + 1, i, newTraineeList);
        startIndex += size + 1;
      }else {
        addGroup(startIndex, size, i, newTraineeList);
        startIndex += size;
      }
    }
    return TraineeConstants.GROUP_LIST;
  }

  private void addGroup(int startIndex, int size, int GroupIndex, List<Trainee> newTraineeList) {
    TraineeConstants.GROUP_LIST.get(GroupIndex)
            .setGroupTrainees(newTraineeList.subList(startIndex, startIndex + size));
  }

  private List<Trainee> initTrainees() {
    TraineeConstants.TRAINEE_LIST.clear();
    List<String> traineeNames = Arrays.asList("沈乐棋", "徐慧慧", "陈思聪", "王江林", "王登宇",
            "杨思雨", "江雨舟", "廖燊", "胡晓", "但杰", "盖迈达", "肖美琦", "黄云洁", "齐瑾浩",
            "刘亮亮", "肖逸凡", "王作文", "郭瑞凌", "李明豪", "党泽", "肖伊佐", "贠晨曦", "李康宁",
            "马庆", "商婕", "余榕", "谌哲", "董翔锐", "陈泰宇", "赵允齐", "张柯", "廖文强", "刘轲",
            "廖浚斌", "凌凤仪");
    for (int i = 0; i < traineeNames.size(); i++) {
      TraineeConstants.TRAINEE_LIST.add(new Trainee(i + 1, traineeNames.get(i)));
    }
    return TraineeConstants.TRAINEE_LIST;
  }

  private List<Group> initGroups() {
    List<String> groupNames = Arrays.asList("Team 1", "Team 2", "Team 3", "Team 4", "Team 5", "Team 6");
    for (int i = 0; i < groupNames.size(); i++) {
      TraineeConstants.GROUP_LIST.add(new Group(groupNames.get(i), new ArrayList<Trainee>()));
    }
    return TraineeConstants.GROUP_LIST;
  }

  private List<Group> clearGroups() {
    for (Group group : TraineeConstants.GROUP_LIST) {
      group.setGroupTrainees(new ArrayList<Trainee>());
    }
    return TraineeConstants.GROUP_LIST;
  }

  public List<Group> editGroupName(String oldName, String newName) {
    for(Group group : TraineeConstants.GROUP_LIST) {
      if (group.getName().equals(oldName)) {
        group.setName(newName);
      }
    }
    return TraineeConstants.GROUP_LIST;
  }
}
