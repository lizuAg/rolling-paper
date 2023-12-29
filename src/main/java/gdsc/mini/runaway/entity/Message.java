package gdsc.mini.runaway.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Message extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Member from;

    @ManyToOne
    @JoinColumn
    private Member to;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column
    private MsgType type;
}
