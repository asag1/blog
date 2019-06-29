package lt.codeacademy.blog.comment;

import lt.codeacademy.blog.config.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/comment")
@CrossOrigin("*")
public class CommentController {

    private final CommentService service;

    @Autowired
    public CommentController(CommentService service) {
        this.service = service;
    }

    @GetMapping
    public List<CommentView> getComment() {
        return service.getCommentView();
    }

    @PostMapping(path = "/add")
    public CommentView addComment(@RequestBody CommentView commentView) {
        return service.addComment(commentView);
    }

    @PutMapping(path = "/update/{id}")
    public void updateComment(@PathVariable("id") int id, @RequestBody CommentView commentView) {
        service.updateComment(id, commentView);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteComment(@PathVariable("id") int id) {
        service.deletePost(id);
    }

    @ExceptionHandler({EmptyResultDataAccessException.class, NotFoundException.class})
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public void handleNotFoundException() {
    }
}
