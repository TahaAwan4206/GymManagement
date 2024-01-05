package gym.management.member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

  private final MemberRepository memberRepository;

  @Autowired
  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  public Member addMember(Member member) {
    return memberRepository.save(member);
  }

  public List<Member> getAllMembers() {
    return memberRepository.findAll();
  }

  public Optional<Member> getMemberById(Long id) {
    return memberRepository.findById(id);
  }

  public Member updateMember(Long id, Member memberDetails) {
    Member member = memberRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));
    member.setName(memberDetails.getName());
    member.setPhoneNumber(memberDetails.getPhoneNumber());
    member.setDateOfBirth(memberDetails.getDateOfBirth());
    member.setEmailAddress(memberDetails.getEmailAddress());
    return memberRepository.save(member);
  }
  public void deleteMember(Long id) {
    memberRepository.deleteById(id);
  }
}
