package entity;

import jakarta.persistence.Embeddable;

@Embeddable
public record Fee(Boolean issuedB, Boolean issuedA) {
}
