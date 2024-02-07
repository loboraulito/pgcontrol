package bo.edu.uto.dtic.pgcontrol;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("bo.edu.uto.dtic.pgcontrol.mapas")
public class PgcontrolApplication {

	public static void main(String[] args) {
		SpringApplication.run(PgcontrolApplication.class, args);
	}
}
