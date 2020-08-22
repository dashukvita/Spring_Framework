package ru.otus.spring.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring.domain.Comment;
import ru.otus.spring.services.imp.CommentService;

@ShellComponent
@RequiredArgsConstructor
public class CommentCommand {

    private final CommentService commentService;

    @ShellMethod(value = "Get comment by id", key = {"get-comment-id", "GC"})
    public void getCommentById(@ShellOption long id) {
        Comment comment = commentService.findById(id);
        System.out.printf("%s  %s \n",
                comment.getId(),
                comment.getMessage());
    }
    
    @ShellMethod(value = "Get comments by book", key = {"get-comments-by-book", "GCB"})
    public void getCommentsByBook(@ShellOption long book_id) {
        commentService.findByBookId(book_id).forEach(comment ->
                System.out.printf("'%s' - %s\n",
                        comment.getBook().getTitle(),
                        comment.getMessage()));
    }

    @ShellMethod(value = "Get all comments", key = {"get-all-comments", "C"})
    public void getAllComments() {
        commentService.findAll().forEach(comment ->
                System.out.printf("'%s' - %s\n",
                        comment.getBook().getTitle(),
                        comment.getMessage()));
    }

    @ShellMethod(value = "Create comment", key = {"create-comment", "CC"})
    public void createComment(@ShellOption String message,
                              @ShellOption long bookId) {
        Comment comment = commentService.save(message, bookId);
        System.out.printf("Комментарий %s на книгу '%s' добавлен.\n",
                comment.getMessage(),
                comment.getBook().getTitle());
    }

    @ShellMethod(value = "Delete comment", key = {"delete-comment", "DC"})
    public void deleteComment(@ShellOption long id) {
        Comment comment = commentService.remove(id);
        System.out.printf("Комментарий '%s' удален.\n",
                comment.getMessage());
    }

}
