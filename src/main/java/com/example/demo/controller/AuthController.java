// package com.example.demo.controller;

// import com.example.demo.model.User;
// import com.example.demo.security.JwtTokenProvider;
// import com.example.demo.service.UserService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.HashMap;
// import java.util.Map;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final UserService userService;
//     private final JwtTokenProvider jwtTokenProvider;

//     public AuthController(UserService userService,
//                           JwtTokenProvider jwtTokenProvider) {
//         this.userService = userService;
//         this.jwtTokenProvider = jwtTokenProvider;
//     }

//     @PostMapping("/register")
//     public ResponseEntity<User> register(@RequestParam String email,
//                                          @RequestParam String password,
//                                          @RequestParam String role) {
//         return ResponseEntity.ok(
//                 userService.register(email, password, role)
//         );
//     }

//     @PostMapping("/login")
//     public ResponseEntity<Map<String, Object>> login(@RequestParam String email,
//                                                      @RequestParam String password) {

//         User user = userService.login(email, password);

//         String token = jwtTokenProvider.createToken(
//                 user.getEmail(),
//                 user.getRole(),
//                 user.getId()
//         );

//         Map<String, Object> response = new HashMap<>();
//         response.put("token", token);
//         response.put("email", user.getEmail());
//         response.put("role", user.getRole());

//         return ResponseEntity.ok(response);
//     }
// }

package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService service;

    public AuthController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {
        String token = service.login(user);
        return Map.of("token", token);
    }
}