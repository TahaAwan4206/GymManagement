package gym.management.Payment;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "payment_info")
public class PaymentInfo {

  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long PaymentId;
  @Column
  private String creditCardNumber;
  @Column
  private String cardHolderName;
  @Column
  private String billingAddress;
  @Column
  private String expirationDate;

  @Column
  private String paymentMethod;
  @Column
  private LocalDate creationDate;
  @Column
  private LocalDate lastUpdatedDate;

  public PaymentInfo() {

  }

  public void setId(Long id) {
    this.PaymentId = id;
  }

  public Long getId() {
    return PaymentId;
  }

  public LocalDate getCreationDate() {
    return creationDate;
  }

  public LocalDate getLastUpdatedDate() {
    return lastUpdatedDate;
  }

  public String getBillingAddress() {
    return billingAddress;
  }

  public String getCardHolderName() {
    return cardHolderName;
  }

  public String getCreditCardNumber() {
    return creditCardNumber;
  }

  public String getExpirationDate() {
    return expirationDate;
  }

  public String getPaymentMethod() {
    return paymentMethod;
  }

  public void setBillingAddress(String billingAddress) {
    this.billingAddress = billingAddress;
  }

  public void setCardHolderName(String cardHolderName) {
    this.cardHolderName = cardHolderName;
  }

  public void setCreationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
  }

  public void setCreditCardNumber(String creditCardNumber) {
    this.creditCardNumber = creditCardNumber;
  }

  public void setPaymentMethod(String paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public void setExpirationDate(String expirationDate) {
    this.expirationDate = expirationDate;
  }

  public void setLastUpdatedDate(LocalDate lastUpdatedDate) {
    this.lastUpdatedDate = lastUpdatedDate;
  }

}
