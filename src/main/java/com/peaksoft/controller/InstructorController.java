package com.peaksoft.controller;

import com.peaksoft.dto.request.InstructorRequest;
import com.peaksoft.dto.response.InstructorResponse;
import com.peaksoft.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    @GetMapping("/getAllInstructors")
    public List<InstructorResponse> getAllInstructor() {
        return instructorService.getAllInstructor();
    }

//    @GetMapping("/getAllGroupByCompanyId/{companyId}")
//    public List<GroupResponse> getAllGroupByCompanyId(@PathVariable Long companyId) {
//        return groupService.getAllGroup(companyId);
//    }

    @GetMapping("/getInstructorById/{id}")
    public List<InstructorResponse> getInstructorByIdIsCourse(@PathVariable Long id) {
        return instructorService.getAllInstructorIsCourse(id);
    }

    @PostMapping("/{courseId}/saveInstructor")
    public InstructorResponse saveInstructor(@PathVariable Long courseId, @RequestBody InstructorRequest instructorRequest) throws IOException {
        return instructorService.saveInstructor(courseId, instructorRequest);
    }

    @PutMapping("/updateInstructor/{id}")
    public InstructorResponse updateInstructor(@PathVariable Long id, @RequestBody InstructorRequest instructorRequest) throws IOException {
        return instructorService.updateInstructor(instructorRequest, id);
    }

    @DeleteMapping("/deleteInstructorById/{id}")
    public InstructorResponse deleteInstructorById(@PathVariable Long id) {
        return instructorService.deleteInstructor(id);
    }

    @PostMapping("/assignInstructorIsCourse/{courseId}/{instructorId}")
    public InstructorResponse assignGroupCourse(@PathVariable Long instructorId, @PathVariable Long courseId) throws IOException {
        return instructorService.assignInstructor(courseId,instructorId);
    }
}
