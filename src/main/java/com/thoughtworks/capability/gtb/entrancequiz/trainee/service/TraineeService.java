package com.thoughtworks.capability.gtb.entrancequiz.trainee.service;

import com.thoughtworks.capability.gtb.entrancequiz.common.constants.TraineeConstants;
import com.thoughtworks.capability.gtb.entrancequiz.trainee.domain.Trainee;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TraineeService {

  public List<Trainee> findALlTrainees() {
    if (TraineeConstants.TRAINEE_LIST.isEmpty()) {
      return initTrainees();
    }else {
      return TraineeConstants.TRAINEE_LIST;
    }
  }

  private List<Trainee> initTrainees() {
    List<String> traineeName = Arrays.asList("沈乐棋", "徐慧慧", "陈思聪", "王江林", "王登宇",
            "杨思雨", "江雨舟", "廖燊", "胡晓", "但杰", "盖迈达", "肖美琦", "黄云洁", "齐瑾浩",
            "刘亮亮", "肖逸凡", "王作文", "郭瑞凌", "李明豪", "党泽", "肖伊佐", "贠晨曦", "李康宁",
            "马庆", "商婕", "余榕", "谌哲", "董翔锐", "陈泰宇", "赵允齐", "张柯", "廖文强", "刘轲",
            "廖浚斌", "凌凤仪");
    for (int i = 0; i < 35; i++) {
      TraineeConstants.TRAINEE_LIST.add(new Trainee(i + 1, traineeName.get(i)));
    }
    return TraineeConstants.TRAINEE_LIST;
  }

  public List<Trainee> addTrainee(String name) {
    TraineeConstants.TRAINEE_LIST.add(new Trainee(TraineeConstants.TRAINEE_LIST.size() + 1, name));
    return TraineeConstants.TRAINEE_LIST;
  }
}
