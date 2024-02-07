package bo.edu.uto.dtic.sim;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("bo.edu.uto.dtic.sim.mapas")
public class SimApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimApplication.class, args);
	}
}
