package com.fiap.goldendata.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "INFO_CONSUMIDOR")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InfoConsumidor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_info")
    private Long idInfo;

    @NotBlank(message = "A preferência de anúncios não pode estar em branco")
    @Size(max = 100, message = "A preferência de anúncios deve ter no máximo 100 caracteres")
    @Column(name = "pref_anc")
    private String prefAnc;

    @NotBlank(message = "Os hobbies não podem estar em branco")
    @Size(max = 200, message = "Os hobbies devem ter no máximo 200 caracteres")
    @Column(name = "hobbies")
    private String hobbies;

    @Size(max = 200, message = "Os anúncios evitados devem ter no máximo 200 caracteres")
    @Column(name = "anc_evitados")
    private String ancEvitados;

    @Column(name = "cmp_on")
    private String cmpOn;
}
