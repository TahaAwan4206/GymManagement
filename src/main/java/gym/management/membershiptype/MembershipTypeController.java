package gym.management.membershiptype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/membership-types")
public class MembershipTypeController {

  private final MembershipTypeService membershipTypeService;

  @Autowired
  public MembershipTypeController(MembershipTypeService membershipTypeService) {
    this.membershipTypeService = membershipTypeService;
  }

  @PostMapping
  public MembershipType createMembershipType(@RequestBody MembershipType membershipType) {
    return membershipTypeService.createMembershipType(membershipType);
  }

  @GetMapping
  public List<MembershipType> getAllMembershipTypes() {
    return membershipTypeService.getAllMembershipTypes();
  }

  @GetMapping("/{id}")
  public ResponseEntity<MembershipType> getMembershipTypeById(@PathVariable Long id) {
    MembershipType membershipType = membershipTypeService.getMembershipTypeById(id)
        .orElseThrow(() -> new RuntimeException("MembershipType not found with id: " + id));
    return ResponseEntity.ok().body(membershipType);
  }

  @PutMapping("/{id}")
  public ResponseEntity<MembershipType> updateMembershipType(@PathVariable Long id, @RequestBody MembershipType membershipTypeDetails) {
    MembershipType updatedMembershipType = membershipTypeService.updateMembershipType(id, membershipTypeDetails);
    return ResponseEntity.ok(updatedMembershipType);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteMembershipType(@PathVariable Long id) {
    membershipTypeService.deleteMembershipType(id);
    return ResponseEntity.ok().build();
  }
}
