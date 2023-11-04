package kodlamaio.hrms.entities.concretes;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "position_advertisements")
public class PositionAdvertisement {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "details")
    private String detail;

    public PositionAdvertisement (){

    }
    public PositionAdvertisement(int id, String title, String detail) {
        this.id = id;
        this.title = title;
        this.detail = detail;
    }
}

