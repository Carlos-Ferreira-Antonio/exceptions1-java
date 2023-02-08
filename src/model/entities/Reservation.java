package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	//Constructors
	public Reservation() {
		
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	//Getters and Setters
	//Não tem set checkout e nem checkin pois não posso mudar a data
	//Somente pelo metodo updateDates
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	//Metodos
	public long duration() {
		//Diferença das datas em milisegundos
		//Dps transformo para dias 
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Reservation dates for update must be future dates!";
		}
		// Se a data de checkOut não for posterior a data de checkIn
		if (!checkOut.after(checkIn)) {
			return "Check-out date must be after check-in date";
		} 
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null; //Operação não deu nenhum erro
	}

	@Override
	public String toString() {
		return "Room " + roomNumber 
				+ ", check-in: " + sdf.format(checkIn) 
				+ ", check-out: " + sdf.format(checkOut)
				+ ", " + duration() + " nights.";
	}
}