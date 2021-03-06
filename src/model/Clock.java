package model;
import java.time.LocalTime;

public class Clock implements Comparable<Clock> {
	
	// Attributes
	private byte hour;
	private byte minute;
	private byte second;
	
	// Constructors
	public Clock(int hour, int minute) {
		setHourMinute(hour, minute);
	}
	public Clock(byte hour, byte minute, byte second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	public Clock(byte hour, byte minute) {
		this.hour = hour;
		this.minute = minute;
	}
	public Clock() {
		hour = (byte) LocalTime.now().getHour();
		minute = (byte) LocalTime.now().getMinute();
	}
	
	//Getter/Setters
		public int getHour() {
			return hour;
		}
		public int getMinute() {
			return minute;
		}
		public int getSecond() { return second;}

		public void setHour(int hh) {
			if(hh < 0 || hh > 23) {
				throw new IllegalArgumentException("Heure invalide : "+hh);
			}
		
			hour = (byte) hh;
		}
		public void setMinute(int mm) {
			if(mm < 0 || mm > 59) {
				throw new IllegalArgumentException("Minute invalides : "+mm);
			}
			minute =  (byte) mm;
		}

		public void setSecond(int ss) {
			if(ss < 0 || ss > 59) {
				throw new IllegalArgumentException("Secondes invalides : "+ss);
			}
			second =  (byte) ss;
		}
		public void setHourMinute(int hh, int mm) {
			setHour(hh);
			setMinute(mm);
		}

		public void setHourMinuteSecond(int hh, int mm, int ss) {
		setHour(hh);
		setMinute(mm);
		setSecond(ss);
		}

		public void now() {
			setHourMinuteSecond(LocalTime.now().getHour(), LocalTime.now().getMinute(), LocalTime.now().getSecond());
		}
	
	// Methods
	
	/** 
	 * Prints hours and minutes as a string like a digital clock from 0 to 24h 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String strHour = Byte.toString(hour);
		String strMinute = Byte.toString(minute);
		// Add 0
		if(strHour.length() == 1){
			strHour = "0".concat(strHour);
		}
		if(strMinute.length() == 1){
			strMinute = "0".concat(strMinute);
		}
		return strHour+":"+strMinute;
	}

	public String toStringWithSeconds() {
		String strHour = Byte.toString(hour);
		String strMinute = Byte.toString(minute);
		String strSecond = Byte.toString(second);
		// Add 0
		if(strHour.length() == 1){
			strHour = "0".concat(strHour);
		}
		if(strMinute.length() == 1){
			strMinute = "0".concat(strMinute);
		}
		if(strSecond.length() == 1){
			strSecond = "0".concat(strSecond);
		}
		return strHour+":"+strMinute+":"+strSecond;
	}
	
	/**
	 *  Add the value min to the current hour and minute 
	 *  @param min the value of minutes
	 */
	public void fwdMinute(int min) {
		int newhour = hour;
		int newminute = minute;
		
		while (min >= 60) {
			newhour++;
			min -= 60;
		}
		while (min < 0) {
			newhour--;
			min += 60;
		}
		
		newminute += min;
		
		if (newminute > 60) {
			newminute -= 60;
			newhour++;
		}
		
		newhour = modulo(newhour, 24);
		
		setHour(newhour);
		setMinute(newminute);
	}
	
	public void print() {
		System.out.println(toString());
	}
	
	public int compareTo(Clock clock) {
		Clock compare = clock;
		int minuteEcart = 60 * (compare.hour - hour);
		minuteEcart += compare.minute - minute;
		return minuteEcart;
	}
	
	private static int modulo(int value, int mod) {
		while (value < 0) { value += mod; }
		while (value > mod) { value -= mod; }
		return value;
	}
	
	public Clock toQuarter() {
		if(this.getMinute() > 52) {
			return new Clock(this.getHour() + 1, 0);
		}
		if(this.getMinute() > 37) {
			return new Clock(this.getHour(), 45);
		}
		if(this.getMinute() > 22) {
			return new Clock(this.getHour(), 30);
		}
		if(this.getMinute() > 7) {
			return new Clock(this.getHour(), 30);
		}
		else {
			return new Clock(this.getHour(), 0);
		}
	}

}
