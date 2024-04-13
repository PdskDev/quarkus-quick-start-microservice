package me.nadetdev.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantModel {

    private Long id;
    private String firstName;
    private String lastName;
    private boolean active;
}
