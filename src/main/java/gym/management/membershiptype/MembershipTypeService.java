package gym.management.membershiptype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembershipTypeService {

  private final MembershipTypeRepository membershipTypeRepository;

  @Autowired
  public MembershipTypeService(MembershipTypeRepository membershipTypeRepository) {
    this.membershipTypeRepository = membershipTypeRepository;
  }

  public MembershipType createMembershipType(MembershipType membershipType) {
    return membershipTypeRepository.save(membershipType);
  }

  public List<MembershipType> getAllMembershipTypes() {
    return membershipTypeRepository.findAll();
  }

  public Optional<MembershipType> getMembershipTypeById(Long id) {
    return membershipTypeRepository.findById(id);
  }

  public MembershipType updateMembershipType(Long id, MembershipType membershipTypeDetails) {
    MembershipType membershipType = membershipTypeRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("MembershipType not found with id: " + id));

    membershipType.setName(membershipTypeDetails.getName());
    membershipType.setPrice(membershipTypeDetails.getPrice());

    return membershipTypeRepository.save(membershipType);
  }
  public void deleteMembershipType(Long id) {
    membershipTypeRepository.deleteById(id);
  }
}
