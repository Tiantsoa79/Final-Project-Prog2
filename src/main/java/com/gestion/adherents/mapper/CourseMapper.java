package com.gestion.adherents.mapper;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CourseMapper {
    private String name;

    private String teacher;

    private List<StudentMapper> adherents;
}
