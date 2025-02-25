package anki.finalproject.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import anki.finalproject.ecommerce.model.Users;
import anki.finalproject.ecommerce.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UsersController {

    @Autowired
    private UsersService userService;

    @PostMapping("/register")
    public Users registerUser(@RequestBody Users user) {

        return userService.registerUser(user);
    }



@PostMapping("/login")
public ResponseEntity<Map<String, String>> loginUser(@RequestBody Users user) {
    Optional<Users> existingUser = userService.findByUsername(user.getUsername());

    if (existingUser.isPresent() && existingUser.get().getPassword().equals(user.getPassword())) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Login successful");
        return ResponseEntity.ok(response);
    } else {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("message", "Invalid credentials");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }
}

//        @Autowired
//        private UsersService userService;
//
//        @PostMapping("/forgot-password")
//        public ResponseEntity<?> forgotPassword(@RequestBody Map<String, String> request) {
//            String email = request.get("email");
//            userService.sendResetPasswordEmail(email);
//            return ResponseEntity.ok(Collections.singletonMap("message", "Password reset link sent"));
//        }
//    }

}


