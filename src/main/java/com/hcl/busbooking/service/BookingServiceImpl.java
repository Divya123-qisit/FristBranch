package com.hcl.busbooking.service;

import java.util.Optional;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hcl.busbooking.dao.BookingRepository;
import com.hcl.busbooking.dao.BusRouteRepository;
import com.hcl.busbooking.dao.UserRepository;
import com.hcl.busbooking.dto.BookingDto;
import com.hcl.busbooking.dto.BookingsDto;
import com.hcl.busbooking.model.Booking;
import com.hcl.busbooking.model.BusRoute;
import com.hcl.busbooking.model.User;
@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	BusRouteRepository busRouteRepository;
	@Autowired
	RestTemplate restTemplate;
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	BookingDto dto = new BookingDto();

	@Override
	public BookingDto bookTheSeat(BookingsDto bookingDto, long userAccountNumber, long busoperatorAccountNumber)
			throws JSONException {
		LOGGER.warn("This is warning in service");
		LOGGER.info("This is information about service");
		LOGGER.debug("This is debugging in service");

		Booking booking = new Booking();
		BeanUtils.copyProperties(bookingDto, booking);

		Optional<User> optional = userRepository.findById(bookingDto.getUserId());
		User user = null;
		if (optional.isPresent()) {
			user = optional.get();
		}
		if (user != null) {

			Optional<BusRoute> option = busRouteRepository.findById(bookingDto.getBusServiceNumber());
			BusRoute bus = null;
			if (option.isPresent()) {
				bus = option.get();
			}

			bus.setAvailableSeats(bus.getAvailableSeats() - bookingDto.getNumberOfSeats());
			bus.setBusName(bus.getBusName());
			busRouteRepository.save(bus);
			booking.setUser(user);
			booking.setBusroute(bus);
			booking.setNoOfSeats(bookingDto.getNumberOfSeats());
			booking.setAmmount(bookingDto.getNumberOfSeats() * bus.getFare());

			Booking booking1 = bookingRepository.save(booking);

			int ammount = booking1.getAmmount();
			if (ammount > 0) {
				String uri = "http://localhost:9093/transfer";

				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);

				JSONObject request = new JSONObject();
				request.put("savingsAccountNumber", userAccountNumber);
				request.put("beneficiaryAccountNumber", busoperatorAccountNumber);
				request.put("transferAmmount", ammount);

				HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);

				restTemplate.postForEntity(uri, entity, String.class);

			}
			dto.setBusName(booking1.getBusroute().getBusName());
			dto.setBusServiceNumber(booking1.getBusroute().getBusServiceNumber());
			dto.setNoOfSeats(booking1.getNoOfSeats());
			dto.setJourneyDate(booking1.getJourneyDate());

		}
		return dto;

	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
