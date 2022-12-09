package com.peaksoft.controller;

import com.peaksoft.dto.request.GroupRequest;
import com.peaksoft.dto.response.GroupResponse;
import com.peaksoft.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;

    @GetMapping("/getAllGroups")
    public List<GroupResponse> getAllGroup() {
        return groupService.getAllGroups();
    }

//    @GetMapping("/getAllGroupByCompanyId/{companyId}")
//    public List<GroupResponse> getAllGroupByCompanyId(@PathVariable Long companyId) {
//        return groupService.getAllGroup(companyId);
//    }

    @GetMapping("/getCourseById/{id}")
    public List<GroupResponse> getCourseById(@PathVariable Long id) {
        return groupService.getAllGroupsByCourseId(id);
    }

    @PostMapping("/{companyId}/saveGroup")
    public GroupResponse saveGroup(@PathVariable Long companyId, @RequestBody GroupRequest groupRequest) throws IOException {
        return groupService.saveGroup(companyId, groupRequest);
    }

    @PutMapping("/updateGroup/{id}")
    public GroupResponse updateGroup(@PathVariable Long id, @RequestBody GroupRequest groupRequest) {
        return groupService.updateGroup(id, groupRequest);
    }

    @DeleteMapping("/deleteGroupById/{id}")
    public GroupResponse deleteGroupById(@PathVariable Long id) {
        return groupService.deleteGroup(id);
    }

    @PostMapping("/assignGroup/{courseId}/{groupId}")
    public GroupResponse assignGroupCourse(@PathVariable Long groupId, @PathVariable Long courseId) throws IOException {
        return groupService.assignGroup(courseId,groupId);
    }
}
