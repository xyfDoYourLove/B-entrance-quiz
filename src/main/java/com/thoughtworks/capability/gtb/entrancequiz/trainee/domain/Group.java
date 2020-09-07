package com.thoughtworks.capability.gtb.entrancequiz.trainee.domain;

import java.util.List;

public class Group {

  private List<Trainee> groupTrainees;

  public Group() {
  }

  public Group(List<Trainee> groupTrainees) {
    this.groupTrainees = groupTrainees;
  }

  public List<Trainee> getGroupTrainees() {
    return groupTrainees;
  }

  public void setGroupTrainees(List<Trainee> groupTrainees) {
    this.groupTrainees = groupTrainees;
  }
}
