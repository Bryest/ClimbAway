package workbot.climbawayapi.climbaway.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import workbot.climbawayapi.security.domain.model.entity.Scalers;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "climbing_gyms")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClimbingGym implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Column(name = "name")
    private String name;

    @NotNull
    @NotBlank
    @Column(name = "password")
    private String password;

    @NotNull
    @NotBlank
    @Column(name = "email")
    private String email;

    @NotNull
    @NotBlank
    @Column(name = "city")
    private String city;

    @NotNull
    @NotBlank
    @Column(name = "district")
    private String district;

    @NotNull
    @NotBlank
    @Column(name = "address")
    private String address;

    @NotNull
    @NotBlank
    @Column(name = "phone")
    private String phone;

    @NotNull
    @NotBlank
    @Column(name = "logo")
    private String logo_url;

    // Relationships
    @ManyToMany
    @JoinTable(name = "climbing_gyms_categories",
            joinColumns = @JoinColumn(name = "climbing_gym_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    // Favorites
    @ManyToMany
    @JoinTable(name = "favorites",
            joinColumns = @JoinColumn(name = "climbing_gym_id"),
            inverseJoinColumns = @JoinColumn(name = "scaler_id"))
    private Set<Scalers> scaler = new HashSet<>();

    // New_news
    @JsonIgnore
    @OneToMany(mappedBy = "climbingGym",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<News> new_news;

    // Comments
    @JsonIgnore
    @OneToMany(mappedBy = "climbingGym",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;

    //Images
    @JsonIgnore
    @OneToMany(mappedBy = "climbingGym",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Image> images;

    //Leagues
    @JsonIgnore
    @OneToMany(mappedBy = "climbingGym",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<League> leagues;

    //Climbers-leagues
    @JsonIgnore
    @OneToMany(mappedBy = "climbingGym",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Member> memberLeagues;

    //Features
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "feature_id", referencedColumnName = "id")
    private Feature feature;
}
