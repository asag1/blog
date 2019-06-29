package lt.codeacademy.blog.post;

import lt.codeacademy.blog.config.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/post")
@CrossOrigin("*")
public class PostController {

    private final PostService service;

    @Autowired
    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public List<PostView> getPost() {
        return service.getPostView();
    }

    @PostMapping(path = "/add")
    public PostView addPost(@RequestBody PostView postView) {
        return service.addPost(postView);
    }

    @PutMapping(path = "/update/{id}")
    public void updatePost(@PathVariable("id") int id, @RequestBody PostView postView) {
        service.updatePost(id, postView);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deletePost(@PathVariable("id") int id) {
        service.deletePost(id);
    }

    @ExceptionHandler({EmptyResultDataAccessException.class, NotFoundException.class})
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public void handleNotFoundException() {
    }
}
