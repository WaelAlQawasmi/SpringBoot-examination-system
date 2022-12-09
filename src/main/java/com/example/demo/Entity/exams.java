package com.example.demo.Entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class exams {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @NonNull
    String name;
    @NonNull
    String date;
    @NonNull
    String createBy;
    @NonNull
    boolean inEnable;
    @NonNull
    int grade;
    @NonNull
    String category;
    @NonNull
    String subject;


}
