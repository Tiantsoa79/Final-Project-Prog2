package com.gestion.adherents.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

// Lombok
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
// JPA : pour faire en sorte que çà devienne une table.
@Entity
@Table(name = "\"student\"")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String reference;

    private String groupProm;


    @OneToMany(mappedBy = "adherents", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Course> courses = new HashSet<>();


}
