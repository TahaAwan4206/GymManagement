package gym.management.member;

import java.time.LocalDate;

public class MemberDTO {

  private String name;
  private String phoneNumber;
  private LocalDate dateOfBirth;
  private String emailAddress;
  private Long membershipTypeId;

  private Long paymentId;
  private Long TrainerId;




  public MemberDTO() {
  }

  public MemberDTO(String name, String phoneNumber, LocalDate dateOfBirth, String emailAddress, Long membershipTypeId) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.dateOfBirth = dateOfBirth;
    this.emailAddress = emailAddress;
    this.membershipTypeId = membershipTypeId;
  }


  public Long getMembershipTypeId() {
    return membershipTypeId;
  }

  public void setMembershipTypeId(Long membershipTypeId) {
    this.membershipTypeId = membershipTypeId;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public String getName() {
    return name;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getPaymentId() {
    return paymentId;
  }

  public Long getTrainerId() {
    return TrainerId;
  }

  public void setPaymentId(Long paymentId) {
    this.paymentId = paymentId;
  }

  public void setTrainerId(Long trainerId) {
    TrainerId = trainerId;
  }
}
