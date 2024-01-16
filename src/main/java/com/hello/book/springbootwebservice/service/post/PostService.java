package com.hello.book.springbootwebservice.service.post;

import com.hello.book.springbootwebservice.domain.posts.Post;
import com.hello.book.springbootwebservice.domain.posts.PostRepository;
import com.hello.book.springbootwebservice.web.dto.PostResponseDto;
import com.hello.book.springbootwebservice.web.dto.PostSaveRequestDto;
import com.hello.book.springbootwebservice.web.dto.PostUpdateRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto) {
        return postRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostUpdateRequestDto requestDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id:" + id));
        post.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostResponseDto findById(Long id){
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id:" + id));
        return new PostResponseDto(post);
    }
}
