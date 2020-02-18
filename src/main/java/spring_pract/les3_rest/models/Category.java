package spring_pract.les3_rest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Product> product = new ArrayList<>();
    private String email;


    public Category(String name) {
        this.name = name;
    }

    public Category(String name, List<Product> product) {
        this.name = name;
        this.product = product;
    }

    public Category(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

