package com.fiap.goldendata.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CADASTRO_CONSUMIDOR")
public class CadastroConsumidor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cons")
    private Long idCons;

    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "O email deve ser válido.")
    @Column(name = "eml_cons")
    private String emlCons;

    @NotBlank(message = "O nome é obrigatório.")
    @Column(name = "nm_cons")
    private String nmCons;

    @NotBlank(message = "O gênero é obrigatório.")
    @Column(name = "gen_cons")
    private String genCons;

    @NotNull(message = "A data de nascimento é obrigatória.")
    @Past(message = "A data de nascimento deve ser no passado.")
    @Column(name = "dt_nasc_cons")
    private LocalDate dtNascCons;
}
