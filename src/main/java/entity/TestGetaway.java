package entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TestGetaway {
	@Id
	private Long id;
	@Embedded
	private Getaway getaway;

	public TestGetaway() {
	}

	public TestGetaway(Long id, Getaway getaway) {
		this.id = id;
		this.getaway = getaway;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Getaway getGetaway() {
		return getaway;
	}

	public void setGetaway(Getaway getaway) {
		this.getaway = getaway;
	}
}
