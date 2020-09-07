package com.thoughtworks.capability.gtb.entrancequiz.trainee.domain;

import java.util.List;

public class Group {

  private String name;

  private List<Trainee> groupTrainees;

  public Group() {
  }

  public Group(String name, List<Trainee> groupTrainees) {
    this.name = name;
    this.groupTrainees = groupTrainees;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Trainee> getGroupTrainees() {
    return groupTrainees;
  }

  public void setGroupTrainees(List<Trainee> groupTrainees) {
    this.groupTrainees = groupTrainees;
  }
}
