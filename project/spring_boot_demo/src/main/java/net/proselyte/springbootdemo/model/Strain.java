package net.proselyte.springbootdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "strains")
public class Strain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "strain_id")
    private Long strainId;

    @Column(name = "strain")
    private String strain;

    @Column(name = "culture_name")
    private String cultureName;

    @Column(name = "date_time_registration")
    private Date dateTimeRegistration;

    @Column(name = "country_id")
    private Long countryId;

    @Column(name = "city_id")
    private Long cityId;

    @Column(name = "organization_id")
    private Long organizationId;

}
