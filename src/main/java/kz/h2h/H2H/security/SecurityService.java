package kz.h2h.H2H.security;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}