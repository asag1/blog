package lt.codeacademy.blog.comment;

import lt.codeacademy.blog.config.NotFoundException;
import lt.codeacademy.blog.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/comment")
@CrossOrigin("*")
public class CommentController {

    private final CommentService commentService;
    private final PostService postService;

    @Autowired
    public CommentController(CommentService commentService, PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
    }

//    @GetMapping
//    public List<CommentView> getComment() {
//        return commentService.getCommentView();
//    }
//    Gal nereikia

    @PostMapping(path = "/addComment")
    public String addComment(@Valid Comment comment, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/commentForm";

        } else {
            commentService.save(comment);
            return "redirect:/post/" + comment.getPost().getId();
        }
    }

//        return service.addComment(commentView);
//    }

//    @PutMapping(path = "/update/{id}")
//    public void updateComment(@PathVariable("id") int id, @RequestBody CommentView commentView) {
//        commentService.updateComment(id, commentView);
//    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteComment(@PathVariable("id") int id) {
        commentService.deletePost(id);
    }

    @ExceptionHandler({EmptyResultDataAccessException.class, NotFoundException.class})
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public void handleNotFoundException() {
    }
}
