package gym.management.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentInfoService {

  private final PaymentInfoRepository paymentMethodRepository;

  @Autowired
  public PaymentInfoService(PaymentInfoRepository paymentMethodRepository) {
    this.paymentMethodRepository = paymentMethodRepository;
  }



  public PaymentInfo createPaymentMethod(PaymentInfo paymentMethod) {
    return paymentMethodRepository.save(paymentMethod);
  }

  public List<PaymentInfo> getAllPaymentMethods() {
    return paymentMethodRepository.findAll();
  }

  public Optional<PaymentInfo> getPaymentMethodById(Long id) {
    return paymentMethodRepository.findById(id);
  }

  public PaymentInfo updatePaymentMethod(Long id, PaymentInfo paymentMethodDetails) {
    PaymentInfo paymentMethod = paymentMethodRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("PaymentInfo not found with id: " + id));

    // Update fields
    paymentMethod.setCreditCardNumber(paymentMethodDetails.getCreditCardNumber());
    paymentMethod.setCardHolderName(paymentMethodDetails.getCardHolderName());
    paymentMethod.setBillingAddress(paymentMethodDetails.getBillingAddress());
    paymentMethod.setExpirationDate(paymentMethodDetails.getExpirationDate());
    paymentMethod.setPaymentMethod(paymentMethodDetails.getPaymentMethod());
    paymentMethod.setLastUpdatedDate(LocalDate.now());

    return paymentMethodRepository.save(paymentMethod);
  }

  public void deletePaymentMethod(Long id) {
    paymentMethodRepository.deleteById(id);
  }
}
