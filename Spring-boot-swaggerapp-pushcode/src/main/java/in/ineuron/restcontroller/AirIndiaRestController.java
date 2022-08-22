package in.ineuron.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.reqeuest.PassengerInfo;
import in.ineuron.response.TicketInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/airIndia")
@Api(value = "This is Air India Disturbuted component")
public class AirIndiaRestController {

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Resource created"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@ApiOperation("This is used to book Flight ticket")
	@PostMapping(value = "/bookFlightTicket", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public ResponseEntity<TicketInfo> bookTicket(@RequestBody PassengerInfo passengerInfo) {

		TicketInfo ticketInfo = new TicketInfo();
		ticketInfo.setPassengerName(passengerInfo.getFname() + " " + passengerInfo.getLname());
		ticketInfo.setTicketPrice("250000$");
		ticketInfo.setTicketStatus("Booked");
		ticketInfo.setFrom(passengerInfo.getFrom());
		ticketInfo.setFlighId(passengerInfo.getFlighId());
		ticketInfo.setTo(passengerInfo.getTo());
		ticketInfo.setJourneyDate(passengerInfo.getJourneyDate());

		ResponseEntity<TicketInfo> responseEntity = new ResponseEntity<TicketInfo>(ticketInfo, HttpStatus.CREATED);

		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return responseEntity;
	}

	@ApiOperation(value = "This is used to get PNR status")
	@GetMapping("/pnrStatus/{pnr}")
	public String getPNRStatus(@PathVariable("pnr") Integer pnrNo) {
		return "status booked";
	}

}
