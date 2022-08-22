package in.ineuron.response;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class TicketInfo {
	private String passengerName;
	private String to;
	private String from;
	private String flighId;
	private String journeyDate;
	private String ticketPrice;
	private String ticketStatus;
}
