package lt.codeacademy.blog.comment;

import lt.codeacademy.blog.config.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository repository;

    @Autowired
    public CommentService(CommentRepository repository) {
        this.repository = repository;
    }

    public Comment save(Comment comment) {
        return repository.save(comment);
    }

    List<CommentView> getCommentView() {
        return repository.findAll()
                .stream()
                .map(this::mapToView)
                .collect(Collectors.toList());
    }

//    List<CommentView> findallForIrasas(int id) {
//        return repository.(id)
//                .stream()
//                .map(this::mapToView)
//                .collect(Collectors.toList());
//
//    }

    void updateComment(int id, CommentView updatedCommentView) {
        Comment comment = find(id);

        if (updatedCommentView.getComment() != null) {
            comment.setComment(updatedCommentView.getComment());
        }
        repository.save(comment);
    }

    public CommentView addComment(CommentView commentView, int id) {
//        comment.setComment(commentService.find(id));
//        commentView.setDate(Date.);
        return mapToView(repository.save(mapFromView(commentView)));
    }

    void deletePost(int id) {
        repository.deleteById(id);
    }

    private Comment mapFromView(CommentView commentView) {
        return new Comment(commentView.getComment(), commentView.getData(), commentView.getAnswer(), commentView.getPost());
    }

    private Comment find(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("CommentView not found"));
    }

    private CommentView mapToView(Comment comment) {
        return new CommentView(comment.getId(), comment.getComment(), comment.getData(), comment.getAnswer(), comment.getPost());
    }
}


