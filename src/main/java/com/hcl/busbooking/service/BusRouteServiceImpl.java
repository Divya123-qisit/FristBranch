package com.hcl.busbooking.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.busbooking.dao.BusRouteRepository;
import com.hcl.busbooking.dao.UserRepository;
import com.hcl.busbooking.dto.BusRoutescurdDto;
import com.hcl.busbooking.dto.BusSearchDto;
import com.hcl.busbooking.dto.ResponseMessage;
import com.hcl.busbooking.exception.AdminNotFoundException;
import com.hcl.busbooking.exception.BusNotFoundException;
import com.hcl.busbooking.model.BusRoute;
import com.hcl.busbooking.model.User;
@Service
public class BusRouteServiceImpl implements BusRouteService {
	
	@Autowired
	private BusRouteRepository busRouteRepository;
	@Autowired
	 private UserRepository userRepository;
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	 BusRoute bus=new BusRoute();
	 @Override
		public BusRoutescurdDto addBusRoute(BusRoutescurdDto dto, int userId) throws AdminNotFoundException {
			User user=userRepository.findByUserId(userId);
			LOGGER.warn("This is warning in service");
			LOGGER.info("This is information about service");
			LOGGER.debug("This is debugging in service");
			BeanUtils.copyProperties(dto, bus);
			BusRoute bus2=null;
			if(user.getRole().equals("admin")) {
			 bus2=busRouteRepository.save(bus);
			}
			else {
				throw new AdminNotFoundException("only admin");
			}
			return dto;
			}
	@Override
	public List<BusRoute> searchBuses(BusSearchDto dto) throws BusNotFoundException{
		LOGGER.warn("This is warning in service");
		LOGGER.info("This is information about service");	
		List<BusRoute> buses=busRouteRepository.findBySourceAndDestinationAndDate(dto.getSource(),dto.getDestination(),dto.getJourneyDate());
		if(buses.isEmpty()) {
			 throw new BusNotFoundException("sorry,buses are not available");
		}
		 return buses;
		
	}

	@Override
	public BusRoutescurdDto updateBusRoute(BusRoutescurdDto dto,int userId) throws AdminNotFoundException {
		User user=userRepository.findByUserId(userId);
		BeanUtils.copyProperties(dto, bus);
		BusRoute bus3=null;
		if(user.getRole().equals("admin")) {
		 bus3=busRouteRepository.save(bus);
		}
		else {
			throw new AdminNotFoundException("only admin");
		}
		return dto;
		}
	@Override
	public ResponseMessage deleteByBusroute(int busServiceNumber,int userId) {
		User user=userRepository.findByUserId(userId);
		ResponseMessage dto=new ResponseMessage();
		if(user.getRole().equals("admin")) {
			busRouteRepository.deleteById(busServiceNumber);
			dto.setMessage("deleted sucessfully");
		}
		else {
			dto.setMessage("you dont have to delete the bus");
		}
			return dto;
	}
	@Override
	public BusRoute getById(int busServiceNumber, int userId) throws AdminNotFoundException {
		User user=userRepository.findByUserId(userId);
		BusRoute bus3=null;
		if(user.getRole().equals("admin")) {
			 bus3=busRouteRepository.getOne(busServiceNumber);
		}else {
			throw new AdminNotFoundException("only admin");
		}

		
		return bus3;
	}


	
}
