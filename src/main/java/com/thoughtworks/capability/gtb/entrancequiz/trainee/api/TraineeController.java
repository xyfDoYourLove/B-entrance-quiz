package com.thoughtworks.capability.gtb.entrancequiz.trainee.api;

import com.thoughtworks.capability.gtb.entrancequiz.trainee.domain.Trainee;
import com.thoughtworks.capability.gtb.entrancequiz.trainee.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/gtb", produces = MediaType.APPLICATION_JSON_VALUE)
public class TraineeController {

  @Autowired
  TraineeService traineeService;


  @CrossOrigin
  @GetMapping(path = "/trainees")
  public ResponseEntity<List<Trainee>> findAllTrainees() {
    return ResponseEntity.ok(traineeService.findALlTrainees());
  }

  @CrossOrigin
  @PostMapping(path = "/add/trainee/{name}")
  public ResponseEntity<List<Trainee>> addTrainee(@PathVariable String name) {
    return ResponseEntity.ok(traineeService.addTrainee(name));
  }

}
