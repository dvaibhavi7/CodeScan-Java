@RestController
public class ApiController {
    private final String apiKey = "myApiKey123";

    @GetMapping("/api/data")
    public String getData() {
        // Use the API key to fetch data
        return "Data fetched successfully";
    }
}
