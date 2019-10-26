package LondonUnderground;

import java.util.Collection;
import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "underground", path = "underground")
public interface StationRepository extends PagingAndSortingRepository<Station, Long> {

	/**
	 * REST api request for searching the station in the graph for details by Name
	 */
    Station findByName(@Param("name") String name);
    
	/**
	 * REST api request for searching the station in the graph for details by Local Authority
	 */
    Station findByLocalAuthority(@Param("localAuthority") String localAuthority);
    
	/**
	 * REST api request for searching the station in the graph for details by Location
	 */
    Station findByLocation(@Param("location") String location);
    
	/**
	 * Querying for a relation between an origin station to the target station
	 */     
	@Query("MATCH (m:Station)<-[r:HAVE_TRACK_BETWEEN]-(a:Station) RETURN m,r,a LIMIT {limit}")
	Collection<Station> graph(@Param("limit") int limit);
	
}