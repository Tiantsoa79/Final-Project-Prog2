package com.gestion.adherents.mapper;


import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CourseMapper {
    private String name;

    private String teacher;

    private Set<StudentMapper> adherents;
}
