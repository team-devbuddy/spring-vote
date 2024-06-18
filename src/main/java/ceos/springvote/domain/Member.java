package ceos.springvote.domain;

import ceos.springvote.constant.Part;
import ceos.springvote.constant.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    @JsonIgnore
    private String loginId;

    @JsonIgnore
    private String password;

    @Email
    @JsonIgnore
    private String email;

    private Part part;

    @JsonIgnore
    private Role role;

    @OneToOne
    @JoinColumn(name = "team_id")
    @JsonIgnore
    private Team team;

    private int voteCount = 0;

    public void addVoteCount() {
        this.voteCount++;
    }

    public void subVoteCount() {
        this.voteCount--;
    }

}
