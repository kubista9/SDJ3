package via.sdj3.springrabbitmqdemo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Product.class)
public class Product implements Serializable {
    private Long id;
    private String description;
    private int numberOfParts;
    private double weight;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // Date
    private LocalDate packaged;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfParts() {
        return numberOfParts;
    }

    public void setNumberOfParts(int numberOfParts) {
        this.numberOfParts = numberOfParts;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public LocalDate getPackaged() {
        return packaged;
    }

    public void setPackaged(LocalDate packaged) {
        this.packaged = packaged;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", numberOfParts=" + numberOfParts +
                ", weight=" + weight +
                ", packaged=" + packaged +
                '}';
    }
}
