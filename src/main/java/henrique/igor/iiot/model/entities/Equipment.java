package henrique.igor.iiot.model.entities;

import henrique.igor.iiot.model.enums.EquipStatus;
import henrique.igor.iiot.model.enums.EquipType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "equipments")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID equipmentId;

    @Column(nullable = false, unique = true)
    private String equipCode;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private EquipType type;

    @Column(nullable = false)
    private EquipStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sector_id")
    private Sector sector;

    @CreatedDate
    @DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
}
