package kz.yamuz.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="tracks")
public class Track{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
