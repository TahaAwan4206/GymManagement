package gym.management.Trainers;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
  // Custom query methods can be added here
}
