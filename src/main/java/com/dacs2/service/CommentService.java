package com.dacs2.service;

import com.dacs2.model.Comment;
import com.dacs2.model.Product;
import com.dacs2.model.UserDtls;

import java.util.List;

public interface CommentService {

    Comment addReply(Long commentId, String replyComment, UserDtls userDtls);

    List<Comment> getAllReplyByAdmin(Product product);

}
