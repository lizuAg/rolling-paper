package gdsc.mini.runaway.repository;

import gdsc.mini.runaway.entity.Member;
import gdsc.mini.runaway.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAllByFrom(Member from);

    List<Message> findAllByTo(Member to);

    Optional<Message> findById(Long id);
}
