package sit.integrated.project.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
@Entity
@Table(name = "products")
@Getter@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class Products {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name ="productid")
    private int productId;


    @Column(name ="productname")
    private String productName;


    @Column(name ="producttype")
    private String productType;


    @Column(name ="productdescription")
    private String productDescription	;


    @Column(name ="productprice")
    private double productPrice;


    @Column(name ="productsize")
    private String productSize;


    @Column(name ="productgender")
    private String productGender;


    @Column(name ="productmanufactured")
    private Date date;

    @ManyToOne
    @JoinColumn(name="brandid", nullable=false)
    private Brands BrandId;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "productscolors" ,
            joinColumns = @JoinColumn(name = "productid"),
            inverseJoinColumns = @JoinColumn(name = "colorid")
    )

    private List<Colors> ProductColors= new ArrayList<>();


}

