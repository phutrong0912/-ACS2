package com.dacs2.service;

import com.dacs2.model.UserDtls;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {

    UserDtls saveUser(UserDtls user);

    UserDtls getUserByEmail(String email);

    Page<UserDtls> getUsers(Integer pageNumber, Integer pageSize, String role);

    UserDtls updateAccountStatus(Integer id, Boolean status);

    void increaseFailedAttempt(UserDtls user);

    void userAccountLock(UserDtls user);

    boolean unlockAccountTimeExpired(UserDtls user);

    void resetAttempt(int userId);

    void updateUserResetToken(String email, String resetToken);

    UserDtls getUserByToken(String token);

    UserDtls updateUser(UserDtls user);

    UserDtls updateUserProfile(UserDtls user, MultipartFile img) throws IOException;

    Page<UserDtls> searchUsers(Integer pageNumber, Integer pageSize, String role, String search);

    UserDtls saveAmin(UserDtls user);

    List<UserDtls> getAllAdmin();

    Boolean existsEmail(String email);

    void updateConfirmEmailToken(String email, String confirmToken);

    UserDtls addUser(UserDtls user);

    UserDtls confirmEmail(String confirmToken);

    UserDtls getFirstAdmin();

}
