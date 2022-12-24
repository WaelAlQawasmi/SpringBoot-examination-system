package com.example.demo.Entity;

import lombok.*;

import javax.persistence.*;
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity

public class exams {

    @Setter(value = AccessLevel.NONE)
    @Id
    @GeneratedValue

    private Long id;
    @NonNull
    String name;
    @NonNull
    String date;

    @NonNull
    boolean inEnable;
    @NonNull
    int grade;
    @NonNull
    String category;
    @NonNull
    String subject;

    @NonNull
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private users user;



}
