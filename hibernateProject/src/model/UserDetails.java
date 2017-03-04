package model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
@Entity
@Table (name="USER_DETAILS")
public class UserDetails {
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	@Column(name = "USER_NAME")
	private String userName;
	@Column(name = "JOINED_DATE")
	private Date joinedDate;
	@Column(name = "DESCRIPTION")
	private String description;
	@ElementCollection
	@JoinTable(name="USER_ADDRESS",
		joinColumns =@JoinColumn(name="USER_ID")
	)
	@GenericGenerator(name = "sequence-gen", strategy = "sequence")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "sequence-gen", type = @Type(type="long"))
	private Collection<Address> listOfAddresses = new ArrayList<Address>();
	@OneToOne
	private Vehicle vehicle;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}	
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@ElementCollection
	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}	
}
