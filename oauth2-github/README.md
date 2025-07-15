# Using GitHub for Authentication in Spring Boot (OAuth2)

### Step 1: Register Your App on GitHub

- Go to GitHub Developer Settings: 🔗https://github.com/settings/developers
  - Click "New OAuth App" → Fill in:
  - Application Name: Your App Name
  - Homepage URL: http://localhost:8080 (dev) or your production URL
  - Authorization callback URL: http://localhost:8080/login/oauth2/code/github (default Spring Boot OAuth2 URL)
  - Click "Register Application" → Note the Client ID and Client Secret.

### Step 2: Add Dependencies to pom.xml

```<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-oauth2-client</artifactId>
</dependency>
```

### Step 3: Configure application.yml


```
spring:
    security:
        oauth2:
            client:
                registration:
                    github:
                        client-id: YOUR_GITHUB_CLIENT_ID
                        client-secret: YOUR_GITHUB_CLIENT_SECRET
                        scope: user:email  # Request email access
```

#### Key Notes:

- Replace YOUR_GITHUB_CLIENT_ID and YOUR_GITHUB_CLIENT_SECRET with values from Step 1.
- scope: user:email ensures you get the user’s email (default scope only gives public profile).

### Step 4: Enable OAuth2 Login in Spring Security

```
java
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/login**").permitAll()
                .anyRequest().authenticated()
            )
            .oauth2Login(oauth2 -> oauth2
                .defaultSuccessUrl("/home", true)
            );
        return http.build();
    }
}
```

### Step 5: Create a Controller (Optional)
To display user details:

```
java
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public String user(@AuthenticationPrincipal OAuth2User user) {
        return "Hello, " + user.getAttribute("login") + "!";
    }

    @GetMapping("/email")
    public String email(@AuthenticationPrincipal OAuth2User user) {
        return "Your email: " + user.getAttribute("email");
    }
}
```

### Step 6: Run and Test
Start your Spring Boot app:

```
mvn spring-boot:run
```

Visit http://localhost:8080 → Click "Login with GitHub".
After authentication, you’ll be redirected to /home (or your success URL).