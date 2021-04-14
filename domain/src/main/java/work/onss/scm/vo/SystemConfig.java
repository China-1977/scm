package work.onss.scm.vo;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;


@Log4j2
@Data
@ConfigurationProperties(prefix = "system")
@EnableConfigurationProperties(SystemConfig.class)
@Configuration
public class SystemConfig implements Serializable {
    private String filePath;
    private String logo;
    private String secret;
}
