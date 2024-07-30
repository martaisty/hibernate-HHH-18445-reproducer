package entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TestVacation {
	@Id
	private Long id;
	@Embedded
	private Vacation vacation;

	public TestVacation() {
	}

	public TestVacation(Long id, Vacation vacation) {
		this.id = id;
		this.vacation = vacation;
	}

	public Vacation getVacation() {
		return vacation;
	}

	public void setVacation(Vacation vacation) {
		this.vacation = vacation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
