package gym.management.membershiptype;

import jakarta.persistence.*;


@Entity
@Table(name = "membership_types")
public class MembershipType {

  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long TypeId;
  @Column
  private String name;
  @Column
  private Double price;

  public String getName() {
    return name;
  }

  public Double getPrice() {
    return price;
  }

  public Long getId() {
    return TypeId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public void setId(Long id) {
    this.TypeId = id;
  }
}
