package ru.otus.spring.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import ru.otus.spring.services.CommentService;

@ShellComponent
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

//    @ShellMethod(value = "Get all comments", key = {"get-all-comments", "C"})
//    public void getAllComments() {
//        commentService.findAll().forEach(comment ->
//                System.out.printf("'%s' - %s\n",
//                        comment.getBook().getBookName(),
//                        comment.getMessage()));
//    }
//
//    @ShellMethod(value = "Get comments by book", key = {"get-comments-by-book", "GCB"})
//    public void getCommentsByBook(@ShellOption Long bookId) {
//        commentService.findByBookId(bookId).forEach(comment ->
//                System.out.printf("'%s' - %s\n",
//                        comment.getBook().getBookName(),
//                        comment.getMessage()));
//    }
//
//    @ShellMethod(value = "Create comment", key = {"create-comment", "CC"})
//    public void createComment(@ShellOption String message,
//                              @ShellOption Long bookId) {
//        Comment comment = commentService.createComment(message, bookId);
//        System.out.printf("Комментарий %s на книгу '%s' добавлен.\n",
//                comment.getMessage(),
//                comment.getBook().getBookName());
//    }
//
//    @ShellMethod(value = "Get comment by id", key = {"get-comment-id", "GC"})
//    public void getCommentNameById(@ShellOption Long id) throws Exception {
//        Comment comment = commentService.findById(id).orElseThrow(() -> new CommentNotFoundException("Comment with id " + id + " not found."));
//
//        System.out.printf("%s  %s \n",
//                comment.getId(),
//                comment.getMessage());
//    }
//
//    @ShellMethod(value = "Delete comment", key = {"delete-comment", "DC"})
//    public void deleteComment(@ShellOption Long id) {
//        commentService.deleteComment(id);
//    }

}
