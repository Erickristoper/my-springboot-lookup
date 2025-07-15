# FilterChain
When a request comes into a Spring web application, it goes through a series of processing steps before reaching your controller and then sending a response back. Let me explain this mechanism in a simple way.

## Key Parts
* HttpServletRequest: Represents the incoming HTTP request (headers, parameters, body, etc.)
* ServletResponse: Represents the HTTP response that will be sent back
* FilterChain: A chain of filters that the request passes through before reaching the servlet (your controller)

### Request Flow
1. Request enters the application
2. Passes through each filter in the FilterChain (each can modify request/response or stop processing)
3. Reaches the DispatcherServlet (Spring's front controller)
4. Dispatched to the appropriate controller method
5. Response travels back through the filters in reverse order

### Example
1. Create a Spring Boot project

    Use start.spring.io with these dependencies: 
   * Spring Web
2. Create a custom filter

```
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CustomFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        
        System.out.println("Filter: Processing request to " + httpRequest.getRequestURI());

        chain.doFilter(request, response);
        
        System.out.println("Filter: Processing response for " + httpRequest.getRequestURI());
    }
}
```

3. Register the filter
```
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<CustomFilter> loggingFilter() {
        FilterRegistrationBean<CustomFilter> registrationBean = new FilterRegistrationBean<>();
        
        registrationBean.setFilter(new CustomFilter());
        registrationBean.addUrlPatterns("/*"); // Apply to all URLs
        
        return registrationBean;
    }
}
```

4. Create a simple controller

```
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/hello")
    public String sayHello() {
        System.out.println("Controller: Handling request");
        return "Hello from Spring!";
    }
}
```
### Output

![Screenshot 2025-07-15 at 2.11.34 PM.png](Screenshot%202025-07-15%20at%202.11.34%E2%80%AFPM.png)
