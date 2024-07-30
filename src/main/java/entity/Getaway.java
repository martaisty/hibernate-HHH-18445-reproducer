package entity;

import jakarta.persistence.Embeddable;

@Embeddable
public record Getaway(
        String getawayB,
        String getawayA
) {
}
