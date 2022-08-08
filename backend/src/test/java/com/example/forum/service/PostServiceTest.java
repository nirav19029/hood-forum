package com.example.forum.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.quality.Strictness;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;


import com.example.forum.ForumApplication;
import com.example.forum.dto.Post;
import com.example.forum.repositoryservices.post.PostRepositoryService;
import com.example.forum.service.post.PostServiceImpl;
import com.example.forum.utils.FixtureHelpers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {ForumApplication.class})
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
@DirtiesContext
@ActiveProfiles("test")
public class PostServiceTest {
    protected static final String FIXTURES = "fixtures/exchanges";
    protected ObjectMapper objectMapper = new ObjectMapper();
    protected Post post1;
    protected Post post2;
    protected Post post3;

    @Autowired
    private PostServiceImpl postService;

    @MockBean
    private PostRepositoryService postRepositoryServiceMock;

    public List<Post> initializePostObjects() throws JsonMappingException, JsonProcessingException {
        String fixture = FixtureHelpers.fixture(FIXTURES + "/mock_list_of_post.json");
        Post[] posts = objectMapper.readValue(fixture, Post[].class);

        post1=posts[0];
        post2=posts[1];
        post3=posts[2];
        return Arrays.asList(posts);
    }

    @BeforeEach
    public void setup() {
      try {
        initializePostObjects();
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }



    @Test
    public void getAllPosts() throws IOException {
        when(postRepositoryServiceMock.getAllPost())
        .thenReturn(Arrays.asList(post1,post2,post3));

        List<Post> p = postService.getAllPost();

        System.out.println(p);
        assertEquals(3, p.size());
        // assertEquals("62e8bd8a3160e9725a0fc7ac", p.get(0).getPostId());
    }
}
