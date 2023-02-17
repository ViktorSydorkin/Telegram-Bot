package com.example.englishstudybot.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Phrasal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phrasal_id")
    private int id;
    @Column(name = "phrasal")
    private String phrasalVerb;
    @OneToMany
    @JoinColumn(name = "phrasal_fk_id")
    @Fetch(value = FetchMode.SELECT)
    private List<Meaning> meanings;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phrasal phrasal = (Phrasal) o;
        return id == phrasal.id && Objects.equals(phrasalVerb, phrasal.phrasalVerb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phrasalVerb);
    }
}
