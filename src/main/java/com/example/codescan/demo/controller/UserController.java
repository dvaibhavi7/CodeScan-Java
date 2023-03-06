@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        if (user == null) {
            throw new NotFoundException("User not found");
        }
        return ResponseEntity.ok(user);
    }
}

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
