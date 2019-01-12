package ummto.l3.travelagency.accessdonnees;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ummto.l3.travelagency.bdd.Hotel;

@Repository
public interface HotelDao extends CrudRepository<Hotel, Integer> {

	/**
	 * retrouve les hotel dans une fourchette de prix et dans adresse sp�cefique
	 * 
	 * @param maxPrix
	 * @param minPrix
	 * @param adresse
	 * @return
	 */
	@Query(value = "select * from hotel where prix <= :maxPrix and prix >= :minPrix and adresse like CONCAT('%',:adresse,'%')", nativeQuery = true)
	List<Hotel> listerToutFiltre(@Param("maxPrix") int maxPrix, @Param("minPrix") int minPrix,
			@Param("adresse") String adresse);

	@Query(value = "select * from hotel where prix <= :maxPrix and prix >= :minPrix", nativeQuery = true)
	List<Hotel> listParPrix(@Param("maxPrix") int maxPrix, @Param("minPrix") int minPrix);

	@Query(value = "select * from hotel where adresse like '%:adresse%'", nativeQuery = true)
	List<Hotel> listParAdresse(@Param("maxPrix") int maxPrix, @Param("minPrix") int minPrix);
}
