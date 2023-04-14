import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserController {

    public ResponseEntity<User> getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        if (user == null) {
            throw new NotFoundException("User not found");
        }
        return ResponseEntity.ok(user);
    }
}

