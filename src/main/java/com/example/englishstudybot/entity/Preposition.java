package com.example.englishstudybot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Preposition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "preposition_id")
    private int id;
    @Column(name = "preposition")
    private String preposition;
    @OneToMany(mappedBy = "preposition")
    @Fetch(value = FetchMode.SELECT)
    @Lazy(value = false)
    List<Phrase> phrases;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Preposition that = (Preposition) o;
        return id == that.id && preposition.equals(that.preposition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, preposition);
    }
}
