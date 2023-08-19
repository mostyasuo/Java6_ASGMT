package model;





import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;



@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "RoleDetails", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"id","accountId", "roleId"})
})
public class RoleDetails {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne @JoinColumn(name = "accountId")
	private Account account;
	@ManyToOne  @JoinColumn(name = "Roleid")
	private Role role;
}
