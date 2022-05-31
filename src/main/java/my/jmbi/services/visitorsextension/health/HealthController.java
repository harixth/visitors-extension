package my.jmbi.services.visitorsextension.health;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

@RestController
public class HealthController {

    @Autowired
    private MessageSource messageSource;

    // GET
    // Check for service health
    //@RequestMapping(method = RequestMethod.GET, path = "/health")
    @GetMapping(path = "/health")
    public String healthCheck(
            // @RequestHeader(name = "Accept-Language", required=false) Locale locale
    ) {
        return messageSource.getMessage("good.health.message", null, "OK",
                LocaleContextHolder.getLocale());
    }

    @GetMapping(path = "/health-bean")
    public MappingJacksonValue healthCheckBean() {
        HealthCheck hb = new HealthCheck("OK");
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("message");
        FilterProvider filters = new SimpleFilterProvider().addFilter("HealthBeanFilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(hb);
        mapping.setFilters(filters);
        return mapping;
    }

    @GetMapping(path = "/hello-wold/path-variable/{name}")
    public HealthCheck healthCheckBean(@PathVariable String name) {
        return new HealthCheck(String.format("Hello %S", name));
    }


}
