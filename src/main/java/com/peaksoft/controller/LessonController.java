package com.peaksoft.controller;

import com.peaksoft.dto.request.LessonRequest;
import com.peaksoft.dto.response.LessonResponse;
import com.peaksoft.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lessons")
public class LessonController {

    private final LessonService lessonService;

    @GetMapping("/getAllLesson")
    public List<LessonResponse> getAllLesson() {
        return lessonService.getAllLesson();
    }

    @GetMapping("/getLessonById/{id}")
    public LessonResponse getLessonIsCourseById(@PathVariable Long id) {
        return lessonService.getLessonById(id);
    }

    @PostMapping("/saveLesson/{courseId}")
    public LessonResponse saveCompany(@PathVariable Long courseId , @RequestBody LessonRequest lessonRequest ) {
        return lessonService.saveLesson(lessonRequest,courseId);
    }

    @PutMapping("/updateLesson/{id}")
    public LessonResponse updateLesson(@PathVariable Long id, @RequestBody LessonRequest lessonRequest) {
        return lessonService.updateLesson(id, lessonRequest);
    }

    @DeleteMapping("/deleteLesson/{id}")
    public LessonResponse deleteCompany(@PathVariable Long id) {
        return lessonService.deleteLessonById(id);
    }
}
