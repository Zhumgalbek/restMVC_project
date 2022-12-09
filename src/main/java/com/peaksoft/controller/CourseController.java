package com.peaksoft.controller;

import com.peaksoft.dto.request.CourseRequest;
import com.peaksoft.dto.response.CourseResponse;
import com.peaksoft.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/getAllCourse")
    public List<CourseResponse> getAllCourse() {
        return courseService.getAllCourse();
    }

    @GetMapping("/getAllCourseByCompanyId/{companyId}")
    public List<CourseResponse> getAllCourseByCompanyId(@PathVariable Long companyId) {
        return courseService.getAllCourse(companyId);
    }

    @GetMapping("/getCourseById/{id}")
    public CourseResponse getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PostMapping("/{companyId}/saveCourse")
    public CourseResponse saveCourse(@PathVariable Long companyId, @RequestBody CourseRequest courseRequest) throws IOException {
        return courseService.saveCourse(companyId, courseRequest);
    }

    @PutMapping("/updateCourse/{id}")
    public CourseResponse updateCourse(@PathVariable Long id, @RequestBody CourseRequest courseRequest) {
        return courseService.updateCourse(id, courseRequest);
    }

    @DeleteMapping("/deleteCourseById/{id}")
    public CourseResponse deleteCourseById(@PathVariable Long id) {
        return courseService.deleteCourse(id);
    }


//
//    @PostMapping("/{courseId}/assignGroup")
//    private String assignGroup(@PathVariable Long courseId,
//                               @ModelAttribute("group") Group group) throws IOException {
//        System.out.println(group);
//        Long id = group.getId();
//        groupService.assignGroup(courseId, id);
//        return "redirect:/getAllGroupByCourseId/" + courseId;
//    }
//
//    @PostMapping("/{courseId}/assignInstructor")
//    private String assignInstructorToCourse(@PathVariable("courseId") Long courseId,
//                                            @ModelAttribute("instructor") Instructor instructor) throws IOException {
//        instructorService.assignInstructor(instructor.getId(), courseId);
//        return "redirect:/getAllInstructorByCourseId/ " + courseId;
//    }
}
