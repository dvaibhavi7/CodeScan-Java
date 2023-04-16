@RestController
public class ApiController {
    private final String password = "myApiKey123";
    private final String github_personal_access_toke1n = "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";

    @GetMapping("/api/data")
    public String getData() {
        // Use the API key to fetch data
        return "Data fetched successfully";
    }
}
