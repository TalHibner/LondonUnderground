package LondonUnderground;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@NodeEntity
public class Station {

	/**
	 * I used https://en.wikipedia.org/wiki/List_of_London_Underground_stations
	 */
	
	@GraphId private Long id;
	
	/**
	 * The station name
	 */
	private String name;
	
	/**
	 * The station location
	 */
	private String location;
	
	/**
	 * The station local Authority
	 */
	private String localAuthority;

	/**
	 *  Number Of Platforms in the station
	 */
	private int NumberOfPlatforms;

	
	private Station() {
		// Empty constructor required as of Neo4j API 2.0.5
	};

	public Station(String name, String location, String localAuthority, int NumberOfPlatforms) {
		this.name = name;
		this.location = location;
		this.localAuthority = localAuthority;
		this.NumberOfPlatforms = NumberOfPlatforms;
	}

	/**
	 * The London Underground is a directional graph using neo4j.
	 * There is a track (relationship) from this station to each one of the target stations that exist in the targetStations set.
	 */
	@Relationship(type = "HAVE_TRACK_BETWEEN", direction = Relationship.DIRECTION)
	public Set<Station> targetStations;

	public void createTrackTo(Station station) {
		if (targetStations == null) {
			targetStations = new HashSet<>();
		}
		targetStations.add(station);
	}
	
	public void hasTrackTo(Station station) {
		if (targetStations == null) {
			targetStations = new HashSet<>();
		}
		targetStations.add(station);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocalAuthority() {
		return localAuthority;
	}

	public void setLocalAuthority(String localAuthority) {
		this.localAuthority = localAuthority;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNumberOfPlatforms() {
		return NumberOfPlatforms;
	}

	public void setNumberOfPlatforms(int numberOfPlatforms) {
		NumberOfPlatforms = numberOfPlatforms;
	}	
	
	public String toString() {

		return this.name + "'s target stations are => "
				+ Optional.ofNullable(this.targetStations).orElse(
						Collections.emptySet()).stream().map(
								station -> station.getName()).collect(Collectors.toList());
	}

}
