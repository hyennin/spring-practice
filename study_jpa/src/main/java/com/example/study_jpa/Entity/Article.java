package com.example.study_jpa.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.*;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Setter
@Getter
public class Article {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true, nullable=false)
    @NonNull
    private String title;

    @Column(nullable=false)
    @NonNull
    @NotBlank
    private String writer;

    @Lob
    @NonNull
    private String content;

    // mappedBy를 이용하여 외래키 관계 생성
    @OneToMany(mappedBy="article",
            fetch=FetchType.LAZY,
            cascade=CascadeType.ALL,
            orphanRemoval=true)
    private List<Comment> comments = new ArrayList<>();
}