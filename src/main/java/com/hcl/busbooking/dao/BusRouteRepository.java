package com.hcl.busbooking.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.busbooking.model.BusRoute;

public interface BusRouteRepository extends JpaRepository<BusRoute, Integer>{
	
	public List<BusRoute> findBySourceAndDestinationAndDate(String source,String destination,Date date);

}
