package gym.management.member;
import gym.management.Payment.PaymentInfo;
import gym.management.Payment.PaymentInfoService;
import gym.management.Trainers.Trainer;
import gym.management.Trainers.TrainerService;
import gym.management.membershiptype.MembershipType;
import gym.management.membershiptype.MembershipTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

  private final MembershipTypeService membershipTypeService;
  private final TrainerService trainerService;
  private final PaymentInfoService paymentMethodService;
  private final MemberService memberService;

  @Autowired
  public MemberController(MemberService memberService, MembershipTypeService membershipTypeService, TrainerService trainerService, PaymentInfoService paymentMethodService) {
    this.membershipTypeService = membershipTypeService;
    this.memberService = memberService;
    this.trainerService = trainerService;
    this.paymentMethodService = paymentMethodService;
  }

  @PostMapping
  public ResponseEntity<Member> addMember(@RequestBody MemberDTO memberDTO) {
    Member member = new Member();
    member.setName(memberDTO.getName());
    member.setEmailAddress(memberDTO.getEmailAddress());
    member.setDateOfBirth(memberDTO.getDateOfBirth());
    member.setPhoneNumber(memberDTO.getPhoneNumber());
    if (memberDTO.getMembershipTypeId() != null) {
      MembershipType membershipType = membershipTypeService.getMembershipTypeById(memberDTO.getMembershipTypeId())
          .orElseThrow(() -> new RuntimeException("MembershipType not found"));
      member.setMembershipType(membershipType);
    }

    if (memberDTO.getPaymentId() != null) {
      PaymentInfo paymentMethod = paymentMethodService.getPaymentMethodById(memberDTO.getPaymentId())
          .orElseThrow(() -> new RuntimeException("PaymentInfo not found"));
      member.setPaymentMethod(paymentMethod);
    }

    if (memberDTO.getTrainerId() != null) {
      Trainer trainer = trainerService.getTrainerById(memberDTO.getTrainerId())
          .orElseThrow(() -> new RuntimeException("Trainer not found"));
      member.setTrainer(trainer);
    }

    Member newMember = memberService.addMember(member);
    return ResponseEntity.ok(newMember);
  }


  @GetMapping
  public List<Member> getAllMembers() {
    return memberService.getAllMembers();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
    Member member = memberService.getMemberById(id)
        .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));
    return ResponseEntity.ok().body(member);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member memberDetails) {
    Member updatedMember = memberService.updateMember(id, memberDetails);
    return ResponseEntity.ok(updatedMember);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
    memberService.deleteMember(id);
    return ResponseEntity.ok().build();
  }
}
