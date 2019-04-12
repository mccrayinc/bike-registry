package pe.cespiritu.demo.bikeregister.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cespiritu.demo.bikeregister.models.Bike;

public interface BikeRepository extends JpaRepository<Bike, Long> {

}
