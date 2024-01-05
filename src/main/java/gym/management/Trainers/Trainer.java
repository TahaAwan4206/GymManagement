package gym.management.Trainers;

import jakarta.persistence.*;

@Entity
@Table(name = "trainers")
public class Trainer {



  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long TrainerId;
  @Column
  private String name;

  public Long getId() {
    return TrainerId;
  }

  public void setId(Long id) {
    this.TrainerId = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
