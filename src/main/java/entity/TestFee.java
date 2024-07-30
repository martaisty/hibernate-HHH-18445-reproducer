package entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TestFee {
	@Id
	private Long id;
	@Embedded
	private Fee fee;

	public TestFee() {
	}

	public TestFee(Long id, Fee fee) {
		this.id = id;
		this.fee = fee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Fee getFee() {
		return fee;
	}

	public void setFee(Fee fee) {
		this.fee = fee;
	}
}
