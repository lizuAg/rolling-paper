package gdsc.mini.runaway.repository;

import gdsc.mini.runaway.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Override
    List<Member> findAll();

    @Override
    Optional<Member> findById(Long aLong);
}
