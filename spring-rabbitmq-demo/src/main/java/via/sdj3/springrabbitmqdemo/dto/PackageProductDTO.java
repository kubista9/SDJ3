package via.sdj3.springrabbitmqdemo.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;

public record PackageProductDTO(Long id, String description,
int numberOfParts, double weight,
@JsonSerialize(using = LocalDateSerializer.class) LocalDate packaged) {
}
