package gym.management.Trainers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainers")
public class TrainerController {

  private final TrainerService trainerService;

  @Autowired
  public TrainerController(TrainerService trainerService) {
    this.trainerService = trainerService;
  }

  @PostMapping
  public Trainer createTrainer(@RequestBody Trainer trainer) {
    return trainerService.createTrainer(trainer);
  }

  @GetMapping
  public List<Trainer> getAllTrainers() {
    return trainerService.getAllTrainers();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Trainer> getTrainerById(@PathVariable Long id) {
    Trainer trainer = trainerService.getTrainerById(id)
        .orElseThrow(() -> new RuntimeException("Trainer not found with id: " + id));
    return ResponseEntity.ok().body(trainer);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Trainer> updateTrainer(@PathVariable Long id, @RequestBody Trainer trainerDetails) {
    Trainer updatedTrainer = trainerService.updateTrainer(id, trainerDetails);
    return ResponseEntity.ok(updatedTrainer);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTrainer(@PathVariable Long id) {
    trainerService.deleteTrainer(id);
    return ResponseEntity.ok().build();
  }
}

