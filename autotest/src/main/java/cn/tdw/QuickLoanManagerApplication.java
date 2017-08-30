package cn.tdw;

import com.tuandai.ms.common.scheduler.config.SchedulerConfiguration;
import com.tuandai.ms.common.spring.BaseConfiguration;
import com.tuandai.ms.common.spring.ServiceClientConfiguration;
import com.tuandai.ms.common.spring.WebApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import({BaseConfiguration.class,
		ServiceClientConfiguration.class, WebApplication.class,SchedulerConfiguration.class})
public class QuickLoanManagerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(QuickLoanManagerApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(QuickLoanManagerApplication.class);
	}
}
