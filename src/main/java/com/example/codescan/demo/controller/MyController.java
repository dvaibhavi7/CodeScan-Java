@RestController
public class MyController {
    
    private final MyService service;
    private String password = "myPassword123";
    
    public MyController(MyService service) {
        this.service = service;
    }
    
    @GetMapping("/my-endpoint")
    public String myEndpoint() {
        String message = service.getMessage();
        return "Received message: " + message;
    }
    
    @PostMapping("/my-endpoint")
    public void postMessage(@RequestBody String message) {
        service.saveMessage(message);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
    
}
