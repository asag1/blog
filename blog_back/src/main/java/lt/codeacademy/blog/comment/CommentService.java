package lt.codeacademy.blog.comment;

import lt.codeacademy.blog.config.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository repository;

    @Autowired
    public CommentService(CommentRepository repository) {
        this.repository = repository;
    }

    List<CommentView> getCommentView() {
        return repository.findAll()
                .stream()
                .map(this::mapToView)
                .collect(Collectors.toList());
    }

    void updateComment(int id, CommentView updatedCommentView) {
        Comment comment = find(id);

        if (updatedCommentView.getComment() != null) {
            comment.setComment(updatedCommentView.getComment());
        }
        if (updatedCommentView.getDate() != null) {
            comment.setDate(updatedCommentView.getDate());
        }
        if (updatedCommentView.getRating() != null) {
            comment.setRating(updatedCommentView.getRating());
        }
        repository.save(comment);
    }

    CommentView addComment(CommentView commentView) {
        return mapToView(repository.save(mapFromView(commentView)));
    }

    void deletePost(int id) {
        repository.deleteById(id);
    }

    private Comment mapFromView(CommentView commentView) {
        return new Comment(commentView.getComment(), commentView.getDate(), commentView.getPost(), commentView.getRating());
    }

    private Comment find(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("CommentView not found"));
    }

    private CommentView mapToView(Comment comment) {
        return new CommentView(comment.getId(), comment.getComment(), comment.getDate(), comment.getPost(), comment.getRating());
    }
}


