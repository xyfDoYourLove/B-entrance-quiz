package com.thoughtworks.capability.gtb.entrancequiz.trainee.service;

import com.thoughtworks.capability.gtb.entrancequiz.common.constants.TraineeConstants;
import com.thoughtworks.capability.gtb.entrancequiz.trainee.domain.Trainee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraineeService {


  public List<Trainee> findALlTrainees() {
    return TraineeConstants.TRAINEE_LIST;
  }
}
