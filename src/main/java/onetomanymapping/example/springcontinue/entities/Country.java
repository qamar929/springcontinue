package onetomanymapping.example.springcontinue.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Country  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   @JsonProperty("id")

    private int countryid;

    @NotNull(message = "country name cannot be null")
    @Size(min =2 ,max =100 , message = "must be min 2 and max 100")
    private  String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cid" , referencedColumnName = "countryid")
    private List<City> cities;
}
