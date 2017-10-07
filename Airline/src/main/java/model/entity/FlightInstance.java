package model.entity;

import java.time.LocalTime;

public class FlightInstance {
	private Long id;
	private String from;
	private String to;
	private LocalTime duration;

	public static class Builder {
		private Long id;
		private String from;
		private String to;
		private LocalTime duration;

		public Builder setId(Long id) {
			this.id = id;
			return this;
		}

		public Builder setFrom(String from) {
			this.from = from;
			return this;
		}

		public Builder setTo(String to) {
			this.to = to;
			return this;
		}

		public Builder setTime(LocalTime duration) {
			this.duration = duration;
			return this;
		}

		public FlightInstance build() {
			FlightInstance flight = new FlightInstance();
			flight.setId(id);
			flight.setFrom(from);
			flight.setTo(to);
			flight.setDuration(duration);
			return flight;
		}
	}

	public FlightInstance() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public LocalTime getDuration() {
		return duration;
	}

	public void setDuration(LocalTime duration) {
		this.duration = duration;
	}

}
