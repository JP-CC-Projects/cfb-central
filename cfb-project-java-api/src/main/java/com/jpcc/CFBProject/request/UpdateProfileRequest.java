package com.jpcc.CFBProject.request;

public record UpdateProfileRequest(String email,
                                   String firstName,
                                   String lastName,
                                   String currentPassword,
                                   String newPassword) {
}
