package com.gestion.adherents.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

// Lombok
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
// JPA : pour faire en sorte que çà devienne une table.
@Entity
@Table(name = "\"course\"")
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_course;

    @Column(nullable = false)
    private String name;

    private String teacher;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "have",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")}
    )
    private List<Student> adherents;

}
