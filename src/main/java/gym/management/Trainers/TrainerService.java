package gym.management.Trainers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {

  private final TrainerRepository trainerRepository;

  @Autowired
  public TrainerService(TrainerRepository trainerRepository) {
    this.trainerRepository = trainerRepository;
  }

  public Trainer createTrainer(Trainer trainer) {
    return trainerRepository.save(trainer);
  }

  public List<Trainer> getAllTrainers() {
    return trainerRepository.findAll();
  }

  public Optional<Trainer> getTrainerById(Long id) {
    return trainerRepository.findById(id);
  }

  public Trainer updateTrainer(Long id, Trainer trainerDetails) {
    Trainer trainer = trainerRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Trainer not found with id: " + id));

    // update fields
    trainer.setName(trainerDetails.getName());
    // other updates...

    return trainerRepository.save(trainer);
  }

  public void deleteTrainer(Long id) {
    trainerRepository.deleteById(id);
  }
}
