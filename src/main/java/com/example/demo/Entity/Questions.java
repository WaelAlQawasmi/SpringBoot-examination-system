package com.example.demo.Entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Questions {

    @Id
    @GeneratedValue

    private Long id;
    @NonNull
    String body;
    @NonNull
    int score;

    @NonNull
    String type;


    @NonNull
    String subject;

    @NonNull
    @ManyToOne
    @JoinColumn(name="exam_id", nullable=false)
    private exams exam;


}
