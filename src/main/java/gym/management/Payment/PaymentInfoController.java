package gym.management.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment-info")
public class PaymentInfoController {

  private final PaymentInfoService paymentMethodService;

  @Autowired
  public PaymentInfoController(PaymentInfoService paymentMethodService) {
    this.paymentMethodService = paymentMethodService;
  }

  @PostMapping
  public PaymentInfo createPaymentMethod(@RequestBody PaymentInfo paymentMethod) {
    return paymentMethodService.createPaymentMethod(paymentMethod);
  }

  @GetMapping
  public List<PaymentInfo> getAllPaymentMethods() {
    return paymentMethodService.getAllPaymentMethods();
  }

  @GetMapping("/{id}")
  public ResponseEntity<PaymentInfo> getPaymentMethodById(@PathVariable Long id) {
    PaymentInfo paymentMethod = paymentMethodService.getPaymentMethodById(id)
        .orElseThrow(() -> new RuntimeException("PaymentInfo not found with id: " + id));
    return ResponseEntity.ok().body(paymentMethod);
  }

  @PutMapping("/{id}")
  public ResponseEntity<PaymentInfo> updatePaymentMethod(@PathVariable Long id, @RequestBody PaymentInfo paymentMethodDetails) {
    PaymentInfo updatedPaymentMethod = paymentMethodService.updatePaymentMethod(id, paymentMethodDetails);
    return ResponseEntity.ok(updatedPaymentMethod);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePaymentMethod(@PathVariable Long id) {
    paymentMethodService.deletePaymentMethod(id);
    return ResponseEntity.ok().build();
  }
}
