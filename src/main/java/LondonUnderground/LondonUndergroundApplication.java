package LondonUnderground;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@EnableNeo4jRepositories
public class LondonUndergroundApplication {
	
	private final static Logger log = LoggerFactory.getLogger(LondonUndergroundApplication.class);

	public static void main(String[] args) throws Exception{
		SpringApplication.run(LondonUndergroundApplication.class, args);
	}
	
	
	
/*	/--------------testing by pre-processing the Graph-------------------------------/*/
	
/*	@Bean
	CommandLineRunner demo(StationRepository stationRepository) {
		return args -> {

			stationRepository.deleteAll();

			Station balham = new Station("Balham", "Balham", "London Borough of Wandsworth", 4);
			Station gunnersbury = new Station("Gunnersbury", "Gunnersbury", "London Borough of Hounslow", 2);
			Station kennington = new Station("Kennington", "Kennington Park Road", "Southwark", 4);

			List<Station> track = Arrays.asList(balham, gunnersbury, kennington);

			log.info("Before linking up with Neo4j...");

			track.stream().forEach(station -> log.info("\t" + station.toString()));

			stationRepository.save(balham);
			stationRepository.save(gunnersbury);
			stationRepository.save(kennington);

			balham = stationRepository.findByName(balham.getName());
			balham.createTrackTo(gunnersbury);
			balham.createTrackTo(kennington);
			stationRepository.save(balham);

			gunnersbury = stationRepository.findByName(gunnersbury.getName());
			gunnersbury.createTrackTo(kennington);
			stationRepository.save(gunnersbury);


			log.info("Lookup each station by name...");
			track.stream().forEach(station -> log.info(
					"\t" + stationRepository.findByName(station.getName()).toString()));
		};
	}*/
	
	
/*	/--------------testing by REST-------------------------------/*/
	
	//There are no stations so the JSON will return empty information
/*	$ curl http://localhost:8080/underground */	
	
	
	//Lets create 3 different stations
	
/*	$ curl -X PUT -H "Content-Type:application/json" -d '{  "name" : "Balham",  "location" : "Balham", "localAuthority" : "London Borough of Wandsworth",  "NumberOfPlatforms" : 4 }' http://localhost:8080/underground/0

/*	$ curl -i -X POST -H "Content-Type:application/json" -d '{  "name" : "Gunnersbury",  "location" : "Gunnersbury", "localAuthority" : "London Borough of Hounslow",  "NumberOfPlatforms" : 2 }' http://localhost:8080/underground */

/*	$ curl -i -X POST -H "Content-Type:application/json" -d '{  "name" : "Kennington",  "location" : "Kennington Park Road", "localAuthority" : "Southwark",  "NumberOfPlatforms" : 4 }' http://localhost:8080/underground */
	

	
	//Lets check the 3 different stations are there
/*	$ curl http://localhost:8080/underground	*/
	
	//Lets start complex queries
	
/*	$ curl http://localhost:8080/underground/search/findByStationName?name=Balham*/
	
/*	$ curl http://localhost:8080/underground/search/findByLocalAuthority?name=London Borough of Wandsworth*/
	
/*	$ curl http://localhost:8080/underground/search/findByLocation?name=Balham*/

	
}
