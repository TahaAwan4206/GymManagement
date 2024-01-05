package gym.management.member;

import gym.management.Payment.PaymentInfo;
import gym.management.Trainers.Trainer;
import gym.management.membershiptype.MembershipType;
import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
@Table(name = "members")
public class Member {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;
  @Column
  private String phoneNumber;
  @Column
  private LocalDate dateOfBirth;
  @Column
  private String emailAddress;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "TypeId")
  MembershipType membershipTypeId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "TrainerId")
  private Trainer trainerId;


  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "PaymentId")
  private PaymentInfo paymentMethodId;



  // Constructors, Getters, and Setters
  public Member() {
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public MembershipType getMembershipType() {
    return membershipTypeId;
  }

  public void setMembershipType(MembershipType membershipType) {
    this.membershipTypeId = membershipType;
  }

  public Trainer getTrainer() {
    return trainerId;
  }

  public void setTrainer(Trainer trainer) {
    this.trainerId = trainer;
  }

  public void setPaymentMethod(PaymentInfo paymentMethod) {
    this.paymentMethodId = paymentMethod;
  }
}


