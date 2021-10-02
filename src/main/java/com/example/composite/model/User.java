package com.example.composite.model;

import com.example.composite.embeddableIds.UserEmbeddedId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "users")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @EmbeddedId
    private UserEmbeddedId id;

    @ManyToOne
    @MapsId("providerId")
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @ManyToOne
    @MapsId("companyId")
    @JoinColumn(name = "company_id")
    private Company company;

    private String name;

    private Date publishedDate = new Date();

    @ManyToMany
    private List<Role> roles;

}
