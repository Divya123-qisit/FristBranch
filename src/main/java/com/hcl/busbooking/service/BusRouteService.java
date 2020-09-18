package com.hcl.busbooking.service;

import java.util.List;

import com.hcl.busbooking.dto.BusRoutescurdDto;
import com.hcl.busbooking.dto.BusSearchDto;
import com.hcl.busbooking.dto.ResponseMessage;
import com.hcl.busbooking.exception.AdminNotFoundException;
import com.hcl.busbooking.exception.BusNotFoundException;
import com.hcl.busbooking.model.BusRoute;

public interface BusRouteService {
	
	public List<BusRoute> searchBuses(BusSearchDto dto) throws BusNotFoundException;
	public BusRoutescurdDto addBusRoute(BusRoutescurdDto dto,int userId)throws AdminNotFoundException;
	public BusRoutescurdDto updateBusRoute(BusRoutescurdDto dto,int userId)throws AdminNotFoundException;
	public ResponseMessage deleteByBusroute(int busServiceNumber, int userId);
	public BusRoute getById(int busServiceNumber,int userId)throws AdminNotFoundException;


}
