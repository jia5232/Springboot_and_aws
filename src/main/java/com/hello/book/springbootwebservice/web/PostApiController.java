package com.hello.book.springbootwebservice.web;

import com.hello.book.springbootwebservice.service.post.PostService;
import com.hello.book.springbootwebservice.web.dto.PostResponseDto;
import com.hello.book.springbootwebservice.web.dto.PostSaveRequestDto;
import com.hello.book.springbootwebservice.web.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostService postService;

    @PostMapping("/api/v1/post")
    public Long save(@RequestBody PostSaveRequestDto requestDto){
        return postService.save(requestDto);
    }

    @PutMapping("/api/v1/post/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto){
        return postService.update(id, requestDto);
    }

//    @DeleteMapping("/api/v1/post/{id}")
//    public Long delete(@PathVariable Long id){
//        postService.delete(id);
//        return id;
//    }

    @GetMapping("api/v1/post/{id}")
    public PostResponseDto findById(@PathVariable Long id){
        return postService.findById(id);
    }

}
