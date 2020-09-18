package com.hcl.busbooking.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.busbooking.dto.BusRoutescurdDto;
import com.hcl.busbooking.dto.BusSearchDto;
import com.hcl.busbooking.dto.ResponseMessage;
import com.hcl.busbooking.exception.AdminNotFoundException;
import com.hcl.busbooking.model.BusRoute;
import com.hcl.busbooking.service.BusRouteService;

@RestController
public class BusRouteController {
	@Autowired
	private BusRouteService busRouteService;
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@PostMapping("/search")
	public ResponseEntity<List<BusRoute>> searchBuses(@Valid @RequestBody BusSearchDto dto) {
		LOGGER.warn("This is warning in controller");
        LOGGER.info("This is information about controller");
        LOGGER.debug("This is debugging in controller");  
		List<BusRoute> buses = busRouteService.searchBuses(dto);
		return new ResponseEntity<List<BusRoute>>(buses, HttpStatus.FOUND);

	}

	@PostMapping("/busRoute/{userId}")
	public ResponseEntity<BusRoutescurdDto> addBusRoute(@RequestBody BusRoutescurdDto dto,@PathVariable int userId) throws AdminNotFoundException{
		BusRoutescurdDto bus=busRouteService.addBusRoute(dto, userId);
		return new ResponseEntity<BusRoutescurdDto>(bus,HttpStatus.OK);
	}
	@PutMapping("/busRoute/{userId}")
	public ResponseEntity<BusRoutescurdDto> updateBusRoute(@RequestBody BusRoutescurdDto dto,@PathVariable int userId) throws AdminNotFoundException{
		BusRoutescurdDto bus=busRouteService.updateBusRoute(dto, userId);
		return new ResponseEntity<BusRoutescurdDto>(bus,HttpStatus.OK);
	}
	@DeleteMapping("/busRoute/{busServiceNumber}")
	public ResponseEntity<ResponseMessage> deleteBybus(@PathVariable int busServiceNumber, int userId){
		ResponseMessage bus=busRouteService.deleteByBusroute(busServiceNumber, userId);
		return new ResponseEntity<ResponseMessage>(bus,HttpStatus.OK);
	}
	@GetMapping("/busRoute/{busServiceNumber}")
	public ResponseEntity<BusRoute> getById( @PathVariable int busServiceNumber, int userId) throws AdminNotFoundException{
		BusRoute bus=busRouteService.getById(busServiceNumber, userId);
		return new ResponseEntity<BusRoute>(bus,HttpStatus.OK);
	}
}
